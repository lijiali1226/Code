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

	添加课程成绩<br/>
	<form action="admin/Course_add" method="post">
		学生名称：<input name="course.student.name"><br/>
		课程名称：<input name="course.name"><br /> 
		成绩：<input name="course.score"><br/>
		 <input type="submit" value="添加"><br />
	</form>
	<hr/>
	
	查询课程成绩<br/>
	<form action="admin/Course_searchByStudent" method="post">
		学生名称：<input name="course.student.name"><br/>
		<input type="submit" value="查询"><br />
	</form>
	
	<form action="admin/Course_searchByCourse" method="post">
		课程名称：<input name="course.name"><br/>
		<input type="submit" value="查询"><br />
	</form>
	<hr />
	
 	查询结果<br/>
	<s:iterator value="courses_result" var="c">
		<s:property value="#c.student.name"/>|
		<s:property value="#c.name" />|
		<s:property value="#c.score"/><br/>
	</s:iterator>
	<hr />
	
	课程成绩列表<br/>
	<s:iterator value="courses" var="u">
	<s:property value="#u.student.name"/>|
		<s:property value="#u.name" />|
		<s:property value="#u.score"/>|
		<a href="admin/Course_delete?id=<s:property value='#u.id'/>">删除</a>|
		<a href="admin/Course_updateInput?id=<s:property value='#u.id'/>">修改</a><br/>
	</s:iterator>
	<hr />
	<s:debug></s:debug>

</body>
</html>