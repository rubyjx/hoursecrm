package com.zxxz.crm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zxxz.crm.dao.CustomerTypeDao;
import com.zxxz.crm.vo.CustomerInfo;
import com.zxxz.crm.vo.CustomerTypeInfo;

public class CustomerTypeDaoImpl extends HibernateDaoSupport implements CustomerTypeDao {
	/**
	 * 根据typeId获取typeInfo信息
	 */
	@Override
	public CustomerTypeInfo findCustomerTypeInfoByTypeId(Integer typeId) {
		CustomerTypeInfo customerTypeInfo = this.getHibernateTemplate().get(CustomerTypeInfo.class, typeId);
		return customerTypeInfo;
	}

	/**
	 * 获取所有类型信息
	 */
	@Override
	public List<CustomerTypeInfo> findAllType() {
		@SuppressWarnings("unchecked")
		List<CustomerTypeInfo> find = (List<CustomerTypeInfo>) this.getHibernateTemplate()
				.find("from CustomerTypeInfo");
		return find;
	}
   

}
