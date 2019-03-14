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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Logger logger=Logger.getLogger("DeleteService.class");
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Delete Servlet Functionality
		String id = request.getParameter("productId");
		int productId = Integer.parseInt(id);
		ProductService productService=new ProductServiceImpl();

		try {
				productService.delete(productId);
		} 
		catch (WebsiteException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ErrorPage.jsp");
			request.setAttribute("error", e.getMessage());
			requestDispatcher.forward(request, response);
		}

		ArrayList<ProductDetailsPojo> adminView;

		try {
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
