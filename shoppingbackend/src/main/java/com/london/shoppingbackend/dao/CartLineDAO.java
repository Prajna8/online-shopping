package com.london.shoppingbackend.dao;

import java.util.List;

import com.london.shoppingbackend.dto.Cart;
import com.london.shoppingbackend.dto.CartLine;

public interface CartLineDAO {
	
	public CartLine get(int id);
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public List<CartLine> list(int carId);
	
	
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId, int productId);

	boolean updateCart(Cart cart);
}
