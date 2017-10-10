package com.zxxz.crm.service;

import java.util.List;

import com.zxxz.crm.vo.CustomerConditionInfo;

public interface CustomerConditionService {

	List<CustomerConditionInfo> findAllCondition();

	List<CustomerConditionInfo> findCustomerConditionByConditionName(String conditionName);

	void deleteCondition(CustomerConditionInfo customerConditionInfo);

	void addCondition(CustomerConditionInfo customerConditionInfo);



}
