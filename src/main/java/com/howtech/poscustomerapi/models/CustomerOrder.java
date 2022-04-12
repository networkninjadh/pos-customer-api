package com.howtech.poscustomerapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Damond Howard
 *
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer_orders")
public class CustomerOrder {
	@Id
	@GeneratedValue
	private Long orderId;
}