package com.grizzly.dao;

import java.util.ArrayList;

import com.grizzly.pojo.InventoryDetailsPojo;
import com.grizzly.pojo.InventoryPojo;
import com.grizzly.pojo.ProductDetailsPojo;
import com.grizzly.validation.WebsiteException;

public interface ProductManagementDao {

	void delete(int id) throws WebsiteException;
	ArrayList<ProductDetailsPojo>  fetchProducts() throws WebsiteException;
	int addProduct(ProductDetailsPojo productPojo) throws WebsiteException;
	
	int addBufferStock(InventoryPojo pojo) throws WebsiteException;
	ArrayList<InventoryDetailsPojo>  fetchInventory() throws WebsiteException;
	InventoryPojo fecthInventoryItems(InventoryPojo inventoryPojo) throws WebsiteException;
}
