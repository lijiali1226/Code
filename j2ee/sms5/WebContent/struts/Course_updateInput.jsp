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

	<form action="admin/Course_update" method="post">
	<input type="hidden" name="course.id" value="<s:property value="course.id"/>" /> 
	<input type="hidden" name="course.student.name" value="<s:property value="course.student.name"/>" /> 
		课程名称：<input name="course.name"  value="<s:property value="course.name"/>"><br /> 
		成绩：<input name="course.score" value="<s:property value="course.score"/>"><br/>
		 <input type="submit" value="修改"><br />

	</form>

</body>
</html>