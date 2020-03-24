package com.example.myfirstspringproject.security.details;

import com.example.myfirstspringproject.models.User;
import com.example.myfirstspringproject.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service(value = "customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    UsersRepository usersRepository;



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOptional = usersRepository.findUserByEmail(email);
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            return new UserDetailsImpl(user);
        }
        throw new UsernameNotFoundException("User not found");
    }
}
