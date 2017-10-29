<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>您的评价记录</title>
</head>
<body>
	<h1>您的评价记录</h1>
	<table border="1">
			<tr>
				<td>被评价人</td>
				<td>评价时间</td>
				<td>评价星级</td>
				<td>修改评价</td>
				<td>删除评价</td>
			</tr>
			<s:iterator value="jdList"> 
		    <tr>
		    	<td><s:property value="frm" /></td> 
		    	<td><s:property value="DTA" /></td> 
		    	<td><s:property value="star" /></td> 
		    	<td><a  href="judge.jsp?frm=<s:property value="originuser" />&to=<s:property value="frm" />">修改 </a></td>
		    	<td><a  href="deljd?frm=<s:property value="originuser" />&to=<s:property value="frm" />">删除</a></td>
			<tr></tr><br>
			</s:iterator> 
		</table>
</body>
</html>