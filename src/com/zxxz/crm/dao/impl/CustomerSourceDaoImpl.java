package com.zxxz.crm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zxxz.crm.dao.CustomerSourceDao;
import com.zxxz.crm.vo.CustomerSourceInfo;


public class CustomerSourceDaoImpl extends HibernateDaoSupport  implements CustomerSourceDao{
     /**
      * 通过sourceId 获取customerSource
      */
	@Override
	public CustomerSourceInfo findCustomerSourceInfoBySourceId(Integer sourceId) {
		CustomerSourceInfo customerSourceInfo = this.getHibernateTemplate().get(CustomerSourceInfo.class, sourceId);
		return customerSourceInfo;
	}
    /**
     * 获取所有来源信息
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerSourceInfo> findAllSource() {
		List<CustomerSourceInfo> find = (List<CustomerSourceInfo>) this.getHibernateTemplate().find("from CustomerSourceInfo");
		return find;
	}
	
	

}
