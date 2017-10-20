package com.zxxz.crm.dao.impl;

import java.io.Serializable;
import java.util.List;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zxxz.crm.dao.HouseDao;
import com.zxxz.crm.vo.HouseInfo;

/**
 * 
 * @author xuhao
 * 房屋信息的Dao接口的实现类
 */
public class HouseDaoImpl extends HibernateDaoSupport implements HouseDao{
	
	//获取全部的房屋信息
	@Override
	public List<HouseInfo> getAllHouse(String queryType,String houseInput,int userId) {
		//获取当前登录员工全部的房屋信息
		List<HouseInfo> list = null;
		//定义hql语句
		StringBuffer hql = new StringBuffer("select a from HouseInfo a,HouseTypeInfo b,UserInfo c where a.typeId=b.houseTypeId and a.userId=c.userId and a.userId=? and a.isUsed='1' ");
 		//根据获取的用户Id判断当前用户是否为登陆状态
		if(userId!=0){
 			if(houseInput!=null && !houseInput.equals("") && queryType.equals("1")){
 				hql.append(" and b.houseTypeName like ?");
 				list = (List<HouseInfo>) this.getHibernateTemplate().find(hql.toString(), new Object[]{userId,"%"+houseInput+"%"});
 			
 			}else if(houseInput!=null && !houseInput.equals("") && queryType.equals("2")){
 				hql.append(" and a.houseAddress like ?");
 				list = (List<HouseInfo>) this.getHibernateTemplate().find(hql.toString(), new Object[]{userId,"%"+houseInput+"%"});
 				
 			}else{
 				list = (List<HouseInfo>) this.getHibernateTemplate().find(hql.toString(), userId);
 			}
 		}
		
		return list;
	}
	
	//新增一条房屋信息
	@Override
	public boolean addHouse(HouseInfo houseInfo) {
		Serializable returnBoolean = null;
		try {
	
			//将新增数据的序列化返回
			returnBoolean = this.getHibernateTemplate().save(houseInfo);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(returnBoolean!=null){
			//将序列化类型的返回值转化为Int
			int b = (int) returnBoolean;
			//根据返回值判断返回值为true || false
			if(b>0){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
		
		
	
	}

	@Override
	public HouseInfo getHouse(int houseId) {
		//根据id获取对应的房屋信息
		HouseInfo houseInfo = null;
		
		try {
			houseInfo = this.getHibernateTemplate().get(HouseInfo.class, houseId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return houseInfo;
	}
	
	@Override
	public void updateHouse(HouseInfo houseInfo){
		//对指定的数据执行更改操作
		try {
			this.getHibernateTemplate().update(houseInfo);;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
