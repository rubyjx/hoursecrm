package com.zxxz.crm.vo;

import java.util.List;

/**
 * 客户的实体类
 *
 */
public class CustomerInfo {

	/**
	 * 客户对应的数目
	 */
	private Integer num;

	/**
	 * 客户编号
	 */
	private Integer customerId;

	/**
	 * 客户状态编号
	 */
	private Integer conditionId;

	/**
	 * 客户状态
	 */
	private String customerCondition;

	/**
	 * 客户类型编号
	 */
	private Integer typeId;

	/**
	 * 客户类型
	 */
	private String customerType;

	/**
	 * 客户所属员工编号
	 */
	private Integer userId;

	/**
	 * 客户所属员工
	 */
	private String customerForUser;

	/**
	 * 客户来源编号
	 */
	private Integer sourceId;

	/**
	 * 客户来源
	 */
	private String customerSource;

	/**
	 * 客户姓名
	 */
	private String customerName;

	/**
	 * 客户性别
	 */
	private String customerSex;

	/**
	 * 客户手机号码
	 */
	private String customerMobile;

	/**
	 * 客户QQ号码
	 */
	private String customerQq;

	/**
	 * 客户住址
	 */
	private String customerAddress;

	/**
	 * 客户邮箱
	 */
	private String customerEmail;

	/**
	 * 客户备注
	 */
	private String customerRemark;

	/**
	 * 客户职位
	 */
	private String customerJob;

	/**
	 * 客户微博
	 */
	private String customerBlog;

	/**
	 * 客户座机号码
	 */
	private String customerTel;

	/**
	 * 客户MSN
	 */
	private String customerMsn;

	/**
	 * 客户出生日期
	 */
	private String customerBirthday;

	/**
	 * 客户添加时间
	 */
	private String customerAddTime;

	/**
	 * 客户添加人
	 */
	private String customerAddMan;

	/**
	 * 客户修改时间
	 */
	private String customerChangeTime;

	/**
	 * 客户修改人
	 */
	private String customerChangeMan;

	/**
	 * 客户所属公司
	 */
	private String customerCompany;

	/**
	 * 客户是否有效
	 */
	private String isUsed;
	/**
	 * 多对1客户对应的员工
	 * @return
	 */
	private UserInfo userinfo;
    /**
     * 客户来源对应1个客户
     * @return
     */
	private CustomerConditionInfo customerConditionInfo;
	
	/**
	 * 客户来源1对 多客户
	 * @return
	 */
	private CustomerSourceInfo customerSourceInfo;
	/**
	 * 客户类型 
	 * @return
	 */
	private CustomerTypeInfo customerTypeInfo;
	


	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerSex() {
		return customerSex;
	}

	public void setCustomerSex(String customerSex) {
		this.customerSex = customerSex;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerQq() {
		return customerQq;
	}

	public void setCustomerQq(String customerQq) {
		this.customerQq = customerQq;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerRemark() {
		return customerRemark;
	}

	public void setCustomerRemark(String customerRemark) {
		this.customerRemark = customerRemark;
	}

	public String getCustomerJob() {
		return customerJob;
	}

	public void setCustomerJob(String customerJob) {
		this.customerJob = customerJob;
	}

	public String getCustomerBlog() {
		return customerBlog;
	}

	public void setCustomerBlog(String customerBlog) {
		this.customerBlog = customerBlog;
	}

	public String getCustomerTel() {
		return customerTel;
	}

	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}

	public String getCustomerMsn() {
		return customerMsn;
	}

	public void setCustomerMsn(String customerMsn) {
		this.customerMsn = customerMsn;
	}

	public String getCustomerBirthday() {
		return customerBirthday;
	}

	public void setCustomerBirthday(String customerBirthday) {
		this.customerBirthday = customerBirthday;
	}

	public String getCustomerAddTime() {
		return customerAddTime;
	}

	public void setCustomerAddTime(String customerAddTime) {
		this.customerAddTime = customerAddTime;
	}

	public String getCustomerChangeTime() {
		return customerChangeTime;
	}

	public void setCustomerChangeTime(String customerChangeTime) {
		this.customerChangeTime = customerChangeTime;
	}

	public String getCustomerChangeMan() {
		return customerChangeMan;
	}

	public void setCustomerChangeMan(String customerChangeMan) {
		this.customerChangeMan = customerChangeMan;
	}

	public String getCustomerCompany() {
		return customerCompany;
	}

	public void setCustomerCompany(String customerCompany) {
		this.customerCompany = customerCompany;
	}

	public String getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}

	public String getCustomerCondition() {
		return customerCondition;
	}

	public void setCustomerCondition(String customerCondition) {
		this.customerCondition = customerCondition;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getCustomerForUser() {
		return customerForUser;
	}

	public void setCustomerForUser(String customerForUser) {
		this.customerForUser = customerForUser;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getConditionId() {
		return conditionId;
	}

	public void setConditionId(Integer conditionId) {
		this.conditionId = conditionId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getSourceId() {
		return sourceId;
	}

	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}

	public String getCustomerSource() {
		return customerSource;
	}

	public void setCustomerSource(String customerSource) {
		this.customerSource = customerSource;
	}

	public String getCustomerAddMan() {
		return customerAddMan;
	}

	public void setCustomerAddMan(String customerAddMan) {
		this.customerAddMan = customerAddMan;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

	public CustomerConditionInfo getCustomerConditionInfo() {
		return customerConditionInfo;
	}

	public void setCustomerConditionInfo(CustomerConditionInfo customerConditionInfo) {
		this.customerConditionInfo = customerConditionInfo;
	}

	public CustomerSourceInfo getCustomerSourceInfo() {
		return customerSourceInfo;
	}

	public void setCustomerSourceInfo(CustomerSourceInfo customerSourceInfo) {
		this.customerSourceInfo = customerSourceInfo;
	}

	public CustomerTypeInfo getCustomerTypeInfo() {
		return customerTypeInfo;
	}

	public void setCustomerTypeInfo(CustomerTypeInfo customerTypeInfo) {
		this.customerTypeInfo = customerTypeInfo;
	}

	@Override
	public String toString() {
		return "CustomerInfo [num=" + num + ", customerId=" + customerId + ", conditionId=" + conditionId
				+ ", customerCondition=" + customerCondition + ", typeId=" + typeId + ", customerType=" + customerType
				+ ", userId=" + userId + ", customerForUser=" + customerForUser + ", sourceId=" + sourceId
				+ ", customerSource=" + customerSource + ", customerName=" + customerName + ", customerSex="
				+ customerSex + ", customerMobile=" + customerMobile + ", customerQq=" + customerQq
				+ ", customerAddress=" + customerAddress + ", customerEmail=" + customerEmail + ", customerRemark="
				+ customerRemark + ", customerJob=" + customerJob + ", customerBlog=" + customerBlog + ", customerTel="
				+ customerTel + ", customerMsn=" + customerMsn + ", customerBirthday=" + customerBirthday
				+ ", customerAddTime=" + customerAddTime + ", customerAddMan=" + customerAddMan
				+ ", customerChangeTime=" + customerChangeTime + ", customerChangeMan=" + customerChangeMan
				+ ", customerCompany=" + customerCompany + ", isUsed=" + isUsed + ", userinfo=" + userinfo
				+ ", customerConditionInfo=" + customerConditionInfo + ", customerSourceInfo=" + customerSourceInfo
				+ ", customerTypeInfo=" + customerTypeInfo + "]";
	}

	

}
