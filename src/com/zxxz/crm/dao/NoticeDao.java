package com.zxxz.crm.dao;

import java.util.List;

import com.zxxz.crm.vo.NoticeInfo;

public interface NoticeDao {
     /**
      * 根据
      * @param noticeInput
      * @param queryType
      * @return
      */
	List<NoticeInfo> getNoticeList(String noticeInput, String queryType);
    
}
