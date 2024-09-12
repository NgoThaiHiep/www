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
		
		
		Student sv = new Student();
		sv.setfName(fName);
		sv.setlName(lName);
		
		
		request.setAttribute("student", sv);
		
		RequestDispatcher rd = request.getRequestDispatcher("studentJSP.jsp");
		rd.forward(request, response);
		
	}

}
