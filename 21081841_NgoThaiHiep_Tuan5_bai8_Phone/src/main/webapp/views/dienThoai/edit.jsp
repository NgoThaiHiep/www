<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit phone</title>
</head>
<style>
   .button {
	padding : 2px;
	background-color: white;
	border: 1px solid black;
	color: black;
	text-decoration: none;
}
  </style>
<body>

<div align="center" >
			<h2>Sửa thông tin điện thoại</h2>
			<h4>
				<a href="${pageContext.request.contextPath}/dienThoai?action=new">Thêm điện thoại</a> 
				&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/dienThoai?action=list">Danh sách điện thoại</a>
			</h4>
			<h2>Add new User</h2>
			<form action="dienThoai?action=update" method="post">
			 <c:set var="item" value="${editDienThoai}" />
				<table>
						<td>Mã điện thoại: </td>
						<td>  
							 <input type="hiden" name="maDienThoai" value="${item.madt}">
						</td>
					<tr>
						<td>Tên điện thoại</td>
						<td>
							<input type="text" name="tenDienThoai" value="${item.tendt}">
						</td>
					</tr>
					<tr>
						<th>Năm sx:</th>
						<td><input type="text" name="namSanXuat" value="${item.namsx}">
						</td>
					</tr>
					<tr>
						<th>Cấu hình:</th>
						<td><input type="text" name="cauHinh" value="${item.cauhinh}">
						</td>
					</tr>
					<tr>
						<th>Mã nhà cung cấp:</th>
						<td><input type="text" name="maNhaCungCap" value="${item.mancc}">
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="update">
						</td>
					</tr>
			</form>
	</div>
</body>
</html>