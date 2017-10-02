package com.london.shoppingbackend.dao;

import java.util.List;
import com.london.shoppingbackend.dto.Product;

public interface ProductDAO {
	
	Product get( int productId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	
	//the meat of the code
	//fetching list of active product
	//if we want to get 10 latest product
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);

}
