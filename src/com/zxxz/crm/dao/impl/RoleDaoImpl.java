package com.zxxz.crm.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zxxz.crm.dao.RoleDao;
import com.zxxz.crm.vo.RoleInfo;

public class RoleDaoImpl extends HibernateDaoSupport implements RoleDao{
	
	@Override
	public RoleInfo getRole(Integer roleId) {
		RoleInfo roleInfo = null;
		try {
			// 根据id获取对应的角色信息
			roleInfo = this.getHibernateTemplate().get(RoleInfo.class, roleId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return roleInfo;
	}

}
