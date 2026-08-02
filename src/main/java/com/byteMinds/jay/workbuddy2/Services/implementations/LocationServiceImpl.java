package com.byteMinds.jay.workbuddy2.Services.implementations;

import com.byteMinds.jay.workbuddy2.Services.LocationService;
import com.byteMinds.jay.workbuddy2.Services.UserService;
import com.byteMinds.jay.workbuddy2.models.Users;
import com.byteMinds.jay.workbuddy2.models.Worker;
import com.byteMinds.jay.workbuddy2.repositories.UsersRepository;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LocationServiceImpl implements LocationService {
    public  static final double RADIUS_METERS = 5000;
    public  final UsersRepository usersRepository;
    public final UserService userService;
    public LocationServiceImpl(UsersRepository usersRepository, UserService userService)
    {
        this.usersRepository= usersRepository;
        this.userService = userService;

    }

    public static   Point createJTSPoint(double longitude, double latitude)
    {
        GeometryFactory geometryFactory = new GeometryFactory();
        Point point = geometryFactory.createPoint(
                new Coordinate(longitude,latitude)
        );
         point.setSRID(4326);
         return point;
    }

    @Override
    public List<Worker> getWorkersByDistance()
    {
        Users currentUser = userService.getCurrentUser();
       List<Users> workerUsersNearby =  usersRepository.findUsersWithinRadius(
                currentUser.getLongitude(),
                 currentUser.getLatitude(),
                LocationServiceImpl.RADIUS_METERS
       );
       List<Worker> workers = new ArrayList<Worker>();
       for(Users user :workerUsersNearby )
       {
           workers.add(user.getWorker());

       }

        return workers;
    }
}
