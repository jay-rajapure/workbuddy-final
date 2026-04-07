package com.byteMinds.jay.workbuddy2.repositories;

import com.byteMinds.jay.workbuddy2.models.Customer;
import com.byteMinds.jay.workbuddy2.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Optional<Customer> findByUser(Users user);
}
