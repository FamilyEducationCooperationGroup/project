<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="backport.Man"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%! int i = 0; %> 
	<%! String order="";%>
	<link rel="stylesheet" href="./css/base.css">
	<link rel="stylesheet" href="./css/sr.css?ver=4">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>搜寻结果</title>
</head>
<body>
			
	<h1 class=text0>根据您的要求我们找到了如下结果:</h1>
		<table id="customers" border="1">
			<tr>
				<th>用户名</th>
				<th>姓名</th>
				<th>性别</th>
				<th>电话</th>
				<th>年级</th>
				<th>科目</th>
				<th>平均评分</th>
				<th>累计成交量</th>
				<th>价位</th>
				<th>时间段</th>
				<th>地点</th>
				<th>他的评价</th>
				<th>发消息</th>
				<% if(!request.getAttribute("jb").equals(request.getAttribute("jbself"))){%>
				 <th>
				 申请匹配
				 </th>
				<%}%>
			</tr>
			<s:iterator value="result"> 
			<% if(i==0){ %>
			<% 	order="style1";%>
			<%}else{%>
			<%order="style2";%>
			<%}%>
			<% if(i==0){ %>
			<%  i=1;%>
			<%}else{%>
			<%i=0;%>
			<%}%>
		    <tr class=<%=order %>>
		    	<td><s:property value="username" /></td> 
		    	<td><s:property value="name" /></td>
		    	<td><s:property value="sex" /></td>
		    	<td><s:property value="tel"/></td>
		    	<td><s:property value="grade"/></td>
		    	<td><s:property value="subject"/></td>
		    	<td><s:property value="avestar" /></td>
		    	<td><s:property value="oknum" /></td>
		    	<td><s:property value="price"/></td>
		    	<td><s:property value="time"/></td>
		    	<td><s:property value="place"/></td>
		    	<td><a  href="jdboxy?to=<s:property value="username" />">他的评价</a></td>
		    	<td><a  href="dialog.jsp?frm=<s:property value="originuser" />&to=<s:property value="username" />">发消息</a></td>
		    	<% if(!request.getAttribute("jb").equals(request.getAttribute("jbself"))){%>
				 <td><a  href="request_match.jsp?frm=<s:property value="originuser" />&to=<s:property value="username" />">申请匹配 </a></td>
				<%}%>
			<tr></tr>
			</s:iterator> 
		</table>
</body>
</html>