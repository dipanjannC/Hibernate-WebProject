package com.grizzly.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StoreServlet
 */
@WebServlet("/StoreServlet")
public class StoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if (request.getParameter("update") != null) {
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("UpdateStockServlet");
			requestDispatcher.forward(request, response);

		}
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getParameter("login")!=null)
		{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("LoginLogout");
			requestDispatcher.forward(request, response);
		}
		
		else if (request.getParameter("add") != null) {
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("AddProductServlet");
			requestDispatcher.forward(request, response);
	

		} else if (request.getParameter("delete") != null) {

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("DeleteServlet");
			requestDispatcher.forward(request, response);

		}
		
	}

}
