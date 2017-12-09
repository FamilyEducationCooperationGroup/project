<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/base.css">
<link rel="stylesheet" href="./css/personbox.css?ver=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>您的联系人</title>
</head>
<body>
	<h1 class="text0">您的联系人</h1>
		<table border="1" id="customers">
			<tr>
				<th>用户名</th>
				<th>评价联系人</th>
				<th>删除联系人</th>
				<th>发消息</th>
			</tr>
			<s:iterator value="personlist"> 
		    <tr>
		    	<td><s:property value="frm" /></td> 
		    	<td><a  href="judge.jsp?frm=<s:property value="originuser" />&to=<s:property value="frm" />">评价 </a></td>
		    	<td><a  href="deletepj?originuser=<s:property value="originuser" />&frm=<s:property value="frm" />">删除 </a></td>
		    	<td><a  href="dialog.jsp?frm=<s:property value="originuser" />&to=<s:property value="frm" />">对话 </a></td>
			<tr></tr><br>
			</s:iterator> 
		</table>
</body>
</html>