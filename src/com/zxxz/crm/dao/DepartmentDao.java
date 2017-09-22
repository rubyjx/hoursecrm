package com.zxxz.crm.dao;

import com.zxxz.crm.vo.DepartmentInfo;

/**
 * 定义部门类的持久层的接口
 * @author xuhao
 *
 */
public interface DepartmentDao {
	/**
	 * 根据部门id获取对应的部门信息
	 * @param departmentId
	 * @return
	 */
	public DepartmentInfo getDepartment(Integer departmentId);
}
