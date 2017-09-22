package com.zxxz.crm.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * 权限是实体类
 *
 */
public class RoleInfo {
	
	/**
	 * 权限编号
	 */
	private Integer roleId;
	
	/**
	 * 权限名称
	 */
	private String roleName;
	
	/**
	 * 权限权利
	 */
	private String rolePower;
	
	/**
	 * 是否有效
	 */
	private String isUsed;
	
	/**
	 * 定义约束的外键信息
	 * @return
	 */
	private Set<UserInfo> userSet = new HashSet<UserInfo>();
	

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRolePower() {
		return rolePower;
	}

	public void setRolePower(String rolePower) {
		this.rolePower = rolePower;
	}

	public String getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}

	public Set<UserInfo> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<UserInfo> userSet) {
		this.userSet = userSet;
	}
	

}
