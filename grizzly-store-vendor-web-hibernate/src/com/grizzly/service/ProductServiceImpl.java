package com.grizzly.service;

import java.util.ArrayList;

import com.grizzly.dao.ProductManagementDao;
import com.grizzly.dao.ProductManagementHibernateImpl;
import com.grizzly.pojo.ProductDetailsPojo;
import com.grizzly.validation.WebsiteException;

public class ProductServiceImpl implements ProductService{

	ProductManagementDao product=new ProductManagementHibernateImpl();
	
	@Override
	public int addProduct(ProductDetailsPojo productPojo) throws WebsiteException {
		// TODO Auto-generated method stub
		int add=product.addProduct(productPojo);
		return add;
	}

	@Override
	public ArrayList<ProductDetailsPojo> fetchProducts() throws WebsiteException {
		// TODO Auto-generated method stub
		ArrayList<ProductDetailsPojo> allProducts=product.fetchProducts();
		return allProducts;
	}

	@Override
	public void delete(int id) throws WebsiteException {
		// TODO Auto-generated method stub
		product.delete(id);
	}

	
}
