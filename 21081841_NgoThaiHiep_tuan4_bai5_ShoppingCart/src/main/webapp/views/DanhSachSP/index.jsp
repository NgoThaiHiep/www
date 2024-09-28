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

header nav ul li a:hover {
	color: #294e79;
}

.content-wrapper {
	display: flex;
	flex: 1;
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

.book-item {
	border: 1px solid #ccc;
	text-align: center;
	background-color: #fff;
}

.book-item img {
	max-width: 120px;
	max-height: 140px;
	margin-bottom: 5px;
}

.button {
	background-color: #4CAF50;
	border: 1px solid black;
	color: black;
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
                <div class="catalog">
                
                    <c:forEach var="book" items="${bookProductList}">
                        <div class="book-item">
                            <div class="book-title">${book.title} 
                                <c:if test="${book.author != null && book.author != ''}">
                                    <span class="book-author"> - Tác giả: ${book.author}</span>
                                </c:if>
                                
                                <c:if test="${book.translator != null && book.translator != ''}">
                                    <span class="book-translator">- Dịch giả: ${book.translator}</span>
                                </c:if>
                            </div>
                            <img src="${pageContext.request.contextPath}/resources/images/${book.image}" alt="${book.title}">
                            <div class="book-price">Price: ${book.price}</div>
                            <div class="book-quantity">Quantity: ${book.quantity}</div>
                             <a href="${pageContext.request.contextPath}/shoppingCart?action=showProduct&id=${book.id}" class="product-detail">Product details</a>
                           <a href="${pageContext.request.contextPath}/shoppingCart?action=addCart&id=${book.id}" class="add-to-cart" onclick="console.log('Book ID:', ${book.id})">Add to cart</a>

                        </div>
                    </c:forEach>
                </div>
            </aside>
        </div>

    	<jsp:include page="../Component/footer.jsp"></jsp:include>
    </div>
</body>
</html>