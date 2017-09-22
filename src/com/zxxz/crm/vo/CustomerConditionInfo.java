package com.zxxz.crm.vo;

import java.util.List;

public class CustomerConditionInfo {

	/**
	 * 客户状态编号
	 */
	private int conditionId;

	/**
	 * 客户状态名称
	 */
	private String conditionName;

	/**
	 * 客户状态描述
	 */
	private String conditionExplain;

	/**
	 * 客户状态是否有效
	 */
	private String conditionIsUsed;

    /**
     * 客户状态对应客户
     * 1对多
     * @return
     */
    private List<CustomerInfo> customerInfolist;
    
	public List<CustomerInfo> getCustomerInfolist() {
		return customerInfolist;
	}

	public void setCustomerInfolist(List<CustomerInfo> customerInfolist) {
		this.customerInfolist = customerInfolist;
	}

	public int getConditionId() {
		return conditionId;
	}

	public void setConditionId(int conditionId) {
		this.conditionId = conditionId;
	}

	public String getConditionName() {
		return conditionName;
	}

	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}

	public String getConditionExplain() {
		return conditionExplain;
	}

	public void setConditionExplain(String conditionExplain) {
		this.conditionExplain = conditionExplain;
	}

	public String getConditionIsUsed() {
		return conditionIsUsed;
	}

	public void setConditionIsUsed(String conditionIsUsed) {
		this.conditionIsUsed = conditionIsUsed;
	}

	@Override
	public String toString() {
		return "CustomerConditionInfo [conditionId=" + conditionId + ", conditionName=" + conditionName
				+ ", conditionExplain=" + conditionExplain + ", conditionIsUsed=" + conditionIsUsed
				+ ", customerInfolist=" + customerInfolist + "]";
	}
	
}
