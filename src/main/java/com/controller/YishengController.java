
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
 * 医生
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yisheng")
public class YishengController {
    private static final Logger logger = LoggerFactory.getLogger(YishengController.class);

    private static final String TABLE_NAME = "yisheng";

    @Autowired
    private YishengService yishengService;


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
        CommonUtil.checkMap(params);
        PageUtils page = yishengService.queryPage(params);

        //字典表数据转换
        List<YishengView> list =(List<YishengView>)page.getList();
        for(YishengView c:list){
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
        YishengEntity yisheng = yishengService.selectById(id);
        if(yisheng !=null){
            //entity转view
            YishengView view = new YishengView();
            BeanUtils.copyProperties( yisheng , view );//把实体数据重构到view中
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
    public R save(@RequestBody YishengEntity yisheng, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yisheng:{}",this.getClass().getName(),yisheng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<YishengEntity> queryWrapper = new EntityWrapper<YishengEntity>()
            .eq("username", yisheng.getUsername())
            .or()
            .eq("yisheng_phone", yisheng.getYishengPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YishengEntity yishengEntity = yishengService.selectOne(queryWrapper);
        if(yishengEntity==null){
            yisheng.setCreateTime(new Date());
            yisheng.setPassword("123456");
            yishengService.insert(yisheng);
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YishengEntity yisheng, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,yisheng:{}",this.getClass().getName(),yisheng.toString());
        YishengEntity oldYishengEntity = yishengService.selectById(yisheng.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<YishengEntity> queryWrapper = new EntityWrapper<YishengEntity>()
            .notIn("id",yisheng.getId())
            .andNew()
            .eq("username", yisheng.getUsername())
            .or()
            .eq("yisheng_phone", yisheng.getYishengPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YishengEntity yishengEntity = yishengService.selectOne(queryWrapper);
        if("".equals(yisheng.getYishengPhoto()) || "null".equals(yisheng.getYishengPhoto())){
                yisheng.setYishengPhoto(null);
        }
        if(yishengEntity==null){
            yishengService.updateById(yisheng);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<YishengEntity> oldYishengList =yishengService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        yishengService.deleteBatchIds(Arrays.asList(ids));

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
            List<YishengEntity> yishengList = new ArrayList<>();//上传的东西
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
                            YishengEntity yishengEntity = new YishengEntity();
//                            yishengEntity.setYishengUuidNumber(data.get(0));                    //医生工号 要改的
//                            yishengEntity.setUsername(data.get(0));                    //账户 要改的
//                            //yishengEntity.setPassword("123456");//密码
//                            yishengEntity.setYishengName(data.get(0));                    //医生名称 要改的
//                            yishengEntity.setYishengTypes(Integer.valueOf(data.get(0)));   //科室 要改的
//                            yishengEntity.setZhiweiTypes(Integer.valueOf(data.get(0)));   //职位 要改的
//                            yishengEntity.setYishengZhichneg(data.get(0));                    //职称 要改的
//                            yishengEntity.setYishengPhoto("");//详情和图片
//                            yishengEntity.setYishengPhone(data.get(0));                    //联系方式 要改的
//                            yishengEntity.setYishengGuahao(data.get(0));                    //预约须知 要改的
//                            yishengEntity.setYishengEmail(data.get(0));                    //邮箱 要改的
//                            yishengEntity.setYishengContent("");//详情和图片
//                            yishengEntity.setCreateTime(date);//时间
                            yishengList.add(yishengEntity);


                            //把要查询是否重复的字段放入map中
                                //医生工号
                                if(seachFields.containsKey("yishengUuidNumber")){
                                    List<String> yishengUuidNumber = seachFields.get("yishengUuidNumber");
                                    yishengUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> yishengUuidNumber = new ArrayList<>();
                                    yishengUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("yishengUuidNumber",yishengUuidNumber);
                                }
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //联系方式
                                if(seachFields.containsKey("yishengPhone")){
                                    List<String> yishengPhone = seachFields.get("yishengPhone");
                                    yishengPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> yishengPhone = new ArrayList<>();
                                    yishengPhone.add(data.get(0));//要改的
                                    seachFields.put("yishengPhone",yishengPhone);
                                }
                        }

                        //查询是否重复
                         //医生工号
                        List<YishengEntity> yishengEntities_yishengUuidNumber = yishengService.selectList(new EntityWrapper<YishengEntity>().in("yisheng_uuid_number", seachFields.get("yishengUuidNumber")));
                        if(yishengEntities_yishengUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YishengEntity s:yishengEntities_yishengUuidNumber){
                                repeatFields.add(s.getYishengUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [医生工号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //账户
                        List<YishengEntity> yishengEntities_username = yishengService.selectList(new EntityWrapper<YishengEntity>().in("username", seachFields.get("username")));
                        if(yishengEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YishengEntity s:yishengEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //联系方式
                        List<YishengEntity> yishengEntities_yishengPhone = yishengService.selectList(new EntityWrapper<YishengEntity>().in("yisheng_phone", seachFields.get("yishengPhone")));
                        if(yishengEntities_yishengPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YishengEntity s:yishengEntities_yishengPhone){
                                repeatFields.add(s.getYishengPhone());
                            }
                            return R.error(511,"数据库的该表中的 [联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        yishengService.insertBatch(yishengList);
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
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        YishengEntity yisheng = yishengService.selectOne(new EntityWrapper<YishengEntity>().eq("username", username));
        if(yisheng==null || !yisheng.getPassword().equals(password))
            return R.error("账号或密码不正确");
        String token = tokenService.generateToken(yisheng.getId(),username, "yisheng", "医生");
        R r = R.ok();
        r.put("token", token);
        r.put("role","医生");
        r.put("username",yisheng.getYishengName());
        r.put("tableName","yisheng");
        r.put("userId",yisheng.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody YishengEntity yisheng, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<YishengEntity> queryWrapper = new EntityWrapper<YishengEntity>()
            .eq("username", yisheng.getUsername())
            .or()
            .eq("yisheng_phone", yisheng.getYishengPhone())
            ;
        YishengEntity yishengEntity = yishengService.selectOne(queryWrapper);
        if(yishengEntity != null)
            return R.error("账户或者联系方式已经被使用");
        yisheng.setYishengUuidNumber(String.valueOf(new Date().getTime()));
        yisheng.setCreateTime(new Date());
        yishengService.insert(yisheng);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        YishengEntity yisheng = yishengService.selectById(id);
        yisheng.setPassword("123456");
        yishengService.updateById(yisheng);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        YishengEntity yisheng = yishengService.selectOne(new EntityWrapper<YishengEntity>().eq("username", username));
        if(yisheng!=null){
            yisheng.setPassword("123456");
            boolean b = yishengService.updateById(yisheng);
            if(!b){
               return R.error();
            }
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrYisheng(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        YishengEntity yisheng = yishengService.selectById(id);
        if(yisheng !=null){
            //entity转view
            YishengView view = new YishengView();
            BeanUtils.copyProperties( yisheng , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = yishengService.queryPage(params);

        //字典表数据转换
        List<YishengView> list =(List<YishengView>)page.getList();
        for(YishengView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YishengEntity yisheng = yishengService.selectById(id);
            if(yisheng !=null){


                //entity转view
                YishengView view = new YishengView();
                BeanUtils.copyProperties( yisheng , view );//把实体数据重构到view中

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
    public R add(@RequestBody YishengEntity yisheng, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yisheng:{}",this.getClass().getName(),yisheng.toString());
        Wrapper<YishengEntity> queryWrapper = new EntityWrapper<YishengEntity>()
            .eq("username", yisheng.getUsername())
            .or()
            .eq("yisheng_phone", yisheng.getYishengPhone())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YishengEntity yishengEntity = yishengService.selectOne(queryWrapper);
        if(yishengEntity==null){
            yisheng.setCreateTime(new Date());
        yisheng.setPassword("123456");
        yishengService.insert(yisheng);

            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }

}
