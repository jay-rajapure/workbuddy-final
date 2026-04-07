package com.byteMinds.jay.workbuddy2.controllers;

import com.byteMinds.jay.workbuddy2.Dto.response.CustomerCreationResponse;
import com.byteMinds.jay.workbuddy2.Services.CustomerService;
import com.byteMinds.jay.workbuddy2.models.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/customer")
public class CutsomerController {

    private  final  CustomerService customerService;


    public CutsomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/")
    public ResponseEntity<CustomerCreationResponse> createCustomer(@RequestBody Customer customer,
                                                                   @RequestHeader("Authorization") String jwt) throws Exception {
        Customer createdCustomer = customerService.createCustomer(customer);
         return ResponseEntity.status(HttpStatus.CREATED).body(new CustomerCreationResponse( "Post Created Successfully ",jwt,createdCustomer));
    }
}
