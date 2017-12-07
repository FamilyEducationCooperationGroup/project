<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="backport.Man"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>搜寻结果</title>
</head>
<body>
	<h1>根据您的要求我们找到了如下结果:</h1>
		<table border="1">
			<tr>
				<td>用户名</td>
				<td>姓名</td>
				<td>性别</td>
				<td>电话</td>
				<td>年级</td>
				<td>科目</td>
				<td>平均评分</td>
				<td>累计成交量</td>
				<td>价位</td>
				<td>时间段</td>
				<td>地点</td>
				<td>他的评价</td>
				<td>发消息</td>
				<td>申请匹配</td>
			</tr>
			<s:iterator value="result"> 
		    <tr>
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
		    	<td><a  href="request_match.jsp?frm=<s:property value="originuser" />&to=<s:property value="username" />">申请匹配 </a></td>
			<tr></tr><br>
			</s:iterator> 
		</table>
</body>
</html>