<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
    	<%! String type; %>
    	<link rel="stylesheet" href="./css/base.css">
        <link rel="stylesheet" href="./css/fm.css?ver=50">
        <title>登录或注册</title>
    </head>
    <body>
    	<div class="head">家教服务系统
    	</div>
    	<div>
	    	 <div class="warningbar">
		    		<s:property value="#parameters.type"/>
		     </div>
	    	<center>
		    	
	        <s:form action="login" >
	            	 <s:textfield label="用户名" styleClass="hi" name="username" cssStyle="border:5px solid red; size:10px; width:245px;height:60px;font-size:30pt;" />
	 				 <s:password label="密码" name="pwd" cssStyle="border:5px solid red; size:10px; width:245;height:60px;font-size:30pt;" />
	                
	                 <s:submit cssStyle="text-align:center;border:5px solid red; size:10px; width:90;height:60px" value="登录" />
	        </s:form>
	        
	        <a href="signin.jsp" target="_blank">如果您没有帐号点击我注册</a>
	        </center>
       </div>    
    </body>
</html>