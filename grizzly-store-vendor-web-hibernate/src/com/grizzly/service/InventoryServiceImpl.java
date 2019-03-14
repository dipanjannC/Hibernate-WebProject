package com.grizzly.service;

import java.util.ArrayList;

import com.grizzly.dao.ProductManagementDao;
import com.grizzly.dao.ProductManagementHibernateImpl;
import com.grizzly.pojo.InventoryDetailsPojo;
import com.grizzly.pojo.InventoryPojo;
import com.grizzly.validation.WebsiteException;

public class InventoryServiceImpl implements InventoryService{

	ProductManagementDao inventory=new ProductManagementHibernateImpl();
	
	@Override
	public int addBufferStock(InventoryPojo pojo) throws WebsiteException {
		// TODO Auto-generated method stub
		int add=inventory.addBufferStock(pojo);
		return add;
	}

	@Override
	public ArrayList<InventoryDetailsPojo> fetchInventory() throws WebsiteException {
		// TODO Auto-generated method stub
		
		ArrayList<InventoryDetailsPojo> vendorProductList=inventory.fetchInventory();
		return vendorProductList;
	}

	@Override
	public InventoryPojo fecthInventoryItems(InventoryPojo inventoryPojo) throws WebsiteException {
		// TODO Auto-generated method stub
		InventoryPojo updateViewPojo=inventory.fecthInventoryItems(inventoryPojo);
		return updateViewPojo;
	}

}
