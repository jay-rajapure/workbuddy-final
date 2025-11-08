package com.byteMinds.jay.workbuddy2.controllers;

import com.byteMinds.jay.workbuddy2.models.Customer;
import com.byteMinds.jay.workbuddy2.models.Users;
import com.byteMinds.jay.workbuddy2.models.Worker;
import com.byteMinds.jay.workbuddy2.repositories.CustomerRepository;
import com.byteMinds.jay.workbuddy2.repositories.UsersRepository;
import com.byteMinds.jay.workbuddy2.repositories.WorkerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/auth")
public class AuthControlltroller {
   @Autowired
    WorkerRepository workerRepository;

   @Autowired
    CustomerRepository customerRepository;




    @PostMapping(value = "/signup/worker",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Users> createWorker(@RequestPart("worker") String workerJSON,
                                              @RequestPart(value = "profilePicture") MultipartFile file) throws Exception
    {
        ObjectMapper objectMapper = new ObjectMapper();
        Worker worker = objectMapper.readValue(workerJSON, Worker.class);
        Worker isWorkerExists  = workerRepository.findByEmail(worker.getEmail());
        if (isWorkerExists!=null)
        {
           throw new Exception("User Already Exists ");

        }
        worker.setProfilePicture(file.getBytes());

        Worker createdWorker  = workerRepository.save(worker);

        return  ResponseEntity.status(HttpStatus.CREATED).body(createdWorker);

    }



}
