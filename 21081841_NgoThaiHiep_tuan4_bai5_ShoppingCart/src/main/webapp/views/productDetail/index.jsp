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
            grid-template-columns: repeat(auto-fill, minmax(500px, 1fr));
            gap: 20px;
        }

        .book-item {
          
            background-color: #fff;
        }
        .book-title{
			margin-bottom: 20px;
		}

        .book-item img {
            max-width: 250px;
            max-height: 500px;
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

        .product-details, .add-to-cart {
            display: block;
            color: black;
            margin-top: 2	0px;
            margin-top: 20px;
        }

        footer {
            width: 100%;
            color: white;
            background-color: black;
            text-align: center;
            border-top: 1px solid brown;
            padding: 10px;
        }

        @media (max-width: 768px) {
            header h1 {
                font-size: 24px;
            }

            header nav ul li a {
                font-size: 16px;
            }
             header nav ul li a:hover {
				color: #294e79;
			}

             

            .content-wrapper {
                flex-direction: column;
            }

            section, aside {
                width: 100%;
            }

            .catalog {
              
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
                   <div class="book-item">
	                  <c:set var="item" value="${requestScope.productDetail}" />
							<div class="book-title">Product details : ${item.book.title}
							    <c:if test="${item.book.author != null && item.book.author != ''}">
							        <span class="book-author"> - Tác giả: ${item.book.author}</span>
							    </c:if>
							    <c:if test="${item.book.translator != null && item.book.translator != ''}">
							        <span class="book-translator">- Dịch giả: ${item.book.translator}</span>
							    </c:if>
							</div>
							<img src="${pageContext.request.contextPath}/resources/images/${item.book.image}" alt="${item.book.title}">
							<div class="book-price">Price(VNĐ): ${item.book.price}</div>
							<div class="book-quantity" >Quantity: ${item.book.quantity}</div>
						
					</div>
						
                </div>
               <div class="product-details">
							<a href="${pageContext.request.contextPath}/BookListController">Back to Product List</a>
						</div>
            </aside>
        </div>
    	<jsp:include page="../Component/footer.jsp"></jsp:include>
    </div>
</body>
</html>