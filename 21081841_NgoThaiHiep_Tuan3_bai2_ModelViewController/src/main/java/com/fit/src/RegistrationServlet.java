package com.fit.src;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fit.etity.Registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private String dbURL = "jdbc:sqlserver://localhost:1455;databaseName=Registration;trustServerCertificate=true";
     private String dbUser= "sa";
     private String dbPass = "sapassword";
     /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
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
		 // Get parameters from the form
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Combine day, month, and year to form a date string
        String birthDayStr = request.getParameter("day") + "-" + request.getParameter("month") + "-" + request.getParameter("year");
        String gender = request.getParameter("gender");

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        // Date format for input and SQL
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");

        // Parse the birth date
        java.sql.Date sqlDate = null;  // Will store the SQL compatible date
        try {
            // Convert birthDayStr to java.util.Date
            Date birthDay = inputFormat.parse(birthDayStr);

            // Convert java.util.Date to java.sql.Date
            sqlDate = new java.sql.Date(birthDay.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
            response.getWriter().println("<h2>Error: Invalid date format.</h2>");
            return;
        }

        try {
            // Load SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish connection
            connection = DriverManager.getConnection(dbURL, dbUser, dbPass);

            // SQL query for inserting data
            String sqlInsert = "INSERT INTO [Registration].[dbo].[Registration] " +
                    "([fName], [lName], [email], [password], [birthDay], [gender]) VALUES (?, ?, ?, ?, ?, ?)";

            // Prepare statement
            preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, fName);
            preparedStatement.setString(2, lName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.setDate(5, sqlDate);  // Set the java.sql.Date value
            preparedStatement.setString(6, gender);

            // Execute the query
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
            	Registration reg = new Registration(fName, lName, email, password, birthDayStr, gender);
            	request.setAttribute("regis", reg);
            	RequestDispatcher rd = request.getRequestDispatcher("RegistrationJSP.jsp");
            	rd.forward(request, response);
            } else {
                response.getWriter().println("<h2>Data insertion failed!</h2>");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().println("<h2>Error: " + e.getMessage() + "</h2>");
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}

}
