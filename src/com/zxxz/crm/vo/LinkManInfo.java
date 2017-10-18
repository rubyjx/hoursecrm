package com.zxxz.crm.vo;

/**
 * 联系人的实体类
 * 
 * 
 */

public class LinkManInfo {

	/**
	 * 联系人编号
	 */
	private int linkmanId;

	/**
	 * 客户编号
	 */

	private int customerId;

	/**
	 * 客户名称
	 */
	private String customerName;

	/**
	 * 联系人姓名
	 */
	private String linkmanName;

	/**
	 * 联系人性别
	 */
	private String linkmanSex;

	/**
	 * 联系人年龄
	 */
	private int linkmanAge;

	/**
	 * 联系人职业
	 */
	private String linkmanJob;

	/**
	 * 联系人手机号码
	 */
	private String linkmanMobile;

	/**
	 * 联系人与客户关系
	 */
	private String linkmanRelation;

	/**
	 * 是否有效
	 */
	private String isUsed;

	private CustomerInfo customerInfo;

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	public int getLinkmanId() {
		return linkmanId;
	}

	public void setLinkmanId(int linkmanId) {
		this.linkmanId = linkmanId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getLinkmanName() {
		return linkmanName;
	}

	public void setLinkmanName(String linkmanName) {
		this.linkmanName = linkmanName;
	}

	public String getLinkmanSex() {
		return linkmanSex;
	}

	public void setLinkmanSex(String linkmanSex) {
		this.linkmanSex = linkmanSex;
	}

	public int getLinkmanAge() {
		return linkmanAge;
	}

	public void setLinkmanAge(int linkmanAge) {
		this.linkmanAge = linkmanAge;
	}

	public String getLinkmanJob() {
		return linkmanJob;
	}

	public void setLinkmanJob(String linkmanJob) {
		this.linkmanJob = linkmanJob;
	}

	public String getLinkmanMobile() {
		return linkmanMobile;
	}

	public void setLinkmanMobile(String linkmanMobile) {
		this.linkmanMobile = linkmanMobile;
	}

	public String getLinkmanRelation() {
		return linkmanRelation;
	}

	public void setLinkmanRelation(String linkmanRelation) {
		this.linkmanRelation = linkmanRelation;
	}

	public String getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}

}
