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
 * Servlet implementation class UpdateStockServlet
 */
@WebServlet("/UpdateStockServlet")
public class UpdateStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Logger logger=Logger.getLogger("UpdateService.class");  
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InventoryPojo inventoryUpdatePojo = new InventoryPojo();
		
		InventoryService inventoryService=new InventoryServiceImpl();
		
		inventoryUpdatePojo.setProductId(Integer.parseInt(request.getParameter("addInventoryProductId")));
		inventoryUpdatePojo.setInventoryStock(Integer.parseInt(request.getParameter("addInventoryStock")));
		inventoryUpdatePojo.setInventoryBuffer( Integer.parseInt(request.getParameter("addInventoryBuffer")));

		try {
			
			inventoryService.addBufferStock(inventoryUpdatePojo);

		} catch (WebsiteException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ErrorPage.jsp");
			request.setAttribute("error", e.getMessage());
			requestDispatcher.forward(request, response);
		}

		try {
			ArrayList<InventoryDetailsPojo> vendorView = inventoryService.fetchInventory();

			// Redirecting through Request Dispatcher
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
