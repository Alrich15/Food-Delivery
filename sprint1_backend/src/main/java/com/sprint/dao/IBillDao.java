package com.sprint.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sprint.entity.Bill;

@Repository
public interface IBillDao extends JpaRepository<Bill,String>{
	
	
	 
	 /*JPA query for viewing bills in a range of dates
	  * start is starting date and end is ending date
	  */
	
	List<Bill> findByBillDateBetween(LocalDate start, LocalDate end);
	//Query for selecting all bills on a particular date
	@Query("select b from Bill b where b.billDate=:date")
	List<Bill> findBillByDate(@Param("date") LocalDate billDate);
	
	//Query for selecting all bills using customer id
	@Query(value="select b.* from bill b,orderdetails o,foodcart f,customer cu "
				+ "where b.bill_id=o.order_id and o.order_id=f.cart_id "
				+ "and f.cart_id=cu.customer_id and cu.customer_id=custId" ,nativeQuery=true)
		List<Bill> findBillByCustomerId(@Param("custId") String custId);
	
	//Query for assigning total cost
		@Query(value="select f.total_amount from bill b,orderdetails o,foodcart f"
				+ "where b.bill_id=o.order_id and o.order_id=f.cart_id;",nativeQuery=true)
		double totalCost();
}
