package com.zxxz.crm.service;

import com.zxxz.crm.vo.DepartmentInfo;

/**
 * 定义部门的业务层接口
 * @author xuhao
 *
 */
public interface DepartmentService {
	/**
	 * 根据指定的部门id获取对应的部门信息
	 * @param departmentId
	 * @return
	 */
	public DepartmentInfo getDepartment(Integer departmentId);
}
