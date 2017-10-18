package com.zxxz.crm.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zxxz.crm.service.LinkManService;
import com.zxxz.crm.vo.CustomerInfo;
import com.zxxz.crm.vo.LinkManInfo;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkManInfo> {
    @Autowired
	private LinkManService linkManService;
	private LinkManInfo linkManInfo=new LinkManInfo();
	@Override
	public LinkManInfo getModel() {
		return linkManInfo;
	}
	//查询所有linkMan信息
    public String linkManList(){
    	
    	HttpServletRequest request=ServletActionContext.getRequest();
    	String LinkmanInput = request.getParameter("LinkmanInput");
		String queryType = request.getParameter("queryType");
		
    	List<LinkManInfo> linkManList=linkManService.findAllLinkMan(LinkmanInput,queryType);
    	request.setAttribute("linkManList", linkManList);
    	
    	return "linkManList";
    	
    }
    
    //删除联系记录(假删除)
    public String deleteLinkMan(){
    	//获取request
    	HttpServletRequest request=ServletActionContext.getRequest();
    
    	try {
    		linkManService.deleteRecord(linkManInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	request.setAttribute("info", "删除成功");
		return "linkManSave";
    	
    }
    
    //进入增加页面准备数据
    
    public String preAddLinkMan(){
    	//获取request
    	HttpServletRequest request=ServletActionContext.getRequest();
    
    	List<CustomerInfo> customerList=linkManService.findAllCustomer();
    	request.setAttribute("customerList", customerList);
		return "linkManAdd";
    	
    }
    
    //添加数据
    public String addLinkMan(){
      	//获取request
    	HttpServletRequest request=ServletActionContext.getRequest();
    	try {
    		linkManService.addLinkMan(linkManInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	request.setAttribute("info", "增加数据成功");
    	
		return "linkManSave";
    	
    }
    //进入修改页面准备信息
    public String preUpdateLinkMan(){
    	//获取request
    	HttpServletRequest request=ServletActionContext.getRequest();
    	List<CustomerInfo> findAllCustomer = null;
    	LinkManInfo linkMan = null;
    	try {
    		 findAllCustomer = linkManService.findAllCustomer();
    		 linkMan=linkManService.findLinkManByLinkManId(linkManInfo.getLinkmanId());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
        request.setAttribute("customerList", findAllCustomer);
        request.setAttribute("linkMan", linkMan);
    	
		return "linkManUpdate";
    	
    }
    
    //修改信息
    
    public String updateLinkMan(){
    	//获取request
    	HttpServletRequest request=ServletActionContext.getRequest();
    	try {
    		linkManService.updateLinkMan(linkManInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	request.setAttribute("info", "修改数据成功");
    	
		return "linkManSave";
    }
}
