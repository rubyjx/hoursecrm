package com.zxxz.crm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zxxz.crm.dao.HouseTypeDao;
import com.zxxz.crm.vo.HouseTypeInfo;

/**
 * 实现房屋类型信息的Dao接口类
 * @author xuhao
 *
 */
public class HouseTypeDaoImpe extends HibernateDaoSupport implements HouseTypeDao{

	@Override
	public List<HouseTypeInfo> getAllHouseType(String houseTypeName) {
		//获取全部的房屋类型信息Or获取对应信息房屋类型数据
		
		//定义List集合存放全部的房屋类型信息
		List<HouseTypeInfo> list = null;
		//定义HQL语句
		String hql = "from HouseTypeInfo where houseTypeIsUsed=1";
		
		if(houseTypeName!=null && !houseTypeName.equals("")){
			hql+=" and houseTypeName like ?";
			
			try {
				//执行hql语句
				list = (List<HouseTypeInfo>) this.getHibernateTemplate().find(hql,"%"+houseTypeName+"%");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else{
			try {
				//执行hql语句
				list = (List<HouseTypeInfo>) this.getHibernateTemplate().find(hql);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public HouseTypeInfo getHouseType(int houseTypeId) {
		// 根据房屋类型id获取对应的房屋信息
		HouseTypeInfo houseTypeInfo = null;
		try {
			houseTypeInfo = this.getHibernateTemplate().get(HouseTypeInfo.class, houseTypeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return houseTypeInfo;
	}

	@Override
	public void saveOrUpdateHouseType(HouseTypeInfo houseTypeInfo) {
		//新增或更改房屋类型信息
		try {
			this.getHibernateTemplate().saveOrUpdate(houseTypeInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
