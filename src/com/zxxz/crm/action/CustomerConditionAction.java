package com.zxxz.crm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zxxz.crm.service.CustomerConditionService;
import com.zxxz.crm.vo.CustomerConditionInfo;
import com.zxxz.crm.vo.CustomerTypeInfo;

public class CustomerConditionAction extends ActionSupport implements ModelDriven<CustomerConditionInfo> {
	private CustomerConditionService customerConditionService;
	private CustomerConditionInfo customerConditionInfo = new CustomerConditionInfo();

	public void setCustomerConditionService(CustomerConditionService customerConditionService) {
		this.customerConditionService = customerConditionService;
	}

	@Override
	public CustomerConditionInfo getModel() {
		return customerConditionInfo;
	}

	// 获取所有客户状态
	public String conditionList() {

		HttpServletRequest request = ServletActionContext.getRequest();
		List<CustomerConditionInfo> conditionList = null;
		try {
			conditionList = customerConditionService.findAllCondition();
		} catch (Exception e) {

			e.printStackTrace();
		}

		request.setAttribute("conditionList", conditionList);
		return "conditionList";

	}

	// 根据条件查询需要的信息
	public String queryCondition() {
		HttpServletRequest request = ServletActionContext.getRequest();

		List<CustomerConditionInfo> customerTypeList = null;
		try {
			customerTypeList = customerConditionService
					.findCustomerConditionByConditionName(customerConditionInfo.getConditionName());
		} catch (Exception e) {

			e.printStackTrace();
		}
		request.setAttribute("conditionList", customerTypeList);
		return "conditionList";
	}

	// 删除用户状态
	public String deleteCondition() {
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			customerConditionService.deleteCondition(customerConditionInfo);
		} catch (Exception e) {

			e.printStackTrace();
		}
		request.setAttribute("info", "删除成功！");
		return "conditionSave";

	}

	// 添加客户类型
	public String addCondition() {
		HttpServletRequest request = ServletActionContext.getRequest();
		customerConditionInfo.setConditionIsUsed("1");
		try {
			customerConditionService.addCondition(customerConditionInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("info", "添加成功！");

		return "conditionSave";

	}

}
