package com.zxxz.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.zxxz.crm.dao.CustomerCareDao;
import com.zxxz.crm.dao.CustomerDao;
import com.zxxz.crm.service.CustomerCareService;
import com.zxxz.crm.vo.CustomerCareInfo;
import com.zxxz.crm.vo.CustomerInfo;

@Transactional
public class CustomerCareServiceImpl implements CustomerCareService {
	@Resource(name = "customerCareDao")
	private CustomerCareDao customerCareDao;
	@Resource(name = "customerDao")
	private CustomerDao customerDao;
	/**
	 * 查询所有关心列表
	 * 
	 * @param customerInput
	 * @param queryType
	 * @return
	 */
	@Override
	public List<CustomerCareInfo> findAllCustomerCareList(String customerInput, String queryType) {
		List<CustomerCareInfo> customerCareList = customerCareDao.findAllCustomerCare(customerInput, queryType);
		for (CustomerCareInfo customerCareInfo : customerCareList) {
			customerCareInfo.getCustomerInfo().getCustomerName();
		}

		return customerCareList;

	}

	/**
	 * 删除客户关心信息
	 * 
	 * @param careId
	 */
	@Override
	public void deleteCustomerCare(Integer careId) {
		/*
		 * 获取careID 查询CustomerCareInfo信息 修改isUsed信息 执行update操作。
		 */
		CustomerCareInfo careInfo = customerCareDao.findCustomerCareByCareId(careId);
		// 修改isused属性会自动同步到数据库中
		careInfo.setIsUsed("0");
	}

	/**
	 * 根据careId获取CustomerCareInfo
	 * 
	 * @param careId
	 * @return
	 */
	@Override
	public CustomerCareInfo findCustomerCareByCustomerCareId(Integer careId) {
		CustomerCareInfo findCustomerCareByCareId = customerCareDao.findCustomerCareByCareId(careId);
	    System.out.println(findCustomerCareByCareId);
		return findCustomerCareByCareId;
	}
	/**
	 * 修改顾客关心信息
	 * @param customerCareInfo
	 */
	@Override
	public void updateCustomerCareService(CustomerCareInfo customerCareInfo) {
		CustomerInfo Customer = customerDao.findCustomerByCustomerId(customerCareInfo.getCustomerId());
		customerCareInfo.setCustomerInfo(Customer);
		customerCareDao.updateCustomerCare(customerCareInfo);
	}
	/**
	 * 保存customerCareInfo
	 * @param customerCareInfo
	 */
	@Override
	public void saveCustomerCare(CustomerCareInfo customerCareInfo) {
		//CustomerInfo Customer = customerDao.findCustomerByCustomerId(customerCareInfo.getCustomerId());
		//customerCareInfo.setCustomerInfo(Customer);
		customerCareInfo.setIsUsed("1");
		customerCareDao.saveCustomerCare(customerCareInfo);	
	}

}
