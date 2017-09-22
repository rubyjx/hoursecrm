package com.zxxz.crm.dao;

import java.util.List;

import com.zxxz.crm.vo.UserInfo;

public interface UserDao {
	/**
	 * 根据账户找到对应的User对象
	 */
	List<UserInfo> findUserByUser_num(UserInfo user);
    /**
     * 根据用户id删除用户
     */
    void deleteUserByUserName(UserInfo user);
    /**
     * 根据id修改用户信息
     */
    void updateUserByUserID(UserInfo user);
    /**
     * 添加用户信息
     */
    void addUser(UserInfo user);
    /**
     * 根据customerId查询对应的员工
     * @param customerId
     * @return
     */
	UserInfo findUserByCusomerId(Integer customerId);
	/**
	 *  获取所有员工信息
	 * @return
	 */
	List<UserInfo> findAllUser();
	/**
	 * 查询所有符合条件的UserInfo
	 * @param userName
	 * @param queryType
	 * @return
	 */
	List<UserInfo> findUserByCondition(int pageIndex,int pageSize,String userName, String queryType);
}
