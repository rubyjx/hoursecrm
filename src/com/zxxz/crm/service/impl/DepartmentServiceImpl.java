package com.zxxz.crm.service.impl;

import com.zxxz.crm.dao.DepartmentDao;
import com.zxxz.crm.service.DepartmentService;
import com.zxxz.crm.vo.DepartmentInfo;

/**
 * 定义部门的业务层实现类
 * @author xuhao
 *
 */
public class DepartmentServiceImpl implements DepartmentService{
	/**
	 * DepartmentDao层
	 */
	private DepartmentDao departmentDao;
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}


	@Override
	public DepartmentInfo getDepartment(Integer departmentId) {
		//根据部门id获取对应的部门信息
		DepartmentInfo departmentInfo = null;
		try {
			departmentInfo = departmentDao.getDepartment(departmentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return departmentInfo;
	}
	
}
