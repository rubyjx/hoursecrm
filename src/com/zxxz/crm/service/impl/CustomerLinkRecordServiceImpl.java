package com.zxxz.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.zxxz.crm.dao.CustomerDao;
import com.zxxz.crm.dao.CustomerLinkRecordDao;
import com.zxxz.crm.service.CustomerLinkRecordService;
import com.zxxz.crm.vo.CustomerInfo;
import com.zxxz.crm.vo.LinkRecordInfo;

@Transactional
public class CustomerLinkRecordServiceImpl implements CustomerLinkRecordService {
	@Resource(name = "customerLinkRecordDao")
	private CustomerLinkRecordDao customerLinkRecordDao;
    //显示所有联系记录
	@Resource(name="customerDao")
    private CustomerDao customerDao;
	@Override
	public List<LinkRecordInfo> findRecordList(String whoLinkInput, String queryType) {
		List<LinkRecordInfo> findAllRecordList = customerLinkRecordDao.findAllRecordList(whoLinkInput, queryType);
		if (findAllRecordList != null&&findAllRecordList.size()>0) {
			for(int i=0;i<findAllRecordList.size();i++)
			findAllRecordList.get(i).getCustomerInfo().getCustomerName();
		}
		return findAllRecordList;
	}
    //删除联系记录
	@Override
	public void deleteRecord(LinkRecordInfo linkRecordInfo) {
		LinkRecordInfo linkRecord= customerLinkRecordDao.findRecordByRecordId(linkRecordInfo.getRecordId());
	    linkRecord.setIsUsed("0");
	    customerLinkRecordDao.updateRecordByRecordId(linkRecord);
	    
	}
	//查询所有顾客信息
	@Override
	public List<CustomerInfo> findAllCustomer() {
		 
		return customerDao.findAllCustomer();
	}
	//增加顾客联系记录
	@Override
	public void addCustomerReocrd(LinkRecordInfo linkRecordInfo) {
		linkRecordInfo.setIsUsed("1");
		customerLinkRecordDao.addCustomerRecord(linkRecordInfo);
	}

}
