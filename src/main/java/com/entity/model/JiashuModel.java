package com.entity.model;

import com.entity.JiashuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 家属
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiashuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 家属姓名
     */
    private String jiashuName;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 头像
     */
    private String jiashuPhoto;


    /**
     * 联系方式
     */
    private String jiashuPhone;


    /**
     * 电子邮箱
     */
    private String jiashuEmail;


    /**
     * 身份
     */
    private Integer shenfenTypes;


    /**
     * 老人
     */
    private Integer yonghuId;


    /**
     * 逻辑删除
     */
    private Integer jiashuDelete;


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

    }
