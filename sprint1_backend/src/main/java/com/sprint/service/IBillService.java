package com.sprint.service;

import java.time.LocalDate;
import java.util.List;

import com.sprint.dto.BillDto;
import com.sprint.entity.Bill;

public interface IBillService {

	//Method for adding bill
	Bill addBill(Bill bill);
	
	//Method for updating bill
	Bill updateBill(Bill bill);
	//Method for deleting bill by using bill id
	Bill removeBillById(String billId);
	//Method for viewing bill by using bill id
	//Bill viewBillById(String billId);
	 //Method for viewing all bills on a particular date
	List<Bill> viewBillByDate(LocalDate billDate);
	//Method for displaying all bills
	List<Bill> viewAllBills();
	
	BillDto viewBillById(String billId);
	//Method for displaying all bills in a range of dates
	List<Bill> viewBillsByDateRange(LocalDate startDate,LocalDate endDate);

	// Method for   displaying all bills of a customer using customer id
	List<Bill> viewBillsByCustomerId(String custId);
	
}