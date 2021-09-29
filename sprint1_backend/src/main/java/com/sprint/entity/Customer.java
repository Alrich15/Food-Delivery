package com.sprint.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customer")
public class Customer {
	
	//Fields
	@Id
	@Column(name="customer_id", unique=true, nullable= false)
	@Size(min=6, max=6, message="Should have 6 character")
	@Pattern(regexp="^[A-Za-z]{3}[0-9]{3}$")
	private String customerId;
	
	@NotBlank
	@Size(min=2, max=20)
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank
	@Size(min=2, max=20)
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="age")
	private int age;
	
	@NotBlank
	@Column(name="gender")
	private String gender;
	
	@NotBlank
	@Column(name="mobile_number", unique=true, nullable= false)
	@Size(min=10, max=10, message="Should have 10 number")
	@Pattern(regexp="^[1-9]{1}[0-9]{9}$")
	private String mobileNumber;
	
	@Column(name="email")
	private String email;
	
	@NotBlank
    @Size(min=4, max=15, message="Should have atleast 4 character")
    @Column(name="password")
    private String password;
	
//	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
//	@JoinColumn(name = "address_id")
//	private Address address;

}
