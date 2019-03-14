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
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Logger logger=Logger.getLogger("AddProductService.class");
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Extracting the Parameters from the Display Page
		String productName = request.getParameter("newProductName");
		String productBrand = request.getParameter("newProductBrand");
		String productCategory = request.getParameter("newProductCategory");
		double productRating = Double.parseDouble(request.getParameter("newProductRating"));
		String productDescription = request.getParameter("newProductDescription");
		int productBuffer = Integer.parseInt(request.getParameter("newProductBuffer"));
		double productPrice = Double.parseDouble(request.getParameter("newProductPrice"));

		/*
		 * boolean resultRating=false;
		 * 
		 * //INPUT VALIDATION String error="Please enter valid rating";
		 * if(resultRating==false) { RequestDispatcher requestDispatcher =
		 * request.getRequestDispatcher("AdminDisplay.jsp");
		 * request.setAttribute("error", error); requestDispatcher.forward(request,
		 * response); }
		 */

		// Setting it to the Product Details Pojo
		ProductDetailsPojo pojo = new ProductDetailsPojo();
		pojo.setProductName(productName);
		pojo.setProductBrand(productBrand);
		pojo.setProductCategory(productCategory);
		pojo.setProductRating(productRating);
		pojo.setProductDescription(productDescription);
		pojo.setProductBuffer(productBuffer);
		pojo.setProductPrice(productPrice);

		try {
			ProductService productService=new ProductServiceImpl();
			productService.addProduct(pojo);
			ArrayList<ProductDetailsPojo> adminView = productService.fetchProducts();

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
