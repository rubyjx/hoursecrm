package com.zxxz.crm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zxxz.crm.service.HouseTypeService;
import com.zxxz.crm.vo.HouseTypeInfo;

public class HouseTypeAction extends ActionSupport{
	
	//获取注入信息houseTypeService
	private HouseTypeService houseTypeService;
	

	/**
	 * 获取全部的房屋类型信息
	 * @return
	 */
	public String findAllHouseType(){
		//获取request域
		HttpServletRequest request = ServletActionContext.getRequest();
		//获取输入框的消息
		String houseTypeName = request.getParameter("houseTypeName");
		//获取全部的房屋类型信息
		List<HouseTypeInfo> list = houseTypeService.getAllHouseType(houseTypeName);
		
		//将获取的信息放入request域中传到前台
		request.setAttribute("list", list);
		
		return "houseTypeList";
	}
	
	/**
	 * 删除一条房屋类型信息
	 * @return
	 */
	public String deleteHouseType(){
		//获取request域
		HttpServletRequest request = ServletActionContext.getRequest();
		//获取隐藏域中的房屋类型主键
		String houseTypeIdString = request.getParameter("houseTypeId");
		if(houseTypeIdString!=null && !houseTypeIdString.equals("")){
			int houseTypeId = Integer.parseInt(houseTypeIdString);
			//调用Service方法删除指定的房屋类型
			houseTypeService.deleteHouseType(houseTypeId);
			request.setAttribute("info", "房屋类型删除成功!");
		}else{
			request.setAttribute("info", "房屋类型删除失败!");
		}
		
		return "houseTypeSave";
	}
	
	
	public String addHouseType(){
		//获取request域
		HttpServletRequest request = ServletActionContext.getRequest();
		//获取前台的数据
		String houseTypeName = request.getParameter("houseTypeName");
		if(houseTypeName!=null && !houseTypeName.equals("")){
			//创建一个HouseType对象
			HouseTypeInfo houseTypeInfo = new HouseTypeInfo();
			houseTypeInfo.setHouseTypeName(houseTypeName);
			houseTypeInfo.setHouseTypeIsUsed("1");
			
			//调用Service中的方法将对象加入数据库
			houseTypeService.saveOrUpdateHouseType(houseTypeInfo);
			
			request.setAttribute("info", "房屋类型添加成功！");
		}else{
			request.setAttribute("info", "房屋类型添加失败！");
		}
		return "houseTypeSave";
	}
	
	
	public HouseTypeService getHouseTypeService() {
		return houseTypeService;
	}
	public void setHouseTypeService(HouseTypeService houseTypeService) {
		this.houseTypeService = houseTypeService;
	}
}
