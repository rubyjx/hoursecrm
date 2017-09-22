package com.zxxz.crm.vo;

import java.util.List;

public class CustomerSourceInfo {

	/**
	 * 客户来源编号
	 */
	private int sourceId;

	/**
	 * 客户来源名称
	 */
	private String sourceName;

	/**
	 * 客户来源是否有效
	 */
	private String sourceIsUsed;

	/**
	 * 客户来源对应客户
	 * 
	 * @return
	 */
	private List<CustomerInfo> customerlist;

	public List<CustomerInfo> getCustomerlist() {
		return customerlist;
	}

	public void setCustomerlist(List<CustomerInfo> customerlist) {
		this.customerlist = customerlist;
	}

	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourceIsUsed() {
		return sourceIsUsed;
	}

	public void setSourceIsUsed(String sourceIsUsed) {
		this.sourceIsUsed = sourceIsUsed;
	}

}
