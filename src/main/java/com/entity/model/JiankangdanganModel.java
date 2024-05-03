package com.entity.model;

import com.entity.JiankangdanganEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 档案信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiankangdanganModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 档案标题
     */
    private String jiankangdanganName;


    /**
     * 档案类型
     */
    private Integer jiankangdanganTypes;


    /**
     * 档案下载
     */
    private String jiankangdanganFile;


    /**
     * 老人
     */
    private Integer yonghuId;


    /**
     * 档案详情
     */
    private String jiankangdanganContent;


    /**
     * 逻辑删除
     */
    private Integer jiankangdanganDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 获取：档案标题
	 */
    public String getJiankangdanganName() {
        return jiankangdanganName;
    }


    /**
	 * 设置：档案标题
	 */
    public void setJiankangdanganName(String jiankangdanganName) {
        this.jiankangdanganName = jiankangdanganName;
    }
    /**
	 * 获取：档案类型
	 */
    public Integer getJiankangdanganTypes() {
        return jiankangdanganTypes;
    }


    /**
	 * 设置：档案类型
	 */
    public void setJiankangdanganTypes(Integer jiankangdanganTypes) {
        this.jiankangdanganTypes = jiankangdanganTypes;
    }
    /**
	 * 获取：档案下载
	 */
    public String getJiankangdanganFile() {
        return jiankangdanganFile;
    }


    /**
	 * 设置：档案下载
	 */
    public void setJiankangdanganFile(String jiankangdanganFile) {
        this.jiankangdanganFile = jiankangdanganFile;
    }
    /**
	 * 获取：老人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：老人
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：档案详情
	 */
    public String getJiankangdanganContent() {
        return jiankangdanganContent;
    }


    /**
	 * 设置：档案详情
	 */
    public void setJiankangdanganContent(String jiankangdanganContent) {
        this.jiankangdanganContent = jiankangdanganContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getJiankangdanganDelete() {
        return jiankangdanganDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setJiankangdanganDelete(Integer jiankangdanganDelete) {
        this.jiankangdanganDelete = jiankangdanganDelete;
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
	 * 获取：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
