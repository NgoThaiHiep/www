<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- <link rel="stylesheet" href="../webapp/CSS/TrangChu.css"> -->
	<title>IUH Bookstore</title>
	<style type="text/css">
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
	font-family: 'Courier New', Courier, monospace;
}

body {
	display: flex;
	flex-direction: column;
	min-height: 100vh;
}

.outer {
	flex: 1;
	display: flex;
	flex-direction: column;
	width: 100%;
}

header {
	width: 100%;
	padding: 20px;
	background-color: #294e79;
	color: #ffffff;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

header h1 {
	font-size: 36px;
	margin: 0;
}

header nav ul {
	list-style-type: none;
	display: flex;
	gap: 20px;
}

header nav ul li {
	background-color: #746c64;
	padding: 10px;
	border-radius: 5px;
}

header nav ul li a {
	color: #ffffff;
	text-decoration: none;
	font-size: 18px;
}

table tr th {
	padding: 10px;
	background-color: #37444d;
	color: white;
}

table tr td {
	padding: 10px;
}

header nav ul li a:hover {
	
	color: #294e79;
}

.content-wrapper {
	display: flex;
	flex: 1;
}

aside table tr td a {
	color: black;
}

aside table tr td a:hover {
	color: blue;
	text-decoration: none;
}

section {
	width: 30%;
	padding: 10px;
	background-color: white;
}

section article input {
	width: 80%;
	border-radius: 5px;
	border: 2px solid black;
	background-color: #f9f9f9;
	padding: 5px;
}

aside input {
	border: 1px solid black;
	padding: 3px;
}

aside {
	width: 70%;
	padding: 20px;
	background-color: #f9f9f9;
}

.catalog .book-item a:hover {
	color: red;
	text-decoration: none;
	font-weight: bold;
}

.catalog {
	display: grid;
	grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
	gap: 20px;
}

.h1 {
	display: flex;
	text-align: center;
}

.book-item img {
	max-width: 120px;
	max-height: 140px;
	margin-bottom: 5px;
}

.button {
	background-color: white;
	border: 1px solid black;
	color: black;
	text-decoration: none;
}

.book-author {
	font-weight: normal;
	font-style: italic;
	margin-top: 5px;
}

.book-price, .book-quantity {
	margin-bottom: 5px;
}

	.product-detail, .add-to-cart {
		display: block;
		color: black;
	}

	aside .button:hover {
		background-color : white;
		border: 1px solid black;
		color: red;
		font-weight: bold;
		text-decoration: underline;
	}

footer {
	width: 100%;
	color: white;
	background-color: black;
	text-align: center;
	border-top: 1px solid brown;
	padding: 10px;
}

@media ( max-width : 768px) {
	header h1 {
		font-size: 24px;
	}
	header nav ul li a {
		font-size: 16px;
	}
	.content-wrapper {
		flex-direction: column;
	}
	section, aside {
		width: 100%;
	}
	.catalog {
		grid-template-columns: 1fr;
	}
}
</style>
</head>
<body>
	<div class="outer">
      <jsp:include page="../Component/header.jsp"></jsp:include>
        <div class="content-wrapper">
          <jsp:include page="../Component/section.jsp"></jsp:include>
            <aside>
             	<div class="book">
             	 <h1 style="margin-left: 30% ; margin-bottom: 20px" >YOUR SHOPPING CART</h1>
		            <table border="1" >
			            <tr>
				            <th>Product ID</th>
				            <th>Product Name</th>
				            <th>Price</th>
				            <th>Qty</th>
				            <th>Total</th>
				            <th>Romove</th>
			            </tr>          
			               <c:set var = "total" value = "0"></c:set>
			          
			               <c:forEach var="item" items="${sessionScope.shoppingCart}">
			               <c:set var = "total" value = "${total + item.book.price * item.quantity}"></c:set>
							    <tr>
							        <td> <c:if test = "${item.book.id < 10 }">
							        		pro0${item.book.id}
							            </c:if>
							            <c:if test = "${item.book.id >= 10 }">
							             	pro${item.book.id}
							             </c:if>
							        </td>
							        <td>${item.book.title}
							        	<c:if test="${item.book.author !=null && item.book.author != ''}">
							        		<span class="book-author">- Tác giả: ${item.book.author}</span>
							        	</c:if>
							        	<c:if test = "${item.book.translator != null && item.book.translator != ''}">
							        		<span class="book-author">- Dịch giả: ${item.book.translator}</span>
							        	</c:if>
							        	
							        	
							        </td>
							        <td>${item.book.price}</td>
							        <td>${item.quantity}</td>
							        <td>${item.book.price * item.quantity}</td>
							        <td><a href="${pageContext.request.contextPath }/shoppingCart?action=removeCart&id=${item.book.id}"
							        	 onclick="return confirm('Are you sure?')">Remove</a></td>
							    </tr>
							</c:forEach>
									 <c:if test="${empty sessionScope.shoppingCart}">
			                            <tr>
			                                <td colspan="6" align="center">Your cart is empty</td>
			                            </tr>
			                        </c:if>
									<tr>
										<td colspan="4" align="right">Total:</td>
										<td colspan= "2">(VNĐ)${total}</td>
										
									</tr>
								
			                </table>
			        </div>
			        <div style="height:50px; margin-top: 20px; " >
			        	
			        		<c:if test= "${ empty sessionScope.shoppingCart }">		
				        		<a class="button"
				        		 onclick="return confirm('Your cart is empty')"
				        		>Check out</a>
			        		</c:if>
			        		
			        		<c:if test= "${ not empty sessionScope.shoppingCart }">			
				        		<a href="${pageContext.request.contextPath }/shoppingCart?action=checkout" class="button"
				        		>Check out</a>
			        		</c:if>
			        		
			        		<a href="${pageContext.request.contextPath }/BookListController" class="button" >Continue shopping</a>
			        
					</div>
            </aside>
        </div>

    	<jsp:include page="../Component/footer.jsp"></jsp:include>
    </div>
</body>
</html>