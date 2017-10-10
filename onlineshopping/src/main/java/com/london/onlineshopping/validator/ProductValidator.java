package com.london.onlineshopping.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.london.shoppingbackend.dto.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Product product = (Product) target;
		
		//whether file has been selected or not
		if(product.getFile()== null ||
				product.getFile().getOriginalFilename().equals("")){
			
			errors.rejectValue("file", null,"Please select an image file to upload");
			return;
			}
			if(! (	product.getFile().getContentType().equals("images/jpeg")||
					product.getFile().getContentType().equals("images/png")||
					product.getFile().getContentType().equals("images/gif")
			   ))
			{
				errors.rejectValue("file",null,"Please use only image file for upload");
				return;
			}
			
			
				
				
			
	}

}
