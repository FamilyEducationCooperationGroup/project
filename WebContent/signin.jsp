<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>注册</title>
</head>
<body>
      <h3>请填写用户信息 </h3>
      <s:form action="signin">
            <s:textfield label="您的用户名（此项必填）" name="username" />
            <s:password label="您的密码（此项必填）" name="pwd" />
           	<s:radio list="#{0:'学生',1:'老师'}" name="job" label="职业" required="true" value="1"></s:radio> 
           	<s:textfield label="姓名" name="name" />
            <s:radio list="#{0:'男',1:'女'}" name="sex" label="性别" required="true" value="1"></s:radio>  
            <s:checkboxlist name="subjects" label="关心的科目（此项必填）"  list="#{1:'数学', 2:'语文',3:'英语', 4:'物理',5:'化学',6:'生物',7:'历史',8:'地理',9:'政治'}" />  
            <s:checkboxlist name="grades" label="关心的学年（此项必填）"  list="#{1:'小一',2:'小二',3:'小三',4:'小四',5:'小五',6:'小六',7:'初一',8:'初二',9:'初三',10:'高一',11:'高二',12:'高三'}" />
            <s:textfield label="您的电话号码" name="tel" />
            <s:submit value="注册帐号"/>
            <s:reset value="清空输入栏"/>
        </s:form> 
</body>
</html>