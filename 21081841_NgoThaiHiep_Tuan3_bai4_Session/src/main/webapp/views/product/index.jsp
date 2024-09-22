<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
</head>
<body>
    <h1>Product List</h1>
    
   
    <a href="${pageContext.request.contextPath}/cart?action=view">View Cart</a>
    <br>
    <br>
    <table border="1" cellpadding="10" cellspacing="0" >
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Image</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        
        <c:forEach items="${products}" var="product">
            <tr width="120" height = "120" >
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>
                    <img src="${pageContext.request.contextPath}/resources/images/${product.image}" alt="Ảnh ${product.name}" width="120" height = "120"/>
                </td>
                <td>${product.price}</td>
                <td align="center">
                    <a href="${pageContext.request.contextPath}/cart?action=buy&id=${product.id}">Buy</a>
                   
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>