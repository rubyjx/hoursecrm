package com.zxxz.crm.dao.impl;

import java.util.List;

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

	@Override
	public List<DepartmentInfo> findAllDepartment(String departmentName) {
		// 根据部门名字获取对应的部门信息如果departmentName为null则获取全部的部门信息
		
		List<DepartmentInfo> list = null;
		//定HQL语句
		String hql = "from DepartmentInfo where isUsed=1 ";
		try {
			if(departmentName != null && !departmentName.equals("")){
				hql+= " and departmentName like ?";
				list = (List<DepartmentInfo>) this.getHibernateTemplate().find(hql, "%"+departmentName+"%");
			}else{
				list = (List<DepartmentInfo>) this.getHibernateTemplate().find(hql, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return list;
	}

	@Override
	public void saveAndUpdateDepartment(DepartmentInfo departmentInfo) {
		// 新增或修改部门信息
		try {
			this.getHibernateTemplate().saveOrUpdate(departmentInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
