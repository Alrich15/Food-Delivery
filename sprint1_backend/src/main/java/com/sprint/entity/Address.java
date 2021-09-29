package com.sprint.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	//Fields
	@Id
	@NotNull
	@Size(min=6, max=6, message="Should have 6 character")
	@Pattern(regexp="^[A-Za-z]{3}[0-9]{3}$")
	private String addressId;
	
	private String buildingName;
	
	private String streetNo;
	
	@NotNull
	@Size(min=2, max=15, message="Length should have 2-15 charecter")	
	private String area;
	
	@NotBlank
	private String city;
	
	@NotNull
	@Size(min=3, max=12)
	private String state;
	
	@NotBlank
	private String country;
	
	@NotBlank
	@Size(min=6, max=6, message="Should have 6 character")
	@Pattern(regexp="^[1-9]{1}[0-9]{5}$")
	private String pincode;
	
}
