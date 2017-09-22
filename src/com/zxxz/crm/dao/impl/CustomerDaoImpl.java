package com.zxxz.crm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zxxz.crm.dao.CustomerDao;
import com.zxxz.crm.utils.PageHibernateCallback;
import com.zxxz.crm.vo.CustomerInfo;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
	/**
	 * 根据用户id查询对应下的所有客户
	 * 
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<CustomerInfo> findCustomerlistByUserID(int pc, int ic, Integer userId, String customerInput,
			String queryType) {

		// 拼装条件和参数
		StringBuilder sql = new StringBuilder(
				"select a from CustomerInfo a,CustomerConditionInfo b, CustomerSourceInfo c, CustomerTypeInfo d, UserInfo e "
						+ "  where a.conditionId=b.conditionId and a.sourceId=c.sourceId and a.typeId =d.customerTypeId and a.userId = e.userId  and a.isUsed=1  ");
		List<Object> item = new ArrayList<Object>();

		if (userId != null && userId != 0) {
			sql.append("and a.userId=?");
			item.add(userId);
		}
        
		if (customerInput != null && !"".equals(customerInput.trim())) {
			item.add("%" + queryType + "%");
			if ("1".equals(customerInput)) {
				sql.append(" and  a.customerName  like ? ");
			} else if ("2".equals(customerInput)) {
				sql.append(" and  b.conditionName  like ? ");
			} else if ("3".equals(customerInput)) {
				sql.append(" and  c.sourceName  like ? ");
			} else if ("4".equals(customerInput)) {
				sql.append(" and  d.customerTypeName  like ? ");
			} else if ("5".equals(customerInput)) {
				sql.append(" and e.userName  like ? ");
			} else if ("6".equals(customerInput)) {
				sql.append(" and a.customerCompany  like ? ");
			}

		}

		/**
		 * 查询结果
		 */
		List<CustomerInfo> findByCriteria = null;
		try {
			/*
			 * List<Goods> list=(List<Goods>)
			 * this.getHibernateTemplate().execute((HibernateCallback<Goods>)
			 * new PageHibernateCallback(hql, new Object[]{}, begin, limit));
			 */
			findByCriteria = (List<CustomerInfo>) this.getHibernateTemplate()
					.execute((HibernateCallback<CustomerInfo>) new PageHibernateCallback(sql.toString(), item.toArray(),
							(pc - 1) * ic, ic));
		} catch (DataAccessException e) {

			e.printStackTrace();
		}

		return findByCriteria;
	}

	/**
	 * 查询该用户下的所有客户数量
	 */
	@Override
	public Long getAllCustomerItemNumber(Integer userId) {
		/**
		 * 查询需要的条目数
		 */
		List findByCriteria = null;
		String hql = "select count(*) from CustomerInfo c where 1=1";
		if (userId != null && userId != 0) {
			hql += " and c.userId=? ";
			findByCriteria = this.getHibernateTemplate().find(hql, userId);
		} else {
			findByCriteria = this.getHibernateTemplate().find(hql);
		}

		/**
		 * 查询所有
		 */
		Long customerNum = null;
		try {
			customerNum = (Long) findByCriteria.get(0);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return customerNum;
	}

	/**
	 * 根据customerId查询客户信息
	 * 
	 * @param customerId
	 * @return
	 */
	@Override
	public CustomerInfo findCustomerByCustomerId(Integer customerId) {
		/**
		 * 查询结果
		 */
		CustomerInfo customerInfo = this.getHibernateTemplate().get(CustomerInfo.class, customerId);
		return customerInfo;
	}

	/**
	 * 根据customerId修改CustomerInfo
	 * 
	 * @param customerId
	 */
	@Override
	public void updateCustomerByCustomerId(CustomerInfo customerInfo) {
		/**
		 * 修改数据
		 */
		this.getHibernateTemplate().update(customerInfo);

	}

	@Override
	public void addUser(CustomerInfo customerInfo) {
		/**
		 * 增加用户
		 */
		this.getHibernateTemplate().save(customerInfo);

	}

	/**
	 * 查询所有员工信息
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerInfo> findAllCustomer() {
	   
		return (List<CustomerInfo>) this.getHibernateTemplate().find("from CustomerInfo c where c.isUsed=1");
	}

}
