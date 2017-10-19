package com.zxxz.crm.service;

import java.util.List;

import com.zxxz.crm.vo.CustomerInfo;
import com.zxxz.crm.vo.LinkRecordInfo;

public interface CustomerLinkRecordService {

	List<LinkRecordInfo> findRecordList(String whoLinkInput, String queryType);
    //删除
	void deleteRecord(LinkRecordInfo linkRecordInfo);
	//查询所有的顾客信息
	List<CustomerInfo> findAllCustomer();
	//增加顾客信息
	void addCustomerReocrd(LinkRecordInfo linkRecordInfo);

}
