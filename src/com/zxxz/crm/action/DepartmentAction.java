package com.zxxz.crm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zxxz.crm.service.DepartmentService;
import com.zxxz.crm.vo.DepartmentInfo;

import antlr.collections.Stack;

public class DepartmentAction extends ActionSupport{
	
	//获取注入在此bean中的DepartmentService
	private DepartmentService departmentService;

	public String findAllDepartment(){
		//获取request域
		HttpServletRequest request = ServletActionContext.getRequest();
		//获取表单中的 数据 查询部门信息表
		String departmentName = request.getParameter("departmentName");
		
		//掉用service中的方法
		List<DepartmentInfo> list = departmentService.findAllDepartment(departmentName);
		
		//将获取的数据放入request域中
		request.setAttribute("list", list);
		
		return "departmentList";
	}
	
	public String deleteDepartment(){
		//获取request域
		HttpServletRequest request = ServletActionContext.getRequest();
		//获取url中的数据
		String id = request.getParameter("id");
		if(id!=null && !id.equals("")){
			Integer departmentId = Integer.parseInt(id);
			//删除对应的部门信息（修改标志位）
			boolean b = departmentService.deleteDepartment(departmentId);
			if(b){
				request.setAttribute("info", "部门信息删除成功");
			}else{
				request.setAttribute("info", "部门信息删除失败");
			}
				
		}else{
			request.setAttribute("info", "部门信息删除失败");
		}
		
		return "departmentSave";
	}
	
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

}
