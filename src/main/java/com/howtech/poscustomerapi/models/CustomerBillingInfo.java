package com.howtech.poscustomerapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Damond Howard
 * @apiNote This Entity contains all the data used by stripe to charge a
 *          customer
 *
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer_billing_info")
public class CustomerBillingInfo {
	@Id
	@GeneratedValue
	@Column(name = "billing_info_id")
	private Long billingInfoId;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	private Customer customer;
}