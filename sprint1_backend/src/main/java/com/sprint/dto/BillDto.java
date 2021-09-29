package com.sprint.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sprint.entity.Item;

import lombok.Data;

@Data
public class BillDto {

	private String billId;
	private LocalDate billDate;
	private double totalCost;
	private double totalItem;
	private String firstName;
	private List<Item> cartItems = new ArrayList<>();
}
