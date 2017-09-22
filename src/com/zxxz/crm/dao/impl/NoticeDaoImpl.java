package com.zxxz.crm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zxxz.crm.dao.NoticeDao;
import com.zxxz.crm.vo.NoticeInfo;

public class NoticeDaoImpl extends HibernateDaoSupport implements NoticeDao {

	@Override
	public List<NoticeInfo> getNoticeList(String noticeInput, String queryType) {
		
		return null;
	}

}
