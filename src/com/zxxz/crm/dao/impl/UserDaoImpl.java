package com.zxxz.crm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zxxz.crm.dao.UserDao;
import com.zxxz.crm.vo.UserInfo;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	/**
	 * 根据账户找到对应的User对象
	 */
	@Override
	public List<UserInfo> findUserByUser_num(UserInfo user) {
		String hql = "from UserInfo u where u.userNum=?";
		
		@SuppressWarnings("unchecked")
		List<UserInfo> find = (List<UserInfo>) this.getHibernateTemplate().find(hql, user.getUserNum());

		return find;
	}

	/**
	 * 根据用户id删除用户
	 */
	@Override
	public void deleteUserByUserName(UserInfo user) {
		//根据用户id删除用户信息（将标志位改为0）
		user.setIsUsed("0");
		
		this.getHibernateTemplate().update(user);
		
	}

	/**
	 * 根据id修改用户信息
	 */
	@Override
	public void updateUserByUserID(UserInfo user) {
		// 修改数据
		this.getHibernateTemplate().update(user);
	}

	/**
	 * 添加用户信息
	 */
	@Override
	public void addUser(UserInfo user) {

	}

	/**
	 * 根据customerId查询对应的员工
	 * 
	 * @param customerId
	 * @return
	 */
	@Override
	public UserInfo findUserByCusomerId(Integer userId) {
		UserInfo userInfo = this.getHibernateTemplate().get(UserInfo.class, userId);
		return userInfo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> findAllUser() {
		List<UserInfo> find = (List<UserInfo>) this.getHibernateTemplate().find("from UserInfo");
		return find;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfo> findUserByCondition(String userName, String queryType) {
	    String hql="select a from UserInfo a,DepartmentInfo b,RoleInfo c where a.departmentId = b.departmentId and a.roleId = c.roleId and a.isUsed!=0"; 
	    List<UserInfo> find =null;
	    if(queryType!=null&&!queryType.isEmpty()){
	    	switch (queryType) {
			case "1":
				hql+=" and  a.userName like ?";
				break;
			case "2":
				hql+=" and  b.departmentName like ?";
				break;
			case "3":
				hql+=" and  c.roleName like ?";
				break;
			case "4":
				hql+=" and a.userDiploma like ?";
				break;
			default:
				
				break;
			}	
	    	//find = (List<UserInfo>) this.getHibernateTemplate().find(hql, "%"+userName+"%");
	    }
	    try {
	    	if(queryType!=null&&!queryType.isEmpty()){
	    		find = (List<UserInfo>)this.getHibernateTemplate().find(hql, "%"+userName+"%" );
	    	}else{
	    		find = (List<UserInfo>) this.getHibernateTemplate().find(hql);
	    	}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return find;
	}

}
