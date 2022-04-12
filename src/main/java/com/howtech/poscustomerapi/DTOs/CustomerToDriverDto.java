package com.howtech.poscustomerapi.DTOs;

import java.math.BigDecimal;

import lombok.Data;

/**
 * 
 * @author Damond Howard
 * @apiNote This is a DTO object for transferring customer information to a
 *          driver
 *
 */
@Data
public class CustomerToDriverDto {

	private String addressCountry;
	private String addressStreet;
	private String addressCity;
	private String addressProvince;
	private String addressPostCode;
	private BigDecimal longitude;
	private BigDecimal latitude;
	private String firstName;
	private String customerMessage;
	// ability to call the customer (later feature)

}
