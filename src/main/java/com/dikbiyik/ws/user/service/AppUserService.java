package com.dikbiyik.ws.user.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dikbiyik.ws.base.BaseAdditionalFields;
import com.dikbiyik.ws.base.service.BaseService;
import com.dikbiyik.ws.user.User;
import com.dikbiyik.ws.user.repository.UserRepository;

@Service
public class AppUserService extends BaseService<User, UserRepository> {
    private final UserRepository userRepository;
    
    public AppUserService(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    public User updateUser(Long id, User user) {

        User userInDB = this.findByIdWithControl(id);
        BaseAdditionalFields baseAdditionalFields = user.getBaseAdditionalFields();

        if (baseAdditionalFields == null) {
            baseAdditionalFields = updateBaseAdditionalFields();
        }

        userInDB.setBaseAdditionalFields(baseAdditionalFields);
        userInDB.setId(id);
        userInDB.setUsername(user.getUsername());
        userInDB.setPassword(user.getPassword());
        userInDB.setEmail(user.getEmail());
        userInDB.setPhoneNumber(user.getPhoneNumber());
        userInDB.setUserType(user.getUserType());
        
        super.save(userInDB);

        return userInDB;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findByUsernameAndPhoneNumber(String username, String phoneNumber) {
        return userRepository.findByUsernameAndPhoneNumber(username, phoneNumber);
    }

    
}