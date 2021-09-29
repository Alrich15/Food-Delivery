package com.sprint.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.sprint.entity.Customer;

@Repository
public interface ICustomerDao extends JpaRepository<Customer, String> {
	
	@Query(value="select c.* from customer c, address a where c.address_id = a.address_id AND a.area=:area",nativeQuery=true)
	List<Customer> viewCustomerByArea(@Param("area") String area);
	
	@Query(value="select c.* from customer c, address a where c.address_id = a.address_id AND a.city=:city",nativeQuery=true)
	List<Customer> viewCustomerByCity(@Param("city") String city);
	
	@Query(value="select c.* from customer c where c.first_name=:firstName",nativeQuery=true)
	List<Customer> viewCustomerByFirstName(@Param("firstName") String firstName);
	
	@Query(value="select c.* from customer c where c.age>=:age",nativeQuery=true)
	List<Customer> viewCustomerByAgeAbove(@Param("age") int age);
	
	
}
