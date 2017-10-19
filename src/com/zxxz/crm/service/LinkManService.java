package com.zxxz.crm.service;

import java.util.List;

import com.zxxz.crm.vo.CustomerInfo;
import com.zxxz.crm.vo.LinkManInfo;

public interface LinkManService {
    
	List<LinkManInfo> findAllLinkMan(String linkmanInput, String queryType);

	void deleteRecord(LinkManInfo linkManInfo);

	List<CustomerInfo> findAllCustomer();

	void addLinkMan(LinkManInfo linkManInfo);

	LinkManInfo findLinkManByLinkManId(int linkmanId);

	void updateLinkMan(LinkManInfo linkManInfo);

}
