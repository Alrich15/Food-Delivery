package com.sprint.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class ItemCategory {
	
	@Id
	//@NotBlank
	@Size(min=6,max=6,message = "Id length must be 6")
	private String itemCategoryId;
	
	@NotBlank(message = "Item category name is mandatory")
	@Size(min=3,max=50,message = "Category name length must be in between 3 to 50")
	@Column(unique = true)
	private String itemCategoryName;
	
	@JsonIgnore 
	@OneToMany(mappedBy="itemCategory",cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	List<Item> items;

	public ItemCategory() {
		
}

	public ItemCategory(String itemCategoryId, String itemCategoryName) {
		super();
		this.itemCategoryId = itemCategoryId;
		this.itemCategoryName = itemCategoryName;
	}
	
}
