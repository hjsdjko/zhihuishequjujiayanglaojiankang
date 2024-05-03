package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 服务项目信息
 *
 * @author 
 * @email
 */
@TableName("fuwuxiangmu")
public class FuwuxiangmuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FuwuxiangmuEntity() {

	}

	public FuwuxiangmuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 服务项目名称
     */
    @ColumnInfo(comment="服务项目名称",type="varchar(200)")
    @TableField(value = "fuwuxiangmu_name")

    private String fuwuxiangmuName;


    /**
     * 服务项目类型
     */
    @ColumnInfo(comment="服务项目类型",type="int(11)")
    @TableField(value = "fuwuxiangmu_types")

    private Integer fuwuxiangmuTypes;


    /**
     * 服务项目封面
     */
    @ColumnInfo(comment="服务项目封面",type="varchar(200)")
    @TableField(value = "fuwuxiangmu_photo")

    private String fuwuxiangmuPhoto;


    /**
     * 服务项目简介
     */
    @ColumnInfo(comment="服务项目简介",type="text")
    @TableField(value = "fuwuxiangmu_content")

    private String fuwuxiangmuContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "fuwuxiangmu_delete")

    private Integer fuwuxiangmuDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="添加时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Fuwuxiangmu{" +
            ", id=" + id +
            ", fuwuxiangmuName=" + fuwuxiangmuName +
            ", fuwuxiangmuTypes=" + fuwuxiangmuTypes +
            ", fuwuxiangmuPhoto=" + fuwuxiangmuPhoto +
            ", fuwuxiangmuContent=" + fuwuxiangmuContent +
            ", fuwuxiangmuDelete=" + fuwuxiangmuDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
