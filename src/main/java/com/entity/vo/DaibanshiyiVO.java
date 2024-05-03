package com.entity.vo;

import com.entity.DaibanshiyiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 事宜信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("daibanshiyi")
public class DaibanshiyiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 事宜标题
     */

    @TableField(value = "daibanshiyi_name")
    private String daibanshiyiName;


    /**
     * 事宜类型
     */

    @TableField(value = "daibanshiyi_types")
    private Integer daibanshiyiTypes;


    /**
     * 工作人员
     */

    @TableField(value = "gongzuorenyuan_id")
    private Integer gongzuorenyuanId;


    /**
     * 事宜封面
     */

    @TableField(value = "daibanshiyi_photo")
    private String daibanshiyiPhoto;


    /**
     * 事宜简介
     */

    @TableField(value = "daibanshiyi_content")
    private String daibanshiyiContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "daibanshiyi_delete")
    private Integer daibanshiyiDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


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
	 * 设置：事宜标题
	 */
    public String getDaibanshiyiName() {
        return daibanshiyiName;
    }


    /**
	 * 获取：事宜标题
	 */

    public void setDaibanshiyiName(String daibanshiyiName) {
        this.daibanshiyiName = daibanshiyiName;
    }
    /**
	 * 设置：事宜类型
	 */
    public Integer getDaibanshiyiTypes() {
        return daibanshiyiTypes;
    }


    /**
	 * 获取：事宜类型
	 */

    public void setDaibanshiyiTypes(Integer daibanshiyiTypes) {
        this.daibanshiyiTypes = daibanshiyiTypes;
    }
    /**
	 * 设置：工作人员
	 */
    public Integer getGongzuorenyuanId() {
        return gongzuorenyuanId;
    }


    /**
	 * 获取：工作人员
	 */

    public void setGongzuorenyuanId(Integer gongzuorenyuanId) {
        this.gongzuorenyuanId = gongzuorenyuanId;
    }
    /**
	 * 设置：事宜封面
	 */
    public String getDaibanshiyiPhoto() {
        return daibanshiyiPhoto;
    }


    /**
	 * 获取：事宜封面
	 */

    public void setDaibanshiyiPhoto(String daibanshiyiPhoto) {
        this.daibanshiyiPhoto = daibanshiyiPhoto;
    }
    /**
	 * 设置：事宜简介
	 */
    public String getDaibanshiyiContent() {
        return daibanshiyiContent;
    }


    /**
	 * 获取：事宜简介
	 */

    public void setDaibanshiyiContent(String daibanshiyiContent) {
        this.daibanshiyiContent = daibanshiyiContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getDaibanshiyiDelete() {
        return daibanshiyiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setDaibanshiyiDelete(Integer daibanshiyiDelete) {
        this.daibanshiyiDelete = daibanshiyiDelete;
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
