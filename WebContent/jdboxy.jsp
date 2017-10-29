<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>评价记录</title>
</head>
<body>
	<h1>您的评价记录</h1>
	<table border="1">
			<tr>
				<td>被评价人</td>
				<td>评价时间</td>
				<td>评价星级</td>
				<td>评价内容</td>
			</tr>
			<s:iterator value="JdBoxyList"> 
		    <tr>
		    	<td><s:property value="frm" /></td> 
		    	<td><s:property value="DTA" /></td> 
		    	<td><s:property value="star" /></td> 
		    	<td><s:property value="STR" /></td> 
			<tr></tr><br>
			</s:iterator> 
		</table>
</body>
</html>