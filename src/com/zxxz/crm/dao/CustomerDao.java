package com.zxxz.crm.dao;

import java.util.List;

import com.zxxz.crm.vo.CustomerInfo;

public interface CustomerDao {
	/**
	 * 根据用户id查询对应下的所有客户
	 * 
	 * @return
	 */
	List<CustomerInfo> findCustomerlistByUserID(int pc,int ic, Integer userId,String customerInput,String queryType);
    /**
     * 获取该员工下的所有客户数量
     * @return
     */
	Long getAllCustomerItemNumber(Integer userId);
	/**
	 * 根据customerId查询客户信息
	 * @param customerId
	 * @return
	 */
	CustomerInfo findCustomerByCustomerId(Integer customerId);
	/**
	 * 根据customerId修改CustomerInfo
	 * @param customerInfo
	 */
	void updateCustomerByCustomerId(CustomerInfo customerInfo);
	/**
	 * 添加用户
	 * @param customerInfo
	 */
	void addUser(CustomerInfo customerInfo);
	/**
	 * 查询所有员工信息
	 * @return
	 */
	List<CustomerInfo> findAllCustomer();

	
}
