package com.zxxz.crm.vo;


public class CustomerCareInfo {

	/**
	 *  关怀编号
	 */
	private Integer careId;
	
	/**
	 * 客户编号
	 */
	private Integer customerId;
	
	/**
	 * 客户姓名
	 */
	private String customerName;
	
	/**
	 * 关怀主题
	 */
	private String careTheme;
	
	/**
	 * 关怀方式
	 */
	private String careWay;
	
	/**
	 * 关怀时间
	 */
	private String careTime;
	
	/**
	 * 关怀备注
	 */
	private String careRemark;
	
	/**
	 * 关怀
	 */
	private String careNexttime;
	
	/**
	 * 关怀人
	 */
	private String carePeople;
	
	/**
	 * 是否有效
	 */
	private String isUsed;
	/**
	 * 对应的客户
	 * @return
	 */
    private CustomerInfo customerInfo;
    
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	public Integer getCareId() {
		return careId;
	}

	public void setCareId(Integer careId) {
		this.careId = careId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCareTheme() {
		return careTheme;
	}

	public void setCareTheme(String careTheme) {
		this.careTheme = careTheme;
	}

	public String getCareWay() {
		return careWay;
	}

	public void setCareWay(String careWay) {
		this.careWay = careWay;
	}

	public String getCareTime() {
		return careTime;
	}

	public void setCareTime(String careTime) {
		this.careTime = careTime;
	}

	public String getCareRemark() {
		return careRemark;
	}

	public void setCareRemark(String careRemark) {
		this.careRemark = careRemark;
	}

	public String getCareNexttime() {
		return careNexttime;
	}

	public void setCareNexttime(String careNexttime) {
		this.careNexttime = careNexttime;
	}

	public String getCarePeople() {
		return carePeople;
	}

	public void setCarePeople(String carePeople) {
		this.carePeople = carePeople;
	}

	public String getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "CustomerCareInfo [careId=" + careId + ", customerId=" + customerId + ", customerName=" + customerName
				+ ", careTheme=" + careTheme + ", careWay=" + careWay + ", careTime=" + careTime + ", careRemark="
				+ careRemark + ", careNexttime=" + careNexttime + ", carePeople=" + carePeople + ", isUsed=" + isUsed
				+ ", customerInfo=" + customerInfo + "]";
	}
	
}
