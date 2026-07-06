package com.byteMinds.jay.workbuddy2.controllers;

import com.byteMinds.jay.workbuddy2.Dto.response.SimpleResponse;
import com.byteMinds.jay.workbuddy2.Dto.response.UsersResponse;
import com.byteMinds.jay.workbuddy2.Dto.response.WorkerCreationResponse;
import com.byteMinds.jay.workbuddy2.Services.UserService;
import com.byteMinds.jay.workbuddy2.Services.WorkerService;
import com.byteMinds.jay.workbuddy2.configs.JwtProvider;
import com.byteMinds.jay.workbuddy2.models.Users;
import com.byteMinds.jay.workbuddy2.models.Worker;
import com.byteMinds.jay.workbuddy2.repositories.UsersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/worker")
public class WorkerController {


    private final  WorkerService workerService;

    public WorkerController(UserService userService,
                            WorkerService workerService
                           )
    {
        this.workerService = workerService;

    }

    @PostMapping("/")
    public ResponseEntity<WorkerCreationResponse> createWorker(@RequestBody Worker worker,
                                               @RequestHeader("Authorization") String jwt)
    {


        Worker savedWorker =  this.workerService.create(worker);
        Users user = savedWorker.getUser();

        WorkerCreationResponse workerCreationResponse = getWorkerCreationResponse(user,jwt, savedWorker);

        return  ResponseEntity.status(HttpStatus.CREATED).body(workerCreationResponse);
    }

    private static WorkerCreationResponse getWorkerCreationResponse(Users user,String jwt, Worker savedWorker) {
        SimpleResponse simpleResponse = new SimpleResponse("User Created Successfully", jwt);
        UsersResponse usersResponse = new UsersResponse(
                user.getName(),
                user.getSurName(),
                user.getEmail(),
                user.getRole(),
                user.getProfilePicture(),
                user.getCreatedAt());
        WorkerCreationResponse workerCreationResponse = new WorkerCreationResponse();
        workerCreationResponse.setDescription(savedWorker.getDescription());
        workerCreationResponse.setExperienceYears(savedWorker.getExperienceYears());
        workerCreationResponse.setWorkCategory(savedWorker.getWorkCategory());
        workerCreationResponse.setSimpleResponse(simpleResponse);
        workerCreationResponse.setUsersResponse(usersResponse);
        return workerCreationResponse;
    }


}
