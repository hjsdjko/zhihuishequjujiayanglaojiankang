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
 * 事宜信息
 *
 * @author 
 * @email
 */
@TableName("daibanshiyi")
public class DaibanshiyiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DaibanshiyiEntity() {

	}

	public DaibanshiyiEntity(T t) {
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
     * 事宜标题
     */
    @ColumnInfo(comment="事宜标题",type="varchar(200)")
    @TableField(value = "daibanshiyi_name")

    private String daibanshiyiName;


    /**
     * 事宜类型
     */
    @ColumnInfo(comment="事宜类型",type="int(11)")
    @TableField(value = "daibanshiyi_types")

    private Integer daibanshiyiTypes;


    /**
     * 工作人员
     */
    @ColumnInfo(comment="工作人员",type="int(11)")
    @TableField(value = "gongzuorenyuan_id")

    private Integer gongzuorenyuanId;


    /**
     * 事宜封面
     */
    @ColumnInfo(comment="事宜封面",type="varchar(200)")
    @TableField(value = "daibanshiyi_photo")

    private String daibanshiyiPhoto;


    /**
     * 事宜简介
     */
    @ColumnInfo(comment="事宜简介",type="text")
    @TableField(value = "daibanshiyi_content")

    private String daibanshiyiContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "daibanshiyi_delete")

    private Integer daibanshiyiDelete;


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

    @Override
    public String toString() {
        return "Daibanshiyi{" +
            ", id=" + id +
            ", daibanshiyiName=" + daibanshiyiName +
            ", daibanshiyiTypes=" + daibanshiyiTypes +
            ", gongzuorenyuanId=" + gongzuorenyuanId +
            ", daibanshiyiPhoto=" + daibanshiyiPhoto +
            ", daibanshiyiContent=" + daibanshiyiContent +
            ", daibanshiyiDelete=" + daibanshiyiDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
