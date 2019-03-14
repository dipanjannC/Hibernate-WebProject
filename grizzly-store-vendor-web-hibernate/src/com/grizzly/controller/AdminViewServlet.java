package com.grizzly.controller;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.grizzly.pojo.ProductDetailsPojo;
import com.grizzly.service.ProductService;
import com.grizzly.service.ProductServiceImpl;
import com.grizzly.validation.WebsiteException;

/**
 * Servlet implementation class AdminViewServlet
 */
@WebServlet("/AdminViewServlet")
public class AdminViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Logger logger=Logger.getLogger("AdminService.class");
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ProductDetailsPojo> adminView;

		try {
			ProductService productService=new ProductServiceImpl();
			adminView = productService.fetchProducts();

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("AdminDisplay.jsp");
			request.setAttribute("productsViewAdmin", adminView);
			requestDispatcher.forward(request, response);

		} catch (WebsiteException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ErrorPage.jsp");
			request.setAttribute("error", e.getMessage());
			
			requestDispatcher.forward(request, response);

		}
	}

}
