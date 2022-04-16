package com.howtech.poscustomerapi.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 * 
 * @author Damond Howard
 * @apiNote This entity maps to a customer
 *
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "customers")
public class Customer extends Person {
	@Id
	@GeneratedValue
	@Column(name = "customer_id")
	private Long customerId;
	@Column(name = "username")
	private String username;
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@ToString.Exclude
	private CustomerAddressInfo customerAddress;
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@ToString.Exclude
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Customer customer = (Customer) o;
		return customerId != null && Objects.equals(customerId, customer.customerId);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}