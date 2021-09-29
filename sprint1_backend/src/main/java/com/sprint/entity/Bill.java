package com.sprint.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * @Entity - for denoting bill class as a entity
 * @Data - for getters,setters,equals,toString and hashCode
 * @AllArgsConstructor - for constructor of Bill class with arguments
 * @NoArgsConstructor - for constructor of Bill class with no arguments  
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
	
	/*
	 * billId - for storing bill id 
	 * billDate - for storing bill date
	 * totalItem - for storing total item
	 * totalCost - for storing total bill amount
	 * order - used as foreign key for storing order details
	 */
	
	//Fields
	@Id
	@NotBlank
	@Size(min=2,max=8,message="Id should have minimum 2 char and maximum 8 char")
	@Pattern(regexp="^[B,b]{1}[0-9]{1,7}$",message="Id should start with B/b and remaining should be 0-9")
	private String billId;
	@Column(name="bill_date",nullable=false)
	@NotNull(message="Date should not be null and should be in the format yyyy-mm-dd")
	private LocalDate billDate;
	@Column(name="total_item",nullable=false)
	@Min(value=1, message="Total item should be minimum 1")
	@Max(value=50, message="Total item should be maximum 50")  
	private int totalItem;
	@Column(name="total_cost",nullable=false)
	@Min(value=50, message="Total cost should be minimum 50")
	private double totalCost;
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="order_id_fk")
	private OrderDetails order;
	
	
	
}
