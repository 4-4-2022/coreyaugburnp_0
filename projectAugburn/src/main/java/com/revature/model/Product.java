package com.revature.model;

import java.util.Objects;

public class Product {

	private int productId;
	private String items;
	private float prices;
	
	public Product() {
		
	}
	
	
	public Product(int productId, String items, float prices) {
		super();
		this.productId = productId;
		this.items = items;
		this.prices = prices;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getItems() {
		return items;
	}


	public void setItems(String items) {
		this.items = items;
	}


	public float getPrices() {
		return prices;
	}


	public void setPrices(float prices) {
		this.prices = prices;
	}


	@Override
	public int hashCode() {
		return Objects.hash(items, prices, productId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(items, other.items) && Float.floatToIntBits(prices) == Float.floatToIntBits(other.prices)
				&& productId == other.productId;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", items=" + items + ", prices=" + prices + "]";
	}
	
	
	
	
	
	
	
	
}
