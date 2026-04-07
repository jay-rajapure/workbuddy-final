package com.byteMinds.jay.workbuddy2.Dto.response;

import com.byteMinds.jay.workbuddy2.models.Post;

public class PostCreationResponse extends  SimpleResponse{
    Post post;

    public  PostCreationResponse(String message,  String jwt ,Post post)
    {
        super(message,jwt);
        this.post = post;
    }
}
