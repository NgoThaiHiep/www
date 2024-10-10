<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center" >
			<h2>Quản lý điên thoại</h2>
			<h4>
				<a href="${pageContext.request.contextPath}/dienThoai?action=new">Thêm điện thoại</a> 
				&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/dienThoai?action=list">Danh sách điện thoại</a>
			</h4>
			<h2>Add new User</h2>
			<form action="dienThoai?action=insert" method="post">
				<table>
						
					<tr>
						<td>Tên điện thoại</td>
						<td>
							<input type="text" name="tenDienThoai" value="${dienThoai.tendt}">
						</td>
					</tr>
					<tr>
						<th>Năm sx:</th>
						<td><input type="text" name="namSanXuat" value="${dienThoai.tendt}">
						</td>
					</tr>
					<tr>
						<th>Cấu hình:</th>
						<td><input type="text" name="cauHinh" value="${dienThoai.cauhinh}">
						</td>
					</tr>
					<tr>
						<th>Mã nhà cung cấp:</th>
						<td><input type="text" name="maNhaCungCap" value="${dienThoai.mancc}">
						</td>
					</tr>
					<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save">
						</td>
						</tr>
			</form>
	</div>
</body>
</html>