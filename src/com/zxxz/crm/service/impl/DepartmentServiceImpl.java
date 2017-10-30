package com.zxxz.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

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


	@Override
	public List<DepartmentInfo> findAllDepartment(String departmentName) {
		//根据部门名称获取对应的部门信息如果DepartmentName为null则获取全部的部门信息
		return departmentDao.findAllDepartment(departmentName);
	}

	@Transactional
	@Override
	public boolean deleteDepartment(int departmentId) {
		//根据部门id获取对应的部门信息
		DepartmentInfo departmentInfo = departmentDao.getDepartment(departmentId);
		if(departmentInfo!=null){
			//对状态位进行修改
			departmentInfo.setIsUsed("0");
			//执行持久化操作
			departmentDao.saveAndUpdateDepartment(departmentInfo);
			
			return true;
		}else{
			return false;
		}
	}
	
}
