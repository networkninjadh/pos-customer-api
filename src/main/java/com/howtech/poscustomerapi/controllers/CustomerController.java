package com.howtech.poscustomerapi.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.howtech.poscustomerapi.DTOs.CustomerDto;
import com.howtech.poscustomerapi.DTOs.InventoryToCustomerDto;
import com.howtech.poscustomerapi.DTOs.StoreToCustomerDto;
import com.howtech.poscustomerapi.DTOs.UserInfo;
import com.howtech.poscustomerapi.exceptions.CustomerNotFoundException;
import com.howtech.poscustomerapi.exceptions.StoreNotFoundException;
import com.howtech.poscustomerapi.services.CustomerService;

/**
 * 
 * @author Damond Howard
 * @apiNote this is a restfull controller for handling anything directly related
 *          to the customer
 *
 */
@RestController
@RequestMapping(path = "/customer-api/")
public class CustomerController {

	Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	/**
	 * 
	 * @param customer new customer object to add to the database
	 * @return a string message confirming the customer has been persisted to the
	 *         database
	 */
	@PostMapping("/customer/new")
	public String addCustomer(@RequestBody CustomerDto customer, UserInfo userInfo) {
		LOGGER.info("CustomerController: Creating new customer with username " + userInfo.getUsername());
		return customerService.createCustomer(customer, userInfo);
	}
	// TODO verify payment method for customer

	/**
	 * 
	 * @param userInfo
	 * @return return the current logged in users CustomerDto object
	 * @throws CustomerNotFoundException
	 */
	@GetMapping("/me")
	public com.howtech.poscustomerapi.models.Customer getMyCustomerInfo(UserInfo userInfo)
			throws CustomerNotFoundException {
		LOGGER.info("CustomerController: Return user info for currently logged in Customer");
		return customerService.getCustomerInfo(userInfo);
	}

	/**
	 * 
	 * @param id the id of the customer to retrieve
	 * @return the JSON object containing the customer's data
	 * @throws CustomerNotFoundException
	 */
	@GetMapping("/customer/{customer_id}")
	public com.howtech.poscustomerapi.models.Customer getCustomer(@PathVariable(name="customer_id") Long customerId, UserInfo userInfo)
			throws CustomerNotFoundException {
		LOGGER.info("CustomerController: Retrieving Customer with ID " + customerId);
		return customerService.getCustomer(customerId, userInfo);
	}

	/**
	 * 
	 * @return the JSON list of all customers in the customerRepository
	 */
	@GetMapping("/customers")
	public List<com.howtech.poscustomerapi.models.Customer> getCustomers(UserInfo userInfo) {
		LOGGER.info("CustomerController: Return a list of all Customers");
		return customerService.getCustomers(userInfo);
	}

	/**
	 * 
	 * @param customerId the id of the customer to delete
	 * @return a string saying that the customer has been deleted
	 */
	@DeleteMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable Long customerId, UserInfo userInfo) {
		LOGGER.info("CustomerController: Delete a Customer with ID " + customerId);
		return customerService.deleteCustomer(customerId, userInfo);
	}

	/**
	 * 
	 * @return message that all customers have been deleted
	 */
	@DeleteMapping("/delete/all")
	public String deleteCustomers() {
		LOGGER.info("CustomerController: Delete all Customers");
		return customerService.deleteCustomers();
	}

	/**
	 * 
	 * @return all available stores as a list an object that encompasses a smaller
	 *         set of a stores info
	 */
	@GetMapping("/stores")
	public List<StoreToCustomerDto> getStores(UserInfo userInfo) {
		LOGGER.info("CustomerController: Retrieve a list of all Stores for a Customer");
		return customerService.getStores(userInfo);
	}

	/**
	 * 
	 * @param storeId
	 * @return a list of a stores's inventory
	 * @throws StoreNotFoundException
	 */
	@GetMapping("/store/{store_id}/inventory")
	public InventoryToCustomerDto getInventory(@PathVariable(name = "store_id") Long storeId)
			throws StoreNotFoundException {
		LOGGER.info("CustomerController: Retrieve a list of Inventory for a Customer");
		return customerService.getInventory(storeId);
	}
}