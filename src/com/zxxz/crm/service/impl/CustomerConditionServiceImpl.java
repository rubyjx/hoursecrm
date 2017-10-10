package com.zxxz.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.zxxz.crm.dao.CustomerConditionDao;
import com.zxxz.crm.service.CustomerConditionService;
import com.zxxz.crm.vo.CustomerConditionInfo;
@Transactional
public class CustomerConditionServiceImpl  implements CustomerConditionService{
    @Autowired
	private   CustomerConditionDao customerConditionDao;
    //显示所有客户状态信息
	@Override
	public List<CustomerConditionInfo> findAllCondition() {
		List<CustomerConditionInfo> findAllCondition = customerConditionDao.findAllCondition();
		return findAllCondition;
	}
    /*根据条件查询客户状态*/
	@Override
	public List<CustomerConditionInfo> findCustomerConditionByConditionName(String conditionName) {
		List<CustomerConditionInfo> conditionList=customerConditionDao.findConditionByConditionName(conditionName);
		return conditionList;
	}
	//删除用户状态（假删除）
	@Override
	public void deleteCondition(CustomerConditionInfo customerConditionInfo) {
		CustomerConditionInfo findConditionInfoByConditionId = customerConditionDao.findConditionInfoByConditionId(customerConditionInfo.getConditionId());
		findConditionInfoByConditionId.setConditionIsUsed("0");
		customerConditionDao.deleteCondition(findConditionInfoByConditionId);
	     
	}
	//增加用户状态
	@Override
	public void addCondition(CustomerConditionInfo customerConditionInfo) {
		customerConditionDao.addCondition(customerConditionInfo);
		
	}
	
    
}
