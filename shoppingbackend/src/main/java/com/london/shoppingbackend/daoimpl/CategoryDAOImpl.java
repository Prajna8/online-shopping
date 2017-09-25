package com.london.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.london.shoppingbackend.dao.CategoryDAO;
import com.london.shoppingbackend.dto.Category;


@Repository ("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static List<Category> categories = new ArrayList<>();
	
	static {

		Category category = new Category();

		// adding first category
		category.setId(1);
		category.setName("Televisions");
		category.setDescription("This the description for the television");
		category.setImageURL("CAT_1.png");

		categories.add(category);

		// adding Second category
		category = new Category();
		category.setId(2);
		category.setName("Mobiles");
		category.setDescription("This the description for the Mobiles");
		category.setImageURL("CAT_2.png");

		categories.add(category);

		// adding first category
		category = new Category();
		category.setId(3);
		category.setName("Laptops");
		category.setDescription("This the description for the Laptops");
		category.setImageURL("CAT_3.png");

		categories.add(category);

	}
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}


	@Override
	public Category get(int id) {
	
		for(Category category:categories){
			
			if(category.getId()==id) return category;
		}

		return null;
	}


	@Override
	@Transactional
	public boolean add(Category category) {
		
		try{
			
			//add the category to the datebase table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception ex) {
			
			ex.printStackTrace();
			return false;
		}
		
		
	}

}
