package com.zxxz.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.zxxz.crm.dao.CustomerSourceDao;
import com.zxxz.crm.service.CustomerSourceService;
import com.zxxz.crm.vo.CustomerSourceInfo;
/**
 * 顾客来源业务层
 * @author leaves
 *
 */
@Transactional
public class CustomerSourceServiceImpl implements CustomerSourceService {
    @Autowired
	private CustomerSourceDao customerSourceDao;
	//查询所有顾客来源信息
    @Override
	public List<CustomerSourceInfo> findAllSource() {
		List<CustomerSourceInfo> findAllSource = customerSourceDao.findAllSource();
		return findAllSource;
	}
    //根据条件查询顾客来源信息
    @Override
	public List<CustomerSourceInfo> findCustomerSourceBySouceName(String sourceName) {

		return customerSourceDao.findCustomerSouceBySourceName(sourceName);
		
	}
    //删除顾客来源信息
	@Override
	public void deleteSource(CustomerSourceInfo customerSourceInfo) {
		CustomerSourceInfo findCustomerSourceInfoBySourceId = customerSourceDao.findCustomerSourceInfoBySourceId(customerSourceInfo.getSourceId());
		findCustomerSourceInfoBySourceId.setSourceIsUsed("0");
		customerSourceDao.deleteSouce(findCustomerSourceInfoBySourceId);
	     
	}
	//添加顾客来源
	@Override
	public void addSouce(CustomerSourceInfo customerSourceInfo) {
		customerSourceDao.addSouce(customerSourceInfo);
	}



}
