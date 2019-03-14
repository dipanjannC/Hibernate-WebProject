package com.grizzly.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class FetchServlet
 */
@WebServlet("/FetchServlet")
public class FetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Fetching the user role from the database, for redirecting accordingly
		HttpSession session = request.getSession();
		String role = (String) session.getAttribute("role");

		// If the user is ADMIN
		if (role.equals("admin")) {

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("AdminViewServlet");
			requestDispatcher.forward(request, response);

		}
		// If the user is VENDOR
		else if (role.equals("vendor")) {
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("VendorViewServlet");
			requestDispatcher.forward(request, response);

		}
	}
}
