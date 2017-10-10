package com.zxxz.crm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zxxz.crm.service.CustomerTypeService;
import com.zxxz.crm.vo.CustomerTypeInfo;

@SuppressWarnings("serial")
public class CustomerTypeAction extends ActionSupport implements ModelDriven<CustomerTypeInfo>{
    private CustomerTypeInfo customerType=new CustomerTypeInfo();
	@Override
	public CustomerTypeInfo getModel() {
		// TODO Auto-generated method stub
		return customerType;
	}
	/**
	 * 
	 */
	private CustomerTypeService customerTypeService;

	public void setCustomerTypeService(CustomerTypeService customerTypeService) {
		this.customerTypeService = customerTypeService;
	}

	/* 展示所有类型信息 */
	public String typeList() {
		HttpServletRequest request = ServletActionContext.getRequest();

		List<CustomerTypeInfo> customerTypeList = null;
		try {
			customerTypeList = customerTypeService.findAllcustomerTypeInfo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("customerTypeList", customerTypeList);
		return "typeList";
	}
    //根据条件查询需要的信息
	public String queryType() {
		HttpServletRequest request = ServletActionContext.getRequest();
        String TypeName=request.getParameter("TypeName");
        List<CustomerTypeInfo> customerTypeList = null;
		try {
			customerTypeList = customerTypeService.findCustomerByTypeName(TypeName);
		} catch (Exception e) {
	
			e.printStackTrace();
		}
        request.setAttribute("customerTypeList", customerTypeList);
		return "typeList";
	}
	//删除用户类型
	public String deleteType(){
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			customerTypeService.deleteType(customerType);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		request.setAttribute("info", "删除成功！");
		return "typesave";
		
	}
	//添加客户类型
	public String addType(){
		HttpServletRequest request = ServletActionContext.getRequest();
		customerType.setCustomerTypeIsUsed("1");
		try {
			customerTypeService.addType(customerType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("info", "添加成功！");
		
		return "typesave";
		
	}

	
	
}
