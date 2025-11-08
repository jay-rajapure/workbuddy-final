package com.byteMinds.jay.workbuddy2;

import com.byteMinds.jay.workbuddy2.models.*;
import com.byteMinds.jay.workbuddy2.repositories.BookingRepository;
import com.byteMinds.jay.workbuddy2.repositories.CustomerRepository;
import com.byteMinds.jay.workbuddy2.repositories.PostRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class BookingTesting {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    BookingRepository bookingRepository;
    @Test
    void  createBooking()
    {
        Booking booking = new Booking();
        Customer customer = customerRepository.findByEmail("jayrajapure1001@gmail.com");
        Post post = customer.getPosts().get(0);
        Worker worker = new Worker();
        worker.setName("ajay");
        worker.setSurName("rajapure");
        worker.setDescription("honest worker");
        worker.setExperienceYears(3);
        worker.setWorkCategory("plumbing");
        worker.setPassword("gagaguga");
        worker.setEmail("jayrajapure1002@gmail.com");
        worker.setRole(Role.WOKRER);

        workerRepository.save(worker);
        workerRepository.flush();

        booking.setCustomer(customer);
        booking.setPost(post);
        booking.setBOOKING_STATUS(BookingStatus.PENDING);
        booking.setWorker( worker);
        bookingRepository.save(booking);






    }

}
