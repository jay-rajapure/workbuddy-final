package com.byteMinds.jay.workbuddy2.repositories;

import com.byteMinds.jay.workbuddy2.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository  extends JpaRepository<Users,Long> {
    public  Users findByEmail(String email);
}
