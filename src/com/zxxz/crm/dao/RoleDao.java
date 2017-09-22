package com.zxxz.crm.dao;

import com.zxxz.crm.vo.RoleInfo;

/**
 * 定义角色持久层接口
 * @author xuhao
 *
 */
public interface RoleDao {
	/**
	 * 根据角色Id获取对应的角色信息
	 * @param rolrId
	 * @return 
	 */
	public RoleInfo getRole(Integer roleId);
	
}
