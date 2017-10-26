package com.london.shoppingbackend.dao;

import java.util.List;

import com.london.shoppingbackend.dto.Address;
import com.london.shoppingbackend.dto.Cart;
import com.london.shoppingbackend.dto.User;

public interface UserDAO {
	
	//add the user
	boolean addUser(User user);
	User getByEmail(String email);
	
	//add an address
	boolean addAddress(Address address);
	//  alternative to avoid running into
	//sending user or userId
	
		Address getBillingAddress(int userId);
	List<Address> listShippingAddresses(int userId);
	
/*	
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);
*/
	
	//update a cart
	boolean updateCart(Cart cart);

}
