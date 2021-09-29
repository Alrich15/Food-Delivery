package com.sprint.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.entity.ItemCategory;

public interface IItemCategoryDAO extends JpaRepository<ItemCategory, String> {

	public ItemCategory findByItemCategoryName(String itemCategoryName);

}
