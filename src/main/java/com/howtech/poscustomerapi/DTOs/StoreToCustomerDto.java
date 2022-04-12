package com.howtech.poscustomerapi.DTOs;

import com.howtech.poscustomerapi.models.HoursOfOperation;

import lombok.Data;

/**
 * 
 * @author Damond Howard
 * @apiNote This is a DTO object that transfers the necessary data from a store
 *          to a customer
 *
 */
@Data
public class StoreToCustomerDto {

	private Long storeId;
	private String storeName;
	private String storeStreet;
	private String storeCity;
	private String storeState;
	private String storeCountry;
	private String storePostalCode;
	private boolean isOpenForDelivery;
	private HoursOfOperation storeHours;
	private String storeImageUrl;
}