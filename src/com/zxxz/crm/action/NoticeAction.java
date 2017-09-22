package com.zxxz.crm.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zxxz.crm.service.NoticeService;
import com.zxxz.crm.vo.NoticeInfo;
/**
 * noticeweb层
 * @author leaves
 *
 */
public class NoticeAction extends ActionSupport {
	@Resource(name="noticeService")
	private NoticeService noticeService;
	
	/**
	 * 显示所有notice信息
	 * @return
	 */
    public String noticeList(){
    	HttpServletRequest request=ServletActionContext.getRequest();
    	String noticeInput = request.getParameter("noticeInput");
		String queryType = request.getParameter("queryType");
    	
		List<NoticeInfo> noticelist=noticeService.getNoticeList(noticeInput,queryType);
		return null;
    	
    }
}