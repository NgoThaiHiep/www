package com.fit.src;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.fit.entity.Student;

/**
 * Servlet implementation class StudentWeb
 */
public class StudentWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public StudentWeb() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		String fName = request.getParameter("txtFName");
		String lName = request.getParameter("txtLName");
		String birthofday = request.getParameter("day") +"-"+ request.getParameter("month") +"-"+request.getParameter("year") ;
		String email = request.getParameter("txtEmail");
		String mobileNum = request.getParameter("txtMobileNumber");
		String gender = request.getParameter("Gender"); 
		String address = request.getParameter("taAddress");
		String city = request.getParameter("txtCity"); 
		String pinCode = request.getParameter("txtPinCode"); 
		String state = request.getParameter("txtState"); 
		  String country = request.getParameter("txtCountry"); 
		  String[] hobbies = request.getParameterValues("ckHobbies");
		  String course = request.getParameter("txtCourse"); 
		Student sv = new Student();
//		sv.setfName(fName);
//		sv.setlName(lName);
//		sv.setBirthDay(birthofday);
//		sv.setEmail(email);
//		sv.setMobileNum(mobileNum);
//		sv.setGender(gender);
//		sv.setAddress(address);
//		sv.setCity(city);
		sv = new Student(fName, lName, birthofday, email, mobileNum, gender, address, city, pinCode, state, country, hobbies, course);
		
		
		
		request.setAttribute("student", sv);
		
		RequestDispatcher rd = request.getRequestDispatcher("studentJSP.jsp");
		rd.forward(request, response);
		
	}

}
