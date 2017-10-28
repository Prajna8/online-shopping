package com.london.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.london.shoppingbackend.dao.UserDAO;
import com.london.shoppingbackend.dto.Address;
import com.london.shoppingbackend.dto.Cart;
import com.london.shoppingbackend.dto.User;


@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addUser(User user){
		
		try{
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
			
		}
	}
	
	@Override
	public boolean addAddress (Address address){
		
		try{
			sessionFactory.getCurrentSession().persist(address);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
			
		}
	}

	@Override
	public boolean updateCart(Cart cart){
		try{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
			
		}
		
	}

	@Override
	public User getByEmail(String email) {
		String selectQuery = "FROM User WHERE email = :email";
		
		try{
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery,User.class)
						.setParameter("email", email)
							.getSingleResult();
		}
		catch(Exception ex){
			//ex.printStackTrace();
			return null;
		}
		
	}
	
	/*---------Fuck i hate last min changes---------*/
	//remember this change
	
//	@Override
//	public Address getBillingAddress(User user) {
//		String selectQuery = "FROM Address WHERE user =:user AND billing = :billing";
//		try{
//			// careful here
//			return sessionFactory.getCurrentSession()
//					.createQuery(selectQuery,Address.class)
//						.setParameter("user", user)
//							.setParameter("billing", true)
//								.getSingleResult();
//			
//		}
//		catch(Exception ex) {
//			ex.printStackTrace();
//			return null;
//		}
//	}
//
//	@Override
//	public List<Address> listShippingAddresses(User user) {
//		
//		String selectQuery = "FROM Address WHERE user =:user AND shipping = :shipping";
//		try{
//			// careful here
//			return sessionFactory.getCurrentSession()
//					.createQuery(selectQuery,Address.class)
//						.setParameter("user", user)
//							.setParameter("shipping", true)
//								.getResultList();
//			
//		}
//		catch(Exception ex) {
//			ex.printStackTrace();
//			return null;
//		}
//	}

	@Override
	public Address getBillingAddress(int userId) {
		String selectQuery = "FROM Address WHERE userId = :userId AND billing = :isBilling";
		try{
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectQuery,Address.class)
						.setParameter("userId", userId)
						.setParameter("isBilling", true)
						.getSingleResult();
		}
		catch(Exception ex) {
			return null;
		}
	}

	@Override
	public List<Address> listShippingAddresses(int userId) {
		String selectQuery = "FROM Address WHERE userId = :userId AND shipping = :isShipping ORDER BY id DESC";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectQuery,Address.class)
						.setParameter("userId", userId)
						.setParameter("isShipping", true)
							.getResultList();
	}
}