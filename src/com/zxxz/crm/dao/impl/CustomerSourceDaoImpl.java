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
		List<CustomerSourceInfo> find = (List<CustomerSourceInfo>) this.getHibernateTemplate().find("from CustomerSourceInfo where sourceIsUsed =1");
		return find;
	}
	//根据条件查询顾客来源
	@Override
	public List<CustomerSourceInfo> findCustomerSouceBySourceName(String sourceName) {
        String hql="from CustomerSourceInfo where sourceIsUsed =1 and sourceName like ?";
		List<CustomerSourceInfo> find = (List<CustomerSourceInfo>) this.getHibernateTemplate().find(hql, "%"+sourceName+"%");
		return find;
	}
	//修改顾客信息
	@Override
	public void deleteSouce(CustomerSourceInfo findCustomerSourceInfoBySourceId) {
		this.getHibernateTemplate().update(findCustomerSourceInfoBySourceId);
	}
	//添加顾客来源
	@Override
	public void addSouce(CustomerSourceInfo customerSourceInfo) {
		this.getHibernateTemplate().save(customerSourceInfo);
	}
	
	

}
