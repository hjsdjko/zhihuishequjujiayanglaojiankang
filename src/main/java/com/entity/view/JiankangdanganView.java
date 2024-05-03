package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JiankangdanganEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 档案信息
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jiankangdangan")
public class JiankangdanganView extends JiankangdanganEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 档案类型的值
	*/
	@ColumnInfo(comment="档案类型的字典表值",type="varchar(200)")
	private String jiankangdanganValue;

	//级联表 老人
		/**
		* 老人姓名
		*/

		@ColumnInfo(comment="老人姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 头像
		*/

		@ColumnInfo(comment="头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 身份证号
		*/

		@ColumnInfo(comment="身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 年龄
		*/

		@ColumnInfo(comment="年龄",type="int(11)")
		private Integer yonghuAge;
		/**
		* 健康指标
		*/
		@ColumnInfo(comment="健康指标",type="int(11)")
		private Integer jiankangTypes;
			/**
			* 健康指标的值
			*/
			@ColumnInfo(comment="健康指标的字典表值",type="varchar(200)")
			private String jiankangValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yonghuDelete;



	public JiankangdanganView() {

	}

	public JiankangdanganView(JiankangdanganEntity jiankangdanganEntity) {
		try {
			BeanUtils.copyProperties(this, jiankangdanganEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 档案类型的值
	*/
	public String getJiankangdanganValue() {
		return jiankangdanganValue;
	}
	/**
	* 设置： 档案类型的值
	*/
	public void setJiankangdanganValue(String jiankangdanganValue) {
		this.jiankangdanganValue = jiankangdanganValue;
	}


	//级联表的get和set 老人

		/**
		* 获取： 老人姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 老人姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 联系方式
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 年龄
		*/
		public Integer getYonghuAge() {
			return yonghuAge;
		}
		/**
		* 设置： 年龄
		*/
		public void setYonghuAge(Integer yonghuAge) {
			this.yonghuAge = yonghuAge;
		}
		/**
		* 获取： 健康指标
		*/
		public Integer getJiankangTypes() {
			return jiankangTypes;
		}
		/**
		* 设置： 健康指标
		*/
		public void setJiankangTypes(Integer jiankangTypes) {
			this.jiankangTypes = jiankangTypes;
		}


			/**
			* 获取： 健康指标的值
			*/
			public String getJiankangValue() {
				return jiankangValue;
			}
			/**
			* 设置： 健康指标的值
			*/
			public void setJiankangValue(String jiankangValue) {
				this.jiankangValue = jiankangValue;
			}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}


	@Override
	public String toString() {
		return "JiankangdanganView{" +
			", jiankangdanganValue=" + jiankangdanganValue +
			", yonghuName=" + yonghuName +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhone=" + yonghuPhone +
			", yonghuEmail=" + yonghuEmail +
			", yonghuAge=" + yonghuAge +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
