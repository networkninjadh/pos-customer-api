package com.howtech.poscustomerapi.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.howtech.poscustomerapi.models.CustomerAddressInfo;
import com.howtech.poscustomerapi.models.StoreDto;
import com.howtech.poscustomerapi.DTOs.CustomerDto;
import com.howtech.poscustomerapi.DTOs.InventoryToCustomerDto;
import com.howtech.poscustomerapi.DTOs.StoreToCustomerDto;
import com.howtech.poscustomerapi.DTOs.UserInfo;
import com.howtech.poscustomerapi.exceptions.CustomerNotFoundException;
import com.howtech.poscustomerapi.exceptions.StoreNotFoundException;
import com.howtech.poscustomerapi.models.Customer;
import com.howtech.poscustomerapi.repositories.CustomerRepository;

/**
 * 
 * @author Damond Howard
 * @apiNote this is a service that links the store with all other elements that
 *          can be accessed through the store
 */
@Service
public class CustomerService {

	Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

	private final CustomerRepository customerRepository;
	private final StoreService storeService;

	public CustomerService(CustomerRepository customerRepository, StoreService storeService) {
		this.customerRepository = customerRepository;
		this.storeService = storeService;
	}

	public String createCustomer(CustomerDto customer, UserInfo userInfo) {
		Customer newCustomer = new Customer();
		CustomerAddressInfo customerAddress = new CustomerAddressInfo();
		customerAddress.setStreet(customer.getAddressStreet());
		customerAddress.setCity(customer.getAddressCity());
		customerAddress.setCountry(customer.getAddressCountry());
		customerAddress.setPostCode(customer.getAddressPostcode());
		customerAddress.setProvince(customer.getAddressProvince());
		newCustomer.setUsername(userInfo.getUsername());
		newCustomer.setCustomerAddress(customerAddress);
		newCustomer.setFirstName(customer.getFirstName());
		newCustomer.setLastName(customer.getLastName());
		newCustomer.setEmail(customer.getEmail());
		try {
			customerRepository.save(newCustomer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Customer saved to database";
	}

	public Customer getCustomerInfo(UserInfo userInfo) throws CustomerNotFoundException {
		return customerRepository.findByUsername(userInfo.getUsername())
				.orElseThrow(() -> new CustomerNotFoundException(userInfo.getUsername()));
	}

	public Customer getCustomer(Long customerId, UserInfo userInfo) throws CustomerNotFoundException {
		return customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException(customerId));
	}

	public List<Customer> getCustomers(UserInfo userInfo) {
		return customerRepository.findAll();
	}

	public String deleteCustomer(Long customerId, UserInfo userInfo) {
		customerRepository.deleteById(customerId);
		return "Customer with " + customerId + " has been deleted";
	}

	public String deleteCustomers() {
		customerRepository.deleteAll();
		return "All customers deleted";
	}

	public List<StoreToCustomerDto> getStores(UserInfo userInfo) {
		List<StoreDto> stores = storeService.getAll();
		List<StoreToCustomerDto> storesForCustomers = stores // TODO note to self add store hours of operation schedule
																// to store as well as StoreToCustomerDto
				.parallelStream()
				.map(store -> {
					StoreToCustomerDto customerStore = new StoreToCustomerDto();
					customerStore.setStoreId(store.getStoreId());
					customerStore.setOpenForDelivery(store.isOpenForDelivery());
					customerStore.setStoreName(store.getStoreName());
					// TODO come back to fix the model vs DTO structure
					// customerStore.setStoreCity(store.getAddress().getCity());
					// customerStore.setStoreCountry(store.getAddress().getCountry());
					// customerStore.setStoreState(store.getAddress().getProvince());
					// customerStore.setStorePostalCode(store.getAddress().getPostCode());
					return customerStore;
				}).collect(Collectors.toList());
		return storesForCustomers;
	}

	public InventoryToCustomerDto getInventory(Long storeId) throws StoreNotFoundException {

		StoreDto myStore = storeService.getById(storeId);

		InventoryToCustomerDto inventory = new InventoryToCustomerDto();
		inventory.setStoreId(storeId);
		inventory.setStoreInventory(myStore.getStoreInventory());

		return inventory;
	}
}
