<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>登录或注册</title>
    </head>
    <body>
        <h3>登录</h3>
        <s:form action="login">
            	用户名: <s:textfield name="username" />
 				密码：         <s:textfield name="pwd" />
            <s:submit value="登录" />
        </s:form>
        <a href="signin.jsp" target="_blank">注册</a>
    </body>
</html>