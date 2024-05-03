package com.entity.vo;

import com.entity.JiankangdanganEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 档案信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiankangdangan")
public class JiankangdanganVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 档案标题
     */

    @TableField(value = "jiankangdangan_name")
    private String jiankangdanganName;


    /**
     * 档案类型
     */

    @TableField(value = "jiankangdangan_types")
    private Integer jiankangdanganTypes;


    /**
     * 档案下载
     */

    @TableField(value = "jiankangdangan_file")
    private String jiankangdanganFile;


    /**
     * 老人
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 档案详情
     */

    @TableField(value = "jiankangdangan_content")
    private String jiankangdanganContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "jiankangdangan_delete")
    private Integer jiankangdanganDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 设置：档案标题
	 */
    public String getJiankangdanganName() {
        return jiankangdanganName;
    }


    /**
	 * 获取：档案标题
	 */

    public void setJiankangdanganName(String jiankangdanganName) {
        this.jiankangdanganName = jiankangdanganName;
    }
    /**
	 * 设置：档案类型
	 */
    public Integer getJiankangdanganTypes() {
        return jiankangdanganTypes;
    }


    /**
	 * 获取：档案类型
	 */

    public void setJiankangdanganTypes(Integer jiankangdanganTypes) {
        this.jiankangdanganTypes = jiankangdanganTypes;
    }
    /**
	 * 设置：档案下载
	 */
    public String getJiankangdanganFile() {
        return jiankangdanganFile;
    }


    /**
	 * 获取：档案下载
	 */

    public void setJiankangdanganFile(String jiankangdanganFile) {
        this.jiankangdanganFile = jiankangdanganFile;
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
	 * 设置：档案详情
	 */
    public String getJiankangdanganContent() {
        return jiankangdanganContent;
    }


    /**
	 * 获取：档案详情
	 */

    public void setJiankangdanganContent(String jiankangdanganContent) {
        this.jiankangdanganContent = jiankangdanganContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getJiankangdanganDelete() {
        return jiankangdanganDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setJiankangdanganDelete(Integer jiankangdanganDelete) {
        this.jiankangdanganDelete = jiankangdanganDelete;
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
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
