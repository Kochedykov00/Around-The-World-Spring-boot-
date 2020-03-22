package com.example.myfirstspringproject.repositories;

import com.example.myfirstspringproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UsersRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    List<User> findAllByUsernameContainsIgnoreCase(String username);
    Optional<User> findByConfirmCode(String confirmCode);
    Optional<User> findUserByEmail(String email);

}

