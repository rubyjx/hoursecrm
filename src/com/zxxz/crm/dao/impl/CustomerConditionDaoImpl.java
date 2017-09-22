package com.zxxz.crm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zxxz.crm.dao.CustomerConditionDao;
import com.zxxz.crm.vo.CustomerConditionInfo;

public class CustomerConditionDaoImpl extends HibernateDaoSupport implements CustomerConditionDao{
	/**
     * 根据conditionid获取condition信息
     * @param conditionId
     * @return
     */
	@Override
	public CustomerConditionInfo findConditionInfoByConditionId(Integer conditionId) {
		CustomerConditionInfo customerConditionInfo = this.getHibernateTemplate().get(CustomerConditionInfo.class, conditionId);
		return customerConditionInfo;
	}
	/**
     * 获取所有condition信息
     * @return
     */

	@Override
	public List<CustomerConditionInfo> findAllCondition() {
		@SuppressWarnings("unchecked")
		List<CustomerConditionInfo> find = (List<CustomerConditionInfo>) this.getHibernateTemplate().find("from CustomerConditionInfo");
		return find;
	}
     
}
