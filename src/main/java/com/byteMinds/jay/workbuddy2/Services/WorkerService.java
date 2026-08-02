package com.byteMinds.jay.workbuddy2.Services;

import com.byteMinds.jay.workbuddy2.models.Users;
import com.byteMinds.jay.workbuddy2.models.Worker;
import com.byteMinds.jay.workbuddy2.repositories.WorkerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {
    private  final WorkerRepository workerRepository;
    private  final  UserService userService;

    public WorkerService(WorkerRepository workerRepository,UserService userService)
    {
        this.workerRepository = workerRepository;
        this.userService = userService;
    }

    public Worker create(Worker worker)
    {
       Users user  =  userService.getCurrentUser();
       if(user == null) throw  new EntityNotFoundException("User for this worker not found");
       worker.setUser(user);
       return workerRepository.save(worker);

    }







}
