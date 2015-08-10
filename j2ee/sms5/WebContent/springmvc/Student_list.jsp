<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setCharacterEncoding("UTF-8");
%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生管理系统</title>
</head>
<body>
	添加学生
	<br />
	<form action="Student_add" method="post">
		姓名：<input name="name"><br /> <input type="submit" value="添加"><br />
	</form>
	<hr />

	查询学生
	<br />
	<form action="Student_search" method="post">
		姓名：<input name="name"><br /> <input type="submit" value="查询"><br />
	</form>
	<hr />

	查询结果
	<br /> ${student_result.id} | ${student_result.name}
	<br />
	<hr />

	学生列表
	<br />
	
	<c:forEach items="${students}" var="u">
		${u.name}|
		<a href="Student_delete?id=${u.id}">删除学生</a>|
		<a href="Student_updateInput?id=${u.id}">修改学生</a>
		<br />
	</c:forEach>
	<hr />
</body>
</html>