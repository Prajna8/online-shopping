package com.london.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name ="user_detail" )

//if ur are storing anything inside a flow scope provided by springweb flow
//			that particular model needs to be serialized otherwise a serialization exception is thrown
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
	@NotBlank(message ="Please enter first name")
	private String firstName;
	
	@Column(name ="last_name")
	@NotBlank(message ="Please enter last name")
	private String lastName;
	
	@NotBlank(message ="Please enter email address")
	private String email;
	
	@Column(name ="contact_number")
	@NotBlank(message ="Please enter contact number")
	private String contactNumber;
	
	private String role;
	
	@NotBlank(message ="Please enter some password")
	private String password;
	
	private boolean enabled = true;
	
	
	//confirm password transient field
	@Transient 
	private String confirmPassword;
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/*******Again OneTo One annotation********/
	
	// USer is going to be the parent and cart its child
	// cascade tells what needs to be done with the child record attached to the parent record
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL ,fetch =FetchType.EAGER)
	
	// cascade all does is only by saving the user data, cart will also get stored
	//also if user is deleted the cart is also deleted
	
	private Cart cart;
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	/*******------------****/
	
	/*
	 * setter and getter for the fields
	 * */

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", contactNumber=" + contactNumber + ", role=" + role + ", password=" + password + ", enabled="
				+ enabled + ", cart=" + cart + "]";
	}

	 
	
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
//				+ ", contactNumber=" + contactNumber + ", role=" + role + ", password=" + password + ", enabled="
//				+ enabled + "]";
//	}

	
	
}


