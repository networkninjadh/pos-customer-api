package com.howtech.poscustomerapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 * 
 * @author Damond Howard
 * @apiNote This Entity contains all the data used by stripe to charge a
 *          customer
 *
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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
	@ToString.Exclude
	private Customer customer;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		CustomerBillingInfo that = (CustomerBillingInfo) o;
		return billingInfoId != null && Objects.equals(billingInfoId, that.billingInfoId);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}