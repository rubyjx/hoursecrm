package com.zxxz.crm.dao;

import java.util.List;

import com.zxxz.crm.vo.HouseInfo;

/**
 * 
 * @author xuhao
 * 定义房屋信息的Dao接口类
 */
public interface HouseDao {
	/**
	 * 获取全部的房屋信息
	 * @return
	 */
	public List<HouseInfo> getAllHouse(String queryType,String houseInput,int userId);
	/**
	 * 新增一条房屋信息
	 * @param houseInfo
	 * @return 
	 */
	public boolean addHouse(HouseInfo houseInfo);
	
	/**
	 * 根据id获取对应的房屋信息
	 * @param houseId
	 * @return
	 */
	public HouseInfo getHouse(int houseId);
	
	/**
	 * 更改一条房屋信息
	 * @param houseInfo
	 */
	public void updateHouse(HouseInfo houseInfo);
}
