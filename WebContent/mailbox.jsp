<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="wispanh=device-wispanh, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="0">
<script src="//cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
<script src="//cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script>
            $first=$.cookie('first_vist');
            if(!$first||$first=='null'||$first==null){
                $.cookie('first_vist','1',{ expires: 7 });
            }else{
                $.cookie('first_vist',null);
                location.reload(true);
            }
</script>

	<%! int i = 0; %> 
	<%! String order="";%> 
	<link rel="stylesheet" href="./css/base.css">
	<link rel="stylesheet" href="./css/mailbox.css?ver=1">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>您的邮箱</title>
</head>
<body>
	<h1>未读信息</h1>
	<table border="1" id="customers">
			<tr>
				<th>发件人</th>
				<th>时间</th>
				<th>简报</th>
				<th>详情</th>
			</tr>
			<s:iterator value="newget"> 
		    <tr>
		    	<td><s:property value="person" /></td> 
		    	<td><s:property value="DTA" /></td>
		    	<td><s:property value="brief" /></td>
		    	<td> 
		    	<a  href="inf?MESID=<s:property value="MESID"/>&refesh=1&originuser=<s:property value="originuser"/>&person=<s:property value="person"/>&DTA=<s:property value="DTA" />">
		    	查看详情
		    	</a>
		    	 </td>
			<tr></tr>
			</s:iterator> 
		</table>
	<h1>等您请求</h1>
			<table border="1" id="customers">
			<tr>
				<th>发件人</th>
				<th>时间</th>
				<th>简报</th>
				<th>同意</th>
			</tr>
			<s:iterator value="ans_wait"> 
		    <tr>
		    	<td><s:property value="frm" /></td> 
		    	<td><s:property value="DTA" /></td>
		    	<td><s:property value="mes" /></td>
		    	<td> 
		    	<a  href="allow?frm=<s:property value="frm"/>&originuser=<s:property value="originuser"/>&DTA=<s:property value="DTA" />">
		    	同意
		    	</a>
		    	</td>
			<tr></tr>
			</s:iterator> 
		</table>
	<h1>您最新的已经通过的请求</h1>
			<table border="1" id="customers">
			<tr>
				<th>同意人</th>
				<th>时间</th>
				<th>简报</th>
				<th>确认</th>
			</tr>
			<s:iterator value="ans_requested"> 
		    <tr>
		    	<td><s:property value="frm" /></td> 
		    	<td><s:property value="DTA" /></td>
		    	<td><s:property value="mes" /></td>
		    	<td> 
		    	<a  href="confirm?originuser=<s:property value="originuser"/>&frm=<s:property value="frm" />&DTA=<s:property value="DTA" />">
		    		确认
		    	</a>
		    	</td>
			<tr></tr>
			</s:iterator> 
		</table>
	<h1>您还未通过的请求</h1>
			<table border="1" id="customers">
			<tr>
				<th>对方</th>
				<th>时间</th>
				<th>简报</th>
			</tr>
			<s:iterator value="request_wait"> 
		    <tr>
		    	<td><s:property value="frm" /></td> 
		    	<td><s:property value="DTA" /></td>
		    	<td><s:property value="mes" /></td>
			<tr></tr>
			</s:iterator> 
		</table>
	<h1>已读信息</h1>
	<table border="1" id="customers">
			<tr>
				<th>发件人</th>
				<th>时间</th>
				<th>简报</th>
				<th>详情</th>
			</tr>
			<s:iterator value="geted"> 
		    <tr>
		    	<td><s:property value="person" /></td> 
		    	<td><s:property value="DTA" /></td>
		    	<td><s:property value="brief" /></td>
		    	<td> 
		    	<a  href="inf?MESID=<s:property value="MESID"/>&refesh=0&originuser=<s:property value="originuser"/>&person=<s:property value="person"/>&DTA=<s:property value="DTA" />">
		    	查看详情
		    	</a>
		    	 </td>
			<tr></tr>
			</s:iterator> 
		</table>
	<h1>已发信息</h1>
	<table border="1" id="customers">
			<tr>
				<th>收件人</th>
				<th>时间</th>
				<th>简报</th>
				<th>详情</th>
			</tr>
			<s:iterator value="post"> 
		    <tr>
		    	<td><s:property value="person" /></td> 
		    	<td><s:property value="DTA" /></td>
		    	<td><s:property value="brief" /></td>
		    	<td> 
		    	<a  href="inf?MESID=<s:property value="MESID"/>&refesh=0&originuser=<s:property value="originuser"/>&person=<s:property value="person"/>&DTA=<s:property value="DTA" />">
		    	查看详情
		    	</a>
		    	 </td>
			<tr></tr>
			</s:iterator> 
		</table>
</body>
</html>