<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.zxxz.crm.vo.CustomerCareInfo"%>
<%@page import="com.zxxz.crm.vo.UserInfo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>客户关怀查询</title>
    
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
.STYLE1 {font-size: 12px}
.STYLE3 {font-size: 12px; font-weight: bold; }
.STYLE4 {
	color: #03515d;
	font-size: 12px;
}

	a{
	text-decoration: none;
	color: #033d61;
	font-size: 12px;
}
A:hover {
	COLOR: #f60; TEXT-DECORATION: underline
}

-->
</style>

<script>
var  highlightcolor='#c1ebff';
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
</script>
<script type="text/javascript">
	function add(){  
			window.location.href="${pageContext.request.contextPath}/customercare_addCusotmerCare?position=1";
		}

</script>
  </head>
  
  <body>
  
  <%
						UserInfo  userInfo  = (UserInfo)request.getSession().getAttribute("userinfo");
			 %>
		
 
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" background="<%=basePath%>resource/images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="<%=basePath%>resource/images/tab_03.gif" width="12" height="30" /></td>
                <td>
     <form  action="${pageContext.request.contextPath}/customercare_customerCareList" method="post">     
       <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="STYLE4" align="center">&nbsp;&nbsp;请输入查询内容：<input type="text" name="customerInput" style="width: 290px"/></td>
            <td class="STYLE4">&nbsp;&nbsp;请选择查询方式：
                <select name="queryType" style="width: 100px">
      					<option value="1" >关怀客户</option>
     				 	<option value="2" >关怀主题</option>
     				 	<option value="3" >关怀方式</option>
   				 </select>            
   				</td>
            <td class="STYLE4">&nbsp;&nbsp;<input  type="submit" value="查询" style="width:50px"/></td>           
          <td class="STYLE4">&nbsp;&nbsp;<input  type="button"  onclick="add()" value="添加"  style="width:50px"/></td>           
          </tr>
        </table>
        </form>
        </td>
        <td width="16"><img src="<%=basePath%>resource/images/tab_07.gif" width="16" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  

    <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" background="<%=basePath%>resource/images/tab_12.gif">&nbsp;</td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td width="2%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">序号</span></div></td>
            <td width="3%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">客户</span></div></td>
            <td width="4%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">关怀主题</span></div></td>
            <td width="4%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">关怀方式</span></div></td>
				
	    <td width="5%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">关怀时间</span></div></td>
	    <td width="5%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">下次关怀时间</span></div></td>
	    
		<td width="10%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">备注</span></div></td>
 	    <td width="3%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">关怀人</span></div></td>
        <td   <% if  ("3".equals(userInfo.getRoleId()) &&  "4".equals(userInfo.getRoleId())) {%> style=" display: none  "  <%}%>   width="4%" height="22" background="<%=basePath%>resource/images/bg2.gif" bgcolor="#FFFFFF" class="STYLE1">
           <div align="center">基本操作</div>
        </td>

</tr>

 <% List<CustomerCareInfo> list = (List<CustomerCareInfo>)request.getAttribute("customercarelist");
			if(list!=null && list.size()>0){
			for(int i=0;i<list.size();i++){ 
				CustomerCareInfo care = list.get(i);
			%>

 <tr>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="center"><%=i+1 %></div>
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=care.getCustomerInfo().getCustomerName() %></span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=care.getCareTheme() %></span></div></td>
   	    <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=care.getCareWay() %></span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=care.getCareTime() %></span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=care.getCareNexttime() %></span></div></td>
		<td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=care.getCareRemark() %> </span></div></td>
		 <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><%=care.getCarePeople() %></span></div></td>
           
             
             <td    <%   if  ("3".equals(userInfo.getRoleId()) &&  "4".equals(userInfo.getRoleId()) ) {%> style=" display: none  "  <%}%>   height="20" bgcolor="#FFFFFF">
                 <div align="center">
                    <span class="STYLE4">
                       <img src="<%=basePath%>resource/images/edt.gif" width="16" height="16" />
                          <a href="${pageContext.request.contextPath}/customercare_updateCustomerCare?position=1&careId=<%=care.getCareId()%>">
                                                                              编辑
                          </a>&nbsp; &nbsp;
                          <img src="<%=basePath%>resource/images/del.gif" width="16" height="16" />
                          <a href="${pageContext.request.contextPath}/customercare_deleteCustomerCare?careId=<%=care.getCareId()%>" >
                                                                    删除
                          </a>
                     </span>
                  </div>
              </td>
          </tr>
           <%}}else{ %>
							<tr>
								<td height="20" bgcolor="#FFFFFF" colspan="21"  align="center">
									<div align="center">
										<span class="STYLE1">没有员工相关信息</span>
									</div>
								</td>
							</tr>
		<%} %>
          
        </table></td>
        <td width="8" background="<%=basePath%>resource/images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35" background="<%=basePath%>resource/images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="<%=basePath%>resource/images/tab_18.gif" width="12" height="35" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="STYLE4">&nbsp;&nbsp;共有 <%= list.size() %> 条记录，当前第 1/1 页</td>
            <td><table border="0" align="right" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="40"><img src="<%=basePath%>resource/images/first.gif" width="37" height="15" /></td>
                  <td width="45"><img src="<%=basePath%>resource/images/back.gif" width="43" height="15" /></td>
                  <td width="45"><img src="<%=basePath%>resource/images/next.gif" width="43" height="15" /></td>
                  <td width="40"><img src="<%=basePath%>resource/images/last.gif" width="37" height="15" /></td>
                  <td width="100"><div align="center"><span class="STYLE1">转到第
                    <input name="textfield" type="text" size="4" style="height:12px; width:20px; border:1px solid #999999;" /> 
                    页 </span></div></td>
                  <td width="40"><img src="<%=basePath%>resource/images/go.gif" width="37" height="15" /></td>
                </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="<%=basePath%>resource/images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>

  </body>
 
</html>
