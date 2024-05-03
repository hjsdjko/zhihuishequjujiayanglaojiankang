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
 * 档案信息
 *
 * @author 
 * @email
 */
@TableName("jiankangdangan")
public class JiankangdanganEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiankangdanganEntity() {

	}

	public JiankangdanganEntity(T t) {
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
     * 档案标题
     */
    @ColumnInfo(comment="档案标题",type="varchar(200)")
    @TableField(value = "jiankangdangan_name")

    private String jiankangdanganName;


    /**
     * 档案类型
     */
    @ColumnInfo(comment="档案类型",type="int(11)")
    @TableField(value = "jiankangdangan_types")

    private Integer jiankangdanganTypes;


    /**
     * 档案下载
     */
    @ColumnInfo(comment="档案下载",type="varchar(200)")
    @TableField(value = "jiankangdangan_file")

    private String jiankangdanganFile;


    /**
     * 老人
     */
    @ColumnInfo(comment="老人",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 档案详情
     */
    @ColumnInfo(comment="档案详情",type="text")
    @TableField(value = "jiankangdangan_content")

    private String jiankangdanganContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "jiankangdangan_delete")

    private Integer jiankangdanganDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="添加时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间   listShow
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
	 * 获取：创建时间   listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间   listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jiankangdangan{" +
            ", id=" + id +
            ", jiankangdanganName=" + jiankangdanganName +
            ", jiankangdanganTypes=" + jiankangdanganTypes +
            ", jiankangdanganFile=" + jiankangdanganFile +
            ", yonghuId=" + yonghuId +
            ", jiankangdanganContent=" + jiankangdanganContent +
            ", jiankangdanganDelete=" + jiankangdanganDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
