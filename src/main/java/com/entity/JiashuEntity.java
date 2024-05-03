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
 * 家属
 *
 * @author 
 * @email
 */
@TableName("jiashu")
public class JiashuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiashuEntity() {

	}

	public JiashuEntity(T t) {
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
     * 家属姓名
     */
    @ColumnInfo(comment="家属姓名",type="varchar(200)")
    @TableField(value = "jiashu_name")

    private String jiashuName;


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
    @TableField(value = "jiashu_photo")

    private String jiashuPhoto;


    /**
     * 联系方式
     */
    @ColumnInfo(comment="联系方式",type="varchar(200)")
    @TableField(value = "jiashu_phone")

    private String jiashuPhone;


    /**
     * 电子邮箱
     */
    @ColumnInfo(comment="电子邮箱",type="varchar(200)")
    @TableField(value = "jiashu_email")

    private String jiashuEmail;


    /**
     * 身份
     */
    @ColumnInfo(comment="身份",type="int(11)")
    @TableField(value = "shenfen_types")

    private Integer shenfenTypes;


    /**
     * 老人
     */
    @ColumnInfo(comment="老人",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "jiashu_delete")

    private Integer jiashuDelete;


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
	 * 获取：家属姓名
	 */
    public String getJiashuName() {
        return jiashuName;
    }
    /**
	 * 设置：家属姓名
	 */

    public void setJiashuName(String jiashuName) {
        this.jiashuName = jiashuName;
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
    public String getJiashuPhoto() {
        return jiashuPhoto;
    }
    /**
	 * 设置：头像
	 */

    public void setJiashuPhoto(String jiashuPhoto) {
        this.jiashuPhoto = jiashuPhoto;
    }
    /**
	 * 获取：联系方式
	 */
    public String getJiashuPhone() {
        return jiashuPhone;
    }
    /**
	 * 设置：联系方式
	 */

    public void setJiashuPhone(String jiashuPhone) {
        this.jiashuPhone = jiashuPhone;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getJiashuEmail() {
        return jiashuEmail;
    }
    /**
	 * 设置：电子邮箱
	 */

    public void setJiashuEmail(String jiashuEmail) {
        this.jiashuEmail = jiashuEmail;
    }
    /**
	 * 获取：身份
	 */
    public Integer getShenfenTypes() {
        return shenfenTypes;
    }
    /**
	 * 设置：身份
	 */

    public void setShenfenTypes(Integer shenfenTypes) {
        this.shenfenTypes = shenfenTypes;
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
	 * 获取：逻辑删除
	 */
    public Integer getJiashuDelete() {
        return jiashuDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setJiashuDelete(Integer jiashuDelete) {
        this.jiashuDelete = jiashuDelete;
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
        return "Jiashu{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", jiashuName=" + jiashuName +
            ", sexTypes=" + sexTypes +
            ", jiashuPhoto=" + jiashuPhoto +
            ", jiashuPhone=" + jiashuPhone +
            ", jiashuEmail=" + jiashuEmail +
            ", shenfenTypes=" + shenfenTypes +
            ", yonghuId=" + yonghuId +
            ", jiashuDelete=" + jiashuDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
