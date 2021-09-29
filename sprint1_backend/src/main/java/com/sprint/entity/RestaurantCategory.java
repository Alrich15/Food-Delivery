package com.sprint.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data


@Table(name="restaurant_category")
public class RestaurantCategory {
	
	@Id
	@Size(min=6,max=6,message = "Id length must be 6")
	private String restaurantCategoryId;

	@NotBlank(message = "Item category name is mandatory")
	@Size(min=3,max=50,message = "Category name length must be in between 3 to 50")
	@Column(unique = true)
	private String restaurantCategoryName;

//	@ManyToOne
//    @JoinColumn(name="restaurantCategoryId")
//    private Restaurant restaurant;

	//@JsonIgnore
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "rest_cat_id", referencedColumnName = "restaurantCategoryId")
	private List<Restaurant>  rest = new ArrayList<>();

	public RestaurantCategory() {
		
	}
	public RestaurantCategory (List<Restaurant> rest,String restaurantCategoryId, String restaurantCategoryName) {
	//	super();
		//this.restaurant = restaurant;
		this.rest=rest;
		this.restaurantCategoryId = restaurantCategoryId;
		this.restaurantCategoryName = restaurantCategoryName;
	}

	
	
}
