package com.zxxz.crm.service;

import java.util.List;

import com.zxxz.crm.vo.HouseTypeInfo;

/**
 * 
 * @author xuhao
 * 定义房屋类型信息的service的接口类
 */
public interface HouseTypeService {
	
	/**
	 * 获取全部被的房屋信息
	 * @return
	 */
	public List<HouseTypeInfo> getAllHouseType(String houseTypeName);
	
	/**
	 * 根据房屋类型主键获取对应的房屋类型信息
	 * @return
	 */
	public HouseTypeInfo getHouseType(int houseTypeId);
	
	/**
	 * 新增或修改房屋类型信息
	 * @param houseTypeId
	 */
	public void saveOrUpdateHouseType(HouseTypeInfo houseTypeInfo);
	
	/**
	 * 根据房屋类型id删除对应的类型信息(更改对应房屋类型信息的状态位)
	 * @param houseTypeName
	 * @return 
	 */
	public boolean deleteHouseType(int houseTypeId);
}
