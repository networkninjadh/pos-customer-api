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

import lombok.*;

/**
 *
 * @author Damond Howard
 * @apiNote this entity maps to the address information table of the store
 *
 */

@Getter
@Setter
@Entity
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
	private Customer customer;
}