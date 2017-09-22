package com.zxxz.crm.dao;

import java.util.List;

import com.zxxz.crm.vo.CustomerConditionInfo;

public interface CustomerConditionDao {
    /**
     * 根据conditionid获取condition信息
     * @param conditionId
     * @return
     */
    CustomerConditionInfo findConditionInfoByConditionId(Integer conditionId);
    /**
     * 获取所有condition信息
     * @return
     */
	List<CustomerConditionInfo> findAllCondition();
}
