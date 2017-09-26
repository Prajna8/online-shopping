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
	
	/*@Test
	public void testAddCategory(){
		
		category = new Category();
		
		category.setName("Mobile");
		category.setDescription("This the description for the Mobile");
		category.setImageURL("CAT_3.png");
		
		assertEquals("Successfully added a category inside the table", true, categoryDAO.add(category));
		
		
	}*/
		
/*	@Test
	public void testGetCategory(){
		
		category = categoryDAO.get(3);
		assertEquals("Successfully fetched a single category inside the table", "Televisions", category.getName());
	
	}*/
	
/*	@Test
	public void testUpdateCategory(){
		
		category = categoryDAO.get(3);
		category.setName("Tv");
		assertEquals("Successfully update a single category inside the table", true, categoryDAO.update(category));

	}*/
	
	/*	@Test
	public void testDeleteCategory(){
		
		category = categoryDAO.get(3);
		assertEquals("Successfully deleted a single category inside the table", true, categoryDAO.delete(category));

	}*/
	
	/*	@Test
	public void testListCategory(){
		
		category = categoryDAO.get(3);
		assertEquals("Successfully fetch a list of category inside the table", 2, categoryDAO.list().size());

	}*/
	
	@Test
	public void testCRUDCategory(){
		//Adding the Category
		category = new Category();
		
		category.setName("Mobile");
		category.setDescription("This the description for the Mobile");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside the table", true, categoryDAO.add(category));
		
		category = new Category();
		
		category.setName("Television");
		category.setDescription("This the description for the Television");
		category.setImageURL("CAT_2.png");
		
		assertEquals("Successfully added a category inside the table", true, categoryDAO.add(category));
		
		//updating the category
		category = categoryDAO.get(2);
		category.setName("Tv");
		assertEquals("Successfully update a single category inside the table", true, categoryDAO.update(category));

		//delete the category
		assertEquals("Successfully deleted a single category inside the table", true, categoryDAO.delete(category));
		
		//fetching the list 
		assertEquals("Successfully fetch a list of category inside the table", 1, categoryDAO.list().size());
	
	}
	
	
	
	
	
}
