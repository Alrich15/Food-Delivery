package com.sprint.dto;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class LoginDto {

	private String email;
	private boolean isLoggedIn;
	private String role;

}
