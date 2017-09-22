package com.zxxz.crm.dao;

import java.util.List;

import com.zxxz.crm.vo.CustomerTypeInfo;

public interface CustomerTypeDao {
	/**
	 * 根据typeId查询CustomerTypeInfo
	 * @param typeId
	 * @return
	 */
	CustomerTypeInfo findCustomerTypeInfoByTypeId(Integer typeId);
     /**
      * 获取所有类型信息
      * @return
      */
	List<CustomerTypeInfo> findAllType();
	/**
	 * 添加用户
	 */

}
