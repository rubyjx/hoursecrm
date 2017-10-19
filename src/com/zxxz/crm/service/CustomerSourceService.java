package com.zxxz.crm.service;

import java.util.List;

import com.zxxz.crm.vo.CustomerSourceInfo;

public interface CustomerSourceService {

	List<CustomerSourceInfo> findAllSource();

	

	List<CustomerSourceInfo> findCustomerSourceBySouceName(String sourceName);



	void deleteSource(CustomerSourceInfo customerSourceInfo);



	void addSouce(CustomerSourceInfo customerSourceInfo);

}
