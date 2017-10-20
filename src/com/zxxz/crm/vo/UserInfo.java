package com.zxxz.crm.vo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 员工信息的实体类
 *
 */
public class UserInfo {

	/**
	 * 员工编号
	 */
	private Integer userId;

	/**
	 * 员工姓名
	 */
	private String userName;

	/**
	 * 员工性别
	 */
	private String userSex;

	/**
	 * 员工年龄
	 */
	private Integer userAge;

	/**
	 * 部门编号
	 */
	private Integer departmentId;

	/**
	 * 部门名称
	 */
	private String departmentName;

	/**
	 * 角色编号
	 */
	private String roleId;

	/**
	 * 角色名称
	 */
	private String roleName;

	/**
	 * 角色权限
	 */
	private Integer rolePower;

	/**
	 * 用户手机
	 */
	private String userMobile;

	/**
	 * 用户座机
	 */
	private String userTel;

	/**
	 * 用户份证号码
	 */
	private String userIdnum;

	/**
	 * 用户邮箱
	 */
	private String userEmail;

	/**
	 * 用户地址
	 */
	private String userAddress;

	/**
	 * 用户添加时间
	 */
	private String userAddtime;

	/**
	 * 用户添加人
	 */
	private String userAddman;

	/**
	 * 用户修改时间
	 */
	private String userChangetime;

	/**
	 * 用户修改人
	 */
	private String userChangeman;

	/**
	 * 用户兴趣
	 */
	private String userIntest;

	/**
	 * 用户学历
	 */
	private String userDiploma;

	/**
	 * 用户银行卡号
	 */
	private String userBankcard;

	/**
	 * 用户种族
	 */
	private String userNation;

	/**
	 * 是否婚配
	 */
	private String isMarried;

	/**
	 * 用户账号
	 */
	private String userNum;

	/**
	 * 用户密码
	 */
	private String userPw;

	/**
	 * 是否有效
	 */
	private String isUsed;
    /**
     * 对应多个顾客
     * @return
     */
    private Set<CustomerInfo> customerList = new HashSet<CustomerInfo>();
    
    private Set<HouseInfo> houseList = new HashSet<HouseInfo>();
    
    /**
     * 定义约束本类的外键信息
     * @return
     */
    private RoleInfo roleInfo;
    
    private DepartmentInfo departmentInfo;
    
    
    
	public DepartmentInfo getDepartmentInfo() {
		return departmentInfo;
	}

	public void setDepartmentInfo(DepartmentInfo departmentInfo) {
		this.departmentInfo = departmentInfo;
	}

	public RoleInfo getRoleInfo() {
		return roleInfo;
	}

	public void setRoleInfo(RoleInfo roleInfo) {
		this.roleInfo = roleInfo;
	}

	public String getUserNum() {
		return userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserIdnum() {
		return userIdnum;
	}

	public void setUserIdnum(String userIdnum) {
		this.userIdnum = userIdnum;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserAddtime() {
		return userAddtime;
	}

	public void setUserAddtime(String userAddtime) {
		this.userAddtime = userAddtime;
	}

	public String getUserChangetime() {
		return userChangetime;
	}

	public void setUserChangetime(String userChangetime) {
		this.userChangetime = userChangetime;
	}

	public String getUserIntest() {
		return userIntest;
	}

	public void setUserIntest(String userIntest) {
		this.userIntest = userIntest;
	}

	public String getUserDiploma() {
		return userDiploma;
	}

	public void setUserDiploma(String userDiploma) {
		this.userDiploma = userDiploma;
	}

	public String getUserBankcard() {
		return userBankcard;
	}

	public void setUserBankcard(String userBankcard) {
		this.userBankcard = userBankcard;
	}

	public String getUserNation() {
		return userNation;
	}

	public void setUserNation(String userNation) {
		this.userNation = userNation;
	}

	public String getIsMarried() {
		return isMarried;
	}

	public void setIsMarried(String isMarried) {
		this.isMarried = isMarried;
	}

	public String getUserAddman() {
		return userAddman;
	}

	public void setUserAddman(String userAddman) {
		this.userAddman = userAddman;
	}

	public String getUserChangeman() {
		return userChangeman;
	}

	public void setUserChangeman(String userChangeman) {
		this.userChangeman = userChangeman;
	}

	public Integer getRolePower() {
		return rolePower;
	}

	public void setRolePower(Integer rolePower) {
		this.rolePower = rolePower;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName + ", userSex=" + userSex + ", userAge=" + userAge
				+ ", departmentId=" + departmentId + ", departmentName=" + departmentName + ", roleId=" + roleId
				+ ", roleName=" + roleName + ", rolePower=" + rolePower + ", userMobile=" + userMobile + ", userTel="
				+ userTel + ", userIdnum=" + userIdnum + ", userEmail=" + userEmail + ", userAddress=" + userAddress
				+ ", userAddtime=" + userAddtime + ", userAddman=" + userAddman + ", userChangetime=" + userChangetime
				+ ", userChangeman=" + userChangeman + ", userIntest=" + userIntest + ", userDiploma=" + userDiploma
				+ ", userBankcard=" + userBankcard + ", userNation=" + userNation + ", isMarried=" + isMarried
				+ ", userNum=" + userNum + ", userPw=" + userPw + ", isUsed=" + isUsed + ", customerList="
				+ customerList + "]";
	}

	public Set<CustomerInfo> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(Set<CustomerInfo> customerList) {
		this.customerList = customerList;
	}

	public Set<HouseInfo> getHouseList() {
		return houseList;
	}

	public void setHouseList(Set<HouseInfo> houseList) {
		this.houseList = houseList;
	}

	
	
	

}
