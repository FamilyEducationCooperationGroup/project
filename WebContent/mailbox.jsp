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
	<h1>等您请求</h1>
			<table border="1">
			<tr>
				<td>发件人</td>
				<td>时间</td>
				<td>简报</td>
				<td>同意</td>
			</tr>
			<s:iterator value="ans_wait"> 
		    <tr>
		    	<td><s:property value="frm" /></td> 
		    	<td><s:property value="DTA" /></td>
		    	<td><s:property value="mes" /></td>
		    	<td> 
		    	<a  href="allow?frm=<s:property value="frm"/>&originuser=<s:property value="originuser"/>&DTA=<s:property value="DTA" />">
		    	同意
		    	</a>
		    	 <td>
			<tr></tr><br>
			</s:iterator> 
		</table>
	<h1>您最新的已经通过的请求</h1>
			<table border="1">
			<tr>
				<td>同意人</td>
				<td>时间</td>
				<td>简报</td>
				<td>确认</td>
			</tr>
			<s:iterator value="ans_requested"> 
		    <tr>
		    	<td><s:property value="frm" /></td> 
		    	<td><s:property value="DTA" /></td>
		    	<td><s:property value="mes" /></td>
		    	<td> 
		    	<a  href="confirm?originuser=<s:property value="originuser"/>&frm=<s:property value="frm" />&DTA=<s:property value="DTA" />">
		    		确认
		    	</a>
		    	 <td>
			<tr></tr><br>
			</s:iterator> 
		</table>
	<h1>您还未通过的请求</h1>
			<table border="1">
			<tr>
				<td>对方</td>
				<td>时间</td>
				<td>简报</td>
			</tr>
			<s:iterator value="request_wait"> 
		    <tr>
		    	<td><s:property value="frm" /></td> 
		    	<td><s:property value="DTA" /></td>
		    	<td><s:property value="mes" /></td>
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