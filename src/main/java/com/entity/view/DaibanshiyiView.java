package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.DaibanshiyiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 事宜信息
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("daibanshiyi")
public class DaibanshiyiView extends DaibanshiyiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 事宜类型的值
	*/
	@ColumnInfo(comment="事宜类型的字典表值",type="varchar(200)")
	private String daibanshiyiValue;

	//级联表 社区工作人员
		/**
		* 工作人员姓名
		*/

		@ColumnInfo(comment="工作人员姓名",type="varchar(200)")
		private String gongzuorenyuanName;
		/**
		* 头像
		*/

		@ColumnInfo(comment="头像",type="varchar(200)")
		private String gongzuorenyuanPhoto;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String gongzuorenyuanPhone;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String gongzuorenyuanEmail;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer gongzuorenyuanDelete;



	public DaibanshiyiView() {

	}

	public DaibanshiyiView(DaibanshiyiEntity daibanshiyiEntity) {
		try {
			BeanUtils.copyProperties(this, daibanshiyiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 事宜类型的值
	*/
	public String getDaibanshiyiValue() {
		return daibanshiyiValue;
	}
	/**
	* 设置： 事宜类型的值
	*/
	public void setDaibanshiyiValue(String daibanshiyiValue) {
		this.daibanshiyiValue = daibanshiyiValue;
	}


	//级联表的get和set 社区工作人员

		/**
		* 获取： 工作人员姓名
		*/
		public String getGongzuorenyuanName() {
			return gongzuorenyuanName;
		}
		/**
		* 设置： 工作人员姓名
		*/
		public void setGongzuorenyuanName(String gongzuorenyuanName) {
			this.gongzuorenyuanName = gongzuorenyuanName;
		}

		/**
		* 获取： 头像
		*/
		public String getGongzuorenyuanPhoto() {
			return gongzuorenyuanPhoto;
		}
		/**
		* 设置： 头像
		*/
		public void setGongzuorenyuanPhoto(String gongzuorenyuanPhoto) {
			this.gongzuorenyuanPhoto = gongzuorenyuanPhoto;
		}

		/**
		* 获取： 联系方式
		*/
		public String getGongzuorenyuanPhone() {
			return gongzuorenyuanPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setGongzuorenyuanPhone(String gongzuorenyuanPhone) {
			this.gongzuorenyuanPhone = gongzuorenyuanPhone;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getGongzuorenyuanEmail() {
			return gongzuorenyuanEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setGongzuorenyuanEmail(String gongzuorenyuanEmail) {
			this.gongzuorenyuanEmail = gongzuorenyuanEmail;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getGongzuorenyuanDelete() {
			return gongzuorenyuanDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setGongzuorenyuanDelete(Integer gongzuorenyuanDelete) {
			this.gongzuorenyuanDelete = gongzuorenyuanDelete;
		}


	@Override
	public String toString() {
		return "DaibanshiyiView{" +
			", daibanshiyiValue=" + daibanshiyiValue +
			", gongzuorenyuanName=" + gongzuorenyuanName +
			", gongzuorenyuanPhoto=" + gongzuorenyuanPhoto +
			", gongzuorenyuanPhone=" + gongzuorenyuanPhone +
			", gongzuorenyuanEmail=" + gongzuorenyuanEmail +
			", gongzuorenyuanDelete=" + gongzuorenyuanDelete +
			"} " + super.toString();
	}
}
