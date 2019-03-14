package com.grizzly.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="inventory")
public class InventoryEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="product_id")
	private ProductDetailsEntity product;
	
	
	@Column(name="inventory_buffer")
	private int inventoryBuffer;
	
	@Column(name="inventory_stock",columnDefinition = "int default 0")
	private int inventoryStock;
	
	
	
	public InventoryEntity() {
		
	}
	
	

	public ProductDetailsEntity getProduct() {
		return product;
	}

	public void setProduct(ProductDetailsEntity product) {
		this.product = product;
	}
	
	
	
	public int getInventoryBuffer() {
		return inventoryBuffer;
	}
	public void setInventoryBuffer(int inventoryBuffer) {
		this.inventoryBuffer = inventoryBuffer;
	}
	

	
	public int getInventoryStock() {
		return inventoryStock;
	}
	public void setInventoryStock(int inventoryStock) {
		this.inventoryStock = inventoryStock;
	}
}
