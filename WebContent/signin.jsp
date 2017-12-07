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
            <s:textfield label="您的用户名（此项必填）" name="username" cssStyle="size:10px; width:245px;height:60px;font-size:30pt;margin:40px auto"/>
            <s:password label="您的密码（此项必填）" name="pwd" cssStyle="size:10px; width:245px;height:60px;font-size:30pt;margin:40px auto"/>
           	<s:radio list="#{0:'学生',1:'老师'}" name="job" label="职业" required="true" value="1" cssStyle="color:#999900;margin:40px auto"></s:radio> 
           	<s:textfield label="姓名" name="name" cssStyle="size:10px; width:245px;height:60px;font-size:30pt;margin:40px auto"/>
            <s:radio list="#{0:'男',1:'女'}" name="sex" label="性别" required="true" value="1" cssStyle="color:#009988;margin:40px auto"></s:radio>  
            <s:checkboxlist name="subjects" label="关心的科目（此项必填）"   list="#{1:'数学', 2:'语文',3:'英语', 4:'物理',5:'化学',6:'生物',7:'历史',8:'地理',9:'政治'}" cssStyle="color:#999900;margin:40px auto"/>  
            <s:checkboxlist name="grades" label="关心的学年（此项必填）"   list="#{1:'小一',2:'小二',3:'小三',4:'小四',5:'小五',6:'小六',7:'初一',8:'初二',9:'初三',10:'高一',11:'高二',12:'高三'}" cssStyle="margin:40px auto"/>
            <s:select name="price" list="#{1:'50元以下',2:'50~100元',3:'100~150元',4:'150~200元',5:'200元以上'}" label="您所在的城市（此项必填）" headerKey="-1"  emptyOption="false" cssStyle="margin:40px auto"/>  
            <s:checkboxlist name="time" label="时间段（此项必填）"  list="#{0:'学校日周一到周五晚',1:'学校日周末上午',2:'学校日周末下午',3:'学校日周末晚上',4:'寒暑假上午',5:'寒暑假下午',6:'寒暑假晚上'}" cssStyle="margin:40px auto"/>
            <s:select name="place" list="#{1:'齐齐哈尔',2:'鸡西',3:'鹤岗',4:'双鸭山',5:'大庆',6:'伊春',7:'佳木斯',8:'七台河',9:'牡丹江',10:'黑河',11:'绥化',12:'哈尔滨',13:'大兴安岭地区'}" label="您所在的城市（此项必填）" headerKey="-1"  emptyOption="false" cssStyle="margin:40px auto"/>  
            <s:textfield label="您的电话号码" name="tel;font-size:30pt;" cssStyle="margin:40px auto"/>
            <s:submit value="注册帐号"/>
            <s:reset value="清空输入栏"/>
      </p>
        </s:form> 
</body>
</html>