<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>详情</title>
</head>
<body>
	<h1>
		正文<s:property value="person"/>:
	</h1>
	<h2>
  		<s:textarea  name="STR" cols="40" rows="10"/>
    </h2>
	<a  href="del?MESID=<s:property value="MESID"/>&person=<s:property value="person"/>&DTA=<s:property value="DTA" />">
	删除
	</a>
	<a  href="dialog.jsp?frm=<s:property value="originuser"/>&to=<s:property value="person"/>">
	对话
	</a>
</body>
</html>