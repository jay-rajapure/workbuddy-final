package com.byteMinds.jay.workbuddy2.Dto.response;

import com.byteMinds.jay.workbuddy2.models.Customer;

public class CustomerCreationResponse extends  SimpleResponse {
    private Customer customer;
    public  CustomerCreationResponse(String jwt, String message,Customer customer)
    {
        this.customer = customer;
    }
}
