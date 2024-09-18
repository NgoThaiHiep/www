
<%@page import="com.fit.etity.Registration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>Insert title here</title>
</head>
<style>
	body {
        font-family: Arial, sans-serif;
    }
   form {
      width: 500px;
      margin: 20px auto;
      background-color: #b0e0e6;
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
     
    }
   	.blue-border {
      border: 2px solid blue;
     
    }
  
    table {
      width: 100%;
     
    }
    td {
      padding: 5px;
    }
	/*   input[type="text"], input[type="email"], input[type="number"], textarea, select {
      width: 100%;
      padding: 8px;
      margin: 5px 0;
      box-sizing: border-box;
    } */
    input[type="checkbox"] {
      margin-right: 10px;
    }
    input[type="radio"] {
      margin-right: 5px;
    }
    .button-group {
      text-align: center;
    }
    .button-group button {
      margin: 10px;
    }
  </style>

<body>
	<%
		Registration reg = new Registration();
		reg = (Registration)request.getAttribute("regis");
		out.println(reg );
	%>
	<Form>

		<table>
			<tr>
				<td>Full Name : </td> 
				<td>  
					<% String fullName = reg.getfName() + " " + reg.getlName();
						out.println(fullName);
					%>
				</td>
			</tr>

			
			<tr>
				<td>Email : </td> 
				<td>  
					<% String email   = reg.getEmail();
						out.println(email  );
					%>
				</td>
			</tr>		
			
			<tr>
				<td>Birth Day : </td> 
				<td>  
					<% String birthDay   = reg.getBirthDay();
						out.println(birthDay  );
					%>
				</td>
			</tr>
			<tr>
				<td>Gender : </td> 
				<td>  
					<% String gender  = reg.getGender();
						out.println(gender );
					%>
				</td>
			</tr>
		</table> 
	</Form>
</body>
</html>