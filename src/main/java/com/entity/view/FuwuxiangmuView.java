package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.FuwuxiangmuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 服务项目信息
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("fuwuxiangmu")
public class FuwuxiangmuView extends FuwuxiangmuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 服务项目类型的值
	*/
	@ColumnInfo(comment="服务项目类型的字典表值",type="varchar(200)")
	private String fuwuxiangmuValue;




	public FuwuxiangmuView() {

	}

	public FuwuxiangmuView(FuwuxiangmuEntity fuwuxiangmuEntity) {
		try {
			BeanUtils.copyProperties(this, fuwuxiangmuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 服务项目类型的值
	*/
	public String getFuwuxiangmuValue() {
		return fuwuxiangmuValue;
	}
	/**
	* 设置： 服务项目类型的值
	*/
	public void setFuwuxiangmuValue(String fuwuxiangmuValue) {
		this.fuwuxiangmuValue = fuwuxiangmuValue;
	}




	@Override
	public String toString() {
		return "FuwuxiangmuView{" +
			", fuwuxiangmuValue=" + fuwuxiangmuValue +
			"} " + super.toString();
	}
}
