
package com.sprint.entity;

import java.util.ArrayList;



import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * @Entity- Restaurant class mapped to the table 
 * @NoArgsConstructor- lombok generates an empty constructor
 * @Getter- lombok generates default getters
 * @Setter-lombok generates default setters
 * @Id- marks restaurant_Id as the primary key 
 * @NotBlank- should not be blank 
 * @Column- to create a column with given names
 * @Size- to give a specific size for the input field
 * @JsonIgnore- is used to mark a property to be ignored.
 * 
 */

@Entity
@ToString
@NoArgsConstructor
@Getter
@Setter

//Creating entity class and table restaurant
@Table(name = "restaurant")
public class Restaurant {

	// Fields

	// Creating column retaurant_Id and setting it as the primary key
	@Id
	@NotNull
	private int restaurantId;

	// Creating column restaurant_name
	@Column(name = "restaurant_name")
	@NotBlank
	private String restaurantName;

	// Creating column manager_name
	@NotBlank
	@Column(name = "manager_name")
	private String managerName;

	// Creating column contact_number
	@NotBlank
	@Size(max = 10, message = "Length should have 10 integer")
	@Column(name = "contact_number")
	private String contactNumber;

	
	/*
	 * One to one mapping between restaurant and address
	 * 
	 */
	//@JsonIgnore
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "address_id")
	private Address address;

	
	/*
	 * One to many mapping between restaurant and restaurant category such that one
	 * restaurant can have many categories
	 */
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "restaurant_id_fk", referencedColumnName = "restaurantId")
//	private List<RestaurantCategory> restCat = new ArrayList<>();
//
//	@OneToMany(mappedBy="itemCategory",cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
//	List<Item> items;

//	@OneToMany(cascade=CascadeType.ALL)
//    @JoinTable(name="restaurant_cat", joinColumns=@JoinColumn(name="restaurant_id_fk", referencedColumnName="restaurant_id")
//    , inverseJoinColumns=@JoinColumn(name="restaurantCategory_id_fk", referencedColumnName="restaurant_category_id"))
//    private  List<RestaurantCategory> restCat ;
	
//	@OneToMany
//    @JoinTable(name="restaurant_cat", joinColumns=@JoinColumn(name="restaurant_id_fk")
//    , inverseJoinColumns=@JoinColumn(name="restaurantCategory_id_fk"))
//    private  List<RestaurantCategory> restCat ;
	
	
	/*
	 * Many to Many mapping between restaurant and item as there can be many
	 * restaurant with same items and many items would be present in restaurants
	 */
	//@JsonIgnore
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "restaurant_item", joinColumns = { @JoinColumn(name = "restaurant_id") }, inverseJoinColumns = {
			@JoinColumn(name = "item_id") })
	private List<Item> itemList = new ArrayList<>();

	


	
	// constructors
	public Restaurant(int restaurantId, String restaurantName, Address address, 
			List<Item> itemList, String managerName, String contactNumber) {

		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.address = address;
		
		this.itemList = itemList;
		this.managerName = managerName;
		this.contactNumber = contactNumber;
	}
}
