package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.YishengYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 医生预约
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("yisheng_yuyue")
public class YishengYuyueView extends YishengYuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 预约审核的值
	*/
	@ColumnInfo(comment="预约审核的字典表值",type="varchar(200)")
	private String yishengYuyueYesnoValue;

	//级联表 医生
		/**
		* 医生工号
		*/

		@ColumnInfo(comment="医生工号",type="varchar(200)")
		private String yishengUuidNumber;
		/**
		* 医生名称
		*/

		@ColumnInfo(comment="医生名称",type="varchar(200)")
		private String yishengName;
		/**
		* 科室
		*/
		@ColumnInfo(comment="科室",type="int(11)")
		private Integer yishengTypes;
			/**
			* 科室的值
			*/
			@ColumnInfo(comment="科室的字典表值",type="varchar(200)")
			private String yishengValue;
		/**
		* 职位
		*/
		@ColumnInfo(comment="职位",type="int(11)")
		private Integer zhiweiTypes;
			/**
			* 职位的值
			*/
			@ColumnInfo(comment="职位的字典表值",type="varchar(200)")
			private String zhiweiValue;
		/**
		* 职称
		*/

		@ColumnInfo(comment="职称",type="varchar(200)")
		private String yishengZhichneg;
		/**
		* 医生头像
		*/

		@ColumnInfo(comment="医生头像",type="varchar(200)")
		private String yishengPhoto;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String yishengPhone;
		/**
		* 预约须知
		*/

		@ColumnInfo(comment="预约须知",type="varchar(200)")
		private String yishengGuahao;
		/**
		* 邮箱
		*/

		@ColumnInfo(comment="邮箱",type="varchar(200)")
		private String yishengEmail;
		/**
		* 履历介绍
		*/

		@ColumnInfo(comment="履历介绍",type="text")
		private String yishengContent;
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



	public YishengYuyueView() {

	}

	public YishengYuyueView(YishengYuyueEntity yishengYuyueEntity) {
		try {
			BeanUtils.copyProperties(this, yishengYuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 预约审核的值
	*/
	public String getYishengYuyueYesnoValue() {
		return yishengYuyueYesnoValue;
	}
	/**
	* 设置： 预约审核的值
	*/
	public void setYishengYuyueYesnoValue(String yishengYuyueYesnoValue) {
		this.yishengYuyueYesnoValue = yishengYuyueYesnoValue;
	}


	//级联表的get和set 医生

		/**
		* 获取： 医生工号
		*/
		public String getYishengUuidNumber() {
			return yishengUuidNumber;
		}
		/**
		* 设置： 医生工号
		*/
		public void setYishengUuidNumber(String yishengUuidNumber) {
			this.yishengUuidNumber = yishengUuidNumber;
		}

		/**
		* 获取： 医生名称
		*/
		public String getYishengName() {
			return yishengName;
		}
		/**
		* 设置： 医生名称
		*/
		public void setYishengName(String yishengName) {
			this.yishengName = yishengName;
		}
		/**
		* 获取： 科室
		*/
		public Integer getYishengTypes() {
			return yishengTypes;
		}
		/**
		* 设置： 科室
		*/
		public void setYishengTypes(Integer yishengTypes) {
			this.yishengTypes = yishengTypes;
		}


			/**
			* 获取： 科室的值
			*/
			public String getYishengValue() {
				return yishengValue;
			}
			/**
			* 设置： 科室的值
			*/
			public void setYishengValue(String yishengValue) {
				this.yishengValue = yishengValue;
			}
		/**
		* 获取： 职位
		*/
		public Integer getZhiweiTypes() {
			return zhiweiTypes;
		}
		/**
		* 设置： 职位
		*/
		public void setZhiweiTypes(Integer zhiweiTypes) {
			this.zhiweiTypes = zhiweiTypes;
		}


			/**
			* 获取： 职位的值
			*/
			public String getZhiweiValue() {
				return zhiweiValue;
			}
			/**
			* 设置： 职位的值
			*/
			public void setZhiweiValue(String zhiweiValue) {
				this.zhiweiValue = zhiweiValue;
			}

		/**
		* 获取： 职称
		*/
		public String getYishengZhichneg() {
			return yishengZhichneg;
		}
		/**
		* 设置： 职称
		*/
		public void setYishengZhichneg(String yishengZhichneg) {
			this.yishengZhichneg = yishengZhichneg;
		}

		/**
		* 获取： 医生头像
		*/
		public String getYishengPhoto() {
			return yishengPhoto;
		}
		/**
		* 设置： 医生头像
		*/
		public void setYishengPhoto(String yishengPhoto) {
			this.yishengPhoto = yishengPhoto;
		}

		/**
		* 获取： 联系方式
		*/
		public String getYishengPhone() {
			return yishengPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setYishengPhone(String yishengPhone) {
			this.yishengPhone = yishengPhone;
		}

		/**
		* 获取： 预约须知
		*/
		public String getYishengGuahao() {
			return yishengGuahao;
		}
		/**
		* 设置： 预约须知
		*/
		public void setYishengGuahao(String yishengGuahao) {
			this.yishengGuahao = yishengGuahao;
		}

		/**
		* 获取： 邮箱
		*/
		public String getYishengEmail() {
			return yishengEmail;
		}
		/**
		* 设置： 邮箱
		*/
		public void setYishengEmail(String yishengEmail) {
			this.yishengEmail = yishengEmail;
		}

		/**
		* 获取： 履历介绍
		*/
		public String getYishengContent() {
			return yishengContent;
		}
		/**
		* 设置： 履历介绍
		*/
		public void setYishengContent(String yishengContent) {
			this.yishengContent = yishengContent;
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
		return "YishengYuyueView{" +
			", yishengYuyueYesnoValue=" + yishengYuyueYesnoValue +
			", yonghuName=" + yonghuName +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhone=" + yonghuPhone +
			", yonghuEmail=" + yonghuEmail +
			", yonghuAge=" + yonghuAge +
			", yonghuDelete=" + yonghuDelete +
			", yishengUuidNumber=" + yishengUuidNumber +
			", yishengName=" + yishengName +
			", yishengZhichneg=" + yishengZhichneg +
			", yishengPhoto=" + yishengPhoto +
			", yishengPhone=" + yishengPhone +
			", yishengGuahao=" + yishengGuahao +
			", yishengEmail=" + yishengEmail +
			", yishengContent=" + yishengContent +
			"} " + super.toString();
	}
}
