<%@page import="Shopping.entity.Student"%>
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
		Student sv = new Student();
		sv = (Student)request.getAttribute("student");
		out.println(sv );
	%>
	<Form>

		<table>
			<tr>
				<td>Full Name : </td> 
				<td>  
					<% String fullName = sv.getfName() + " " + sv.getlName();
						out.println(fullName);
					%>
				</td>
			</tr>

			<tr>
				<td>Birth Day : </td> 
				<td>  
					<% String birthDay   = sv.getBirthDay();
						out.println(birthDay  );
					%>
				</td>
			</tr>
			<tr>
				<td>Email : </td> 
				<td>  
					<% String email   = sv.getEmail();
						out.println(email  );
					%>
				</td>
			</tr>
			<tr>
				<td>Mobile Number :  </td> 
				<td>  
					<% String mobileNumber  = sv.getMobileNum();
						out.println(mobileNumber);
					%>
				</td>
			</tr>			
			<tr>
				<td>Gender : </td> 
				<td>  
					<% String gender  = sv.getGender();
						out.println(gender );
					%>
				</td>
			</tr>
			<tr>
				<td>Address : </td> 
				<td>  
					<% String address = sv.getAddress();
						out.println(address  );
					%>
				</td>
			</tr>
			<tr>
				<td>City : </td> 
				<td>  
					<% String city = sv.getCity();
						out.println(city );
					%>
				</td>
			</tr>
			<tr>
				<td>Pin Code: </td> 
				<td>  
					<% String pinCode= sv.getPinCode();
						out.println(pinCode );
					%>
				</td>
			</tr>
			<tr>
				<td>State : </td> 
				<td>  
					<% String state= sv.getState();
						out.println(state );
					%>
				</td>
			</tr>
			<tr>
				<td>Country : </td> 
				<td>  
					<% String country = sv.getCountry();
						out.println(country );
					%>
				</td>
			</tr>
			
			<tr>
				<td> Hobbies  : </td> 
				<td>  
					<% 
					int count = 0;
					for (String  hobbies : sv.getHobbies()){
						if	( sv.getHobbies().length - count == 1 ){
								String hob =  hobbies;
									out.println(hob);
						}else{
							String hob =  hobbies;
								out.println(hob +", ");
								
						}
						count ++;
					}
				
					%>
				</td>
			</tr>
			<tr>
				<td>Course : </td> 
				<td>  
					<% String course = sv.getCourse();
						out.println(course );
					%>
				</td>
			</tr>
		</table> 
	</Form>
</body>
</html>