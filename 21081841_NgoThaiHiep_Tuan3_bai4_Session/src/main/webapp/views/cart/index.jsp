<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body >
<div style="justify-content: 'center',align-items: 'center'">


    <h1>Shopping Cart</h1>
    </div>
    <a href="${pageContext.request.contextPath}/DSSP">Continue Shopping</a>
    <br>
    <br>
	<table border="1">
			 <tr>
	            <th>ID</th>
	            <th>Name</th>
	            <th>Image</th>
	            <th>Price</th>
	            <th>Quantity</th>
	            <th>Total</th>
	            <th>Action</th>
	            
	        </tr>
	        
	<c:set var="total" value="0"></c:set>
	<c:set var="qua" value="0"></c:set>
		
		<c:forEach var="item" items="${sessionScope.cart}">
	    <c:set var="qua" value="${qua + item.quantity}"></c:set>
	    <c:set var="total" value="${total + item.product.price * item.quantity}"></c:set>
	  
			<tr width="120" height = "120" >
	        <td>${item.product.id}</td>
	        <td>${item.product.name}</td>
	        <td>
	            <img src="${pageContext.request.contextPath}/resources/images/${item.product.image}" width="120" height = "120">
	        </td>
	        <td>${item.product.price}</td>
	        <td>${item.quantity}</td>
	        <td>${item.product.price * item.quantity}</td>
	        <td align="center">
	            <a href="${pageContext.request.contextPath}/cart?action=remove&id=${item.product.id}"
	               onclick="return confirm('Are you sure?')">Remove</a>
	        </td>
	       
	    </tr>
	    </c:forEach>
		<tr>
			
			<td colspan="5" align="right">Quantity:</td>
			<td>${qua}</td>
			<tr>
				<td colspan="5" align="right">Total:</td>
				<td>${total}</td>
				
			</tr>
	</table>
   


</body>
</html>