package com.byteMinds.jay.workbuddy2;

import com.byteMinds.jay.workbuddy2.models.Customer;
import com.byteMinds.jay.workbuddy2.models.Role;
import com.byteMinds.jay.workbuddy2.models.Worker;
import com.byteMinds.jay.workbuddy2.repositories.CustomerRepository;
import com.byteMinds.jay.workbuddy2.repositories.WorkerRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class UserSignInTest {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private WorkerRepository workerRepository;

    @Test
    void  testDuplicateEmails(){
        Customer customer = new Customer();
        customer.setName("jay");
        customer.setSurName("rajapure");
        customer.setEmail("jayrajapure1001@gmail.com");
        customer.setRole(Role.CUSTOMER);

        Worker worker = new Worker();
        worker.setName("jay");
        worker.setSurName("rajapure");
        worker.setDescription("honest worker");
        worker.setExperienceYears(3);
        worker.setWorkCategory("plumbing");
        worker.setPassword("gagaguga");
        worker.setEmail("jayrajapure1001@gmail.com");
        customerRepository.save(customer);
        customerRepository.flush();
        workerRepository.save(worker);
        workerRepository.flush();

    }
    @Test
    void  testWorkerSignIn(){


    }


}
