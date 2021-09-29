package com.sprint.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "foodcart")
public class FoodCart {

	// fields

	@Id
	@NotNull
	// cart id length should be 6
	@Size(min = 6, max = 6, message = "cart Id should contain 6 characters")
	private String cartId;

	/*
	 * many to many mapping with Item one cart can contain many items and one item
	 * can be stored in many carts
	 */
	//@JsonIgnore
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "Cart_Items", joinColumns = { @JoinColumn(name = "cart_id") }, inverseJoinColumns = {
			@JoinColumn(name = "item_id") })
	private List<Item> cartItems = new ArrayList<>();

	// @JsonIgnore
	// @OneToOne(cascade= {CascadeType.PERSIST, CascadeType.REFRESH})
	// private OrderDetails orderDetails;

	// amount should not be null
	private double totalAmount;

	/*
	 * one to one mapping with customer
	 */
	@JsonIgnore
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.REFRESH})
	private Customer customer;

}

