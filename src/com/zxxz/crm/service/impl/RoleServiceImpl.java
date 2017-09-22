package com.zxxz.crm.service.impl;

import com.zxxz.crm.dao.RoleDao;
import com.zxxz.crm.service.RoleService;
import com.zxxz.crm.vo.RoleInfo;

public class RoleServiceImpl implements RoleService{
	/**
	 * 
	 */
	private RoleDao roleDao;
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}


	@Override
	public RoleInfo getRole(Integer roleId) {
		//定义RoleInfo
		RoleInfo roleInfo = null;
		try {
			roleInfo = roleDao.getRole(roleId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return roleInfo;
	}

}
