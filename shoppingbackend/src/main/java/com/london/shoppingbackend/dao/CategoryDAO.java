package com.london.shoppingbackend.dao;

import java.util.List;

import com.london.shoppingbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	Category get(int id);
}
