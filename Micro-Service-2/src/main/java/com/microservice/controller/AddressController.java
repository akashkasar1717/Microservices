package com.microservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservice.entities.Address;
import com.microservice.service.AddressService;

@RestController
public class AddressController {
	
	private static final Logger log = LoggerFactory.getLogger(AddressController.class);
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("address")
	public List<Address> userHandler() {
		List<Address> user = addressService.fetchAddressList();
		return user;
	}

	@PostMapping("postaddress")
	public ResponseEntity<String> postUserHandler(@RequestBody Address address) {
		Address users = addressService.saveAddress(address);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	@GetMapping("address/{id}")
	public Address getUserById(@PathVariable Long id) {
		Address address = addressService.fetchAddress(id);
		log.info("addresss info is sent");
		return address;
	}
}
