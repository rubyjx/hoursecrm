package com.zxxz.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.zxxz.crm.dao.CustomerDao;
import com.zxxz.crm.dao.LinkManDao;
import com.zxxz.crm.service.LinkManService;
import com.zxxz.crm.vo.CustomerInfo;
import com.zxxz.crm.vo.LinkManInfo;
/**
 * linkMan业务层
 * @author leaves
 *
 */
@Transactional
public class LinkManServiceImpl implements LinkManService {
    @Autowired
	private LinkManDao linkManDao;
    @Autowired
	private CustomerDao customerDao;
	//显示所有linkman信息
	@Override
	public List<LinkManInfo> findAllLinkMan(String linkmanInput, String queryType) {
		List<LinkManInfo> findAllLinkMan = linkManDao.findAllLinkMan(linkmanInput,queryType);
		for(int i=0;i<findAllLinkMan.size();i++){
			findAllLinkMan.get(i).getCustomerInfo().getCustomerName();
		}
		return findAllLinkMan;
	}
    //删除LinkMan
	@Override
	public void deleteRecord(LinkManInfo linkManInfo) {
		LinkManInfo linkMan=linkManDao.findLinkManBYLinkManId(linkManInfo.getLinkmanId());
		linkMan.setIsUsed("0");
	}
    //查询所有顾客信息
	@Override
	public List<CustomerInfo> findAllCustomer() {
		
		return customerDao.findAllCustomer();
	}

	@Override
	public void addLinkMan(LinkManInfo linkManInfo) {
		linkManInfo.setIsUsed("1");
		linkManDao.addLinkMan(linkManInfo);
		
	}
	//根据id查询LinkMan
	@Override
	public LinkManInfo findLinkManByLinkManId(int linkmanId) {
		 
		return linkManDao.findLinkManBYLinkManId(linkmanId);
	}
	//修改LinkMan信息
	@Override
	public void updateLinkMan(LinkManInfo linkManInfo) {
		linkManDao.updateLinkMan(linkManInfo);	
	}


}
