<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生管理系统</title>
</head>
<body>

	添加课程成绩
	<br />
	<form action="Course_add" method="post">
		学生名称：<input name="student.name"><br /> 
		课程名称：<input name="name"><br /> 
		成绩：<input name="score"><br /> 
		<input type="submit" value="添加"><br />
	</form>
	<hr />

	查询课程成绩
	<br />
	<form action="Course_searchByStudent" method="post">
		学生名称：<input name="student.name"><br /> <input type="submit"
			value="查询"><br />
	</form>

	<form action="Course_searchByCourse" method="post">
		课程名称：<input name="name"><br /> <input type="submit"
			value="查询"><br />
	</form>
	<hr />

	查询结果
	<br />
	<c:forEach items="${courses_result}" var="c">
		${c.student.name}|${c.name}|${c.score}
		<br />
	</c:forEach>
	<hr />

	课程成绩列表
	<br />
	<c:forEach items="${courses}" var="u">
		${u.student.name}|${u.name}|${u.score}
		<a href="Course_delete?id=${u.id}">删除</a>|
		<a href="Course_updateInput?id=${u.id}">修改</a>
		<br />
	</c:forEach>
	<hr />

</body>
</html>