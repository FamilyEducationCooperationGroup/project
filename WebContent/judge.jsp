<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>写评价</title>
</head>
<body>
	<%
    	String s=request.getParameter("frm");
    	String t=request.getParameter("to");
    	session.setAttribute("obj1",s);
    	session.setAttribute("obj2",t);
    	%>
	<s:form action="addjudge">
		<s:radio list="#{1:'差',2:'中',3:'良',4:'优',5:'完美'}" name="star" label="星级" required="true" value="5"></s:radio>
    	<s:textarea label="请输入评价" name="STR" cols="40" rows="10"/>
            <s:submit value="发送" />
    </s:form>
</body>
</html>