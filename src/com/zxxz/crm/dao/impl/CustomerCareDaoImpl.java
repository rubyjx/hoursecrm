package com.zxxz.crm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zxxz.crm.dao.CustomerCareDao;
import com.zxxz.crm.vo.CustomerCareInfo;

public class CustomerCareDaoImpl extends HibernateDaoSupport implements CustomerCareDao {

	/**
	 * 查询所有CustomerCareInfo信息
	 * 
	 * @return
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerCareInfo> findAllCustomerCare(String customerInput, String queryType) {
		String hql = "select a from CustomerCareInfo a ,CustomerInfo b where a.customerId=b.customerId and  a.isUsed=1 ";

		List<Object> item = new ArrayList<Object>();
		List<CustomerCareInfo> find = null;
		if (customerInput != null && !"".equals(customerInput.trim())) {
			item.add("%" + customerInput + "%");
			if ("1".equals(queryType)) {
				hql += "  and  b.customerName  like ?";
			} else if ("2".equals(queryType)) {
				hql += "  and  a.careTheme  like ?";
			} else if ("3".equals(queryType)) {
				hql += "  and  a.careWay  like ?";
			}
			find = (List<CustomerCareInfo>) this.getHibernateTemplate().find(hql, item.toArray());
		} else {
			find = (List<CustomerCareInfo>) this.getHibernateTemplate().find(hql);

		}
		return find;
	}

	/**
	 * 根据careId获取CustomerCareInfo对象
	 * 
	 * @param careId
	 * @return
	 */
	@Override
	public CustomerCareInfo findCustomerCareByCareId(Integer careId) {

		return this.getHibernateTemplate().load(CustomerCareInfo.class, careId);
	}

	/**
	 * 修改顾客信息
	 * 
	 * @param customerCareInfo
	 */
	@Override
	public void updateCustomerCare(CustomerCareInfo customerCareInfo) {
		this.getHibernateTemplate().update(customerCareInfo);

	}

	/**
	 * 保存顾客关心信息
	 * 
	 * @param customerCareInfo
	 */
	@Override
	public void saveCustomerCare(CustomerCareInfo customerCareInfo) {
        this.getHibernateTemplate().save(customerCareInfo);
	}

}
