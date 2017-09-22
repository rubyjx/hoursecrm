package com.zxxz.crm.vo;

import java.util.List;

/**
 * 客户类型的实体类
 *
 */
public class CustomerTypeInfo {

	/**
	 * 客户类型编号
	 */
	private int customerTypeId;

	/**
	 * 客户类型名称
	 */
	private String customerTypeName;

	/**
	 * 客户类型是否有效
	 */
	private String customerTypeIsUsed;

	/**
	 * 客户类型对应的客户
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

	public int getCustomerTypeId() {
		return customerTypeId;
	}

	public void setCustomerTypeId(int customerTypeId) {
		this.customerTypeId = customerTypeId;
	}

	public String getCustomerTypeName() {
		return customerTypeName;
	}

	public void setCustomerTypeName(String customerTypeName) {
		this.customerTypeName = customerTypeName;
	}

	public String getCustomerTypeIsUsed() {
		return customerTypeIsUsed;
	}

	public void setCustomerTypeIsUsed(String customerTypeIsUsed) {
		this.customerTypeIsUsed = customerTypeIsUsed;
	}
}
