package com.zxxz.crm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zxxz.crm.dao.CustomerConditionDao;
import com.zxxz.crm.vo.CustomerConditionInfo;
/**
 * 用户状态Dao层
 * @author leaves
 *
 */
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
		List<CustomerConditionInfo> find = (List<CustomerConditionInfo>) this.getHibernateTemplate().find("from CustomerConditionInfo where  conditionIsUsed=1");
		return find;
	}
	/*根据条件查询用户状态*/
	@Override
	public List<CustomerConditionInfo> findConditionByConditionName(String conditionName) {
		String hql="from CustomerConditionInfo where  conditionIsUsed=1 and  conditionName like ? ";
		List<CustomerConditionInfo> find = (List<CustomerConditionInfo>) this.getHibernateTemplate().find(hql, "%"+conditionName+"%");
		
		return find;
	}
	//删除用户状态
	@Override
	public void deleteCondition(CustomerConditionInfo findConditionInfoByConditionId) {
		this.getHibernateTemplate().update(findConditionInfoByConditionId);
	}
	//增加用户
	@Override
	public void addCondition(CustomerConditionInfo customerConditionInfo) {
		this.getHibernateTemplate().save(customerConditionInfo);
	}
     
}
