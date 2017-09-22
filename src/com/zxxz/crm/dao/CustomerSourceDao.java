package com.zxxz.crm.dao;

import java.util.List;

import com.zxxz.crm.vo.CustomerConditionInfo;
import com.zxxz.crm.vo.CustomerSourceInfo;

public interface CustomerSourceDao {
   /**
    * sourceId查询CustomerSourceInfo
    */
	CustomerSourceInfo findCustomerSourceInfoBySourceId(Integer sourceId);
    /**
     * 获取所有来源信息
     * @return
     */
	List<CustomerSourceInfo> findAllSource();

}
