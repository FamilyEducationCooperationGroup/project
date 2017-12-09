<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%! int i = 0; %> 
	<%! String order="";%> 
	<link rel="stylesheet" href="./css/base.css">
	<link rel="stylesheet" href="./css/jdboxy.css?ver=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>评价记录</title>
</head>
<body>
	<h1 class="text0">评价记录</h1>
	<table id="customers" border="1">
			<tr>
				<th>被评价人</th>
				<th>评价时间</th>
				<th>评价星级</th>
				<th>评价内容</th>
			</tr>
			<s:iterator value="JdBoxyList"> 
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
		    	<td><s:property value="frm" /></td> 
		    	<td><s:property value="DTA" /></td> 
		    	<td><s:property value="star" /></td> 
		    	<td><s:property value="STR" /></td> 
			<tr></tr><br>
			</s:iterator> 
		</table>
</body>
</html>