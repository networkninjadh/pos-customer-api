package com.howtech.poscustomerapi.DTOs;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Damond Howard
 * @apiNote Dto for transfering store inventory to customers
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryToCustomerDto {

	private Long storeId;
	private Long customerId;
	private Set<ProductDto> storeInventory;

}
