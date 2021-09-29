package com.sprint.service;

import com.sprint.dto.LoginDto;
import com.sprint.entity.Login;
import com.sprint.exception.InvalidCredentialsException;
import com.sprint.exception.UserNotFoundException;

public interface ILoginService {
	
	LoginDto login(Login login) throws InvalidCredentialsException;
	LoginDto logout(String userId) throws InvalidCredentialsException;

}
