
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
 * 事宜信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/daibanshiyi")
public class DaibanshiyiController {
    private static final Logger logger = LoggerFactory.getLogger(DaibanshiyiController.class);

    private static final String TABLE_NAME = "daibanshiyi";

    @Autowired
    private DaibanshiyiService daibanshiyiService;


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
        params.put("daibanshiyiDeleteStart",1);params.put("daibanshiyiDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = daibanshiyiService.queryPage(params);

        //字典表数据转换
        List<DaibanshiyiView> list =(List<DaibanshiyiView>)page.getList();
        for(DaibanshiyiView c:list){
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
        DaibanshiyiEntity daibanshiyi = daibanshiyiService.selectById(id);
        if(daibanshiyi !=null){
            //entity转view
            DaibanshiyiView view = new DaibanshiyiView();
            BeanUtils.copyProperties( daibanshiyi , view );//把实体数据重构到view中
            //级联表 社区工作人员
            //级联表
            GongzuorenyuanEntity gongzuorenyuan = gongzuorenyuanService.selectById(daibanshiyi.getGongzuorenyuanId());
            if(gongzuorenyuan != null){
            BeanUtils.copyProperties( gongzuorenyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "gongzuorenyuanId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setGongzuorenyuanId(gongzuorenyuan.getId());
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
    public R save(@RequestBody DaibanshiyiEntity daibanshiyi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,daibanshiyi:{}",this.getClass().getName(),daibanshiyi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("社区工作人员".equals(role))
            daibanshiyi.setGongzuorenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<DaibanshiyiEntity> queryWrapper = new EntityWrapper<DaibanshiyiEntity>()
            .eq("daibanshiyi_name", daibanshiyi.getDaibanshiyiName())
            .eq("daibanshiyi_types", daibanshiyi.getDaibanshiyiTypes())
            .eq("gongzuorenyuan_id", daibanshiyi.getGongzuorenyuanId())
            .eq("daibanshiyi_delete", daibanshiyi.getDaibanshiyiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DaibanshiyiEntity daibanshiyiEntity = daibanshiyiService.selectOne(queryWrapper);
        if(daibanshiyiEntity==null){
            daibanshiyi.setDaibanshiyiDelete(1);
            daibanshiyi.setInsertTime(new Date());
            daibanshiyi.setCreateTime(new Date());
            daibanshiyiService.insert(daibanshiyi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DaibanshiyiEntity daibanshiyi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,daibanshiyi:{}",this.getClass().getName(),daibanshiyi.toString());
        DaibanshiyiEntity oldDaibanshiyiEntity = daibanshiyiService.selectById(daibanshiyi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("社区工作人员".equals(role))
//            daibanshiyi.setGongzuorenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<DaibanshiyiEntity> queryWrapper = new EntityWrapper<DaibanshiyiEntity>()
            .notIn("id",daibanshiyi.getId())
            .andNew()
            .eq("daibanshiyi_name", daibanshiyi.getDaibanshiyiName())
            .eq("daibanshiyi_types", daibanshiyi.getDaibanshiyiTypes())
            .eq("gongzuorenyuan_id", daibanshiyi.getGongzuorenyuanId())
            .eq("daibanshiyi_delete", daibanshiyi.getDaibanshiyiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DaibanshiyiEntity daibanshiyiEntity = daibanshiyiService.selectOne(queryWrapper);
        if("".equals(daibanshiyi.getDaibanshiyiPhoto()) || "null".equals(daibanshiyi.getDaibanshiyiPhoto())){
                daibanshiyi.setDaibanshiyiPhoto(null);
        }
        if(daibanshiyiEntity==null){
            daibanshiyiService.updateById(daibanshiyi);//根据id更新
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
        List<DaibanshiyiEntity> oldDaibanshiyiList =daibanshiyiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<DaibanshiyiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            DaibanshiyiEntity daibanshiyiEntity = new DaibanshiyiEntity();
            daibanshiyiEntity.setId(id);
            daibanshiyiEntity.setDaibanshiyiDelete(2);
            list.add(daibanshiyiEntity);
        }
        if(list != null && list.size() >0){
            daibanshiyiService.updateBatchById(list);
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
            List<DaibanshiyiEntity> daibanshiyiList = new ArrayList<>();//上传的东西
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
                            DaibanshiyiEntity daibanshiyiEntity = new DaibanshiyiEntity();
//                            daibanshiyiEntity.setDaibanshiyiName(data.get(0));                    //事宜标题 要改的
//                            daibanshiyiEntity.setDaibanshiyiTypes(Integer.valueOf(data.get(0)));   //事宜类型 要改的
//                            daibanshiyiEntity.setGongzuorenyuanId(Integer.valueOf(data.get(0)));   //工作人员 要改的
//                            daibanshiyiEntity.setDaibanshiyiPhoto("");//详情和图片
//                            daibanshiyiEntity.setDaibanshiyiContent("");//详情和图片
//                            daibanshiyiEntity.setDaibanshiyiDelete(1);//逻辑删除字段
//                            daibanshiyiEntity.setInsertTime(date);//时间
//                            daibanshiyiEntity.setCreateTime(date);//时间
                            daibanshiyiList.add(daibanshiyiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        daibanshiyiService.insertBatch(daibanshiyiList);
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
        PageUtils page = daibanshiyiService.queryPage(params);

        //字典表数据转换
        List<DaibanshiyiView> list =(List<DaibanshiyiView>)page.getList();
        for(DaibanshiyiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DaibanshiyiEntity daibanshiyi = daibanshiyiService.selectById(id);
            if(daibanshiyi !=null){


                //entity转view
                DaibanshiyiView view = new DaibanshiyiView();
                BeanUtils.copyProperties( daibanshiyi , view );//把实体数据重构到view中

                //级联表
                    GongzuorenyuanEntity gongzuorenyuan = gongzuorenyuanService.selectById(daibanshiyi.getGongzuorenyuanId());
                if(gongzuorenyuan != null){
                    BeanUtils.copyProperties( gongzuorenyuan , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setGongzuorenyuanId(gongzuorenyuan.getId());
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
    public R add(@RequestBody DaibanshiyiEntity daibanshiyi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,daibanshiyi:{}",this.getClass().getName(),daibanshiyi.toString());
        Wrapper<DaibanshiyiEntity> queryWrapper = new EntityWrapper<DaibanshiyiEntity>()
            .eq("daibanshiyi_name", daibanshiyi.getDaibanshiyiName())
            .eq("daibanshiyi_types", daibanshiyi.getDaibanshiyiTypes())
            .eq("gongzuorenyuan_id", daibanshiyi.getGongzuorenyuanId())
            .eq("daibanshiyi_delete", daibanshiyi.getDaibanshiyiDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DaibanshiyiEntity daibanshiyiEntity = daibanshiyiService.selectOne(queryWrapper);
        if(daibanshiyiEntity==null){
            daibanshiyi.setDaibanshiyiDelete(1);
            daibanshiyi.setInsertTime(new Date());
            daibanshiyi.setCreateTime(new Date());
        daibanshiyiService.insert(daibanshiyi);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}
