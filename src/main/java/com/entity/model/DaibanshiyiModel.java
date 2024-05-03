package com.entity.model;

import com.entity.DaibanshiyiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 事宜信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class DaibanshiyiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 事宜标题
     */
    private String daibanshiyiName;


    /**
     * 事宜类型
     */
    private Integer daibanshiyiTypes;


    /**
     * 工作人员
     */
    private Integer gongzuorenyuanId;


    /**
     * 事宜封面
     */
    private String daibanshiyiPhoto;


    /**
     * 事宜简介
     */
    private String daibanshiyiContent;


    /**
     * 逻辑删除
     */
    private Integer daibanshiyiDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：事宜标题
	 */
    public String getDaibanshiyiName() {
        return daibanshiyiName;
    }


    /**
	 * 设置：事宜标题
	 */
    public void setDaibanshiyiName(String daibanshiyiName) {
        this.daibanshiyiName = daibanshiyiName;
    }
    /**
	 * 获取：事宜类型
	 */
    public Integer getDaibanshiyiTypes() {
        return daibanshiyiTypes;
    }


    /**
	 * 设置：事宜类型
	 */
    public void setDaibanshiyiTypes(Integer daibanshiyiTypes) {
        this.daibanshiyiTypes = daibanshiyiTypes;
    }
    /**
	 * 获取：工作人员
	 */
    public Integer getGongzuorenyuanId() {
        return gongzuorenyuanId;
    }


    /**
	 * 设置：工作人员
	 */
    public void setGongzuorenyuanId(Integer gongzuorenyuanId) {
        this.gongzuorenyuanId = gongzuorenyuanId;
    }
    /**
	 * 获取：事宜封面
	 */
    public String getDaibanshiyiPhoto() {
        return daibanshiyiPhoto;
    }


    /**
	 * 设置：事宜封面
	 */
    public void setDaibanshiyiPhoto(String daibanshiyiPhoto) {
        this.daibanshiyiPhoto = daibanshiyiPhoto;
    }
    /**
	 * 获取：事宜简介
	 */
    public String getDaibanshiyiContent() {
        return daibanshiyiContent;
    }


    /**
	 * 设置：事宜简介
	 */
    public void setDaibanshiyiContent(String daibanshiyiContent) {
        this.daibanshiyiContent = daibanshiyiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getDaibanshiyiDelete() {
        return daibanshiyiDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setDaibanshiyiDelete(Integer daibanshiyiDelete) {
        this.daibanshiyiDelete = daibanshiyiDelete;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
