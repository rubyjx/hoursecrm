package com.zxxz.crm.service;

import java.util.List;
import java.util.Map;

import com.zxxz.crm.vo.CustomerCareInfo;
import com.zxxz.crm.vo.CustomerInfo;
import com.zxxz.crm.vo.PageBean;
import com.zxxz.crm.vo.UserInfo;

public interface CustomerService {
	/**
	 * 根据用户id查询对应下的所有客户
	 * 
	 * @return
	 */
	PageBean<CustomerInfo> findCustomerlistByUserID(int pc,int ic,String url, Integer userId,String customerInput,String queryType);
    /**
     * 根据customerId查询具体用户
     */
	CustomerInfo findCustomerByCustomerId(Integer customerId);
	/**
	 * 根据customerId修改数据
	 * @param customerInfo
	 */
	void updateCustomerByCustomerId(CustomerInfo customerInfo,Integer position);
	/**
	 * 查询所有需要的信息
	 * @return
	 */

	List findAllOtherData();
	/**
	 * 增加员工信息
	 * @param customerInfo
	 */
	void addCustomer(CustomerInfo customerInfo);
	/**
	 * 根据条件将Customerlist返回
	 * @param str
	 * @return
	 */
	List<CustomerInfo> findCustomerByCondition(String[] str);
	/**
	 * 批量将客户分配给对应的员工
	 * @param str
	 */
	void updateCustomerByCondition(String[] str,Integer userId);
	/**
	 * 查询所有员工的信息
	 * @return
	 */
	List<UserInfo> findAllUser();
	/**
	 * 查询所有CustomerInfo
	 * @return
	 */
	List<CustomerInfo> findAllCustomer();
	


}
