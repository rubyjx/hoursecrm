package com.zxxz.crm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zxxz.crm.service.HouseService;
import com.zxxz.crm.service.HouseTypeService;
import com.zxxz.crm.service.UserService;
import com.zxxz.crm.vo.HouseInfo;
import com.zxxz.crm.vo.HouseTypeInfo;
import com.zxxz.crm.vo.UserInfo;

/**
 * 
 * @author xuhao
 * 定义房屋信息的Action类
 */
public class HouseAction extends ActionSupport implements ModelDriven<HouseInfo>{
	
	//获取房屋信息的service
	private HouseService houseService;
	//获取房屋类型信息的service
	private HouseTypeService houseTypeService;
	//获取管理者的service(用户信息)
	private UserService userService;
	
	//使用模型封装获取前台的参数
	private HouseInfo houseInfo = new HouseInfo();
	@Override
	public HouseInfo getModel() {
		// TODO Auto-generated method stub
		return houseInfo;
	}
	
	/**
	 * 获取当前登录员工下的全部的房屋信息
	 */
	public String findAllHouse(){
		//获取request域
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//获取参数
		String queryType = request.getParameter("queryType");
		String houseInput = request.getParameter("houseInput");
		String userIdString = request.getParameter("userId");
		int userId=0;
 		if(userIdString!=null && !userIdString.equals("")){
 			userId = Integer.parseInt(userIdString);
 		}else{
 			UserInfo userInfo = (UserInfo)request.getSession().getAttribute("userinfo");
 			userId = userInfo.getUserId();
 		}
		
		//调用Service中的方法
		List<HouseInfo>  houseList = houseService.getAllHouse(queryType, houseInput, userId);
		
		//将获取的房屋信息放入request域中
		request.setAttribute("houseList", houseList);
		
		return "houseList";
	}
	
	/**
	 * 新增一条房屋信息
	 * @return
	 */
	public String addHouse(){
		//获取request域
		HttpServletRequest request = ServletActionContext.getRequest();
		//获取标志位typeId
		String typeId = null;
		
		typeId = request.getParameter("typeId");
		
		if(typeId==null){
			/**
			 * 根据标志位判断请求信息来自展示页面还是来自新增页面
			 */
			//获取全部的房屋类型信息
			List<HouseTypeInfo> houseTypeList = null;
			houseTypeList = houseTypeService.getAllHouseType(null);
			
			//获取全部的管理者信息
			List<UserInfo> userList = null;
			userList = userService.findAllUser();
			
			//将获取的数据放入request域中
			request.setAttribute("houseList", houseTypeList);
			request.setAttribute("userList", userList);
			
			return "houseAdd";
		}else{
			//调用houseService中的方法新增一条房屋信息
			
			//设置该条数据的状态位为1
			houseInfo.setIsUsed("1");
			
			boolean b = houseService.addHouse(houseInfo);
			if(b){
				request.setAttribute("info", "房屋添加成功！");
			}else{
				request.setAttribute("info", "房屋添加失败！");
			}
			
			return "houseSave";
		}
		
	}
	
	public String updateHouse(){
		//获取request域
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//获取标志位
		String houseTypeString = request.getParameter("typeId");
		//根据标志位判断请求时来自展示页面还是更改页面
		if(houseTypeString==null){
			//定义HouseInfo
			HouseInfo houseInfo = null;
			//获取url中的数据
			String houseIdString = request.getParameter("houseId");
			if(houseIdString!=null && !houseIdString.equals("")){
				int houseId = Integer.parseInt(houseIdString);

				//调用houseDao中的方法根据id获取对应的房屋信息
				houseInfo = houseService.getHouse(houseId);
			}
			//获取全部的房屋类型信息
			List<HouseTypeInfo> houseTypeList = null;
			houseTypeList = houseTypeService.getAllHouseType(null);
			
			//获取全部的管理者信息
			List<UserInfo> userList = null;
			userList = userService.findAllUser();
			
			//将获取的数据放入request域中传到前台
			request.setAttribute("houseinfo", houseInfo);
			request.setAttribute("houseTypeList", houseTypeList);
			request.setAttribute("userList", userList);
			
			return "houseUpdate";
		}else{
			//对需要更改的数据设置标志位为1
			houseInfo.setIsUsed("1");
			//调用houseService中的方法更改指定的数据
			houseService.updateHouse(houseInfo);
			
			//只是一条假的提示信息
			request.setAttribute("info", "房屋修改成功");
			
			return "houseSave";
		}	
	}
	/**
	 * 根据数据Id删除一条房屋信息
	 * @return
	 */
	public String deleteHouse(){
		//获取request域
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//获取url中的数据
		String houseIdString = request.getParameter("houseId");
		if(houseIdString!=null && !houseIdString.equals("")){
			int houseId = Integer.parseInt(houseIdString);
			//调用service中的方法更改对应数据的状态为位
			houseService.deleteHouse(houseId);
			request.setAttribute("info", "房屋删除成功！");
		}else{
			request.setAttribute("info", "房屋删除失败！");
		}
		
		return "houseSave";
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public HouseTypeService getHouseTypeService() {
		return houseTypeService;
	}

	public void setHouseTypeService(HouseTypeService houseTypeService) {
		this.houseTypeService = houseTypeService;
	}

	
	public HouseService getHouseService() {
		return houseService;
	}
	public void setHouseService(HouseService houseService) {
		this.houseService = houseService;
	}

	
	
}
