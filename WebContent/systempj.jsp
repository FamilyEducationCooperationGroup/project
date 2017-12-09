<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
    <link rel="stylesheet" href="./css/base.css">
	<link rel="stylesheet" href="./css/fm.css?ver=2">
        <title>系统评价</title>
    </head>
    <body class="bg1">
    	
    	<%
    	String s=request.getParameter("originuser");
    	session.setAttribute("obj1",s);
    	%>
    	
        <s:form action="Systempj.action">
    	<s:textarea label="请输入内容" name="STR" cols="100" rows="10"/>
            <s:submit value="发送" />
     </s:form>
    </body>
</html>