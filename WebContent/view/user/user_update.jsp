<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.zxxz.crm.vo.UserInfo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	UserInfo userinfo = (UserInfo)request.getAttribute("userinfo");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>修改员工信息</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<LINK href="<%=basePath%>resource/css/admin.css" type=text/css
			rel=stylesheet>
			<script type="text/javascript"
			src="<%=basePath%>resource/js/CheckForm.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>resource/js/My97DatePicker/WdatePicker.js"></script>
			<script language="JavaScript" type="text/javascript" src="<%=basePath%>resource/js/FormValid.js"></script>

	</head>

	<body>
		<form action="user_update" method="post" name="form2" onsubmit="return validator(this)" >
			
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请修改用户的详细信息
						<input type="hidden" name="userId" value="${userinfo.userId }"
							readonly="readonly">
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							姓名：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style="width: 145px" name="userName" disabled="disabled" value="${userinfo.userName}"
							readonly="readonly">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							年龄：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px" name="userAge" maxlength="2"  valid="required|isNumber"  errmsg="员工年龄不能为空!|请输入正确的年龄!" value="${userinfo.userAge }">
						&nbsp;
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0" style="height: 21px">
						<div align="center">
							性别：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF" style="height: 21px">
						<input type="radio" name="userSex" value="男" <c:if test="${userinfo.userSex =='男'}">checked="checked"</c:if>/>男
						<input type="radio" name="userSex" value="女" <c:if test="${userinfo.userSex =='女'}">checked="checked"</c:if>/>	女			 
						<br />
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							民族：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px" name="userNation"
							value="${userinfo.userNation}">
						&nbsp;
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							学历：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
					    <select name="userDiploma" style="width: 145px" > 
					       <option value="专科" <c:if test="${ userinfo.userDiploma=='专科'}"> selected="selected"</c:if>>专科</option>
					       <option value="本科" <c:if test="${ userinfo.userDiploma=='本科'}"> selected="selected"</c:if>>本科</option>
					       <option value="硕士" <c:if test="${ userinfo.userDiploma=='硕士'}"> selected="selected"</c:if>>硕士</option>
					       <option value="博士" <c:if test="${ userinfo.userDiploma=='博士'}"> selected="selected"</c:if>>博士</option>
					    </select>
									
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							婚姻：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
					    <select name="isMarried" style="width: 145px">
					       <option value="未婚" <c:if test="${ userinfo.isMarried=='未婚'}"> selected="selected"</c:if>>未婚</option>
					       <option value="已婚" <c:if test="${ userinfo.isMarried=='已婚'}"> selected="selected"</c:if>>已婚</option>
					       <option value="保密" <c:if test="${ userinfo.isMarried=='保密'}"> selected="selected"</c:if>>保密</option>
					    </select>
						
					</td>
				</tr>


				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							部门：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
					     <select name="departmentId" style="width: 145px">
					       <option value="1" <c:if test="${ userinfo.departmentId=='1'}"> selected="selected"</c:if>>财务部</option>
					       <option value="3" <c:if test="${ userinfo.departmentId=='3'}"> selected="selected"</c:if>>销售部</option>
					    </select>
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							角色：
						</div>
					</td>

					<td colspan="3" bgcolor="#FFFFFF">
						 <select name="roleId" style="width: 145px" onfocus="this.defaultIndex=this.selectedIndex;"
						  onchange="this.selectedIndex=this.defaultIndex;" >
					       <option value="3" <c:if test="${ userinfo.roleId==3}"> selected="selected"</c:if>>管理员</option>
					       <option value="2" <c:if test="${ userinfo.roleId==2}"> selected="selected"</c:if>>员工</option>
					       <option value="1" <c:if test="${ userinfo.roleId==1}"> selected="selected"</c:if>>老板</option>
					    </select>
				
					</td>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							座机：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px"     valid="isPhone"   errmsg="请输入正确的座机号码!" name="userTel" value="${ userinfo.userTel}">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							爱好：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px"  maxlength="50"  name="userIntest"
							value="${ userinfo.userIntest}">
						&nbsp;
					</td>
				</tr>
			
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							工资卡号：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style="width: 145px"  valid="isNumber"   errmsg="请输入正确的工资卡号!"  maxlength="20"   name="userBankcard"
							value="${ userinfo.userBankcard }">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							手机：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px" valid="regexp"  regexp="^1[3|4|5|8][0-9]\d{8}$"   errmsg="请输入正确的手机号码!" name="userMobile"
							value="${ userinfo.userMobile }">
						&nbsp;
					</td>

				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							身份证：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px"  valid="isIdCard"   errmsg="请输入正确的身份证号码!" name="userIdnum" value="${ userinfo.userIdnum}">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							添加时间：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px" name="userAddtime"
							disabled="disabled" value="${ userinfo.userAddtime}">
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							添加人：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px"  maxlength="10" name="userAddman"
							disabled="disabled" value="${ userinfo.userAddman}">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							修改人：
						</div>
						<input type="hidden"   value="" name="userChangeTime">
					
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" name="userChangeman"
							style="width: 145px"    maxlength="20"value="${ userinfo.userChangeman}">
						&nbsp;
					</td>
				</tr>

				<tr>

					<td bgcolor="#FFFDF0">
						<div align="center">
							E_mail：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style="width: 145px"  maxlength="50" name="userEmail" value="${ userinfo.userEmail}">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							地址：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style="width: 145px"  maxlength="50"  name="userAddress"
							value="${ userinfo.userAddress}">
						&nbsp;
					</td>
				</tr>

			</table>
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr bgcolor="#ECF3FD">
					<td width="36%">
		                <input type="hidden" name="userNum" value="${ userinfo.userNum }" />
		                <input type="hidden" name="userPw" value="${ userinfo.userPw }" />
		                <input type="hidden" name="userId1" value="${ userinfo.userId }" />
		                <input type="hidden" name="isUsed" value="${ userinfo.isUsed }" />
		                <input type="hidden" name="userAddman" value="${ userinfo.userAddman }" />
		                <input type="hidden" name="userName" value="${ userinfo.userName }" />
		             </td>
					<td width="17%"><input type="submit" name="submit"  value="提交"></td>
					<td width="4%"><input type="button" name="button"  onClick="history.back()"  value="返回"></td>
					<td width="43%"></td>
				</tr>
			</table>

		</form>

	</body>
</html>
