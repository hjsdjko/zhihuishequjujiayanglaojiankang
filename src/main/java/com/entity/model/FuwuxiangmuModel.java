package com.entity.model;

import com.entity.FuwuxiangmuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 服务项目信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FuwuxiangmuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 服务项目名称
     */
    private String fuwuxiangmuName;


    /**
     * 服务项目类型
     */
    private Integer fuwuxiangmuTypes;


    /**
     * 服务项目封面
     */
    private String fuwuxiangmuPhoto;


    /**
     * 服务项目简介
     */
    private String fuwuxiangmuContent;


    /**
     * 逻辑删除
     */
    private Integer fuwuxiangmuDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：服务项目名称
	 */
    public String getFuwuxiangmuName() {
        return fuwuxiangmuName;
    }


    /**
	 * 设置：服务项目名称
	 */
    public void setFuwuxiangmuName(String fuwuxiangmuName) {
        this.fuwuxiangmuName = fuwuxiangmuName;
    }
    /**
	 * 获取：服务项目类型
	 */
    public Integer getFuwuxiangmuTypes() {
        return fuwuxiangmuTypes;
    }


    /**
	 * 设置：服务项目类型
	 */
    public void setFuwuxiangmuTypes(Integer fuwuxiangmuTypes) {
        this.fuwuxiangmuTypes = fuwuxiangmuTypes;
    }
    /**
	 * 获取：服务项目封面
	 */
    public String getFuwuxiangmuPhoto() {
        return fuwuxiangmuPhoto;
    }


    /**
	 * 设置：服务项目封面
	 */
    public void setFuwuxiangmuPhoto(String fuwuxiangmuPhoto) {
        this.fuwuxiangmuPhoto = fuwuxiangmuPhoto;
    }
    /**
	 * 获取：服务项目简介
	 */
    public String getFuwuxiangmuContent() {
        return fuwuxiangmuContent;
    }


    /**
	 * 设置：服务项目简介
	 */
    public void setFuwuxiangmuContent(String fuwuxiangmuContent) {
        this.fuwuxiangmuContent = fuwuxiangmuContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getFuwuxiangmuDelete() {
        return fuwuxiangmuDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setFuwuxiangmuDelete(Integer fuwuxiangmuDelete) {
        this.fuwuxiangmuDelete = fuwuxiangmuDelete;
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
