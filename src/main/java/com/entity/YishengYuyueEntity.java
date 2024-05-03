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
 * 医生预约
 *
 * @author 
 * @email
 */
@TableName("yisheng_yuyue")
public class YishengYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YishengYuyueEntity() {

	}

	public YishengYuyueEntity(T t) {
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
     * 医生
     */
    @ColumnInfo(comment="医生",type="int(11)")
    @TableField(value = "yisheng_id")

    private Integer yishengId;


    /**
     * 老人
     */
    @ColumnInfo(comment="老人",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="预约时间",type="timestamp")
    @TableField(value = "yisheng_yuyue_time")

    private Date yishengYuyueTime;


    /**
     * 预约备注
     */
    @ColumnInfo(comment="预约备注",type="text")
    @TableField(value = "yisheng_yuyue_text")

    private String yishengYuyueText;


    /**
     * 预约审核
     */
    @ColumnInfo(comment="预约审核",type="int(11)")
    @TableField(value = "yisheng_yuyue_yesno_types")

    private Integer yishengYuyueYesnoTypes;


    /**
     * 审核结果
     */
    @ColumnInfo(comment="审核结果",type="text")
    @TableField(value = "yisheng_yuyue_yesno_text")

    private String yishengYuyueYesnoText;


    /**
     * 创建时间  listShow
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
	 * 获取：医生
	 */
    public Integer getYishengId() {
        return yishengId;
    }
    /**
	 * 设置：医生
	 */

    public void setYishengId(Integer yishengId) {
        this.yishengId = yishengId;
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
	 * 获取：预约时间
	 */
    public Date getYishengYuyueTime() {
        return yishengYuyueTime;
    }
    /**
	 * 设置：预约时间
	 */

    public void setYishengYuyueTime(Date yishengYuyueTime) {
        this.yishengYuyueTime = yishengYuyueTime;
    }
    /**
	 * 获取：预约备注
	 */
    public String getYishengYuyueText() {
        return yishengYuyueText;
    }
    /**
	 * 设置：预约备注
	 */

    public void setYishengYuyueText(String yishengYuyueText) {
        this.yishengYuyueText = yishengYuyueText;
    }
    /**
	 * 获取：预约审核
	 */
    public Integer getYishengYuyueYesnoTypes() {
        return yishengYuyueYesnoTypes;
    }
    /**
	 * 设置：预约审核
	 */

    public void setYishengYuyueYesnoTypes(Integer yishengYuyueYesnoTypes) {
        this.yishengYuyueYesnoTypes = yishengYuyueYesnoTypes;
    }
    /**
	 * 获取：审核结果
	 */
    public String getYishengYuyueYesnoText() {
        return yishengYuyueYesnoText;
    }
    /**
	 * 设置：审核结果
	 */

    public void setYishengYuyueYesnoText(String yishengYuyueYesnoText) {
        this.yishengYuyueYesnoText = yishengYuyueYesnoText;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "YishengYuyue{" +
            ", id=" + id +
            ", yishengId=" + yishengId +
            ", yonghuId=" + yonghuId +
            ", yishengYuyueTime=" + DateUtil.convertString(yishengYuyueTime,"yyyy-MM-dd") +
            ", yishengYuyueText=" + yishengYuyueText +
            ", yishengYuyueYesnoTypes=" + yishengYuyueYesnoTypes +
            ", yishengYuyueYesnoText=" + yishengYuyueYesnoText +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
