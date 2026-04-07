package com.byteMinds.jay.workbuddy2.controllers;

import com.byteMinds.jay.workbuddy2.Dto.response.PostCreationResponse;
import com.byteMinds.jay.workbuddy2.Dto.response.SimpleResponse;
import com.byteMinds.jay.workbuddy2.Services.PostService;
import com.byteMinds.jay.workbuddy2.models.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/post")
public class PostController {

    private  final PostService postService;
    public  PostController(PostService postService)
    {
        this.postService= postService;

    }

    @PostMapping("/")
    public ResponseEntity<PostCreationResponse>createPost(@RequestBody Post post,
                                     @RequestHeader("Authorization")String jwt) throws Exception {


          Post createdPost =   postService.createPost(post,jwt);
         return  ResponseEntity.status(HttpStatus.CREATED).body(new PostCreationResponse("Post Created Successfully ",jwt,createdPost));
    }
}
