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

import com.grizzly.pojo.InventoryDetailsPojo;
import com.grizzly.pojo.InventoryPojo;
import com.grizzly.service.InventoryService;
import com.grizzly.service.InventoryServiceImpl;
import com.grizzly.validation.WebsiteException;

/**
 * Servlet implementation class VendorViewServlet
 */
@WebServlet("/VendorViewServlet")
public class VendorViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Logger logger=Logger.getLogger("VendorService.class");  
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		InventoryService inventoryService=new InventoryServiceImpl();
		
		// This is redirected to Vendor Update/Manage Option view
		if (request.getParameter("manage") != null) {
			InventoryPojo inventoryDisplayPojo = new InventoryPojo();
			inventoryDisplayPojo.setProductId(Integer.parseInt(request.getParameter("inventoryProductId")));

		try {
				InventoryPojo stockUpdateViewPojo = inventoryService.fecthInventoryItems(inventoryDisplayPojo);
		
				// Redirecting through Request Dispatcher to ManageStock page

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("ManageStock.jsp");
				request.setAttribute("productID", stockUpdateViewPojo.getProductId());
				request.setAttribute("inventoryStock", stockUpdateViewPojo.getInventoryStock());
				request.setAttribute("inventoryBuffer", stockUpdateViewPojo.getInventoryBuffer());
				
				requestDispatcher.forward(request, response);
			} catch (WebsiteException e) {

				// TODO Auto-generated catch block

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("ErrorPage.jsp");
				request.setAttribute("error", e.getMessage());
				requestDispatcher.forward(request, response);
			}
		}

		else {
			// This is redirected to Vendor Home Page

			try {
				// Fetching the ArrayList from DAO layer
				ArrayList<InventoryDetailsPojo> vendorView = inventoryService.fetchInventory();

				// Redirecting through Request Dispatcher to Vendor Display

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("VendorDisplay.jsp");
				request.setAttribute("inventoryView", vendorView);
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

}
