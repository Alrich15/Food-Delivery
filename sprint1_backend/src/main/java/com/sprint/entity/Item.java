package com.sprint.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*	
 * 			This is Entity class for Food Item
 * 		which defines the basic structure for items
 * 		
 */

//Food Items
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item")
public class Item {
	// Fields

	//Item id: for unique identification of food items
	@Id
	@NotNull
	@Size(min=6, max=6, message="Item Id should be 6 characters long")
	@Pattern(regexp="^[A-Za-z]{3}[0-9]{3}$",
			 message="Item id should have 3 characters describing its category followed by 3 digits for unique identification")
	private String itemId;
	private String image;
	
	//Item Name: Name of Food Item
	@Size(min=3, message="Food Item name should be atleast 3 characters long")
	private String itemName;
	
	//Item Desc : A short description for food item
	@NotNull
	@Size(min=10, message="Item description should be atleast 10 characters long")
	private String itemDesc;
	
	//qty: No of items available
	@Range(min=1, message="Quantity cannot be empty or null")
	private int qty;
	
	//cost: Price of the item
	@Range(min=30, message="Minimum cost should be atleast INR. 30")
	private double cost;
	
	/*
	 * One-to-One mapping of item with item category
	 * 
	 */
	@OneToOne(cascade = { CascadeType.PERSIST})
	@JoinColumn(name = "itemcategory_id_fk")
	private ItemCategory itemCategory;
	
	/*
	 * Many-to-Many mapping of FoodCart with item
	 */
	@JsonIgnore
	@ManyToMany(mappedBy="cartItems") 
	private List<FoodCart> carts =new ArrayList<>();
	
	/*
	 * Many-to-Many mapping of restaurant with item
	 */
	@JsonIgnore
	@ManyToMany(mappedBy = "itemList")
	private List<Restaurant> restList= new ArrayList<>();

	//Constructors
	public Item(String itemId, String itemName, String itemDesc, int qty, double cost,ItemCategory itemCategory) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.qty = qty;
		this.cost = cost;
		this.itemCategory=itemCategory;
	}


}
