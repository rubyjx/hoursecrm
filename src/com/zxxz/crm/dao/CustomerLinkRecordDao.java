package com.zxxz.crm.dao;

import java.util.List;

import com.zxxz.crm.vo.LinkRecordInfo;

public interface CustomerLinkRecordDao {

	List<LinkRecordInfo> findAllRecordList(String whoLinkInput, String queryType);

	LinkRecordInfo findRecordByRecordId(int recordId);

	void updateRecordByRecordId(LinkRecordInfo linkRecord);

	void addCustomerRecord(LinkRecordInfo linkRecordInfo);



	

}
