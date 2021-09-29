package com.sprint.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.entity.RestaurantCategory;

public interface IRestaurantCategoryDAO extends JpaRepository<RestaurantCategory, String> {

	public RestaurantCategory findByRestaurantCategoryName(String restCategoryName);

}
