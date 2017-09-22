<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.zxxz.crm.vo.CustomerSourceInfo"%>
<%@page import="com.zxxz.crm.vo.CustomerConditionInfo"%>
<%@page import="com.zxxz.crm.vo.CustomerTypeInfo"%>
<%@page import="com.zxxz.crm.vo.CustomerInfo"%>
<%@page import="com.zxxz.crm.vo.UserInfo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>修改客户信息</title>

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
<script language="JavaScript" type="text/javascript"
	src="<%=basePath%>resource/js/FormValid.js"></script>
<script type="text/javascript" src="resource/js/jquery-2.0.0.js"></script>
<script type="text/javascript" src="resource/js/ajaxutil.js"></script>


</head>

<body >
	<form action="<c:url value='/customer_updateCustomer'/>" method="post"
		name="form2" onsubmit="return validator(this)">
		<%
			CustomerInfo customerInfo = (CustomerInfo) request.getAttribute("customer");
		%>

		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr class=editHeaderTr>
				<td class=editHeaderTd colSpan=7>请修改客户信息 <input type="hidden"
					name="customerId" value="${requestScope.customer.customerId }" />
				</td>
			</tr>
			<tr>
				<td width="12%" bgcolor="#FFFDF0"><div align="center">负责员工：</div></td>
				<td colspan="3" bgcolor="#FFFFFF"><select name="userId"
					style="width: 145px">
						<%
							List<UserInfo> userList = (List<UserInfo>) request.getAttribute("userlist");
						%>
						<%
							for (int i = 0; i < userList.size(); i++) {
								UserInfo userInfo = userList.get(i);
						%>
						<option value="${sessionScope.userinfo.userId }"
							<% if(customerInfo.getUserId() == userInfo.getUserId()){ %>
							selected="selected" <%} %>><%=userInfo.getUserName()%></option>
						<%
							}
						%>
				</select></td>
				<td width="12%" bgcolor="#FFFDF0">
					<div align="center">客户来源：</div>
				</td>
				<td width="37%" colspan="3" bgcolor="#FFFFFF"><select
					name="sourceId" style="width: 145px">
						<%
							List<CustomerSourceInfo> sourceList = (List<CustomerSourceInfo>) request.getAttribute("sourcelist");
						%>
						<%
							for (int i = 0; i < sourceList.size(); i++) {
								CustomerSourceInfo sourceInfo = sourceList.get(i);
						%>
						<option value="<%=sourceInfo.getSourceId()%>"
							<%if (customerInfo.getSourceId() == sourceInfo.getSourceId()) {%>
							selected="selected" <%}%>><%=sourceInfo.getSourceName()%></option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr>
				<td bgcolor="#FFFDF0">
					<div align="center">客户姓名：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" readonly="readonly" name="customerName"
					value="<%=customerInfo.getCustomerName()%>"></td>
				<td bgcolor="#FFFDF0">
					<div align="center">客户状态：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><select name="conditionId"
					style="width: 145px">
						<%
							List<CustomerConditionInfo> conditionList = (List<CustomerConditionInfo>) request
									.getAttribute("conditionlist");
						%>

						<%
							for (int i = 0; i < conditionList.size(); i++) {
								CustomerConditionInfo conditionInfo = conditionList.get(i);
						%>
						<option value="<%=conditionInfo.getConditionId()%>"
							<%if (customerInfo.getConditionId() == conditionInfo.getConditionId()) {%>
							selected="selected" <%}%>><%=conditionInfo.getConditionName()%></option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr>
				<td bgcolor="#FFFDF0">
					<div align="center">客户性别：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="radio"
					name="customerSex" value="男"
					<%if (customerInfo.getCustomerSex().equals("男")) {%>
					checked="checked" <%}%> /> 男&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="radio" name="customerSex" value="女"
					<%if (customerInfo.getCustomerSex().equals("女")) {%>
					checked="checked" <%}%> /> 女 <br /></td>
				<td bgcolor="#FFFDF0">
					<div align="center">客户类型：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><select name="typeId"
					style="width: 145px">
						<%
							List<CustomerTypeInfo> typeList = (List<CustomerTypeInfo>) request.getAttribute("typelist");
						%>
						<%
							for (int i = 0; i < typeList.size(); i++) {
								CustomerTypeInfo typeInfo = typeList.get(i);
						%>
						<option value="<%=typeInfo.getCustomerTypeId()%>"
							<%if (customerInfo.getTypeId() == typeInfo.getCustomerTypeId()) {%>
							selected="selected" <%}%>><%=typeInfo.getCustomerTypeName()%></option>
						<%
							}
						%>
				</select></td>
			</tr>

			<tr>
				<td bgcolor="#FFFDF0">
					<div align="center">出生日期：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" disabled="disabled" name="customerBirthday"
					value="<%=customerInfo.getCustomerBirthday()%>" readonly="readonly"
					id="customerBirthday"
					onclick="WdatePicker({el:customerBirthday,dateFmt:'yyyy-MM-dd HH:mm:ss '})">
					&nbsp;</td>
				<td bgcolor="#FFFDF0">
					<div align="center">客户手机：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" valid="regexp" regexp="^1[3|4|5|8][0-9]\d{8}$"
					errmsg="请输入正确的手机号码!" name="customerMobile"
					value="<%=customerInfo.getCustomerMobile()%>"> &nbsp;</td>
			</tr>

			<tr>
				<td bgcolor="#FFFDF0">
					<div align="center">客户QQ：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" valid="isQQ" errmsg="请输入正确的QQ号码!"
					name="customerQq" value="<%=customerInfo.getCustomerQq()%>">
					&nbsp;</td>
				<td bgcolor="#FFFDF0">
					<div align="center">客户地址：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" maxlength="50" name="customerAddress"
					value="<%=customerInfo.getCustomerAddress()%>"> &nbsp;</td>
			</tr>

			<tr>
				<td bgcolor="#FFFDF0">
					<div align="center">客户邮箱：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" maxlength="50" name="customerEmail"
					valid="required|isEmail" errmsg="Email不能为空|Email格式不对!"
					value="<%=customerInfo.getCustomerEmail()%>"> &nbsp;</td>
				<td bgcolor="#FFFDF0">
					<div align="center">客户职位：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" maxlength="50" name="customerJob"
					value="<%=customerInfo.getCustomerJob()%>"> &nbsp;</td>
			</tr>

			<tr>
				<td bgcolor="#FFFDF0">
					<div align="center">客户微博：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" maxlength="50" name="customerBlog"
					value="<%=customerInfo.getCustomerBlog()%>"> &nbsp;</td>
				<td bgcolor="#FFFDF0">
					<div align="center">客户座机：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" valid="isPhone" errmsg="请输入正确的座机号码!"
					name="customerTel" value="<%=customerInfo.getCustomerTel()%>">
					&nbsp;</td>
			</tr>

			<tr>
				<td bgcolor="#FFFDF0">
					<div align="center">客户MSN：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" maxlength="50" name="customerMsn"
					value="<%=customerInfo.getCustomerMsn()%>"> &nbsp;</td>
				<td bgcolor="#FFFDF0">
					<div align="center">客户公司：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" maxlength="50" name="customerCompany"
					value="<%=customerInfo.getCustomerCompany()%>"> &nbsp;</td>
			</tr>
			<tr>
				<td bgcolor="#FFFDF0">
					<div align="center">创建人：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" disabled="disabled" name="customerAddMan"
					value="<%=customerInfo.getCustomerAddMan()%>"> <input
					type="hidden"
					value="<%=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())%>"
					name="customerChangeTime"> <input type="hidden"
					name="customerAddTime"
					value="<%=customerInfo.getCustomerAddTime()%>" readonly="readonly"
					id="customerAddTime"></td>
				<td bgcolor="#FFFDF0">
					<div align="center">修改人：</div>
				</td>
				<td colspan="3" bgcolor="#FFFFFF"><input type="text"
					style="width: 145px" maxlength="50" name="customerChangeMan"
					value="<%=customerInfo.getCustomerChangeMan()%>"> &nbsp;</td>
			</tr>
			<tr>
				<td bgcolor="#FFFDF0">
					<div align="center">备注：</div>
				</td>
				<td colspan="6" bgcolor="#FFFFFF"><textarea rows="10"
						name="customerRemark" style="width: 100%; resize: none;"><%=customerInfo.getCustomerRemark()%>
			
		</textarea></td>
			</tr>
		</table>
		<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
			align=center border=0>
			<tr bgcolor="#ECF3FD">
				<td width="36%"><input type="hidden" name="position" value="3" />
					<input type="hidden" name="customerAddMan"
					value="${customer.customerAddMan}" /> 
					<input type="hidden" name="userId1"
					value="${customer.userId}" /> 
					<input type="hidden" name="customerChangeMan" value="${customer.customerChangeMan}" /> <input
					type="hidden" name="isUsed" value="${customer.isUsed}" /></td>
				<td width="17%"><input type="submit" name="submit" value="提交"></td>
				<td width="4%"><input type="button" name="button"
					onClick="history.back() " value="返回"></td>
				<td width="43%"></td>
			</tr>
		</table>
	</form>
</body>
</html>
