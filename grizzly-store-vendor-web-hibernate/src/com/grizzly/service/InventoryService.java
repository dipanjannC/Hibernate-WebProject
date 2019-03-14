package com.grizzly.service;

import java.util.ArrayList;

import com.grizzly.pojo.InventoryDetailsPojo;
import com.grizzly.pojo.InventoryPojo;
import com.grizzly.validation.WebsiteException;

public interface InventoryService {

	
	int addBufferStock(InventoryPojo pojo) throws WebsiteException;
	ArrayList<InventoryDetailsPojo>  fetchInventory() throws WebsiteException;
	InventoryPojo fecthInventoryItems(InventoryPojo inventoryPojo) throws WebsiteException;
}
