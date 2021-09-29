package com.sprint.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sprint.entity.Login;


public interface ILoginRepository extends JpaRepository<Login, Integer>{
	
	Optional<Login> findByEmail(String email);

	@Query(value="select * from login where user_id=:name", nativeQuery=true )
	Optional<Login> findByUsrName(@Param("name") String name);

}
