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

	<form action="admin/Student_update" method="post">
		<input type="hidden" name="student.id" value="<s:property value="student.id"/>" /> 
			姓名：<input name="student.name" value="<s:property value="student.name"/>"><br />
		 <input type="submit" value="修改"><br />

	</form>

</body>
</html>