package com.revature.repository;

import java.util.List;
import java.util.Set;

import com.revature.model.Product;

public interface ProductRepository {

	public Set<Product> findAllProducts();
	
}
