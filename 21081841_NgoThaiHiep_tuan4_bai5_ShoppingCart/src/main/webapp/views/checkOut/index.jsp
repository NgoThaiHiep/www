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
	table {
        border: 2px solid black; /* Viền bên ngoài của bảng */
        border-collapse: collapse;
    }
    td, th {
        border: none; /* Không có viền giữa các ô */
        padding: 10px;
    }
    
     table {
        border-collapse: collapse;
    }
    td, th {
        border: 1px solid black;
    }
    table, tr, th, td {
        border-spacing: 0;
    }
header nav ul li a:hover {
	color: #294e79;
}
 .table-form td:first-child {
        width: 30%;
    }

    .table-form td:last-child {
        width: 70%;
    }

    .table-form input[type="text"] {
        width: 30%;
        background-color: #eaeaea;
        border: 1px solid black;
        border-radius: 5px;
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
	padding : 2px;
	background-color: white;
	border: 1px solid black;
	color: black;
	text-decoration: none;
}

aside .button:hover {
		background-color : white;
		border: 1px solid black;
		color: red;
		font-weight: bold;
		text-decoration: underline;
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
             	<div class="book">
	             	<div  style="margin-left: 30%"> 
	             	 	<h5>Checkout - Already registered?</h5>
	             	</div>
             	
		            <table class="table-form"  style="width: 90%;">
			            <tr>
				           <td>
				           		<lable for="fullName">Full Name:</lable>
				           </td>
								<td><input type="text" name="fullName" id="fullName">
							</td>
						</tr>   
						<tr>
				           <td>
				           		<lable for="address">Shopping address:</lable>
				           </td>
								<td><input type="text" name="address" id="address" style="width: 50%">
							</td>
						</tr>      
						<tr>
				           <td>
				           		<lable for="total">Total price:</lable>
				           </td>
				           		<c:set var="total" value="${total}"/>
								<td><input type="text" name="total" id="total" disabled value="${total }" style="font-weight: bold">
							</td>
						</tr>     
						<tr>
				           <td>
				           		<lable for="paymentMethod">Shopping address:</lable>
				           </td>
								<td>
									<input type="radio" name="paymentMethod" id="paymentMethod" value="Paypal"> <span> Paypal</span>
									<input type="radio" name="paymentMethod" id="paymentMethod" value="ATM Debit"></span> ATM Debit</span>
									<input type="radio" name="paymentMethod" id="paymentMethod" value="Visa/Master card"></span> Visa/Master card</span>
							</td>
						</tr>     	
						<tr>
							<td colspan="2" style="text-align: center;">
								<a herf = "${pageContext.request.contextPath}/checkout" class="button">Save</a> 
								<a herf = "${pageContext.request.contextPath}/checkout" class="button">Cancel</a>
						</tr>
			         </table>
			        </div>
			       
            </aside>
        </div>

    	<jsp:include page="../Component/footer.jsp"></jsp:include>
    </div>
</body>
</html>