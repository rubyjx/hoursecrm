package com.zxxz.crm.service;

import java.util.List;

import com.zxxz.crm.vo.HouseInfo;

/**
 * 
 * @author xuhao
 * 房屋信息的service接口类
 */
public interface HouseService {
	/**
	 * 获取全部的房屋信息
	 * @return
	 */
	public List<HouseInfo> getAllHouse(String queryType,String houseInput,int userId);
	
	/**
	 * 新增一条房屋信息
	 */
	public boolean addHouse(HouseInfo houseInfo);
	
	/**
	 * 根据数据的id获取对应的房屋信息
	 * @param houseId
	 * @return
	 */
	public HouseInfo getHouse(int houseId);
	
	/**
	 * 更改一条房屋信息
	 * @param houseInfo
	 */
	public void updateHouse(HouseInfo houseInfo);
	
	/**
	 * 删除一条房屋数据
	 * @param houseId
	 */
	public void deleteHouse(int houseId);
}
