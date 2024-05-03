package com.entity.vo;

import com.entity.FuwuxiangmuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 服务项目信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fuwuxiangmu")
public class FuwuxiangmuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 服务项目名称
     */

    @TableField(value = "fuwuxiangmu_name")
    private String fuwuxiangmuName;


    /**
     * 服务项目类型
     */

    @TableField(value = "fuwuxiangmu_types")
    private Integer fuwuxiangmuTypes;


    /**
     * 服务项目封面
     */

    @TableField(value = "fuwuxiangmu_photo")
    private String fuwuxiangmuPhoto;


    /**
     * 服务项目简介
     */

    @TableField(value = "fuwuxiangmu_content")
    private String fuwuxiangmuContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "fuwuxiangmu_delete")
    private Integer fuwuxiangmuDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：服务项目名称
	 */
    public String getFuwuxiangmuName() {
        return fuwuxiangmuName;
    }


    /**
	 * 获取：服务项目名称
	 */

    public void setFuwuxiangmuName(String fuwuxiangmuName) {
        this.fuwuxiangmuName = fuwuxiangmuName;
    }
    /**
	 * 设置：服务项目类型
	 */
    public Integer getFuwuxiangmuTypes() {
        return fuwuxiangmuTypes;
    }


    /**
	 * 获取：服务项目类型
	 */

    public void setFuwuxiangmuTypes(Integer fuwuxiangmuTypes) {
        this.fuwuxiangmuTypes = fuwuxiangmuTypes;
    }
    /**
	 * 设置：服务项目封面
	 */
    public String getFuwuxiangmuPhoto() {
        return fuwuxiangmuPhoto;
    }


    /**
	 * 获取：服务项目封面
	 */

    public void setFuwuxiangmuPhoto(String fuwuxiangmuPhoto) {
        this.fuwuxiangmuPhoto = fuwuxiangmuPhoto;
    }
    /**
	 * 设置：服务项目简介
	 */
    public String getFuwuxiangmuContent() {
        return fuwuxiangmuContent;
    }


    /**
	 * 获取：服务项目简介
	 */

    public void setFuwuxiangmuContent(String fuwuxiangmuContent) {
        this.fuwuxiangmuContent = fuwuxiangmuContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getFuwuxiangmuDelete() {
        return fuwuxiangmuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setFuwuxiangmuDelete(Integer fuwuxiangmuDelete) {
        this.fuwuxiangmuDelete = fuwuxiangmuDelete;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
