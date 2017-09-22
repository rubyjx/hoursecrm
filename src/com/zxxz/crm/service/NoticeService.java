package com.zxxz.crm.service;

import java.util.List;

import com.zxxz.crm.vo.NoticeInfo;
/**
 * 通知业务层
 * @author leaves
 *
 */
public interface NoticeService {
    /**
     * 根据条件查询所有通知信息
     * @param noticeInput
     * @param noticeInput2
     * @return
     */
	List<NoticeInfo> getNoticeList(String noticeInput, String noticeInput2);
    
 }
