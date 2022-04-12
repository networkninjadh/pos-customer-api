package com.howtech.poscustomerapi.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Damond Howard
 * @apiNote This entity maps to a customer
 *
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "customers")
public class Customer extends com.howtech.poscustomerapi.models.Person {
	@Id
	@GeneratedValue
	@Column(name = "customer_id")
	private Long customerId;
	@Column(name = "username")
	private String username;
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private CustomerAddressInfo customerAddress;
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private CustomerBillingInfo customerBillingInfo;

	public void setCustomerAddress(CustomerAddressInfo customerAddress) {
		if (customerAddress == null) {
			if (this.customerAddress != null) {
				this.customerAddress.setCustomer(null);
			}
		} else {
			customerAddress.setCustomer(this);
		}
		this.customerAddress = customerAddress;
	}

	public void setCustomerBillingInfo(CustomerBillingInfo customerBillingInfo) {
		if (customerBillingInfo == null) {
			if (this.customerBillingInfo != null) {
				this.customerBillingInfo.setCustomer(this);
			} else {
				this.customerBillingInfo = customerBillingInfo;
			}
		}
	}
}