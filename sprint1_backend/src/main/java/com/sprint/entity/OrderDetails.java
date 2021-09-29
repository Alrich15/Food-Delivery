package com.sprint.entity;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;


@Entity //Enables you to map class with the table
@Table(name="orderdetails") //creates a table with name OrderDetails
@Data //Injects all the getters and setters methods

public class OrderDetails {
	
	    //Fields
		@Id
		@NotBlank(message="order id should not be blank") //Not Blank annotation does not allow blank value
		@Size(min=6,max=6,message="order id should be 6 characters") //Size annotation limits the size of the field
		@Pattern(regexp="^[O,o]{1}[D,d]{1}[0-9]{1,4}$",message="order id should start with OD or od") //Pattern annotation validates the field to match regular expression
		private String orderId;
		
		@Column(name="order_date", nullable=false) //creates a column name
		@NotNull(message="Date should be in this format yyyy-mm-dd") //Not Null annotation does not allow null values
		private LocalDate orderDate;
		
		@Column(name="order_status", nullable=false) //creates a column name
		@NotNull(message="order status should not be null") //Not Null annotation does not allow null values
		private String orderStatus;
		
		/*
		 * One to one mapping to map foodCart
		 */
		@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.REFRESH})
		/*
		 * column name cart_id_fk is added as foreign key to order details table
		 */
		@JoinColumn(name="cart_id_fk")
		private FoodCart cart;
		
//		@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.REFRESH})
//		/*
//		 * column name cart_id_fk is added as foreign key to order details table
//		 */
//		@JoinColumn(name="cart_id_fk")
//		private FoodCart cart;

		/*
		 * Many to one mapping to map restaurant
		 */
//		@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.REFRESH})
//		private Restaurant restaurant;
		
		//Default Constructor
		public OrderDetails() {}

		//Constructor with fields
		public OrderDetails(
				@NotBlank(message = "order id should not be blank") @Size(min = 6, max = 6, message = "order id should have only 6 characters") String orderId,
				@NotNull(message = "Date should be in this format yyyy-mm-dd") LocalDate orderDate,
				@NotNull(message = "order status should not be null") String orderStatus) {
			super();
			this.orderId = orderId;
			this.orderDate = orderDate;
			this.orderStatus = orderStatus;
		
		}

}
