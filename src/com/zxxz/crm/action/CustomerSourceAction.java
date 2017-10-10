package com.zxxz.crm.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zxxz.crm.service.CustomerSourceService;
import com.zxxz.crm.vo.CustomerSourceInfo;

public class CustomerSourceAction extends ActionSupport implements ModelDriven<CustomerSourceInfo> {
	@Resource(name = "customerSourceService")
	private CustomerSourceService customerSourceService;
	private CustomerSourceInfo customerSourceInfo = new CustomerSourceInfo();

	@Override
	public CustomerSourceInfo getModel() {

		return customerSourceInfo;
	}

	// 获取所有客户状态
	public String sourceList() {

		HttpServletRequest request = ServletActionContext.getRequest();
		List<CustomerSourceInfo> sourceList = null;
		try {
			sourceList = customerSourceService.findAllSource();
		} catch (Exception e) {

			e.printStackTrace();
		}

		request.setAttribute("sourceList", sourceList);
		return "sourceList";

	}

	// 根据条件查询需要的信息
	public String querySource() {
		HttpServletRequest request = ServletActionContext.getRequest();

		List<CustomerSourceInfo> customersourceList = null;
		try {
			customersourceList = customerSourceService
					.findCustomerSourceBySouceName(customerSourceInfo.getSourceName());
		} catch (Exception e) {

			e.printStackTrace();
		}
		request.setAttribute("sourceList", customersourceList);
		return "sourceList";
	}

	// 删除用户状态
	public String deleteSource() {
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			customerSourceService.deleteSource(customerSourceInfo);
		} catch (Exception e) {

			e.printStackTrace();
		}
		request.setAttribute("info", "删除成功！");
		return "sourceSave";

	}

	// 添加客户类型
	public String addSource() {
		HttpServletRequest request = ServletActionContext.getRequest();
		customerSourceInfo.setSourceIsUsed("1");
		try {
			customerSourceService.addSouce(customerSourceInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("info", "添加成功！");

		return "sourceSave";

	}

}
