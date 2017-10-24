<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>Say Hello</title>
    </head>
    <body>
    	
    	<%
    	String s=request.getParameter("frm");
    	String t=request.getParameter("to");
    	session.setAttribute("obj1",s);
    	session.setAttribute("obj2",t);
    	%>
    	
        <s:form action="dialog.action">
    	<s:textarea label="请输入内容" name="message" cols="40" rows="10"/>
            <s:submit value="发送" />
     </s:form>
    </body>
</html>