<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style type="text/css">
.a {
	width: 160px;
	height: 200px;
	border: 1px solid black;
	padding: 5px;
	margin: 10px;
	float: left;
	text-align: center;
}

.hinh {
	width: 80px;
	height: 100px;
}
</style>
</head>
<body>
	<p>
		<a href = "21081841_NgoThaiHiep_Tuan3_bai4_Session/ShoppingCart.jsp">View Cart</a>
	</p>
	<c:forEach items="${ds}" var="sp" >
		<div class="a">
		    <form name="modelDetail" method="post" action="21081841_NgoThaiHiep_Tuan3_bai4_Session/CartController">
		    	${sp.model} <br/>
		    	<img src= '/21081841_NgoThaiHiep_Tuan3_bai4_Session/images/${sp.imgURL}' class="hinh" /> <br/>'
		    	Price: ${sp.price} <br/>
		        <input type="text" size="2" name="quantity" value="1" />
		        <input type="hidden" name="modelNO" value="${sp.id}"/>
		         <input type="hidden" name="price" value="${sp.price}"/>
		          <input type="hidden" name="description" value="${sp.model}"/>
		           <input type="hidden" name="action" value="add"/>
		           <input type="submit" name="addToCart"  value="Add To Cart"/>
		    </form>
		</div>
	</c:forEach>
</body>
</html>