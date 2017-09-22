package com.zxxz.crm.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zxxz.crm.dao.DepartmentDao;
import com.zxxz.crm.vo.DepartmentInfo;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@Override
	public DepartmentInfo getDepartment(Integer departmentId) {
		//根据部门id获取对应的部门信息
		DepartmentInfo departmentInfo = null;
		try {
			departmentInfo = this.getHibernateTemplate().get(DepartmentInfo.class, departmentId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return departmentInfo;
	}
	
	
}
