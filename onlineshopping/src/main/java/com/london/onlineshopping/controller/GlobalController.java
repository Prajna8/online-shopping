package com.london.onlineshopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.london.onlineshopping.model.UserModel;
import com.london.shoppingbackend.dao.UserDAO;
import com.london.shoppingbackend.dto.User;

@ControllerAdvice
public class GlobalController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDAO userDAO;
	
	private UserModel userModel = null;
	
	
	
	@ModelAttribute("userModel")
	public UserModel getUserModel() {
		
		if(session.getAttribute("userModel")==null){
			//add the user model
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
		User user = userDAO.getByEmail(authentication.getName());
		
		if(user!=null){
			
			// create a new model
			userModel = new UserModel();
			
			// set the name and the id
			userModel.setId(user.getId());
			userModel.setEmail(user.getEmail());
			userModel.setFullName(user.getFirstName() + " " + user.getLastName());
			userModel.setRole(user.getRole());
			
			if(userModel.getRole().equals("USER")){
				//set the cart if user is buyer
				userModel.setCart(user.getCart());
				
			}
			//set the userModal in the session
			session.setAttribute("userModel", userModel);
			return userModel;
			
		}
		
		}
		
		
		return (UserModel) session.getAttribute("userModel");
	}

}
