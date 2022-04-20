package com.revature.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.revature.Util.ConnectionFactory;

import com.revature.model.Product;

public class ProductRepositoryImpl implements ProductRepository{

	public static ProductRepositoryImpl productRepository;
	
//	public static synchronized ProductRepositoryImpl getProductRepository() {
//		if(productRepository == null) {
//			productRepository = new ProductRepositoryImpl();
//		}
//		return productRepository;
//	}
	
	
	
	@Override
	public Set<Product> findAllProducts() {
		Set<Product> products = new HashSet<>();
		
		Connection conn = null;
		Statement stmt =null;
		ResultSet set = null; 
		final String SQL = "select * from product";
		
		try {
			conn = ConnectionFactory.getConnetion();
			stmt = conn.createStatement();
			//At this point, we have executed a statement and we have the records
			set = stmt.executeQuery(SQL);
			while(set.next()){
				Product product = new Product(
						set.getInt(1),
						set.getString(2),
						set.getFloat(3)
						);
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			conn.close();
			stmt.close();
			set.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		
		
		return products;
	}

}
