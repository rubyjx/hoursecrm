<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

		<title>My JSP 'customerCondition_save.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<%
						UserInfo userInfo  =   (UserInfo)request.getSession().getAttribute("userInfo2");
	%>
		
		<script type="text/javascript">
			alert('${info}');
			window.location="<%=basePath%>servlet/HouseQueryServlet?userId=<%= userInfo.getUserId()  %>";
			/*等同于超链接 <a>*/
		</script>

	</head>

</html>
