package com.zxxz.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.zxxz.crm.dao.NoticeDao;
import com.zxxz.crm.service.NoticeService;
import com.zxxz.crm.vo.NoticeInfo;

public class NoticeServiceImpl implements NoticeService {
	@Resource(name="noticeDao")
	private NoticeDao noticeDao;
	/**
     * 根据条件查询所有通知信息
     * @param noticeInput
     * @param noticeInput2
     * @return
     */
	@Override
	public List<NoticeInfo> getNoticeList(String noticeInput, String queryType) {
		List<NoticeInfo>	noticelist=noticeDao.getNoticeList(noticeInput,queryType);
		return noticelist;
	}

}
