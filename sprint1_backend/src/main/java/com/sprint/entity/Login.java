package com.sprint.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
@Entity
public class Login {

	
	//@GeneratedValue
	//private int userId;

	@Id
	private String email;
	@NotEmpty(message = "Please enter your password")
	private String password;
	
	private String role;
	
	@JsonIgnore
	private boolean isLoggedIn = false;
	
	/*
	 * @JsonIgnore
	 * 
	 * @OneToOne(mappedBy="login") private User user;
	 */
		
}
