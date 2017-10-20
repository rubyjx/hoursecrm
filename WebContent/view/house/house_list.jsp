<%@ page language="java" import="java.util.*,com.zxxz.crm.vo.*"
	pageEncoding="utf-8"%>
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

		<title>My JSP 'house_query.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.STYLE1 {
	font-size: 12px
}

.STYLE3 {
	font-size: 12px;
	font-weight: bold;
}

	a{
	text-decoration: none;
	color: #033d61;
	font-size: 12px;
}

A:hover {
	COLOR: #f60; TEXT-DECORATION: underline
}


.STYLE4 {
	color: #03515d;
	font-size: 12px;
}
-->
</style>
<script type="text/javascript" src="resource/js/jquery-2.0.0.js"></script>
<script>
var  highlightcolor='#c1ebff';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function add(){
			//只提交到doGet方法
			window.location = "<%=basePath%>/house_addHouse";
		}
function subselect(){
	var inputdata=$('input[name="houseInput"]').val();
	if(inputdata.length==0){
		$('input[name="houseInput"]').val('请输入内容').css('background','#1873AA');
		return false;
	}else{
		
    	$('#selectdata').submit();
	}
}
	
</script>

	</head>

	<body>
		<form action="<%=basePath%>/house_findAllHouse" method="post">
		
		<%
						UserInfo  userInfo = (UserInfo)request.getSession().getAttribute("userinfo");
		%>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="30"
						background="<%=basePath%>resource/images/tab_05.gif">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="12" height="30">
									<img src="<%=basePath%>resource/images/tab_03.gif" width="12"
										height="30" />
								</td>
								<td>
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td class="STYLE4" align="center">
												&nbsp;&nbsp;请输入查询信息：
												<input type="text" name="houseInput" style="width: 290px" />
											</td>
											<td class="STYLE4">
												&nbsp;&nbsp;请选择查询方式：
												<select name="queryType" style="width: 100px">
													<option value="1">
														房屋类型
													</option>
													<option value="2">
														房屋地址
													</option>
												</select>
											</td>
											<td class="STYLE4">
												&nbsp;&nbsp;
												<input type="submit" value="查询" style="width: 50px" />
												<input type="hidden"   name="userId"   value="<%=userInfo.getUserId() %>"  />
											</td>
											<td class="STYLE4">
												&nbsp;&nbsp;
												<input type="button" value="添加" onclick="add()"
													style="width: 50px" />
											</td>
										</tr>
									</table>
								</td>
								<td width="16">
									<img src="<%=basePath%>resource/images/tab_07.gif" width="16"
										height="30" />
								</td>
							</tr>
						</table>
					</td>
				</tr>


				<tr>
					<td>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="8"
									background="<%=basePath%>resource/images/tab_12.gif">
									&nbsp;
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="1"
										bgcolor="b5d6e6" onmouseover="changeto()"
										onmouseout="changeback()">
										<tr>
											<td width="3%"
												background="<%=basePath%>resource/images/bg2.gif"
												bgcolor="#FFFFFF" style="width: 3%; height: 22px;">
												<div align="center">
													<span class="STYLE1">序号</span>
												</div>
											</td>
											<td background="<%=basePath%>resource/images/bg2.gif"
												bgcolor="#FFFFFF" style="width: 10%; height: 22px;">
												<div align="center">
													<span class="STYLE1">户型</span>
												</div>
											</td>
											<td background="<%=basePath%>resource/images/bg2.gif"
												bgcolor="#FFFFFF" style="width: 5%; height: 22px;">
												<div align="center">
													<span class="STYLE1">管理员工</span>
												</div>
											</td>
											<td background="<%=basePath%>resource/images/bg2.gif"
												bgcolor="#FFFFFF" style="width: 20%; height: 22px;">
												<div align="center">
													<span class="STYLE1">房屋地址</span>
												</div>
											</td>
											<td background="<%=basePath%>resource/images/bg2.gif"
												bgcolor="#FFFFFF" style="width: 10%; height: 22px;">
												<div align="center">
													<span class="STYLE1">房屋价格(平米)</span>
												</div>
											</td>
											<td background="<%=basePath%>resource/images/bg2.gif"
												bgcolor="#FFFFFF" style="width: 30%; height: 22px;">
												<div align="center">
													<span class="STYLE1">房屋环境</span>
												</div>
											</td>
											<td width="20%"
												background="<%=basePath%>resource/images/bg2.gif"
												bgcolor="#FFFFFF" class="STYLE1"
												style="width: 20%; height: 22px;">
												<div align="center">
													基本操作
												</div>
											</td>
										</tr>
										<%
											List<HouseInfo> list = (List<HouseInfo>) request.getAttribute("houseList");
											if (list != null && list.size() > 0) {
												for (int i = 0; i < list.size(); i++) {
													HouseInfo houseInfo = list.get(i);
										%>

										<tr>
											<td height="20" bgcolor="#FFFFFF" style="width: 3%">
												<div align="center" class="STYLE1">
													<div align="center">
														<%=i + 1%>
													</div>
												</div>
											</td>
											<td height="20" bgcolor="#FFFFFF" style="width: 10%">
												<div align="center">
													<span class="STYLE1"><%=houseInfo.getTypeName()%></span>
												</div>
											</td>
											<td height="20" bgcolor="#FFFFFF" style="width: 10%">
												<div align="center">
													<span class="STYLE1"><%=houseInfo.getUserName()%></span>
												</div>
											</td>
											<td height="20" bgcolor="#FFFFFF" style="width: 20%">
												<div align="center">
													<span class="STYLE1"><%=houseInfo.getHouseAddress()%></span>
												</div>
											</td>
											<td height="20" bgcolor="#FFFFFF" style="width: 10%">
												<div align="center">
													<span class="STYLE1"><%=houseInfo.getHousePrice()%></span>
												</div>
											</td>
											<td height="20" bgcolor="#FFFFFF" style="width: 20%">
												<div align="center">
													<span class="STYLE1"><%=houseInfo.getHouseAmbient()%></span>
												</div>
											</td>
											<td height="20" bgcolor="#FFFFFF" style="width: 20%">
												<div align="center">
													<span class="STYLE4"> <img
															src="<%=basePath%>resource/images/edt.gif" width="16"
															height="16" /> <a
														href="<%=basePath%>/house_updateHouse?houseId=<%=houseInfo.getHouseId()%>">编辑</a>&nbsp;
														&nbsp; <img src="<%=basePath%>resource/images/del.gif"
															width="16" height="16" /><a
														href="<%=basePath%>/house_deleteHouse?houseId=<%=houseInfo.getHouseId()%>">删除</a>
													</span>
												</div>
											</td>
										</tr>
										<%
											}
											} else {
										%>
										<tr>
											<td height="20" bgcolor="#FFFFFF" colspan="7" align="center">
												<div align="center">
													<span class="STYLE1">没有相关房屋信息</span>
												</div>
											</td>
										</tr>
										<%
											}
										%>
									</table>
								</td>
								<td width="8"
									background="<%=basePath%>resource/images/tab_15.gif">
									&nbsp;
								</td>
							</tr>
						</table>
					</td>
				</tr>

				<tr>
					<td height="35"
						background="<%=basePath%>resource/images/tab_19.gif">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="12" height="35">
									<img src="<%=basePath%>resource/images/tab_18.gif" width="12"
										height="35" />
								</td>
								<td>
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td class="STYLE4">
												&nbsp;&nbsp;共有 <%=list.size() %> 条记录，当前第 1/1 页
											</td>
											<td>
												<table border="0" align="right" cellpadding="0"
													cellspacing="0">
													<tr>
														<td width="40">
															<img src="<%=basePath%>resource/images/first.gif"
																width="37" height="15" />
														</td>
														<td width="45">
															<img src="<%=basePath%>resource/images/back.gif"
																width="43" height="15" />
														</td>
														<td width="45">
															<img src="<%=basePath%>resource/images/next.gif"
																width="43" height="15" />
														</td>
														<td width="40">
															<img src="<%=basePath%>resource/images/last.gif"
																width="37" height="15" />
														</td>
														<td width="100">
															<div align="center">
																<span class="STYLE1">转到第 <input name="textfield"
																		type="text" size="4"
																		style="height: 12px; width: 20px; border: 1px solid #999999;" />
																	页 </span>
															</div>
														</td>
														<td width="40">
															<img src="<%=basePath%>resource/images/go.gif" width="37"
																height="15" />
														</td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
								<td width="16">
									<img src="<%=basePath%>resource/images/tab_20.gif" width="16"
										height="35" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
