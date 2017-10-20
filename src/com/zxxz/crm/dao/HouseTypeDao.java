package com.zxxz.crm.dao;

import java.util.List;

import com.zxxz.crm.vo.HouseTypeInfo;

/**
 * 
 * @author xuhao
 * 定义房屋信息的Dao接口
 */
public interface HouseTypeDao {
	/**
	 * 获取全部的房屋信息
	 * @return
	 */
	public List<HouseTypeInfo> getAllHouseType(String houseTypeName);
	
	/**
	 * 根据房屋类型Id获取对应的房屋类型信息
	 * @param houseTypeId
	 * @return
	 */
	public HouseTypeInfo getHouseType(int houseTypeId);
	
	/**
	 * 新增或修改房屋类型信息
	 * @param houseTypeId
	 */
	public void saveOrUpdateHouseType(HouseTypeInfo houseTypeInfo);
	
}
