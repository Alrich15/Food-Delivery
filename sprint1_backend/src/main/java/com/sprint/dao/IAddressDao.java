package com.sprint.dao;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.sprint.entity.Address;
import org.springframework.data.repository.query.Param;

@Repository
public interface IAddressDao extends JpaRepository<Address, String>{
	//This query returns a list of addresses having same area as gien in argument 
	@Query("select a from Address a where a.area=:area")
	List<Address> getAddrByArea(@Param("area") String area);
}
