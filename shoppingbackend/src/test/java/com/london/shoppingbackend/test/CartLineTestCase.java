package com.london.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.london.shoppingbackend.dao.CartLineDAO;
import com.london.shoppingbackend.dao.ProductDAO;
import com.london.shoppingbackend.dao.UserDAO;
import com.london.shoppingbackend.dto.Cart;
import com.london.shoppingbackend.dto.CartLine;
import com.london.shoppingbackend.dto.Product;
import com.london.shoppingbackend.dto.User;

public class CartLineTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static CartLineDAO cartLineDAO = null;
	private static ProductDAO productDAO = null;
	private static UserDAO userDAO = null;
	
	private Product product = null;
	private User user= null;
	private Cart cart = null;
	private CartLine cartLine = null;
	
	@BeforeClass
	public static void init(){
		context= new AnnotationConfigApplicationContext();
		context.scan("com.london.shoppingbackend");
		context.refresh();
		productDAO= (ProductDAO)context.getBean("productDAO");
		userDAO = (UserDAO)context.getBean("userDAO");
		cartLineDAO = (CartLineDAO)context.getBean("cartLineDAO");
		
		
	}
	
	@Test
	public void testAddNewCartLine(){
		
		user = userDAO.getByEmail("dd@gmail.com");
		
		cart= user.getCart();
		
		product = productDAO.get(1);
		
		cartLine = new CartLine();
		
		cartLine.setBuyingPrice(product.getUnitPrice());
		
		cartLine.setProductCount(cartLine.getProductCount()+1);
		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
		
		cartLine.setAvailable(true);
		cartLine.setCartId(cart.getId());
		
		cartLine.setProduct(product);
		
		assertEquals("Failed to add the cartLine", true, cartLineDAO.add(cartLine));
		
		cart.setGrandTotal(cart.getGrandTotal()+ cartLine.getTotal());
		cart.setCartLines(cart.getCartLines()+1);
		
		assertEquals("Failed to update the cartLine", true, cartLineDAO.updateCart(cart));
		
	
	}
	
}
