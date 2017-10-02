package com.london.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.london.shoppingbackend.dao.ProductDAO;
import com.london.shoppingbackend.dto.Product;

public class ProductTestCase {

private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.london.shoppingbackend");
		context.refresh();
		
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	/*
	@Test
	public void testCRUDProduct(){
		//Adding the Category
		product = new Product();
		
		product.setName("Mobile");
		product.setBrand("Oppo");
		product.setDescription("This the description for the Mobile");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		assertEquals("Something went wrong while inserting new things",
										true, productDAO.add(product));
	
	// reading and updating the category
		product = productDAO.get(2);
		product.setName("Samsung Galaxy S7");
		assertEquals("Something went wrong while updating the existing record",
				true,productDAO.update(product));
		
		assertEquals("Something went wrong while deleting the existing record",
				true,productDAO.delete(product));
		
	// list
		assertEquals("Something went wrong while deleting the existing record",
				6,productDAO.list().size());
		
	}	
	
	 	*/
	
	@Test
	public void testListActiveProducts(){
			assertEquals("Something went wrong while fetching the list of products",
					5,productDAO.listActiveProducts().size());
		}
	
	@Test
	public void testListActiveProductsByCategory(){
		assertEquals("Something went wrong while fetching the list of products",
				3,productDAO.listActiveProductsByCategory(3).size());
		assertEquals("Something went wrong while fetching the list of products",
				2,productDAO.listActiveProductsByCategory(1).size());
	}
	@Test
	public void testGetLatestActiveProduct(){
		assertEquals("Something went wrong while fetching the list of products",
				3,productDAO.getLatestActiveProducts(3).size());
		
	}
	
}
