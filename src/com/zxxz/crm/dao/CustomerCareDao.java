package com.zxxz.crm.dao;
import java.util.List;

import com.zxxz.crm.vo.CustomerCareInfo;
public interface CustomerCareDao {
	/**
	 * 查询所有CustomerCareInfo信息
	 * @return
	 */
	List<CustomerCareInfo> findAllCustomerCare(String customerInput, String queryType);
    /**
     * 根据careId获取CustomerCareInfo对象
     * @param careId
     * @return
     */
	CustomerCareInfo findCustomerCareByCareId(Integer careId);
	/**
	 * 修改顾客信息
	 * @param customerCareInfo
	 */
	void updateCustomerCare(CustomerCareInfo customerCareInfo);
	/**
	 * 保存顾客关心信息
	 * @param customerCareInfo
	 */
	void saveCustomerCare(CustomerCareInfo customerCareInfo);
	
  
}
