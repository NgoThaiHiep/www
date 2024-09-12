<%@page import="com.fit.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>Insert title here</title>
</head>
<body>
	<%
		Student sv = new Student();
		sv = (Student)request.getAttribute("student");
		out.println("First name:" + sv.getfName() );
	%>
</body>
</html>