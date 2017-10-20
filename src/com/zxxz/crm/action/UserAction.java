package com.zxxz.crm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zxxz.crm.service.DepartmentService;
import com.zxxz.crm.service.RoleService;
import com.zxxz.crm.service.UserService;
import com.zxxz.crm.vo.PageBean;
import com.zxxz.crm.vo.UserInfo;

/**
 * 1.关于用户的操作，登陆，添加用户，
 * 
 * @author leaves
 * 
 */
@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements ModelDriven<UserInfo> {
	/**
	 * 封装信息实体userinfo
	 */
	private UserInfo userinfo = new UserInfo();

	/**
	 * 将信息放入值栈中
	 * 
	 * @return
	 */
	public UserInfo getUserinfo() {
		return userinfo;
	}

	/**
	 * 获取注入到本action的类
	 */
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	private RoleService roleService;
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}


	/**
	 * 模型驱动方式获得前台数据
	 */
	@Override
	public UserInfo getModel() {

		return userinfo;
	}
	
	
	/**
	 * 核对登陆信息
	 * 
	 * @return
	 */
	public String checkLogin() {
		/**
		 * 获取request域
		 */
		HttpServletRequest request = ServletActionContext.getRequest();

		/**
		 * 查询结果是否存在
		 */

		List<UserInfo> checkLogin = null;
		try {
			checkLogin = userService.checkLogin(userinfo);
		} catch (Exception e) {

			e.printStackTrace();
			return "error";
		}
		/**
		 * 1.存在则进入主页 2.否则返回对应的错误信息
		 */
		if (checkLogin == null || checkLogin.isEmpty()) {
			/**
			 * 返回错误信息
			 */

			request.setAttribute("loginmsg", "用户名不存在");
			/**
			 * 进入登陆页面
			 */
			return LOGIN;
		} else if (!checkLogin.get(0).getUserPw().equals(userinfo.getUserPw())) {
			request.setAttribute("loginmsg", "密码错误");
			return LOGIN;
		} else {
			/**
			 * 1.将登陆成功用户放入session中 2.跳转到主页
			 */
			request.getSession().setAttribute("userinfo", checkLogin.get(0));
			/**
			 * 进入主页
			 */
			return SUCCESS;
		}

	}

	/**
	 * 注销
	 * 
	 * @return
	 */
	public String cancelUser() {
		// 获取session
		HttpSession httpSession = ServletActionContext.getRequest().getSession();
		/**
		 * 销毁session
		 */
		httpSession.invalidate();
		return LOGIN;
	}

	/**
	 * 查询所有员工以及初始的准备信息
	 * 
	 * @return
	 */
	public String findAllUser() {
		//获取request域
		HttpServletRequest request = ServletActionContext.getRequest();
		
		/*获取分页的数据
		int pageIndex = getpc(request);
		int pageSize = 10;
		String url = getUrl(request);
		*/
		
		// 条件
		String userName = request.getParameter("userName");
		String queryType = request.getParameter("queryType");

		List<UserInfo> userList = userService.findUserByCondition(userName, queryType);
		
		
		request.setAttribute("userList", userList);

		return "userlist";

	}

	/**
	 * 进入详情页
	 * 
	 * @return
	 */
	public String queryMore() {
		// 获取request域
		HttpServletRequest request = ServletActionContext.getRequest();
		// 获取url中的的id
		String id = request.getParameter("id");
		// 定义UserInfo对象
		UserInfo userInfo = null;

		if (id != null && !id.equals("")) {
			Integer userId = Integer.parseInt(id);
			userInfo = userService.getUser(userId);
			// 将获取的对象信息放入request域中
			request.setAttribute("userinfo", userInfo);
			return "more";
		} else {
			return "error";
		}

	}

	/**
     * 编辑用户数据
     * @return
     */
   public String update(){
    	//获取request域
    	HttpServletRequest request = ServletActionContext.getRequest();
    	//获取session域
    	HttpSession session = request.getSession();
    	//获取当前登录用户的id
    	UserInfo loginId = (UserInfo)session.getAttribute("userinfo");
    	//获取userId
    	String id = request.getParameter("id");
    	if(id != null && !id.equals("")){
	    	//带着信息进入修改页面
    		
    		Integer userId = Integer.parseInt(id);
    		
	    		//根据用户id获取用户的详细信息
	    		UserInfo userInfo = userService.getUser(userId);
	    		//将获取的用户信息放入request域中
	    		request.setAttribute("userinfo", userInfo);
    		
    		return "preupdate"; 		
    	}else{
    		
    		userinfo.setDepartmentInfo(departmentService.getDepartment(userinfo.getDepartmentId()));
    		Integer roleId = Integer.parseInt(userinfo.getRoleId());
    		userinfo.setRoleInfo(roleService.getRole(roleId));
    		userService.updateUser(userinfo);
    		if(userinfo.getUserId().equals(loginId)){
    			request.setAttribute("info", "信息修改成功");
    			return "center";
    		}else{
    			request.setAttribute("info", "信息修改成功");
	    		return "save";
    		}
    	}
	}
   
   /**
    * 删除用户数据（将用户的标志位改为0）
    * @return
    */
	public String delete() {
		// 获取request域
		HttpServletRequest request = ServletActionContext.getRequest();
		// 获取userId
		String id = request.getParameter("id");

		if (id != null && !id.equals("")) {
			Integer userId = Integer.parseInt(id);
			// 根据id获取要删除的用户的数据
			UserInfo userInfo = userService.getUser(userId);
			// 删除指定的用户信息
			userService.deleteUser(userInfo);

			request.setAttribute("info", "员工删除成功");
		} else {
			request.setAttribute("info", "员工删除失败");
		}

		return "save";
	}
	
	/**
	 * 获取当前页
	 * 
	 * @param request
	 * @return
	 */
/*	private int getpc(HttpServletRequest request) {
		String pagecount = request.getParameter("pc");
		int pc = 0;
		if (pagecount != null && !pagecount.isEmpty()) {
			pc = Integer.parseInt(pagecount);
		} else {
			pc = 1;
		}
		return pc;
	}
	*/
	
	/**
	 * 获取页面请求链接url
	 * @return
	 */
/*	private String getUrl(HttpServletRequest req){
		String context = req.getContextPath();
		String servlet = req.getServletPath();
		String querryString = req.getQueryString();
		// System.out.println(context+servlet+"?"+querryString);
		if (querryString!=null && querryString.contains("&pc=")) {
			int index = querryString.lastIndexOf("&pc=");
			querryString = querryString.substring(0, index);
			return context + servlet + "?" + querryString;
		}
		
		return context+servlet;
	}*/

}
