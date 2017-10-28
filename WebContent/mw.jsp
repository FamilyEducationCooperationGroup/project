<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="backport.Man"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>家教管理系统</title>
</head>
<body>
	<%
    	String s=request.getParameter("username");
    	session.setAttribute("obj1",s);
    %>
	<h1>欢迎<s:property value="username" /></h1>
	<h2>您有<s:property value="unread" />封邮件未读</h2>
	<a href = "show.action?jb=1&originuser=<s:property value="username" />">
		家教公示
	</a>
	<a href = "show.action?jb=0&originuser=<s:property value="username" />">
		学生公示
	</a>
	<a href = "mailbox.action?MESID=<s:property value="MESID" />&originuser=<s:property value="username" />">
		您的邮箱
	</a>
	<a href = "updatebox.jsp?originuser=<s:property value="username" />">
		修改个人信息
	</a>
	<a href = "personbox?MESID=<s:property value="MESID" />&originuser=<s:property value="username" />">
		联系人
	</a>
	<a href = "systempj.jsp?originuser=<s:property value="username" />">
		系统评价
	</a>
	<h2>输入条件来查询您想找的人</h2>
	<p>
		<s:form action="search">
            <s:textfield label="用户名" name="username" />
           	<s:radio list="#{0:'学生',1:'老师'}" name="job" label="职业" required="true" value="1"></s:radio> 
           	<s:textfield label="姓名" name="name" />
            <s:radio list="#{0:'男',1:'女'}" name="sex" label="性别" required="true" value="1"></s:radio>  
            <s:checkboxlist name="subjects" label="关心的科目（此项必填）"  list="#{1:'数学', 2:'语文',3:'英语', 4:'物理',5:'化学',6:'生物',7:'历史',8:'地理',9:'政治'}" />  
            <s:checkboxlist name="grades" label="关心的学年（此项必填）"  list="#{1:'小一',2:'小二',3:'小三',4:'小四',5:'小五',6:'小六',7:'初一',8:'初二',9:'初三',10:'高一',11:'高二',12:'高三'}" />
            <s:submit value="搜索一下"/>
            <s:reset value="清空输入栏"/>
        </s:form>
	</p>
	<h3>猜您想要</h3>
		<table border="1">
			<tr>
				<td>用户名</td>
				<td>姓名</td>
				<td>性别</td>
				<td>电话</td>
				<td>年级</td>
				<td>科目</td>
				<td>发消息</td>
				<td>申请匹配</td>
			</tr>
			<s:iterator value="result"> 
		    <tr>
		    	<td><s:property value="username" /></td> 
		    	<td><s:property value="name" /></td>
		    	<td><s:property value="sex" /></td>
		    	<td><s:property value="tel"/></td>
		    	<td><s:property value="grade"/></td>
		    	<td><s:property value="subject"/></td>
		    	<td> 
		    	<a  href="dialog.jsp?frm=<%= request.getParameter("username")%>&to=<s:property value="username" />">发消息 </a>
		    	 </td>
		    	 <td> 
		    	<a  href="request_match.jsp?frm=<%= request.getParameter("username")%>&to=<s:property value="username" />">申请匹配 </a>
		    	 </tr>
			<tr></tr><br>
			</s:iterator> 
		</table>

	
</body>
</html>