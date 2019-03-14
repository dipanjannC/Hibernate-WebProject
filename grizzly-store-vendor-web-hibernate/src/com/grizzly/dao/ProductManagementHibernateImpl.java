package com.grizzly.dao;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.grizzly.entity.InventoryEntity;
import com.grizzly.entity.ProductDetailsEntity;

import com.grizzly.pojo.InventoryDetailsPojo;
import com.grizzly.pojo.InventoryPojo;
import com.grizzly.pojo.ProductDetailsPojo;
import com.grizzly.validation.WebsiteException;



public class ProductManagementHibernateImpl implements ProductManagementDao{
	
	public  void delete(int id) throws WebsiteException
    {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
		try {
           Transaction transaction = session.beginTransaction();
           ProductDetailsEntity product = (ProductDetailsEntity)session.createQuery("from ProductDetailsEntity where productId="+id).list().get(0);
           session.delete(product);
           transaction.commit();
    
		}catch(HibernateException he){
    	
			throw new WebsiteException("Couldn't Delete the product!!");
    	
		}
		finally {
				
			session.close();
		}
    }
	
	
	public ArrayList<ProductDetailsPojo>  fetchProducts() throws WebsiteException
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		ArrayList<ProductDetailsPojo> allProducts = new ArrayList<ProductDetailsPojo>();

		try {
			
			@SuppressWarnings("unchecked")
			List<ProductDetailsEntity> productList = (List<ProductDetailsEntity>) session.createQuery("from ProductDetailsEntity").list();
			Iterator<ProductDetailsEntity> itr = productList.iterator();

			while (itr.hasNext()) {
				ProductDetailsPojo productPojo = new ProductDetailsPojo();
				ProductDetailsEntity product = itr.next();

				productPojo.setProductId(product.getProductId());
				productPojo.setProductName(product.getProductName());
				productPojo.setProductCategory(product.getProductCategory());
				productPojo.setProductBrand(product.getProductBrand());
				productPojo.setProductRating(product.getProductRating());
				productPojo.setProductPrice(product.getProductPrice());
				productPojo.setProductDescription(product.getProductDescription());

				allProducts.add(productPojo);
			}

		} catch (HibernateException he) {
			throw new WebsiteException("Couldn't fetch Product Details!!");
		
		} finally {
			session.close();
		}

		return allProducts;

	}
	
	
	public ArrayList<InventoryDetailsPojo>  fetchInventory() throws WebsiteException
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		ArrayList<InventoryDetailsPojo> allInventory = new ArrayList<InventoryDetailsPojo>();

		try {
			
			
			
			@SuppressWarnings("unchecked")
			List<ProductDetailsEntity> productList = (List<ProductDetailsEntity>) session.createQuery("from ProductDetailsEntity").list();
			
			Iterator<ProductDetailsEntity> itr = productList.iterator();

			while (itr.hasNext()) {
				InventoryDetailsPojo inventoryPojo = new InventoryDetailsPojo();
				ProductDetailsEntity product = itr.next();

				inventoryPojo.setProductId(product.getProductId());
				inventoryPojo.setProductName(product.getProductName());
				inventoryPojo.setProductCategory(product.getProductCategory());
				inventoryPojo.setProductBrand(product.getProductBrand());
				inventoryPojo.setProductPrice(product.getProductPrice());
				inventoryPojo.setProductRating(product.getProductRating());
				
				InventoryEntity inventoryEntity=product.getInventory();
			
				inventoryPojo.setInventoryBuffer(inventoryEntity.getInventoryBuffer());
				inventoryPojo.setInventoryStock(inventoryEntity.getInventoryStock());

				allInventory.add(inventoryPojo);
			}

		} catch (HibernateException he) {
			throw new WebsiteException("Couldn't fetch Product Details!!");
		
		} finally {
			session.close();
		}

		return allInventory;

	}
	
	
	public InventoryPojo fecthInventoryItems(InventoryPojo inventoryPojo) throws WebsiteException
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {

			InventoryEntity inventoryList = session.get(InventoryEntity.class, inventoryPojo.getProductId());

			if (inventoryList != null) {

				inventoryPojo.setInventoryBuffer(inventoryList.getInventoryBuffer());
				inventoryPojo.setInventoryStock(inventoryList.getInventoryStock());
				
			}

		} catch (HibernateException he) {
			throw new WebsiteException("Couldn't fetch Product Details!!");

		} finally {
			session.close();
		}

		return inventoryPojo;

	}
	
	
	public  int addProduct(ProductDetailsPojo productPojo) throws WebsiteException
	{
		int add = 0;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		try {
			Transaction transaction = session.beginTransaction();

			ProductDetailsEntity productItem = new ProductDetailsEntity();

			productItem.setProductName(productPojo.getProductName());
			productItem.setProductBrand(productPojo.getProductBrand());
			productItem.setProductCategory(productPojo.getProductCategory());
			productItem.setProductRating(productPojo.getProductRating());
			productItem.setProductDescription(productPojo.getProductDescription());
			productItem.setProductPrice(productPojo.getProductPrice());

			session.save(productItem);
			transaction.commit();

			Transaction transactionInventory = session.beginTransaction();

			InventoryEntity inventoryItem = new InventoryEntity();

			inventoryItem.setProduct(productItem);
			inventoryItem.setInventoryBuffer(productPojo.getProductBuffer());
			
			session.save(inventoryItem);
			transactionInventory.commit();

		} catch (HibernateException he) {

			throw new WebsiteException("couldn't Add a product!!!");

		} finally {
			session.close();
		}

		return add;

	}
	
	
	public  int addBufferStock(InventoryPojo pojo) throws WebsiteException {
		int inventoryTableInsert=0;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		try {
			Transaction transactionManageStock = session.beginTransaction();
			
			InventoryEntity inventoryStockUpdate=session.get(InventoryEntity.class, pojo.getProductId());
			inventoryStockUpdate.setInventoryStock(pojo.getInventoryStock());
			
			session.update(inventoryStockUpdate);
			transactionManageStock.commit();

		} catch (HibernateException he) {
			// TODO Auto-generated catch block
			throw new WebsiteException("Falied to addBufferStock.");
		
		}finally {
			
			session.close();
		}

		return inventoryTableInsert;
	}
	
	
	
}
