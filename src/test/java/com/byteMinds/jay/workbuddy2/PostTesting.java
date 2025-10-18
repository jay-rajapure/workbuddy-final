package com.byteMinds.jay.workbuddy2;

import com.byteMinds.jay.workbuddy2.models.Customer;
import com.byteMinds.jay.workbuddy2.models.Post;
import com.byteMinds.jay.workbuddy2.models.Role;
import com.byteMinds.jay.workbuddy2.repositories.CustomerRepository;
import com.byteMinds.jay.workbuddy2.repositories.PostRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class PostTesting {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CustomerRepository customerRepository;


    @Test
    void postCreation()
    {
        Customer customer = customerRepository.findByEmail("jayrajapure1001@gmail.com");

        Post post = new Post();
        post.setPriceStart(12.999999999999);
        post.setPriceEnd(200.012);
        post.setDescription("wanted to fix this");
        post.setTitle("wanted to fix this ");
        post.setUser(customer);
        postRepository.save(post);
        Post post2 = postRepository.findByUser_id(customer.getId());

        System.out.println(post2.getPriceStart()+""+post2.getPriceEnd());



    }
}
