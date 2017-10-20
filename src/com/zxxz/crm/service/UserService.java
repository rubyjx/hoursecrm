package com.zxxz.crm.service;

import java.util.List;

import com.zxxz.crm.vo.PageBean;
import com.zxxz.crm.vo.UserInfo;

public interface UserService {
	/**
	 * 核对登陆信息
	 * @param user
	 * @return
	 */
    List<UserInfo> checkLogin(UserInfo user);
    /**
     * 增加用户
     * @param user
     * @return
     */
    void addUser(UserInfo user);
    /**
     * 删除普通员工
     * @param user
     * @return
     */
    void deleteUser(UserInfo user);
    /**
     * 修改员工信息
     * @param user
     * @return
     */
    void updateUser(UserInfo user);
    /**
     * 根据条件查询符合userinfo
     * @param userName
     * @param queryType
     * @return
     */
    public List<UserInfo> findUserByCondition(String userName, String queryType);
	
	/**
	 * 
	 * 根据员工的ID获取员工的详细信息
	 * @param userId
	 */
	public UserInfo getUser(Integer userId);
	/**
	 * 查询所有用户信息
	 * @return
	 */
	List<UserInfo> findAllUser();
}
