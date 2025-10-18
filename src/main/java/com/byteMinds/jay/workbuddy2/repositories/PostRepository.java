package com.byteMinds.jay.workbuddy2.repositories;

import com.byteMinds.jay.workbuddy2.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    public  Post findByUser_id(Long id);
}
