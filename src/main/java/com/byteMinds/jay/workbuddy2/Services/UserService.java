package com.byteMinds.jay.workbuddy2.Services;

import com.byteMinds.jay.workbuddy2.models.Users;
import com.byteMinds.jay.workbuddy2.repositories.UsersRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

   private  final UsersRepository usersRepository;
   public  UserService(UsersRepository usersRepository)
   {
    this.usersRepository = usersRepository;
   }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user =  usersRepository.findByEmail(email);
        if(user==null) throw  new UsernameNotFoundException("User with email:"+ email+"not found");
        List<GrantedAuthority> authorities = new ArrayList<>();

        return  new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return List.of(new SimpleGrantedAuthority(user.getRole().toString()));
            }

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            @Override
            public String getUsername() {
                return  user.getEmail();
            }
        };


    }

}
