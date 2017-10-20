package com.zxxz.crm.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.zxxz.crm.dao.HouseDao;
import com.zxxz.crm.service.HouseService;
import com.zxxz.crm.vo.HouseInfo;

/**
 * 
 * @author xuhao
 * 房屋信息的service接口的实现类
 * 
 */
public class HouseServiceImpl implements HouseService{
	
	//获取HouseDao
	private HouseDao houseDao;
	
	@Transactional
	@Override
	public List<HouseInfo> getAllHouse(String queryType,String houseInput,int userId) {
		// 获取当前登录用户的全部的房屋信息
		
		List<HouseInfo> list = houseDao.getAllHouse(queryType, houseInput, userId);
	
		//循环获取关联外键中的值给HouseInfo中的参数赋值
		for(int i=0;i<list.size();i++){
			list.get(i).setUserName(list.get(i).getUserInfo().getUserName());
			list.get(i).setTypeName(list.get(i).getHouseTypeInfo().getHouseTypeName());
		}
		
		return list;
	}
	
	@Transactional
	@Override
	public boolean addHouse(HouseInfo houseInfo) {
		//调用Dao中的方法新增一条房屋信息
		boolean b = houseDao.addHouse(houseInfo);
		
		return b;
	}
	
	@Transactional
	@Override
	public HouseInfo getHouse(int houseId) {
		// 根据id获取对应的房屋信息
		HouseInfo houseInfo = houseDao.getHouse(houseId);
		if(houseInfo!=null){
			//对获取对象中的其他变量进行赋值操作
			houseInfo.setUserName(houseInfo.getUserInfo().getUserName());
			houseInfo.setTypeName(houseInfo.getHouseTypeInfo().getHouseTypeName());
		}
		return houseInfo;
	}
	
	@Transactional
	@Override
	public void updateHouse(HouseInfo houseInfo) {
		// 更改一条房屋信息
		houseDao.updateHouse(houseInfo);
		
	}
	
	public HouseDao getHouseDao() {
		return houseDao;
	}
	public void setHouseDao(HouseDao houseDao) {
		this.houseDao = houseDao;
	}
	
	@Transactional
	@Override
	public void deleteHouse(int houseId) {
		//删除一条房屋信息（将标志位改为 0）
		//根据Id获取需要删除的信息再调用update方法更改数据
		HouseInfo houseInfo = houseDao.getHouse(houseId);
		if(houseInfo!=null){
			houseInfo.setIsUsed("0");
		}
		houseDao.updateHouse(houseInfo);

	}


}
