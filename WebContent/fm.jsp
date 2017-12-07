<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
    	<link rel="stylesheet" href="./css/base.css">
        <link rel="stylesheet" href="./css/fm.css?ver=34">
        <title>登录或注册</title>
    </head>
    <body>
    	<div class="head">欢迎使用爷就是神家教平台</div>
    	
    	<div class="rightbar">
        <s:form action="login">
            	 <s:textfield label="用户名" styleClass="hi" name="username" cssStyle="border:5px solid red; size:10px; width:245px;height:60px;font-size:30pt;" />
 				 <s:textfield label="密码" name="pwd" cssStyle="border:5px solid red; size:10px; width:245;height:60px;font-size:30pt;" />
                 <s:submit cssStyle="border:5px solid red; size:10px; width:90;height:60px" value="登录" />
        </s:form>
        
        <a href="signin.jsp" target="_blank">如果您没有帐号点击我注册</a>
        
        </div>    
    </body>
</html>