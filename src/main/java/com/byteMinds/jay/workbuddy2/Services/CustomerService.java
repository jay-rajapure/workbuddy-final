package com.byteMinds.jay.workbuddy2.Services;

import com.byteMinds.jay.workbuddy2.models.Customer;
import com.byteMinds.jay.workbuddy2.models.Users;
import com.byteMinds.jay.workbuddy2.repositories.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private  final  CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository)
    {
        this.customerRepository=customerRepository;

    }
    public Customer createCustomer(Customer customer) throws Exception {
         if(customer==null) throw  new Exception("Customer object provided is null ");

         return  customerRepository.save(customer);
    }
    public  Customer getCustomerByUser(Users user)
    {
            Customer customer = customerRepository.findByUser(user)
                    .orElseThrow(()->new EntityNotFoundException("customer not found"));
            return  customer;
    }


}
