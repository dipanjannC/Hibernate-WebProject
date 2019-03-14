package com.grizzly.service;

import java.util.ArrayList;

import com.grizzly.pojo.ProductDetailsPojo;
import com.grizzly.validation.WebsiteException;

public interface ProductService {

	int addProduct(ProductDetailsPojo productPojo) throws WebsiteException;
	ArrayList<ProductDetailsPojo>  fetchProducts() throws WebsiteException;
	void delete(int id) throws WebsiteException;
}
