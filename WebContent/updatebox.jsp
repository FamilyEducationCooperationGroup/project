<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>修改个人信息</title>
</head>
<body>
	  <%
    	String s=request.getParameter("username");
    	session.setAttribute("obj2",s);
    	%>
      <h3>请填写要修改的信息 </h3>
      <s:form action="update"> 
      		<s:textfield label="密码" name="pwd" />
            <s:checkboxlist name="subjects" label="关心的科目"  list="#{1:'数学', 2:'语文',3:'英语', 4:'物理',5:'化学',6:'生物',7:'历史',8:'地理',9:'政治'}" />  
            <s:checkboxlist name="grades" label="关心的学年"  list="#{1:'小一',2:'小二',3:'小三',4:'小四',5:'小五',6:'小六',7:'初一',8:'初二',9:'初三',10:'高一',11:'高二',12:'高三'}" />
            <s:select name="price" list="#{1:'50元以下',2:'50~100元',3:'100~150元',4:'150~200元',5:'200元以上'}" label="您所在的城市（此项必填）" headerKey="-1"  emptyOption="false"/>  
             <s:checkboxlist name="time" label="时间段（此项必填）"  list="#{0:'学校日周一到周五晚',1:'学校日周末上午',2:'学校日周末下午',3:'学校日周末晚上',4:'寒暑假上午',5:'寒暑假下午',6:'寒暑假晚上'}" />
            <s:select name="place" list="#{1:'齐齐哈尔',2:'鸡西',3:'鹤岗',4:'双鸭山',5:'大庆',6:'伊春',7:'佳木斯',8:'七台河',9:'牡丹江',10:'黑河',11:'绥化',12:'哈尔滨',13:'大兴安岭地区'}" label="您所在的城市（此项必填）" headerKey="-1"  emptyOption="false"/>  
            <s:textfield label="您的电话号码" name="tel" />
            <s:submit value="修改"/>
            <s:reset value="清空输入栏"/>
        </s:form> 
</body>
</html>