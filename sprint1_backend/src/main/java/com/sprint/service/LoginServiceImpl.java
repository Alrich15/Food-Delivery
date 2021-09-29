package com.sprint.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.dto.LoginDto;
import com.sprint.entity.Login;
import com.sprint.exception.InvalidCredentialsException;
import com.sprint.exception.UserNotFoundException;
import com.sprint.dao.ILoginRepository;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	ILoginRepository loginRepo;
	
	private static Logger logger = LogManager.getLogger();

	@Override
	public LoginDto login(Login login) throws InvalidCredentialsException {
		Optional<Login> opt = loginRepo.findByEmail(login.getEmail());
		if(!opt.isPresent()) {
			throw new InvalidCredentialsException("Invalid Credentials");
		}
		Login dbLogin = opt.get();
		if(login.getEmail().equalsIgnoreCase(dbLogin.getEmail()) && 
				login.getPassword().equalsIgnoreCase(dbLogin.getPassword())  && 
				login.getRole().equalsIgnoreCase(dbLogin.getRole())) {
			// set isLoggedIn flag to true
			dbLogin.setLoggedIn(true);
			
			// update isLoggedIn flag to true 
			loginRepo.save(dbLogin);
			LoginDto dto = new LoginDto();
			dto.setEmail(login.getEmail());
			dto.setRole(login.getRole());
			dto.setLoggedIn(true);
			
			return dto;
		} else {
			throw new InvalidCredentialsException("Invalid Credentials");
		}
	}

	@Override
	public LoginDto logout(String email) throws InvalidCredentialsException {
		logger.info(email);
		Optional<Login> opt = loginRepo.findByEmail(email);
		if(!opt.isPresent()) {
			throw new InvalidCredentialsException("Invalid Credentials");
		}
		Login login= opt.get();
		login.setLoggedIn(false);
		loginRepo.save(login);
		LoginDto loginDto = new LoginDto();
		loginDto.setLoggedIn(false);
		return loginDto;
	}

}
