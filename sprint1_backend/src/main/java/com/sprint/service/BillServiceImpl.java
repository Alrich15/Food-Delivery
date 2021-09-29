package com.sprint.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.dao.IBillDao;
import com.sprint.dto.BillDto;
import com.sprint.entity.Bill;
import com.sprint.exception.BillAlreadyExistsException;
import com.sprint.exception.BillNotFoundException;

@Service
public class BillServiceImpl implements IBillService{

	@Autowired
	IBillDao billDao;
	
	//Method implementation for adding bill
		@Override
		public Bill addBill(Bill bill) {
			Optional<Bill> opt = billDao.findById(bill.getBillId());
			if(opt.isPresent())
			{
				throw new BillAlreadyExistsException("Bill with given id already exists : " + bill.getBillId());
			}
			else
			{	
				//bill.setTotalCost(billDao.totalCost());
				return billDao.save(bill);
			}
		}

		//Method implementation for updating bill
	@Override
	public Bill updateBill(Bill bill) {
		Optional<Bill> opt = billDao.findById(bill.getBillId());
		if(opt.isPresent())
		{
			Bill dbBill = opt.get();
			dbBill.setBillDate(bill.getBillDate());
			dbBill.setTotalItem(bill.getTotalItem());
			dbBill.setTotalCost(bill.getTotalCost());
			
			billDao.save(dbBill);
		}
		else
		{
			throw new BillNotFoundException("Bill with given id not found : " + bill.getBillId());
		}
		return bill;
	}

	//Method implementation for deleting bill by using bill id
	@Override
	public Bill removeBillById(String billId) {
		Optional<Bill> opt = billDao.findById(billId);
		if(opt.isPresent())
		{
			billDao.delete(opt.get());
			return opt.get();
		}
		else
		{
			throw new BillNotFoundException("Bill with given id not found : " + billId);
		}
	}

	 //Method implementation for viewing bill by using bill id
//	@Override
//	public Bill viewBillById(String billId) {
//		Optional<Bill> opt = billDao.findById(billId);
//		if(!opt.isPresent()) {
//			throw new BillNotFoundException("Bill with given id not found : " + billId);
//		}
//		return opt.get();
//	}
	//Method implementation for viewing all bills on a particular date
	@Override
	public List<Bill> viewBillByDate(LocalDate billDate) {
		List<Bill> bills = billDao.findBillByDate(billDate);
		if(bills.size()==0) {
			throw new BillNotFoundException("Bill with given date not found : " + billDate);
		}
		return bills;
	}
	
	//Method implementation for displaying all bills	@Override
	public List<Bill> viewAllBills() {
		List<Bill> bills = billDao.findAll();
		if(bills.size()==0) {
			throw new BillNotFoundException("Bill db is empty");
		}
		return bills;
	}
	
	//Method implementation for displaying all bills in a range of dates
	@Override
	public List<Bill> viewBillsByDateRange(LocalDate startDate, LocalDate endDate) {
		List<Bill>bills = billDao.findByBillDateBetween(startDate, endDate);
		if(bills.size()==0) {
			throw new BillNotFoundException("No bills in given date range");
		}
		return bills;
	}

	//Method implementation for displaying all bills of a customer using customer id
		@Override

		public List<Bill> viewBillsByCustomerId(String custId) {
			List<Bill> bills = billDao.findBillByCustomerId(custId);
			if(bills.size()==0) {
				throw new BillNotFoundException("No bills with given customer id");
			}
			return bills;
		}
		@Override
		public BillDto viewBillById(String billId) {
			Optional<Bill> opt = billDao.findById(billId);
			if(!opt.isPresent()) {
				throw new BillNotFoundException("Bill with given id not found : " + billId);
			}
			Bill b = opt.get();
			BillDto bd = new BillDto();
			bd.setBillId(b.getBillId());
			bd.setBillDate(b.getBillDate());
			bd.setTotalItem(b.getTotalItem());
			bd.setTotalCost(b.getOrder().getCart().getTotalAmount());
			bd.setFirstName(b.getOrder().getCart().getCustomer().getFirstName());
			bd.setCartItems(b.getOrder().getCart().getCartItems());
			return bd;
		}
}
