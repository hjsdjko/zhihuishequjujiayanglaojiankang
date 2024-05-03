
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 档案信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiankangdangan")
public class JiankangdanganController {
    private static final Logger logger = LoggerFactory.getLogger(JiankangdanganController.class);

    private static final String TABLE_NAME = "jiankangdangan";

    @Autowired
    private JiankangdanganService jiankangdanganService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    //注册表service
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private GongzuorenyuanService gongzuorenyuanService;
    @Autowired
    private JiashuService jiashuService;
    @Autowired
    private YishengService yishengService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("老人".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("社区工作人员".equals(role))
            params.put("gongzuorenyuanId",request.getSession().getAttribute("userId"));
        else if("家属".equals(role))
            params.put("jiashuId",request.getSession().getAttribute("userId"));
        else if("医生".equals(role))
            params.put("yishengId",request.getSession().getAttribute("userId"));
        params.put("jiankangdanganDeleteStart",1);params.put("jiankangdanganDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = jiankangdanganService.queryPage(params);

        //字典表数据转换
        List<JiankangdanganView> list =(List<JiankangdanganView>)page.getList();
        for(JiankangdanganView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiankangdanganEntity jiankangdangan = jiankangdanganService.selectById(id);
        if(jiankangdangan !=null){
            //entity转view
            JiankangdanganView view = new JiankangdanganView();
            BeanUtils.copyProperties( jiankangdangan , view );//把实体数据重构到view中
            //级联表 老人
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jiankangdangan.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JiankangdanganEntity jiankangdangan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiankangdangan:{}",this.getClass().getName(),jiankangdangan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("老人".equals(role))
            jiankangdangan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JiankangdanganEntity> queryWrapper = new EntityWrapper<JiankangdanganEntity>()
            .eq("jiankangdangan_name", jiankangdangan.getJiankangdanganName())
            .eq("jiankangdangan_types", jiankangdangan.getJiankangdanganTypes())
            .eq("yonghu_id", jiankangdangan.getYonghuId())
            .eq("jiankangdangan_delete", jiankangdangan.getJiankangdanganDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiankangdanganEntity jiankangdanganEntity = jiankangdanganService.selectOne(queryWrapper);
        if(jiankangdanganEntity==null){
            jiankangdangan.setJiankangdanganDelete(1);
            jiankangdangan.setInsertTime(new Date());
            jiankangdangan.setCreateTime(new Date());
            jiankangdanganService.insert(jiankangdangan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiankangdanganEntity jiankangdangan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jiankangdangan:{}",this.getClass().getName(),jiankangdangan.toString());
        JiankangdanganEntity oldJiankangdanganEntity = jiankangdanganService.selectById(jiankangdangan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("老人".equals(role))
//            jiankangdangan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<JiankangdanganEntity> queryWrapper = new EntityWrapper<JiankangdanganEntity>()
            .notIn("id",jiankangdangan.getId())
            .andNew()
            .eq("jiankangdangan_name", jiankangdangan.getJiankangdanganName())
            .eq("jiankangdangan_types", jiankangdangan.getJiankangdanganTypes())
            .eq("yonghu_id", jiankangdangan.getYonghuId())
            .eq("jiankangdangan_delete", jiankangdangan.getJiankangdanganDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiankangdanganEntity jiankangdanganEntity = jiankangdanganService.selectOne(queryWrapper);
        if("".equals(jiankangdangan.getJiankangdanganFile()) || "null".equals(jiankangdangan.getJiankangdanganFile())){
                jiankangdangan.setJiankangdanganFile(null);
        }
        if(jiankangdanganEntity==null){
            jiankangdanganService.updateById(jiankangdangan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JiankangdanganEntity> oldJiankangdanganList =jiankangdanganService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<JiankangdanganEntity> list = new ArrayList<>();
        for(Integer id:ids){
            JiankangdanganEntity jiankangdanganEntity = new JiankangdanganEntity();
            jiankangdanganEntity.setId(id);
            jiankangdanganEntity.setJiankangdanganDelete(2);
            list.add(jiankangdanganEntity);
        }
        if(list != null && list.size() >0){
            jiankangdanganService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<JiankangdanganEntity> jiankangdanganList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            JiankangdanganEntity jiankangdanganEntity = new JiankangdanganEntity();
//                            jiankangdanganEntity.setJiankangdanganName(data.get(0));                    //档案标题 要改的
//                            jiankangdanganEntity.setJiankangdanganTypes(Integer.valueOf(data.get(0)));   //档案类型 要改的
//                            jiankangdanganEntity.setJiankangdanganFile(data.get(0));                    //档案下载 要改的
//                            jiankangdanganEntity.setYonghuId(Integer.valueOf(data.get(0)));   //老人 要改的
//                            jiankangdanganEntity.setJiankangdanganContent("");//详情和图片
//                            jiankangdanganEntity.setJiankangdanganDelete(1);//逻辑删除字段
//                            jiankangdanganEntity.setInsertTime(date);//时间
//                            jiankangdanganEntity.setCreateTime(date);//时间
                            jiankangdanganList.add(jiankangdanganEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        jiankangdanganService.insertBatch(jiankangdanganList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = jiankangdanganService.queryPage(params);

        //字典表数据转换
        List<JiankangdanganView> list =(List<JiankangdanganView>)page.getList();
        for(JiankangdanganView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiankangdanganEntity jiankangdangan = jiankangdanganService.selectById(id);
            if(jiankangdangan !=null){


                //entity转view
                JiankangdanganView view = new JiankangdanganView();
                BeanUtils.copyProperties( jiankangdangan , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(jiankangdangan.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody JiankangdanganEntity jiankangdangan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jiankangdangan:{}",this.getClass().getName(),jiankangdangan.toString());
        Wrapper<JiankangdanganEntity> queryWrapper = new EntityWrapper<JiankangdanganEntity>()
            .eq("jiankangdangan_name", jiankangdangan.getJiankangdanganName())
            .eq("jiankangdangan_types", jiankangdangan.getJiankangdanganTypes())
            .eq("yonghu_id", jiankangdangan.getYonghuId())
            .eq("jiankangdangan_delete", jiankangdangan.getJiankangdanganDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiankangdanganEntity jiankangdanganEntity = jiankangdanganService.selectOne(queryWrapper);
        if(jiankangdanganEntity==null){
            jiankangdangan.setJiankangdanganDelete(1);
            jiankangdangan.setInsertTime(new Date());
            jiankangdangan.setCreateTime(new Date());
        jiankangdanganService.insert(jiankangdangan);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}
