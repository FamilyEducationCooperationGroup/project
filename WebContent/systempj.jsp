<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>Say Hello</title>
    </head>
    <body>
    	
    	<%
    	String s=request.getParameter("originuser");
    	session.setAttribute("obj1",s);
    	%>
    	
        <s:form action="Systempj.action">
    	<s:textarea label="请输入内容" name="STR" cols="40" rows="10"/>
            <s:submit value="发送" />
     </s:form>
    </body>
</html>