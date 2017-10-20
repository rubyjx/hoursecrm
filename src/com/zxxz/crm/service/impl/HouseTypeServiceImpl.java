package com.zxxz.crm.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.zxxz.crm.dao.HouseTypeDao;
import com.zxxz.crm.service.HouseTypeService;
import com.zxxz.crm.vo.HouseTypeInfo;

/**
 * 
 * @author xuhao
 * 实现房屋类型信息service接口
 */
public class HouseTypeServiceImpl implements HouseTypeService{
	///获取注入到service中的 Dao接口
	private HouseTypeDao houseTypeDao;

	@Override
	public List<HouseTypeInfo> getAllHouseType(String houseTypeName) {
		//获取全部的房屋类型信息
		
		List<HouseTypeInfo> list = null;
		
		//调用dao接口中的方法获取全部的房屋类型信息
		list = houseTypeDao.getAllHouseType(houseTypeName);
		
		return list;
	}
	
	@Transactional
	@Override
	public boolean deleteHouseType(int houseTypeId) {
		// 根据房屋类型名字删除对应的类型信息(改变对应的房屋类型信息的标志位)
		//根据房屋类型id获取对应的信息
		HouseTypeInfo houseTypeInfo = houseTypeDao.getHouseType(houseTypeId);
		if(houseTypeInfo!=null){
			houseTypeInfo.setHouseTypeIsUsed("0");
			
			houseTypeDao.saveOrUpdateHouseType(houseTypeInfo);
			
			return true;
		}else{
			return false;
		}
	}
	
	@Transactional
	@Override
	public void saveOrUpdateHouseType(HouseTypeInfo houseTypeInfo) {
		// 新增或修改房屋类型信息
		//调用dao中的方法新增一条房屋类型信息
		houseTypeDao.saveOrUpdateHouseType(houseTypeInfo);
		
	}
	
	@Transactional
	@Override
	public HouseTypeInfo getHouseType(int houseTypeId) {
		//根据id获取对应的房屋类型
		HouseTypeInfo houseTypeInfo = houseTypeDao.getHouseType(houseTypeId);
		
		return houseTypeInfo;
	}

	
	public HouseTypeDao getHouseTypeDao() {
		return houseTypeDao;
	}

	public void setHouseTypeDao(HouseTypeDao houseTypeDao) {
		this.houseTypeDao = houseTypeDao;
	}


}
