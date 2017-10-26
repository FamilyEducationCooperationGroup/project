<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>您的邮箱</title>
</head>
<body>
	<h1>未读信息</h1>
	<table border="1">
			<tr>
				<td>发件人</td>
				<td>时间</td>
				<td>简报</td>
				<td>详情</td>
			</tr>
			<s:iterator value="newget"> 
		    <tr>
		    	<td><s:property value="person" /></td> 
		    	<td><s:property value="DTA" /></td>
		    	<td><s:property value="brief" /></td>
		    	<td> 
		    	<a  href="inf?MESID=<s:property value="MESID"/>&refesh=1&originuser=<s:property value="originuser"/>&person=<s:property value="person"/>&DTA=<s:property value="DTA" />">
		    	查看详情
		    	</a>
		    	 <td>
			<tr></tr><br>
			</s:iterator> 
		</table>
	<h1>已读信息</h1>
	<table border="1">
			<tr>
				<td>发件人</td>
				<td>时间</td>
				<td>简报</td>
				<td>详情</td>
			</tr>
			<s:iterator value="geted"> 
		    <tr>
		    	<td><s:property value="person" /></td> 
		    	<td><s:property value="DTA" /></td>
		    	<td><s:property value="brief" /></td>
		    	<td> 
		    	<a  href="inf?MESID=<s:property value="MESID"/>&refesh=0&originuser=<s:property value="originuser"/>&person=<s:property value="person"/>&DTA=<s:property value="DTA" />">
		    	查看详情
		    	</a>
		    	 <td>
			<tr></tr><br>
			</s:iterator> 
		</table>
	<h1>已发信息</h1>
	<table border="1">
			<tr>
				<td>收件人</td>
				<td>时间</td>
				<td>简报</td>
				<td>详情</td>
			</tr>
			<s:iterator value="post"> 
		    <tr>
		    	<td><s:property value="person" /></td> 
		    	<td><s:property value="DTA" /></td>
		    	<td><s:property value="brief" /></td>
		    	<td> 
		    	<a  href="inf?MESID=<s:property value="MESID"/>&refesh=0&originuser=<s:property value="originuser"/>&person=<s:property value="person"/>&DTA=<s:property value="DTA" />">
		    	查看详情
		    	</a>
		    	 <td>
			<tr></tr><br>
			</s:iterator> 
		</table>
</body>
</html>