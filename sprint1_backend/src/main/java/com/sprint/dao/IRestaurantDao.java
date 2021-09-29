package com.sprint.dao;




import java.util.List;
import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.sprint.entity.Restaurant;

@Repository
public interface IRestaurantDao extends JpaRepository<Restaurant, Integer> {

	//Optional<Restaurant> findById(String id);
	
	@Query("Select restaurant from Restaurant restaurant where restaurant.restaurantId=:id")
	List<Restaurant> findByRestaurantId(@Param("id") int restaurantId);
	
	@Query("Select restaurant from Restaurant restaurant where restaurant.restaurantName=:name")
	Optional<Restaurant> findByRestaurantName(@Param("name") String restaurantName);

	@Modifying
	 @Transactional
	@Query("delete from Restaurant r where r.restaurantName=:name")
	void deleteRestaurant(@Param("name") String name);


	@Query(value="select r.* from restaurant r, address a WHERE r.address_id = a.address_id and a.area=:area",nativeQuery=true)
	List<Restaurant> getRestaurantByArea(@Param("area") String area);
	
	@Query(value="select r.* from restaurant r, address a WHERE r.address_id = a.address_id and a.city=:city",nativeQuery=true)
	List<Restaurant> getRestaurantByCity(@Param("city") String area);

}
