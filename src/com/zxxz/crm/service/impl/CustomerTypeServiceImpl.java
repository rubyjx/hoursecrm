package com.zxxz.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.zxxz.crm.dao.CustomerTypeDao;
import com.zxxz.crm.service.CustomerTypeService;
import com.zxxz.crm.vo.CustomerTypeInfo;

@Transactional
public class CustomerTypeServiceImpl implements CustomerTypeService {
	@Autowired
	private CustomerTypeDao cusotmerTypeDao;

	@Override
	public List<CustomerTypeInfo> findAllcustomerTypeInfo() {
		
		return cusotmerTypeDao.findAllType();
	}
     /*根据条件查询用户类型*/
	@Override
	public List<CustomerTypeInfo> findCustomerByTypeName(String typeName) {
		List<CustomerTypeInfo> customertypelist=cusotmerTypeDao.findCustomerTypeByTypeName(typeName);
		return customertypelist;
	}
    //删除用户类型
	@Override
	public void deleteType(CustomerTypeInfo customerType) {
		
		
			CustomerTypeInfo customerTypeInfo=cusotmerTypeDao.findCustomerTypeInfoByTypeId(customerType.getCustomerTypeId());
			customerTypeInfo.setCustomerTypeIsUsed("0");
			cusotmerTypeDao.deleteType(customerTypeInfo);
		
	}
	@Override
	public void addType(CustomerTypeInfo customerType) {
		
		cusotmerTypeDao.addType(customerType);
	}

}
