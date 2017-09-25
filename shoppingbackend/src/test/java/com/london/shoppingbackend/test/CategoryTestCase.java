package com.london.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.london.shoppingbackend.dao.CategoryDAO;
import com.london.shoppingbackend.dto.Category;

public class CategoryTestCase {

	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.london.shoppingbackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
	@Test
	public void testAddCategory(){
		
		category = new Category();
		
		category.setName("Televisions");
		category.setDescription("This the description for the television");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside the table", true, categoryDAO.add(category));
		
		
	}
		
	
	
	
	
}
