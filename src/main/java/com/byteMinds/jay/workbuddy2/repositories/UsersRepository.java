package com.byteMinds.jay.workbuddy2.repositories;

import com.byteMinds.jay.workbuddy2.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository  extends JpaRepository<Users,Long> {
    public  Users findByEmail(String email);
    @Query(
            value = """
                    SELECT * 
                    FROM users u
                    WHERE u.role= 'WORKER'
                    AND ST_Distance_Sphere(
                    u.location,
                    ST_SRID(POINT(:longitude, :latitude ),4326)
                    )<= :radiusMeters
                    """, nativeQuery = true
    )
   public List<Users> findUsersWithinRadius(

            @Param("longitude")double longitude,
            @Param("latitude")double latitude,
            @Param("radiusMeters")double radiusMeters
    );
}
