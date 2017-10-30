package com.zxxz.crm.dao;

import java.util.List;

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
	
	/**
	 * 根据部门名字获取对应的部门信息如果departmentName为null则获取全部的部门信息
	 * @param departmentName
	 * @return
	 */
	public List<DepartmentInfo> findAllDepartment(String departmentName);
	
	/**
	 * 对传入的部门信息进行新增或修改操作
	 * @param departmentInfo
	 */
	public void saveAndUpdateDepartment(DepartmentInfo departmentInfo);
}
