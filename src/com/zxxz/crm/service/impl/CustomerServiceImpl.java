package com.zxxz.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.zxxz.crm.dao.CustomerCareDao;
import com.zxxz.crm.dao.CustomerConditionDao;
import com.zxxz.crm.dao.CustomerDao;
import com.zxxz.crm.dao.CustomerSourceDao;
import com.zxxz.crm.dao.CustomerTypeDao;
import com.zxxz.crm.dao.UserDao;
import com.zxxz.crm.service.CustomerService;
import com.zxxz.crm.vo.CustomerCareInfo;
import com.zxxz.crm.vo.CustomerConditionInfo;
import com.zxxz.crm.vo.CustomerInfo;
import com.zxxz.crm.vo.CustomerSourceInfo;
import com.zxxz.crm.vo.CustomerTypeInfo;
import com.zxxz.crm.vo.PageBean;
import com.zxxz.crm.vo.UserInfo;

@Transactional
public class CustomerServiceImpl implements CustomerService {
	// userdao注入CustomerService
	@Resource(name = "userDao")
	private UserDao userDao;
	// customerSourceDao注入CustomerService
	@Resource(name = "customerSourceDao")
	private CustomerSourceDao customerSourceDao;
	// customerConditionDao注入CustomerService
	@Resource(name = "customerConditionDao")
	private CustomerConditionDao customerConditionDao;

	// customerTypeDao注入CustomerService
	@Resource(name = "customerTypeDao")
	private CustomerTypeDao customerTypeDao;


	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 根据用户id查询对应下的所有客户
	 * 
	 * @return
	 */
	@Override
	public PageBean<CustomerInfo> findCustomerlistByUserID(int pc, int ic, String url, Integer userId,
			String customerInput, String queryType) {

		/**
		 * 查询结果
		 */
		List<CustomerInfo> findCustomerlistByUserID = customerDao.findCustomerlistByUserID(pc, ic, userId,
				customerInput, queryType);
		/**
		 * 根据customerid查询对应的员工
		 */
		PageBean<CustomerInfo> pagebean = null;
		/**
		 * 如果查询结果为空 ，就直接返回
		 */
		if (findCustomerlistByUserID.size() != 0) {

			for (int i = 0; i < findCustomerlistByUserID.size(); i++) {
				/**
				 * 通过顾客信息中的userId获取userinfo对象
				 */
				Integer userIdbycustomer = findCustomerlistByUserID.get(i).getUserId();
				UserInfo userInfo = userDao.findUserByCusomerId(userIdbycustomer);
				/**
				 * 通过顾客信息中的sourceId获取CustomerSourceInfo对象
				 */
				Integer sourceId = findCustomerlistByUserID.get(i).getSourceId();
				CustomerSourceInfo findCustomerSourceInfoBySourceId = customerSourceDao
						.findCustomerSourceInfoBySourceId(sourceId);
				/**
				 * 通过顾客信息中typeId获取CustomerTypeInfo对象
				 */
				Integer typeId = findCustomerlistByUserID.get(i).getTypeId();
				CustomerTypeInfo coTypeInfo = customerTypeDao.findCustomerTypeInfoByTypeId(typeId);
				/**
				 * 将顾客所属状态conditionId获取CustomerConditionInfo对象；
				 */
				Integer conditionId = findCustomerlistByUserID.get(i).getConditionId();
				CustomerConditionInfo conditionInfo = customerConditionDao.findConditionInfoByConditionId(conditionId);
				/**
				 * 将顾客所属员工设置进来
				 */
				findCustomerlistByUserID.get(i).setCustomerCondition(conditionInfo.getConditionName());
				findCustomerlistByUserID.get(i).setCustomerType(coTypeInfo.getCustomerTypeName());
				findCustomerlistByUserID.get(i).setCustomerSource(findCustomerSourceInfoBySourceId.getSourceName());
				findCustomerlistByUserID.get(i).setCustomerForUser(userInfo.getUserName());
			}

			/**
			 * 建立分页实体类
			 */
			pagebean = new PageBean<CustomerInfo>();
			pagebean.setBeanlist(findCustomerlistByUserID);
			pagebean.setPc(pc);
			pagebean.setUrl(url);
			pagebean.setIc(ic);
			/**
			 * 获取总条目数
			 */

			Long ai = customerDao.getAllCustomerItemNumber(userId);
			pagebean.setAi(Integer.valueOf(ai.toString()));
		}
		return pagebean;
	}

	/**
	 * 根据customerID查询具体用户
	 */
	@Override
	public CustomerInfo findCustomerByCustomerId(Integer customerId) {
		/**
		 * 查询数据
		 */
		CustomerInfo customerInfo = customerDao.findCustomerByCustomerId(customerId);
		/**
		 * 负责该员工的信息
		 */
		Integer userIdbycustomer = customerInfo.getUserId();
		UserInfo userInfo = userDao.findUserByCusomerId(userIdbycustomer);
		Integer sourceId = customerInfo.getSourceId();
		CustomerSourceInfo findCustomerSourceInfoBySourceId = customerSourceDao
				.findCustomerSourceInfoBySourceId(sourceId);
		/**
		 * 通过顾客信息中typeId获取CustomerTypeInfo对象
		 */
		Integer typeId = customerInfo.getTypeId();
		CustomerTypeInfo coTypeInfo = customerTypeDao.findCustomerTypeInfoByTypeId(typeId);
		/**
		 * 将顾客所属状态conditionId获取CustomerConditionInfo对象；
		 */
		Integer conditionId = customerInfo.getConditionId();
		CustomerConditionInfo conditionInfo = customerConditionDao.findConditionInfoByConditionId(conditionId);

		customerInfo.setCustomerForUser(userInfo.getUserName());
		customerInfo.setCustomerCondition(conditionInfo.getConditionName());
		customerInfo.setCustomerType(coTypeInfo.getCustomerTypeName());
		customerInfo.setCustomerSource(findCustomerSourceInfoBySourceId.getSourceName());
		return customerInfo;
	}

	/**
	 * 根据customerId修改数据
	 * 
	 * @param customerId
	 */
	@Override
	public void updateCustomerByCustomerId(CustomerInfo customerInfo, Integer position) {
		/**
		 * 获取customerId
		 */
		Integer customerId = customerInfo.getCustomerId();
		/**
		 * positon==2删除用户
		 */
		if (position == 2) {

			/**
			 * 根据customerId查询customer信息
			 */

			customerInfo = customerDao.findCustomerByCustomerId(customerId);
			/**
			 * 设置状态位为"0"
			 */
			customerInfo.setIsUsed("0");

		}
		/**
		 * position==1修改用户，修改信息都在customerInfo保存直接执行修改
		 */
		/**
		 * 修改数据
		 */
		customerDao.updateCustomerByCustomerId(customerInfo);

	}

	/**
	 * 获取客户来源，客户,状态，类型
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List findAllOtherData() {
		List alldata = new ArrayList();
		/**
		 * 获取所有客户来源信息
		 */
		List<CustomerSourceInfo> sourcelist = customerSourceDao.findAllSource();
		alldata.add(sourcelist);
		/**
		 * 获取所有客户状态信息
		 */
		List<CustomerConditionInfo> conditionlist = customerConditionDao.findAllCondition();
		alldata.add(conditionlist);

		/**
		 * 获取所有客户类型信息
		 */
		List<CustomerTypeInfo> typelist = customerTypeDao.findAllType();
		alldata.add(typelist);
		/**
		 * 获取所有员工信息
		 */
		List<UserInfo> userlist = userDao.findAllUser();
		alldata.add(userlist);

		return alldata;
	}

	/**
	 * 增加员工
	 */
	@Override
	public void addCustomer(CustomerInfo customerInfo) {

		customerDao.addUser(customerInfo);
	}

	/**
	 * 根据条件将Customerlist返回
	 * 
	 * @param str
	 * @return
	 */
	@Override
	public List<CustomerInfo> findCustomerByCondition(String[] str) {
		List<CustomerInfo> customerlist = new ArrayList<CustomerInfo>();
		for (int i = 0; i < str.length; i++) {
			CustomerInfo customerInfo = customerDao.findCustomerByCustomerId(Integer.parseInt(str[i]));
			customerlist.add(customerInfo);

		}
		return customerlist;
	}

	/**
	 * 批量将客户分配给对应的员工
	 * 
	 * @param str
	 */
	@Override
	public void updateCustomerByCondition(String[] customerstr, Integer userId) {

		for (int i = 0; i < customerstr.length; i++) {
			CustomerInfo findCustomer = customerDao.findCustomerByCustomerId(Integer.parseInt(customerstr[i]));
			findCustomer.setUserId(userId);
			customerDao.updateCustomerByCustomerId(findCustomer);
		}
	}

	/**
	 * 查询所有员工的信息
	 * 
	 * @return
	 */
	@Override
	public List<UserInfo> findAllUser() {

		return userDao.findAllUser();
	}
	/**
	 * 查询所有CustomerInfo
	 * @return
	 */
	@Override
	public List<CustomerInfo> findAllCustomer() {
		List<CustomerInfo> findAllCustomer = customerDao.findAllCustomer();
		return findAllCustomer;
	}

	

	

}
