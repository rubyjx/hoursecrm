<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.zxxz.crm.vo.CustomerSourceInfo"%>
<%@page import="com.zxxz.crm.vo.CustomerConditionInfo"%>
<%@page import="com.zxxz.crm.vo.CustomerTypeInfo"%>
<%@page import="com.zxxz.crm.vo.CustomerInfo"%>
<%@page import="com.zxxz.crm.vo.UserInfo"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
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
	
	</head>

	<body>
		<form action="customer_updateCustomer"
			method="get" name="form2" onSubmit="return checkForm('form2');">
			<%
				CustomerInfo customerInfo = (CustomerInfo) request
						.getAttribute("customer");
			%>

			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>客户详细信息<input type="hidden" name="customerId"value="<%=customerInfo.getCustomerId()%>" /></td>
				</tr>
				<tr>
					<td width="12%" bgcolor="#FFFDF0"><div align="center">负责员工：</div></td>
					<td colspan="3" bgcolor="#FFFFFF"  align="center">${customer.customerForUser}</td>
				  <td width="14%" bgcolor="#FFFDF0"  ><div align="center">客户来源：</div></td>
					<td width="41%" colspan="3"   align="center" bgcolor="#FFFFFF">${customer.customerSource}</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0"><div align="center">客户姓名：</div></td>
					<td colspan="3" bgcolor="#FFFFFF"  align="center"><%=customerInfo.getCustomerName()%></td>
					<td bgcolor="#FFFDF0"><div align="center">客户状态：</div></td>
					<td colspan="3" bgcolor="#FFFFFF"  align="center">${customer.customerCondition}</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0"><div align="center">客户性别：</div></td>
					<td colspan="3" bgcolor="#FFFFFF"  align="center"><%=customerInfo.getCustomerSex()%></td>
					<td bgcolor="#FFFDF0"><div align="center">客户类型：</div></td>
					<td colspan="3" bgcolor="#FFFFFF"  align="center">${customer.customerType}</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0"><div align="center">出生日期：</div></td>
					<td colspan="3" bgcolor="#FFFFFF"   align="center"><%=customerInfo.getCustomerBirthday()%></td>
					<td bgcolor="#FFFDF0"><div align="center">客户手机：</div></td>
					<td colspan="3" bgcolor="#FFFFFF"  align="center"><%=customerInfo.getCustomerMobile()%></td>
				</tr>
				
				<tr>
					<td bgcolor="#FFFDF0"><div align="center">客户QQ：</div></td>
					<td colspan="3" bgcolor="#FFFFFF"  align="center"><%=customerInfo.getCustomerQq()%></td>
					<td bgcolor="#FFFDF0"><div align="center">客户地址：</div></td>
					<td colspan="3" bgcolor="#FFFFFF"  align="center"><%=customerInfo.getCustomerAddress()%></td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0"><div align="center">客户邮箱：</div></td>
					<td colspan="3" bgcolor="#FFFFFF"   align="center"><%=customerInfo.getCustomerEmail()%></td>
					<td bgcolor="#FFFDF0"><div align="center">客户职位：</div></td>
					<td colspan="3" bgcolor="#FFFFFF"  align="center"><%=customerInfo.getCustomerJob()%></td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0"><div align="center">客户微博：</div></td>
					<td colspan="3" bgcolor="#FFFFFF"   align="center"><%=customerInfo.getCustomerBlog()%></td>
					<td bgcolor="#FFFDF0"><div align="center">客户座机：</div></td>
					<td colspan="3" bgcolor="#FFFFFF"  align="center"><%=customerInfo.getCustomerTel()%></td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0"><div align="center">客户MSN：</div></td>
					<td colspan="3" bgcolor="#FFFFFF"   align="center"><%=customerInfo.getCustomerMsn()%></td>
					<td bgcolor="#FFFDF0"><div align="center">客户公司：</div></td>
					<td colspan="3" bgcolor="#FFFFFF"  align="center"><%=customerInfo.getCustomerCompany()%></td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0"><div align="center">创建人：</div></td>
					<td colspan="3" bgcolor="#FFFFFF"   align="center"><%=customerInfo.getCustomerAddMan()%></td>
					<td bgcolor="#FFFDF0"><div align="center">修改人：</div></td>
					<td colspan="3" bgcolor="#FFFFFF"   align="center"><%=customerInfo.getCustomerChangeMan()%></td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0"><div align="center">创建时间：</div></td>
					<td colspan="3" bgcolor="#FFFFFF"   align="center"><%=customerInfo.getCustomerAddTime()%></td>
					<td bgcolor="#FFFDF0"><div align="center">修改时间：</div></td>
					<td colspan="3" bgcolor="#FFFFFF"   align="center"><%=customerInfo.getCustomerChangeTime()%></td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0"><div align="center">备注：</div></td>
					<td colspan="6" bgcolor="#FFFFFF"   align="center"><%=customerInfo.getCustomerRemark()%></td>
				</tr>
			</table>
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr bgcolor="#ECF3FD">
					<td width="36%"><input type="hidden" name="position" value="1"/></td>
					<td width="17%"><input type="submit" name="submit"  value="编辑"></td>
					<td width="4%"><input type="button" name="button"  onClick="history.back() "  value="返回"></td>
					<td width="43%"></td>
				</tr>
			</table>
		</form>
	</body>
</html>
