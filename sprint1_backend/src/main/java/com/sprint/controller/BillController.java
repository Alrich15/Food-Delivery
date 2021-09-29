package com.sprint.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.dto.BillDto;
import com.sprint.entity.Bill;
import com.sprint.service.IBillService;

@CrossOrigin
@RestController
public class BillController {
	
	@Autowired
	IBillService billServ;


    private final Logger log = LoggerFactory.getLogger(getClass());

	//Controller method for adding bill object  in bill database	
	@PostMapping("bill/add")
	public ResponseEntity<Bill> addBill(@Valid @RequestBody Bill bill){
		billServ.addBill(bill);
		return new ResponseEntity<Bill>(bill,HttpStatus.OK);
	}

//Controller method for updating bill
	@PutMapping("/bill/update")
	public ResponseEntity<Bill> updateBill(@Valid @RequestBody Bill bill) {
		Bill newBill = billServ.updateBill(bill);
		return new ResponseEntity<Bill>(newBill,HttpStatus.OK);
	}
	 //Controller method for deleting bill using bill id
	
	@DeleteMapping("/bill/delete/byId/{id}")
	public ResponseEntity<Bill> removeBillById(@Valid @PathVariable("id") String billId){
		Bill newBill = billServ.removeBillById(billId);
		return new ResponseEntity<Bill>(newBill,HttpStatus.OK);
	}
	 //Controller method for fetching bill using bill id
//	@GetMapping("/bill/view/byId/{id}")
//	public ResponseEntity<Bill> viewBillById(@Valid @PathVariable("id") String billId){
//		Bill newBill = billServ.viewBillById(billId);
//		return new ResponseEntity<Bill>(newBill,HttpStatus.OK);
//	}
	 //Controller method for fetching all bills on a particular date
	@GetMapping("/bill/view/byDate/{date}")
	public ResponseEntity<List<Bill>> viewBillByDate(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate billDate){
		List<Bill> bills = billServ.viewBillByDate(billDate);
		return new ResponseEntity<List<Bill>>(bills,HttpStatus.OK);
	}
	
	//Controller method for fetching all bills from bill database
	@GetMapping("/bill/viewall")
	public ResponseEntity<List<Bill>> viewAllBills(){
		List<Bill> bills = billServ.viewAllBills();
		return new ResponseEntity<List<Bill>>(bills,HttpStatus.OK);
	} 
	
	//Controller method for viewing all bills in a given range of date
	
	@GetMapping("bill/view/{start}/{end}")
	public ResponseEntity<List<Bill>> viewBillsByDateRange(@PathVariable("start") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate startDate,@PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
		List<Bill> bills =  billServ.viewBillsByDateRange(startDate, endDate);
		return new ResponseEntity<List<Bill>>(bills,HttpStatus.OK);
	}
	
	//Controller method for viewing all by a particular customer id
   	@GetMapping("bill/view/{custId}")
   	public ResponseEntity<List<Bill>> viewBillsByCustomerId(@PathVariable("custId")String custId) {
		List<Bill> bills =  billServ.viewBillsByCustomerId(custId);
		log.info("Getting all Bills by customer Id");
		return new ResponseEntity<List<Bill>>(bills,HttpStatus.OK);
	
}
   	@GetMapping("/bill/view/byId/{id}")
	public ResponseEntity<BillDto> viewBillById(@Valid @PathVariable("id") String billId){
		BillDto newBill = billServ.viewBillById(billId);
		return new ResponseEntity<BillDto>(newBill,HttpStatus.OK);
	}
}