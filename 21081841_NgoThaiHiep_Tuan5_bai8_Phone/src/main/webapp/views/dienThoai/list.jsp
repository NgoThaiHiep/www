<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Danh sách điện thoại</h2>
<h4>
	<a href="${pageContext.request.contextPath}/dienThoai?action=new">Thêm điện thoại</a> 
	&nbsp;&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath}/dienThoai">Danh sách điện thoại</a>
	&nbsp;&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath}/dienThoai">Chức năng quản lý</a>
</h4>

<table>
		<tr>
			<th>Mã điện thoại</th>
			<th>Tên điện thoại</th>
			<th>Năm sản xuất</th>
			<th>Cấu hình</th>
			<th>Mã nhà cung cấp</th>
		</tr>
		<c:forEach var="dienThoai" items="${listDienThoai}">
			<tr>
				<td>${dienThoai.madt}</td>
				<td>${dienThoai.tendt}</td>
				<td>${dienThoai.namsx}</td>
				<td>${dienThoai.cauhinh}</td>
				<td>${dienThoai.mancc}</td>
				<td>
					<a href="${pageContext.request.contextPath}/dienThoai?action=edit&id=<c:out value='${dienThoai.madt}' />">Edit</a>
					<a href="${pageContext.request.contextPath}/dienThoai?action=delete&id=<c:out value='${dienThoai.madt}' />">Delete</a>
				</td>
			</tr>
		</c:forEach>
</body>
</html>