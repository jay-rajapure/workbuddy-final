package com.byteMinds.jay.workbuddy2;

import com.byteMinds.jay.workbuddy2.Services.LocationService;
import com.byteMinds.jay.workbuddy2.Services.implementations.LocationServiceImpl;
import com.byteMinds.jay.workbuddy2.models.Role;
import com.byteMinds.jay.workbuddy2.models.Users;
import com.byteMinds.jay.workbuddy2.models.Worker;
import com.byteMinds.jay.workbuddy2.repositories.UsersRepository;
import com.byteMinds.jay.workbuddy2.repositories.WorkerRepository;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
public class SignUpTests {
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    WorkerRepository workerRepository;

    @Autowired
    LocationService locationService;
    @Test
    public void signUp()
    {
         double customerLat = 18.517810;
         double customerLong = 73.973352;

        for (int i = 0; i < 20; i++) {
            Users users = new Users();
            users.setName("worker"+i);
            users.setSurName("user"+i);
            users.setEmail("worker"+i+"@gmail.com");
            users.setRole(Role.WORKER);
            users.setPassword(encoder.encode("workerpassword"));
            if (i%2==0){
                Point location =LocationServiceImpl.createJTSPoint(customerLong, customerLat+0.02);
                users.setLocation(location);
            }
            else
            {
                Point location = LocationServiceImpl.createJTSPoint(customerLong,customerLat+0.06);
                users.setLocation(location);

            }

            Users createdUser = usersRepository.save(users);

            Worker worker = new Worker();
            worker.setUser(users);
            worker.setAvailaible(true);
            worker.setStars(3);
            worker.setDescription("best worker"+i);
            worker.setExperienceYears(5);
            worker.setWorkCategory("plumbing");
            workerRepository.save(worker);

        }
        List<Users> users=  usersRepository.findUsersWithinRadius(customerLong,customerLat,5000);
        for (Users user: users)
        {
           System.out.println(user.getName());
        }
    }


}
