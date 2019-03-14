package com.grizzly.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_details")
public class ProductDetailsEntity implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private int productId;
	
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_brand")
	private String productBrand;
	
	@Column(name="product_category")
	private String productCategory;
	
	@Column(name="product_rating")
	private double productRating;
	
	@Column(name="product_description")
	private String productDescription;
	
	@Column(name="product_price")
	private double productPrice;
	
	@OneToOne(mappedBy="product")
	private InventoryEntity inventory;

	public InventoryEntity getInventory() {
		return inventory;
	}

	public void setInventory(InventoryEntity inventory) {
		this.inventory = inventory;
	}

	//Public Constructor
	public ProductDetailsEntity() {
		
	}
	
	//getters and setters for ProductId 
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	//getters and setters for ProductName
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	//getters and setters for ProductBrand
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	
	//getters and setters for ProductCategory
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	
	//getters and setters for ProductRating
	public double getProductRating() {
		return productRating;
	}
	public void setProductRating(double productRating) {
		this.productRating = productRating;
	}
	

	//getters and setters for ProductDescription
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	
}
