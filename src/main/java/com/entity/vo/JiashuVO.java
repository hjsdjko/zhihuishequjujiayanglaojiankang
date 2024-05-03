package com.entity.vo;

import com.entity.JiashuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 家属
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiashu")
public class JiashuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 家属姓名
     */

    @TableField(value = "jiashu_name")
    private String jiashuName;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 头像
     */

    @TableField(value = "jiashu_photo")
    private String jiashuPhoto;


    /**
     * 联系方式
     */

    @TableField(value = "jiashu_phone")
    private String jiashuPhone;


    /**
     * 电子邮箱
     */

    @TableField(value = "jiashu_email")
    private String jiashuEmail;


    /**
     * 身份
     */

    @TableField(value = "shenfen_types")
    private Integer shenfenTypes;


    /**
     * 老人
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 逻辑删除
     */

    @TableField(value = "jiashu_delete")
    private Integer jiashuDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：家属姓名
	 */
    public String getJiashuName() {
        return jiashuName;
    }


    /**
	 * 获取：家属姓名
	 */

    public void setJiashuName(String jiashuName) {
        this.jiashuName = jiashuName;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：头像
	 */
    public String getJiashuPhoto() {
        return jiashuPhoto;
    }


    /**
	 * 获取：头像
	 */

    public void setJiashuPhoto(String jiashuPhoto) {
        this.jiashuPhoto = jiashuPhoto;
    }
    /**
	 * 设置：联系方式
	 */
    public String getJiashuPhone() {
        return jiashuPhone;
    }


    /**
	 * 获取：联系方式
	 */

    public void setJiashuPhone(String jiashuPhone) {
        this.jiashuPhone = jiashuPhone;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getJiashuEmail() {
        return jiashuEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setJiashuEmail(String jiashuEmail) {
        this.jiashuEmail = jiashuEmail;
    }
    /**
	 * 设置：身份
	 */
    public Integer getShenfenTypes() {
        return shenfenTypes;
    }


    /**
	 * 获取：身份
	 */

    public void setShenfenTypes(Integer shenfenTypes) {
        this.shenfenTypes = shenfenTypes;
    }
    /**
	 * 设置：老人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：老人
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getJiashuDelete() {
        return jiashuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setJiashuDelete(Integer jiashuDelete) {
        this.jiashuDelete = jiashuDelete;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
