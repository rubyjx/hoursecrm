package com.zxxz.crm.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zxxz.crm.service.CustomerService;
import com.zxxz.crm.vo.CustomerCareInfo;
import com.zxxz.crm.vo.CustomerInfo;
import com.zxxz.crm.vo.PageBean;
import com.zxxz.crm.vo.UserInfo;

@SuppressWarnings("serial")
public class CustomerAction extends ActionSupport implements ModelDriven<CustomerInfo> {
	/**
	 * 定义实体类来封装数据
	 */
	private CustomerInfo customerInfo = new CustomerInfo();

	private CustomerService customerService;
    
	/**
	 * 注入customerService
	 * 
	 * @param customerService
	 */
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	/**
	 * 封装前台数据
	 */
	@Override
	public CustomerInfo getModel() {
		return customerInfo;
	}

	/**
	 * 查询该员工所对应的顾客信息
	 * 
	 * @return
	 */

	public String dataOfCustomer() {
		/*
		 * 1.查询该员工名下的所有员工信息 2.放入request域中 3.转发进入前台
		 */
		/**
		 * 获取request
		 * 
		 */
		HttpServletRequest request = ServletActionContext.getRequest();

		String queryType = request.getParameter("queryType");
		String customerInput = request.getParameter("customerInput");

		// 分页基础信息
		int pc = getpc(request); // 当前页
		int ic = 10; // 每页的数目
		String url = getUrl(request);// 页面跳转的地址
		/**
		 * 获取该员工的id
		 */
		Integer userId = null;

		/**
		 * 获取该用户下的客户列表
		 */
		PageBean<CustomerInfo> findCustomerlistByUserID = null;
		try {

			userId = customerInfo.getUserId();

			findCustomerlistByUserID = customerService.findCustomerlistByUserID(pc, ic, url, userId, queryType,
					customerInput);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		/**
		 * 将结果放入request域中
		 */
		request.setAttribute("queryType", queryType);
		request.setAttribute("customerInput", customerInput);
		request.setAttribute("customerlist", findCustomerlistByUserID);

		return "customerlist";

	}

	/**
	 * 获取当前页
	 * 
	 * @param req
	 * @return
	 */
	private int getpc(HttpServletRequest req) {
		String pagecount = req.getParameter("pc");
		int pc = 0;
		if (pagecount != null && !pagecount.isEmpty()) {
			pc = Integer.parseInt(pagecount);
		} else {
			pc = 1;
		}
		return pc;
	}

	/**
	 * 获取页面请求参数的url
	 * 
	 * @param req
	 * @return
	 */
	private String getUrl(HttpServletRequest req) {
		String context = req.getContextPath();
		String servlet = req.getServletPath();
		String querryString = req.getQueryString();
		// System.out.println(context+servlet+"?"+querryString);
		if (querryString.contains("&pc=")) {
			int index = querryString.lastIndexOf("&pc=");
			querryString = querryString.substring(0, index);
		}

		return context + servlet + "?" + querryString;

	}

	/**
	 * 预修改数据和修改数据
	 * 
	 * @return
	 */
	public String updateCustomer() {

		/**
		 * 获取request域
		 */
		HttpServletRequest request = ServletActionContext.getRequest();
		/**
		 * 获取customerId
		 */
		Integer customerId = customerInfo.getCustomerId();
		/**
		 * 获取状态位
		 */
		Integer position = Integer.parseInt(request.getParameter("position"));
		if (position == 1) {

			// 定义客户
			CustomerInfo customer = null;
			// 定义准备信息
			List allPrepareData = null;
			try {
				/**
				 * 从数据获取该id所对应的客户
				 */
				customer = customerService.findCustomerByCustomerId(customerId);
				/**
				 * 获取准备信息
				 */
				allPrepareData = customerService.findAllOtherData();
			} catch (Exception e) {

				e.printStackTrace();
				return "error";
			}

			/**
			 * 放入requets域中
			 */
			request.setAttribute("userlist", allPrepareData.get(3));
			request.setAttribute("sourcelist", allPrepareData.get(0));
			request.setAttribute("conditionlist", allPrepareData.get(1));
			request.setAttribute("typelist", allPrepareData.get(2));
			request.setAttribute("customer", customer);
			return "preUpdateCustomer";
		} else {
			/**
			 * 修改数据
			 */
			try {
				Integer userId = Integer.parseInt(request.getParameter("userId1"));
				customerInfo.setUserId(userId);
				customerService.updateCustomerByCustomerId(customerInfo, position);
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
			request.setAttribute("info", "修改成功");
			return "updateCustomerPosition";

		}

	}

	/**
	 * 显示顾客详细信息
	 * 
	 * @return
	 */
	public String customerData() {
		/**
		 * 获取request域
		 */
		HttpServletRequest request = ServletActionContext.getRequest();

		/**
		 * 1.获取顾客id
		 */
		Integer customerId = customerInfo.getCustomerId();
		CustomerInfo findCustomerByCustomerId = null;
		try {
			findCustomerByCustomerId = customerService.findCustomerByCustomerId(customerId);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		/**
		 * 将查询到的数据放入request域中
		 */
		request.setAttribute("customer", findCustomerByCustomerId);

		return "dataCustomer";
	}

	/**
	 * 删除顾客
	 */
	public String deleteCustomer() {
		Integer position = 2;// 1表示修改数据2表示删除数据
		/**
		 * 获取request域
		 */
		HttpServletRequest request = ServletActionContext.getRequest();

		/**
		 * 1.获取顾客id
		 */
		Integer customerId = customerInfo.getCustomerId();

		try {
			customerService.updateCustomerByCustomerId(customerInfo, position);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		request.setAttribute("info", "删除成功");
		/**
		 * 设置删除状态信息
		 */
		return "updateCustomerPosition";

	}

	/**
	 * 添加客户信息
	 * 
	 * @return
	 */
	public String addCustomer() {
		// 获取request
		HttpServletRequest request = ServletActionContext.getRequest();

		int position = Integer.parseInt(request.getParameter("position"));

		if (position == 1) {
			// 进入增加员工信息准备其他信息页面

			List allPrepareData = null;
			try {

				/**
				 * 获取准备信息
				 */
				allPrepareData = customerService.findAllOtherData();
				/**
				 * 放入requets域中
				 */
				request.setAttribute("userlist", allPrepareData.get(3));
				request.setAttribute("sourcelist", allPrepareData.get(0));
				request.setAttribute("conditionlist", allPrepareData.get(1));
				request.setAttribute("typelist", allPrepareData.get(2));
				return "preAddCustomer";
			} catch (Exception e) {

				e.printStackTrace();
				return "error";
			}

		} else {
			customerInfo.setIsUsed("1");
			try {
				customerService.addCustomer(customerInfo);
				request.setAttribute("info", "添加成功");
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		}

		return "updateCustomerPosition";

	}

	/**
	 * 客户分配功能
	 * 
	 * @return
	 */
	public String customerAllocation() {

		/**
		 * 获取request
		 * 
		 */
		HttpServletRequest request = ServletActionContext.getRequest();

		String queryType = request.getParameter("queryType");
		String customerInput = request.getParameter("customerInput");

		// 分页基础信息
		int pc = getpc(request); // 当前页
		int ic = 15; // 每页的数目
		// String url = getUrl(request);// 页面跳转的地址

		String url = "111";
		/**
		 * 获取该员工的id
		 */
		Integer userId = null;

		/**
		 * 获取该用户下的客户列表
		 */
		PageBean<CustomerInfo> findCustomerlistByUserID = null;
		try {

			userId = customerInfo.getUserId();

			findCustomerlistByUserID = customerService.findCustomerlistByUserID(pc, ic, url, userId, queryType,
					customerInput);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		/**
		 * 将结果放入request域中
		 */
		request.setAttribute("queryType", queryType);
		request.setAttribute("customerInput", customerInput);
		request.setAttribute("customerlist", findCustomerlistByUserID);

		return "customerallocation";
	}

	/**
	 * 客户分配给员工页面准备信息
	 * 
	 * @return
	 */
	public String customerDivide() {
		/*
		 * 1.根据id获取要分配的客户 2.获取所有员工信息 3.数据放入request域中
		 * 
		 */
		HttpServletRequest request = ServletActionContext.getRequest();
		List<CustomerInfo> customerlist = new ArrayList<CustomerInfo>();
		List<UserInfo> userlist = null;
		try {
			userlist = customerService.findAllUser();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		String[] str = request.getParameterValues("checkbox");
		String position = request.getParameter("position");
		Integer customerId = customerInfo.getCustomerId();
		if (customerId != null && customerId != 0 && "1".equals(position)) {
			CustomerInfo customerInfo = null;
			try {
				customerInfo = customerService.findCustomerByCustomerId(customerId);
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}

			request.setAttribute("customerInfo", customerInfo);
			request.setAttribute("userlist", userlist);
			return "customerdivide";

		}
		if (str == null || str.length <= 0) {

			request.setAttribute("info", "请选择要分配的客户");
			return "customerdividemsg";

		} else {

			try {
				customerlist = customerService.findCustomerByCondition(str);
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}

			request.setAttribute("customerlist", customerlist);
			request.setAttribute("userlist", userlist);
			return "customerdivideall";
		}

	}

	/**
	 * 员工负责的客户修改
	 * 
	 * @return
	 */
	public String customerDivideUpdate() {
		HttpServletRequest request = ServletActionContext.getRequest();

		Integer userId = null;

		String customerForUser = customerInfo.getCustomerForUser();
		if (customerForUser != null && !customerForUser.isEmpty()) {
			userId = Integer.parseInt(customerForUser);
		}

		String position = request.getParameter("position");
		if (position != null && !position.isEmpty() && "1".equals(position)) {
			/**
			 * 将单个客户分配给某个员工
			 */
			Integer customerId = customerInfo.getCustomerId();
			try {
				customerInfo = customerService.findCustomerByCustomerId(customerId);
				customerInfo.setUserId(userId);
				customerService.updateCustomerByCustomerId(customerInfo, 3);
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}

		} else {
			/**
			 * 批量将客户分配给某个员工
			 * 
			 * @return
			 */
			try {
				String[] str = request.getParameterValues("customerId");
				customerService.updateCustomerByCondition(str, userId);
			} catch (Exception e) {

				e.printStackTrace();
				return "error";
			}

		}
		request.setAttribute("info", "客户分配成功");
		return "customerdividemsg";

	}

}
