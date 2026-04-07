package com.byteMinds.jay.workbuddy2.Services;

import com.byteMinds.jay.workbuddy2.models.Customer;
import com.byteMinds.jay.workbuddy2.models.Post;
import com.byteMinds.jay.workbuddy2.models.Users;
import com.byteMinds.jay.workbuddy2.repositories.PostRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private  final PostRepository postRepository;
    private  final UserService userService;
    private  final CustomerService customerService;
    public  PostService(PostRepository postRepository, UserService userService, CustomerService customerService)
    {
     this.postRepository = postRepository;
        this.userService = userService;
        this.customerService = customerService;
    }

    public  Post createPost(Post post,String jwt) throws Exception {
        if(post == null) throw  new Exception("Post not valid");
         Users user=  userService.findUserByJwt(jwt);
         Customer customer =customerService.getCustomerByUser(user);
         post.getCustomer(customer);
         Post createdPost = postRepository.save(post);
        return  createdPost;

    }
}
