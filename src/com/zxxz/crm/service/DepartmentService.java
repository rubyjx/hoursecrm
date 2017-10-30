package com.zxxz.crm.service;

import java.util.List;

import com.zxxz.crm.vo.DepartmentInfo;

/**
 * 定义部门的业务层接口
 * @author xuhao
 *
 */
public interface DepartmentService {
	
	/**
	 * 根据部门名称获取对应的部门信息如果departmentName为null则获取全部的部门信息
	 * @param departmentName
	 * @return
	 */
	public List<DepartmentInfo> findAllDepartment(String departmentName);
	
	/**
	 * 根据指定的部门id获取对应的部门信息
	 * @param departmentId
	 * @return
	 */
	public DepartmentInfo getDepartment(Integer departmentId);
	
	/**
	 * 根据部门id删除对应的部门信息(就是将标志位改为0)
	 * @param departmentId
	 * @return 
	 */
	public boolean deleteDepartment(int departmentId);

}
