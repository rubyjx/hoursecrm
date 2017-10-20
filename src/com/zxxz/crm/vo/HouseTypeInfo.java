package com.zxxz.crm.vo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 房屋类型的实体类
 *
 */
public class HouseTypeInfo {

	/**
	 * 房屋类型编号
	 */
	private int houseTypeId;

	/**
	 * 房屋类型名称
	 */
	private String houseTypeName;

	/**
	 * 房屋类型是否有效
	 */
	private String houseTypeIsUsed;

	/**
	 * 定义一对多的外键约束
	 */
	private Set<HouseInfo> houseSet = new HashSet<HouseInfo>();

	public Set<HouseInfo> getHouseSet() {
		return houseSet;
	}

	public void setHouseSet(Set<HouseInfo> houseSet) {
		this.houseSet = houseSet;
	}

	public int getHouseTypeId() {
		return houseTypeId;
	}

	public void setHouseTypeId(int houseTypeId) {
		this.houseTypeId = houseTypeId;
	}

	public String getHouseTypeName() {
		return houseTypeName;
	}

	public void setHouseTypeName(String houseTypeName) {
		this.houseTypeName = houseTypeName;
	}

	public String getHouseTypeIsUsed() {
		return houseTypeIsUsed;
	}

	public void setHouseTypeIsUsed(String houseTypeIsUsed) {
		this.houseTypeIsUsed = houseTypeIsUsed;
	}

}
