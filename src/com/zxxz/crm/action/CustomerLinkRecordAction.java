package com.zxxz.crm.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zxxz.crm.service.CustomerLinkRecordService;
import com.zxxz.crm.vo.CustomerInfo;
import com.zxxz.crm.vo.LinkRecordInfo;

/**
 * 联系记录action层
 * @author leaves
 *
 */
public class CustomerLinkRecordAction extends ActionSupport implements ModelDriven<LinkRecordInfo> {
    private LinkRecordInfo linkRecordInfo=new LinkRecordInfo();
    @Resource(name="customerLinkRecordService")
	private CustomerLinkRecordService customerLinkRecordService;
    @Override
	public LinkRecordInfo getModel() {
		return linkRecordInfo;
	}
	//查询所有联系记录
    public String recordList(){
    	//获取request
    	HttpServletRequest request=ServletActionContext.getRequest();
    	//获取查询条件
		String whoLinkInput = request.getParameter("whoLinkInput");
		String queryType = request.getParameter("queryType");
		
    	
    	List<LinkRecordInfo> recordList = null;
		try {
			recordList = customerLinkRecordService.findRecordList(whoLinkInput,queryType);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    	
    	request.setAttribute("recordList", recordList);
    	
    	
		return "recordList";
    	
    }
    
    //删除联系记录(假删除)
    public String deleteRecord(){
    	//获取request
    	HttpServletRequest request=ServletActionContext.getRequest();
    
    	try {
			customerLinkRecordService.deleteRecord(linkRecordInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	request.setAttribute("info", "删除成功");
		return "recordSave";
    	
    }
    
    //进入增加页面准备数据
    
    public String preAddRecord(){
    	//获取request
    	HttpServletRequest request=ServletActionContext.getRequest();
    
    	List<CustomerInfo> customerList=customerLinkRecordService.findAllCustomer();
    	request.setAttribute("customerList", customerList);
		return "recordAdd";
    	
    }
    
    //添加数据
    public String addRecord(){
      	//获取request
    	HttpServletRequest request=ServletActionContext.getRequest();
    	try {
			customerLinkRecordService.addCustomerReocrd(linkRecordInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	request.setAttribute("info", "增加数据成功");
    	
		return "recordSave";
    	
    }
}
