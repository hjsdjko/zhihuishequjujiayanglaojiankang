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
 * 社区工作人员
 *
 * @author 
 * @email
 */
@TableName("gongzuorenyuan")
public class GongzuorenyuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GongzuorenyuanEntity() {

	}

	public GongzuorenyuanEntity(T t) {
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
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 工作人员姓名
     */
    @ColumnInfo(comment="工作人员姓名",type="varchar(200)")
    @TableField(value = "gongzuorenyuan_name")

    private String gongzuorenyuanName;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 头像
     */
    @ColumnInfo(comment="头像",type="varchar(200)")
    @TableField(value = "gongzuorenyuan_photo")

    private String gongzuorenyuanPhoto;


    /**
     * 联系方式
     */
    @ColumnInfo(comment="联系方式",type="varchar(200)")
    @TableField(value = "gongzuorenyuan_phone")

    private String gongzuorenyuanPhone;


    /**
     * 电子邮箱
     */
    @ColumnInfo(comment="电子邮箱",type="varchar(200)")
    @TableField(value = "gongzuorenyuan_email")

    private String gongzuorenyuanEmail;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "gongzuorenyuan_delete")

    private Integer gongzuorenyuanDelete;


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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 设置：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 设置：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：工作人员姓名
	 */
    public String getGongzuorenyuanName() {
        return gongzuorenyuanName;
    }
    /**
	 * 设置：工作人员姓名
	 */

    public void setGongzuorenyuanName(String gongzuorenyuanName) {
        this.gongzuorenyuanName = gongzuorenyuanName;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 设置：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：头像
	 */
    public String getGongzuorenyuanPhoto() {
        return gongzuorenyuanPhoto;
    }
    /**
	 * 设置：头像
	 */

    public void setGongzuorenyuanPhoto(String gongzuorenyuanPhoto) {
        this.gongzuorenyuanPhoto = gongzuorenyuanPhoto;
    }
    /**
	 * 获取：联系方式
	 */
    public String getGongzuorenyuanPhone() {
        return gongzuorenyuanPhone;
    }
    /**
	 * 设置：联系方式
	 */

    public void setGongzuorenyuanPhone(String gongzuorenyuanPhone) {
        this.gongzuorenyuanPhone = gongzuorenyuanPhone;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getGongzuorenyuanEmail() {
        return gongzuorenyuanEmail;
    }
    /**
	 * 设置：电子邮箱
	 */

    public void setGongzuorenyuanEmail(String gongzuorenyuanEmail) {
        this.gongzuorenyuanEmail = gongzuorenyuanEmail;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getGongzuorenyuanDelete() {
        return gongzuorenyuanDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setGongzuorenyuanDelete(Integer gongzuorenyuanDelete) {
        this.gongzuorenyuanDelete = gongzuorenyuanDelete;
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
        return "Gongzuorenyuan{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", gongzuorenyuanName=" + gongzuorenyuanName +
            ", sexTypes=" + sexTypes +
            ", gongzuorenyuanPhoto=" + gongzuorenyuanPhoto +
            ", gongzuorenyuanPhone=" + gongzuorenyuanPhone +
            ", gongzuorenyuanEmail=" + gongzuorenyuanEmail +
            ", gongzuorenyuanDelete=" + gongzuorenyuanDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
