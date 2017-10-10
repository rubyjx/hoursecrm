package com.zxxz.crm.service;

import java.util.List;

import com.zxxz.crm.vo.CustomerTypeInfo;

public interface CustomerTypeService {

	List<CustomerTypeInfo> findAllcustomerTypeInfo();

	List<CustomerTypeInfo> findCustomerByTypeName(String typeName);

	void deleteType(CustomerTypeInfo customerType);

	void addType(CustomerTypeInfo customerType);

}
