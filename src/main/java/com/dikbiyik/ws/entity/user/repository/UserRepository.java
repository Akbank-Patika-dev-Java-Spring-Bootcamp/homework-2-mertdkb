package com.dikbiyik.ws.entity.user.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dikbiyik.ws.entity.user.User;

@Primary
public interface UserRepository extends JpaRepository<User, Long>{
    
}
