<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>学生管理系统</title>
</head>
<body>
添加学生	<br/>
<form action="admin/Student_add" method="post">
		姓名：<input name="student.name"><br /> 
		 <input type="submit" value="添加"><br />
	</form>
	<hr />
	
查询学生	<br/>
<form action="admin/Student_search" method="post">
		姓名：<input name="student.name"><br /> 
		<input type="submit"value="查询"><br />
	</form>
	<hr />
	
查询结果<br/>
	<s:property value="student.id" />
	<s:property value="student.name" />
	<br />
	<hr/>
	
学生列表	<br/>
	<s:iterator value="students" var="u">
		<s:property value="#u.name" />|
		<a href="admin/Student_delete?id=<s:property value='#u.id'/>">删除学生</a>|
		<a href="admin/Student_updateInput?id=<s:property value='#u.id'/>">修改学生</a>
		<br />
	</s:iterator>
	<hr />
	<s:debug></s:debug>

</body>
</html>