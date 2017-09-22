package com.zxxz.crm.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zxxz.crm.service.CustomerCareService;
import com.zxxz.crm.service.CustomerService;
import com.zxxz.crm.vo.CustomerCareInfo;
import com.zxxz.crm.vo.CustomerInfo;

@SuppressWarnings("serial")
public class CustomerCareAction extends ActionSupport implements ModelDriven<CustomerCareInfo> {
	@Resource(name = "customerCareService")
	private CustomerCareService customerCareService;
	@Resource(name = "customerService")
	private CustomerService customerService;
	private CustomerCareInfo customerCareInfo = new CustomerCareInfo();

	// modeldriven封装数据
	@Override
	public CustomerCareInfo getModel() {
		// TODO Auto-generated method stub
		return customerCareInfo;
	}

	/**
	 * 客户关怀列表
	 * 
	 * @return
	 */
	public String customerCareList() {
		// 获取request
		HttpServletRequest request = ServletActionContext.getRequest();
		// 查询条件
		String customerInput = request.getParameter("customerInput");
		String queryType = request.getParameter("queryType");
		List<CustomerCareInfo> customercarelist = null;
		// 查询结果
		try {
			customercarelist = customerCareService.findAllCustomerCareList(customerInput, queryType);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		// 将结果放入request域中
		request.setAttribute("customercarelist", customercarelist);
		return "customercarelist";
	}

	/**
	 * 删除客户关心，将isUsed设置为0
	 * 
	 * @return
	 */
	public String deleteCustomerCare() {
		/*
		 * 获取要删除的客户关心表的id 执行service层删除用户业务加trycatch
		 * 
		 */
		HttpServletRequest request = ServletActionContext.getRequest();
		String careId1 = request.getParameter("careId");
		if (careId1 == null || careId1.isEmpty()) {
			System.out.println("deleteCustomerCare参数careId丢失");
			return "error";
		}
		Integer careId = Integer.parseInt(careId1);
		try {
			customerCareService.deleteCustomerCare(careId);
		} catch (Exception e) {

			e.printStackTrace();
			return "error";
		}
		request.setAttribute("info", "删除信息成功");
		return "customercaremsg";
	}

	/**
	 * 预修改准备信息和修改数据功能利用position来区分相关功能
	 * 
	 * @return
	 */
	public String updateCustomerCare() {
		/*
		 * 进入修改页面获取要修改的数据
		 */
		HttpServletRequest request = ServletActionContext.getRequest();
		String position = request.getParameter("position");
		CustomerCareInfo customerCareInfo1 = null;
		List<CustomerInfo> customerlist = null;
		// 进入修改页面准备数据
		if ("1".equals(position)) {
			String careId1 = request.getParameter("careId");
			if (careId1 == null || careId1.isEmpty()) {
				System.out.println("deleteCustomerCare参数careId丢失");
				return "error";
			}
			Integer careId = Integer.parseInt(careId1);

			try {
				customerCareInfo1 = customerCareService.findCustomerCareByCustomerCareId(careId);
				customerlist = customerService.findAllCustomer();
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
			request.setAttribute("careInfo", customerCareInfo1);
			request.setAttribute("customerlist", customerlist);
			return "customercareupdate";
		} else {
			/*
			 * 1.修改数据 2.获取修改过的数据。 3.调用service中的方法保存数据
			 * 
			 */
			try {
				customerCareService.updateCustomerCareService(customerCareInfo);
			} catch (Exception e) {

				e.printStackTrace();
				return "error";
			}
			request.setAttribute("info", "修改成功");
			return "customercaremsg";
		}

	}

	/**
	 * 进入添加客户关心页面准备数据
	 *  添加数据
	 * 
	 * @return
	 */
	public String addCusotmerCare() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String position = request.getParameter("position");
		List<CustomerInfo> customerlist = null;
		if("1".equals(position)){
			customerlist = customerService.findAllCustomer();
			request.setAttribute("customerlist", customerlist);
			return "customercareadd";
		}else{		
			customerCareService.saveCustomerCare(customerCareInfo);
			request.setAttribute("info", "添加成功");	
			return "customercaremsg";
		}
		
		
		
	}

}
