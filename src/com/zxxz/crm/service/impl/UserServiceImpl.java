package com.zxxz.crm.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.zxxz.crm.dao.UserDao;
import com.zxxz.crm.service.UserService;
import com.zxxz.crm.vo.CustomerInfo;
import com.zxxz.crm.vo.PageBean;
import com.zxxz.crm.vo.UserInfo;

/**
 * userService实现类
 * 
 * @author leaves
 *
 */
@Transactional
public class UserServiceImpl implements UserService {
	private UserDao userDao;

	/**
	 * set注入方式获取userdao
	 * 
	 * @param userdao
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 核对登陆信息
	 * 
	 * @param user
	 * @return
	 */
	@Override
	public List<UserInfo> checkLogin(UserInfo user) {

		/**
		 * 查询结果
		 */
		List<UserInfo> userlist = userDao.findUserByUser_num(user);

		return userlist;
	}

	/**
	 * 增加用户
	 * 
	 * @param user
	 * @return
	 */
	@Override
	public void addUser(UserInfo user) {

	}

	/**
	 * 删除普通员工
	 * 
	 * @param user
	 * @return
	 */
	@Override
	public void deleteUser(UserInfo user) {
		//调用dao中的方法删除用户信息
		userDao.deleteUserByUserName(user);
		
	}

	/**
	 * 修改员工信息
	 * 
	 * @param user
	 * @return
	 */
	@Override
	public void updateUser(UserInfo user) {

		/**
		 * 将数据保存到
		 */
		userDao.updateUserByUserID(user);
	}

	/**
	 * 根据条件查询符合条件的UserInfo
	 */
	@Override
	public PageBean<UserInfo> findUserByCondition(int pageIndex,int pageSize,String url,String userName, String queryType) {
		// 调用dao中的方法获取员工的信息
		//定义一个页面Bean对象
		PageBean<UserInfo> pageBean = null;
		//获取员工信息
		List<UserInfo> findUserByCondition = userDao.findUserByCondition(pageIndex,pageSize,userName,queryType);
		System.out.println(findUserByCondition);
		// 使用for循环对类中的子段循环赋值
		for (int i = 0; i < findUserByCondition.size(); i++) {
			// 对实体类中的部门信息进行赋值
			findUserByCondition.get(i).setRoleName(findUserByCondition.get(i).getRoleInfo().getRoleName());

			// 对实体类中的角色信息进行赋值
			findUserByCondition.get(i)
					.setDepartmentName(findUserByCondition.get(i).getDepartmentInfo().getDepartmentName());

		}
		/**
		 * 建立分页实体类
		 */
		pageBean = new PageBean<UserInfo>();
		pageBean.setBeanlist(findUserByCondition);
		pageBean.setPc(pageIndex);
		pageBean.setUrl(url);
		pageBean.setIc(pageSize);
		/**
		 * 获取总条目数
		 */

		pageBean.setAi(findUserByCondition.size());
		
	
		return pageBean;
	}
	/**
	 * 查询所有用户信息
	 * @return
	 */
	@Override
	public List<UserInfo> findAllUser() {
		
		return userDao.findAllUser();
		
	}

	@Override
	public UserInfo getUser(Integer userId) {
		//定义员工对象
		UserInfo userInfo = null;
		try {
			//根据员工的编号获取员工的信息
			userInfo = userDao.findUserByCusomerId(userId);
			//对员工的角色和部门进行赋值
			userInfo.setRoleName(userInfo.getRoleInfo().getRoleName());
			userInfo.setDepartmentName(userInfo.getDepartmentInfo().getDepartmentName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userInfo;
	}

}
