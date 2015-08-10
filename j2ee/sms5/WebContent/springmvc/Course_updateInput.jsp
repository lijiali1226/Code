<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生管理系统</title>
</head>
<body>

	<form action="Course_update" method="post">
	<input type="hidden" name="id" value="${course.id}"/><br /> 
	<input type="hidden" name="student.name" value="${course.student.name}"/><br /> 
		课程名称：<input name="name"  value="${course.name}"/><br /> 
		成绩：<input name="score" value="${course.score}"/><br/>
		 <input type="submit" value="修改"><br />
	</form>

</body>
</html>