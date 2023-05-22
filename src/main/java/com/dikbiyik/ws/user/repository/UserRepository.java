package com.dikbiyik.ws.user.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.dikbiyik.ws.user.User;


public interface UserRepository extends JpaRepository<User, Long>{
    
    @Query(
        "select user from Appuser user where user.username = :username "
    )
    User findByUsername(@Param("username")String username);

    @Query("SELECT user FROM Appuser user WHERE user.username = :username AND user.phoneNumber = :phoneNumber")
    User findByUsernameAndPhoneNumber(@Param("username")String username, @Param("phoneNumber") String phoneNumber);
}
