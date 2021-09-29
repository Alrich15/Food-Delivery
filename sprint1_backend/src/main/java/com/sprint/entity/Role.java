package com.sprint.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Role {
	
	@Id
	@GeneratedValue
	private int id;

	private String roleName;
	
	/*
	@ManyToMany(targetEntity=User.class, cascade=CascadeType.ALL)
	private List<User> user = new ArrayList<>();
	*/
	@JsonIgnore
	@OneToMany(mappedBy="role", cascade=CascadeType.ALL)
	private List<Login> login = new ArrayList<>();
	
}
