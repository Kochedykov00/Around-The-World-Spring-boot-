package com.example.myfirstspringproject.repositories;


import com.example.myfirstspringproject.models.CookieValue;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CookieValuesRepository extends JpaRepository<CookieValue, Long> {
    CookieValue findByValue(String value);
}

