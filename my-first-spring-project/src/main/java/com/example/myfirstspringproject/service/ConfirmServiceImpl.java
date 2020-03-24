package com.example.myfirstspringproject.service;

import com.example.myfirstspringproject.models.State;
import com.example.myfirstspringproject.models.User;
import com.example.myfirstspringproject.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

    @Service
    public class ConfirmServiceImpl implements ConfirmService {

        @Autowired
        private UsersRepository usersRepository;

        @Override
        public boolean confirm(String confirmCode) {
            Optional<User> userOptional = usersRepository.findByConfirmCode(confirmCode);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                user.setState(State.CONFIRMED);
                usersRepository.save(user);
                return true;
            }
            return false;
        }
    }


