<%@ page language="java" import="java.util.*,com.zxxz.crm.vo.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="${pageContext.request.contextPath}/">
    
    <title>显示客户信息</title>
    
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
<script type="text/javascript" src="resource/js/jquery-2.0.0.js"></script>
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
	
	window.location="<c:url value='/customer_addCustomer?position=1'/>";
}
/**
 * 按照页码跳转到对应的action
 */
function changepage(){
	
	var pc=$('#pagepc').val();
	window.location.href="<c:out value='${customerlist.url}&pc='/>"+pc;
}
function subselect(){
	var inputdata=$('input[name="customerInput"]').val();
	if(inputdata.length==0){
		$('input[name="customerInput"]').val('请输入内容').css('background','#1873AA');
		return false;
	}
    $('#selectdata').submit();
}
</script>
  </head>
    
  <body>

  

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" background="${pageContext.request.contextPath}/resource/images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="${pageContext.request.contextPath}/resource/images/tab_03.gif" width="12" height="30" /></td>
                <td>
       <form id="selectdata" action="<c:url value='/customer_dataOfCustomer'/>" method="get">
          <table width="100%" border="0" cellspacing="0" cellpadding="0">
         
	           <tr>
	              <td class="STYLE4" align="center">&nbsp;&nbsp;请输入查询内容：<input type="text" name="customerInput" value="${customerInput}" style="width: 290px"/></td>
	              <td class="STYLE4">&nbsp;&nbsp;请选择查询方式：
	                 <select name="queryType" style="width: 100px">
	      					<option value="1" <c:if test="${queryType eq '1'}">selected="selected"</c:if>>客户姓名</option>
	     				 	<option value="2" <c:if test="${queryType eq '2'}">selected="selected"</c:if>>客户状态</option>
	     				 	<option value="3" <c:if test="${queryType eq '3'}">selected="selected"</c:if>>客户来源</option>
	     				 	<option value="4" <c:if test="${queryType eq '4'}">selected="selected"</c:if>>客户类型</option>
	     				 	<option value="5" <c:if test="${queryType eq '5'}">selected="selected"</c:if>>所属员工</option>
	     				 	<option value="6" <c:if test="${queryType eq '6'}">selected="selected"</c:if>>客户公司</option>
	   				  </select>            
	   				</td>
	            <td class="STYLE4">
	             <input type="hidden" name="userId" value="${sessionScope.userinfo.userId}"/>
	            &nbsp;&nbsp;<input  type="button" onclick="subselect()" value="查询" style="width:50px"/></td>
	            <td class="STYLE4">&nbsp;&nbsp;<input  type="button" value="添加"  onclick="add()"  style="width:50px"/></td>            
	          </tr>

           </table>
        </form>
        
        </td>
        <td width="16"><img src="${pageContext.request.contextPath}/resource/images/tab_07.gif" width="16" height="30" />
        	 <input   type="hidden"   name="userId"   value="${sessionScope.userinfo.userId }"  />
        </td>
      </tr>
    </table></td>
  </tr>


    <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" background="${pageContext.request.contextPath}/resource/images/tab_12.gif">&nbsp;</td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td  width="5%" height="22" background="${pageContext.request.contextPath}/resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">姓名</span></div></td>
            <td  width="7%" height="22" background="${pageContext.request.contextPath}/resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">状态</span></div></td>
            <td width="7%" height="22" background="${pageContext.request.contextPath}/resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">来源</span></div></td>
            <td width="5%" height="22" background="${pageContext.request.contextPath}/resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">所属员工</span></div></td>		
			<td width="5%" height="22" background="${pageContext.request.contextPath}/resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">类型</span></div></td>
			<td width="4%" height="22" background="${pageContext.request.contextPath}/resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">性别</span></div></td>
			<td width="7%" height="22" background="${pageContext.request.contextPath}/resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">手机</span></div></td>	
			<td width="9%" height="22" background="${pageContext.request.contextPath}/resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">QQ</span></div></td>	
			<td width="10%" height="22" background="${pageContext.request.contextPath}/resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">邮箱</span></div></td>
			<td width="6%" height="22" background="${pageContext.request.contextPath}/resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">职位</span></div></td>
			<td width="13%" height="22" background="${pageContext.request.contextPath}/resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">公司</span></div></td>
			<td width="7%" height="22" background="${pageContext.request.contextPath}/resource/images/bg2.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">备注</span></div></td>
			<td width="15%" height="22" background="${pageContext.request.contextPath}/resource/images/bg2.gif" bgcolor="#FFFFFF" class="STYLE1"><div align="center">基本操作</div></td>
</tr>
	<c:choose>
	    <c:when test="${not empty customerlist.beanlist}">
	       <c:forEach items="${customerlist.beanlist}" var="cl">
            <tr>
			          <td height="20" bgcolor="#FFFFFF"style="width: 3%"><div align="center"><span class="STYLE1">${cl.customerName} </span></div></td>
			          <td height="20" bgcolor="#FFFFFF"style="width: 3%"><div align="center"><span class="STYLE1">${cl.customerCondition}</span></div></td>
			          <td height="20" bgcolor="#FFFFFF"style="width: 3%"><div align="center"><span class="STYLE1">${cl.customerSource}</span></div></td>
			          <td height="20" bgcolor="#FFFFFF"style="width: 6%"><div align="center"><span class="STYLE1">${cl.customerForUser}</span></div></td>
				      <td height="20" bgcolor="#FFFFFF"style="width: 3%"><div align="center"><span class="STYLE1">${cl.customerType}</span></div></td>
			          <td height="20" bgcolor="#FFFFFF"style="width: 3%"><div align="center"><span class="STYLE1">${cl.customerSex}</span></div></td>
			          <td height="20" bgcolor="#FFFFFF"style="width: 5%"><div align="center"><span class="STYLE1">${cl.customerMobile}</span></div></td>
				      <td height="20" bgcolor="#FFFFFF"style="width: 3%"><div align="center"><span class="STYLE1">${cl.customerQq}</span></div></td>
			          <td height="20" bgcolor="#FFFFFF"style="width: 5%"><div align="center"><span class="STYLE1">${cl.customerEmail}</span></div></td>
			          <td height="20" bgcolor="#FFFFFF"style="width: 3%"><div align="center"><span class="STYLE1">${cl.customerJob}</span></div></td>
				      <td height="20" bgcolor="#FFFFFF"style="width: 3%"><div align="center"><span class="STYLE1">${cl.customerCompany}</span></div></td>
				      <td height="20" bgcolor="#FFFFFF"style="width: 8%"><div align="center"><span class="STYLE1">${cl.customerRemark}</span></div></td>
			          <td noWrap height="20" bgcolor="#FFFFFF"style="width: 15%"><div align="center"><span class="STYLE4"><img src="${pageContext.request.contextPath}/resource/images/edt.gif" width="16" height="16" />
			          <a href="${pageContext.request.contextPath}/customer_updateCustomer?position=1&customerId=${cl.customerId}">编辑</a>&nbsp; <img src="${pageContext.request.contextPath}/resource/images/edt.gif" width="16" height="16" />
                      <a href="${pageContext.request.contextPath}/customer_customerData?customerId=${cl.customerId}">详情</a>&nbsp; <img src="${pageContext.request.contextPath}/resource/images/del.gif" width="16" height="16" />
                      <a href="${pageContext.request.contextPath}/customer_deleteCustomer?customerId=${cl.customerId}">删除</a></span></div></td>
              </tr>
          </c:forEach>
          </c:when>
          <c:otherwise>
        				<tr>
								<td height="20" bgcolor="#FFFFFF" colspan="22"  align="center">
									<div align="center">
										<span class="STYLE1">没有客户相关信息</span>
									</div>
								</td>
						</tr>
			</c:otherwise>
         </c:choose>
         </table></td>
        <td width="8" background="${pageContext.request.contextPath}/resource/images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
   <tr>
   <!-- 分页页码计数逻辑 -->
   <c:choose>
    <c:when test="${customerlist.ap<10 }">
        <c:set var="begin" value="1"></c:set>
        <c:set var="end" value="${customerlist.ap}"></c:set>
    </c:when>
    <c:otherwise>
        <c:set var="begin" value="${customerlist.pc-5}"></c:set>
        <c:set var="end" value="${customerlist.pc+4}"></c:set>
        <c:if test="${begin<1}">
            <c:set var="begin" value="1"></c:set>
            <c:set var="end" value="10"></c:set>
        </c:if>
         <c:if test="${end>customerlist.ap}">
            <c:set var="begin" value="${customerlist.ap-9 }"></c:set>
            <c:set var="end" value="${customerlist.ap }"></c:set>
        </c:if>
    </c:otherwise>
</c:choose>
    <td height="35" background="${pageContext.request.contextPath}/resource/images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="${pageContext.request.contextPath}/resource/images/tab_18.gif" width="12" height="35" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="STYLE4">&nbsp;&nbsp;共有${customerlist.ai}条记录，当前第${customerlist.pc}页</td>
            <td><table border="0" align="right" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="40"><a href="${customerlist.url}&pc=1"><img src="${pageContext.request.contextPath}/resource/images/first.gif" width="37" height="15" /></a></td>
                   <c:if test="${customerlist.pc>1}">                 
                     <td width="45"><a href="${customerlist.url}&pc=${customerlist.pc-1}"><img src="${pageContext.request.contextPath}/resource/images/back.gif" width="43" height="15" /></a></td>
                   </c:if>
        
                  <c:if test="${customerlist.pc<customerlist.ap}">
					 <td width="45"><a href="${customerlist.url }&pc=${customerlist.pc+1}"><img src="${pageContext.request.contextPath}/resource/images/next.gif" width="43" height="15" /></a></td>
                  </c:if>  
                  <td width="40"><a href="${customerlist.url}&pc=${customerlist.ap}"><img src="${pageContext.request.contextPath}/resource/images/last.gif" width="37" height="15" /></a></td>
                 
                 
                    <td width="100"><div align="center"><span class="STYLE1">转到第
                      <input id="pagepc" name="pc" type="text" size="4" style="height:12px; width:20px; border:1px solid #999999;" /> 
                                                         页 </span></div></td>
                    <td width="40"><img onclick="changepage()" src="${pageContext.request.contextPath}/resource/images/go.gif" width="37" height="15" /></td>
                   
                  
                </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="${pageContext.request.contextPath}/resource/images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>

</body>
</html>
