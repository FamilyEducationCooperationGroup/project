<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./css/base.css">
<link rel="stylesheet" href="./css/fm.css?ver=32">
<title>注册</title>
</head>
<body>
      <h3>请填写用户信息 </h3>
      <s:form action="signin">
      <p class=txt>
            <s:textfield label="您的用户名（此项必填）" name="username" />
            <s:password label="您的密码（此项必填）" name="pwd" />
           	<s:radio list="#{0:'学生',1:'老师'}" name="job" label="职业" required="true" value="1" ></s:radio> 
           	<s:textfield label="姓名" name="name" />
            <s:radio list="#{0:'男',1:'女'}" name="sex" label="性别" required="true" value="1" ></s:radio>  
            <s:checkboxlist name="subjects" label="关心的科目（此项必填）"   list="#{1:'数学', 2:'语文',3:'英语', 4:'物理',5:'化学',6:'生物',7:'历史',8:'地理',9:'政治'}" />  
            <s:checkboxlist name="grades" label="关心的学年（此项必填）"   list="#{1:'小一',2:'小二',3:'小三',4:'小四',5:'小五',6:'小六',7:'初一',8:'初二',9:'初三',10:'高一',11:'高二',12:'高三'}" />
            <s:select name="price" list="#{1:'50元以下',2:'50~100元',3:'100~150元',4:'150~200元',5:'200元以上'}" label="您想要的价位（此项必填）" headerKey="-1"  emptyOption="false" />  
            <s:checkboxlist name="time" label="时间段（此项必填）"  list="#{0:'学校日周一到周五晚',1:'学校日周末上午',2:'学校日周末下午',3:'学校日周末晚上',4:'寒暑假上午',5:'寒暑假下午',6:'寒暑假晚上'}" />
            <s:select name="place" list="#{1:'哈尔滨',2:'齐齐哈尔',3:'鸡西',4:'鹤岗',5:'双鸭山',6:'大庆',7:'伊春',8:'佳木斯',9:'七台河',10:'牡丹江',11:'黑河',12:'绥化',13:'大兴安岭地区'}" label="您所在的城市（此项必填）" headerKey="-1"  emptyOption="false" />  
            <s:textfield label="您的电话号码" name="tel" />
            <s:submit value="注册帐号" />
            <s:reset value="清空输入栏"/>
      </p>
        </s:form> 
</body>
</html>