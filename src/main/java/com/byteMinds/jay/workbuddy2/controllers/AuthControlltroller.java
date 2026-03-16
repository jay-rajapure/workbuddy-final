package com.byteMinds.jay.workbuddy2.controllers;

import com.byteMinds.jay.workbuddy2.Dto.request.LoginRequest;
import com.byteMinds.jay.workbuddy2.Dto.response.AuthResponse;
import com.byteMinds.jay.workbuddy2.Dto.response.UsersResponse;
import com.byteMinds.jay.workbuddy2.Dto.response.WorkerResponse;
import com.byteMinds.jay.workbuddy2.configs.JwtProvider;
import com.byteMinds.jay.workbuddy2.models.Role;
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
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthControlltroller {
   @Autowired
   private UsersRepository usersRepository;
   @Autowired
    private  CustomerRepository customerRepository;
   @Autowired
    private  PasswordEncoder passwordEncoder;
   @Autowired
   private JwtProvider jwtProvider;


    @PostMapping(value = "/signup",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<AuthResponse> createWorker(@RequestPart("user") String userJSON,
                                              @RequestPart(value = "profilePicture") MultipartFile file) throws Exception
    {

        ObjectMapper objectMapper = new ObjectMapper();
        Users  user  = objectMapper.readValue(userJSON, Users.class);

        String email = user.getEmail();
        Role role = user.getRole();
        String password = user.getPassword();

        Users isUserExists  = usersRepository.findByEmail(email);
        if (isUserExists!=null)
        {
           throw new Exception("User Already Exists ");

        }
        user.setProfilePicture(file.getBytes());
        user.setPassword(passwordEncoder.encode(password));


        Users createdUser  = usersRepository.save(user);
        List<GrantedAuthority>  authorities =new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.toString()));

        Authentication authentication = new UsernamePasswordAuthenticationToken(email,password,authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.generateToken(authentication);

        UsersResponse usersResponse = new UsersResponse(
                user.getName(),
                user.getSurName(),
                user.getEmail(),
                user.getRole(),
                user.getProfilePicture(),
                user.getCreatedAt()
        );

        AuthResponse  authResponse = new AuthResponse();
        authResponse.setJwt(token);
        authResponse.setMessage("successfully created user");

        return  ResponseEntity.status(HttpStatus.CREATED).body( authResponse);

    }

    @PostMapping("/signin/user")
    public  ResponseEntity<AuthResponse > signIn(@RequestBody LoginRequest loginRequest)
    {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();



    }
    








}
