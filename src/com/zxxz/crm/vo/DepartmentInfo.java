package com.zxxz.crm.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * 部门信息的实体类
 *
 */
public class DepartmentInfo {
	
	/**
	 * 部门编号
	 */
	private int departmentId;
	
	/**
	 * 部门名称
	 */
	private String departmentName;

	/**
	 * 部门介绍
	 */
	private String departmentDesc;
	
	/**
	 * 是否有效
	 */
	private String isUsed;
	
	/**
	 * 定义被本类约束的外键信息
	 * @return
	 */
	private Set<UserInfo> userInfoSet = new HashSet<UserInfo>();
	

	public Set<UserInfo> getUserInfoSet() {
		return userInfoSet;
	}

	public void setUserInfoSet(Set<UserInfo> userInfoSet) {
		this.userInfoSet = userInfoSet;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentDesc() {
		return departmentDesc;
	}

	public void setDepartmentDesc(String departmentDesc) {
		this.departmentDesc = departmentDesc;
	}

	public String getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}
}
