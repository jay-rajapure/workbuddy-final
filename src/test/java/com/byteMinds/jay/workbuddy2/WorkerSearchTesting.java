package com.byteMinds.jay.workbuddy2;

import com.byteMinds.jay.workbuddy2.Services.UserService;
import com.byteMinds.jay.workbuddy2.models.Users;
import com.byteMinds.jay.workbuddy2.repositories.UsersRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class WorkerSearchTesting {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    UserService userService;
    @Test
    void distanceCalculation(){

        final  double EARTH_RADIUS_KM = 6371.0;
        Users users = usersRepository.findByEmail("workeruser1232@gmail.com");
        double latitude =  users.getLatitude();
        double longitude = users.getLongitude();

        double user2Lat = 18.518428;
        double user2Long = 73.934823;

        double lradian =  Math.toRadians(user2Lat-latitude);
        double longradian = Math.toRadians(user2Long-longitude);

        double a =
                Math.sin(lradian / 2) * Math.sin(lradian / 2)
                        + Math.cos(Math.toRadians(latitude))
                        * Math.cos(Math.toRadians(user2Lat))
                        * Math.sin(longradian / 2)
                        * Math.sin(longradian / 2);

        double c = 2 * Math.atan2(
                Math.sqrt(a),
                Math.sqrt(1 - a)
        );

        System.out.println(EARTH_RADIUS_KM * c); ;

    }





}
