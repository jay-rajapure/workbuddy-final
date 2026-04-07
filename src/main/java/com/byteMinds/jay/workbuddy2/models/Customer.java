package com.byteMinds.jay.workbuddy2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer  {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @JsonIgnore
    @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL,orphanRemoval = true)
    List<Post> posts = new ArrayList<>();
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    Users user ;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
