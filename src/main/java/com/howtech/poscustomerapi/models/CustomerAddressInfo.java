package com.howtech.poscustomerapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 * 
 * @author Damond Howard
 * @apiNote this entity maps to the address information table of the store
 *
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address_info")
public class CustomerAddressInfo {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long addressId;
	@Column(name = "street")
	private String street;
	@Column(name = "city")
	private String city;
	@Column(name = "province")
	private String province;
	@Column(name = "country")
	private String country;
	@Column(name = "postcode")
	private String postCode;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	@ToString.Exclude
	private Customer customer;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		CustomerAddressInfo that = (CustomerAddressInfo) o;
		return addressId != null && Objects.equals(addressId, that.addressId);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}