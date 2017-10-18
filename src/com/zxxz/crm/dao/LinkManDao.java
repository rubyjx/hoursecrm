package com.zxxz.crm.dao;

import java.util.List;

import com.zxxz.crm.vo.LinkManInfo;

public interface LinkManDao {

	List<LinkManInfo> findAllLinkMan(String linkmanInput, String queryType);

	LinkManInfo findLinkManBYLinkManId(int linkmanId);

	void addLinkMan(LinkManInfo linkManInfo);

	void updateLinkMan(LinkManInfo linkManInfo);

}
