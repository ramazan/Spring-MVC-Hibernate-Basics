package com.ramazan.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = "springstudent";
		String password = "springstudent";

		String jdbcurl = "jdbc:mysql://127.0.0.1:3306/web_customer_tracker?useSSL=false";

		String driver = "com.mysql.jdbc.Driver";

		PrintWriter out = response.getWriter();
		try {
			out.print("Connecting to database " + jdbcurl);
			Class.forName(driver);

			Connection con = DriverManager.getConnection(jdbcurl, username, password);

			out.println("\nConnection Succesfully");

		} catch (Exception ex) {
			out.println("\nConnection :(((");
			ex.printStackTrace();
		}
	}

}
