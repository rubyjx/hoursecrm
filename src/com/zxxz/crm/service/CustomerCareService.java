package com.zxxz.crm.service;

import java.util.List;

import com.zxxz.crm.vo.CustomerCareInfo;
import com.zxxz.crm.vo.CustomerInfo;

public interface CustomerCareService {
    /**
     * 查询所有关心列表
     * @param customerInput
     * @param queryType
     * @return
     */
	List<CustomerCareInfo> findAllCustomerCareList(String customerInput, String queryType);
	/**
	 * 删除客户关心信息
	 * 
	 * @param careId
	 */
	void deleteCustomerCare(Integer careId);
	/**
	 * 根据careId获取CustomerCareInfo
	 * @param careId
	 * @return
	 */
	CustomerCareInfo findCustomerCareByCustomerCareId(Integer careId);
	/**
	 * 修改顾客关心信息
	 * @param customerCareInfo
	 */
	void updateCustomerCareService(CustomerCareInfo customerCareInfo);
	/**
	 * 保存customerCareInfo
	 * @param customerCareInfo
	 */
	void saveCustomerCare(CustomerCareInfo customerCareInfo);
	
	
}
