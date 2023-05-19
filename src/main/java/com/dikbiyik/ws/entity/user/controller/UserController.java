package com.dikbiyik.ws.entity.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dikbiyik.ws.entity.user.dto.DeleteUserRequestDto;
import com.dikbiyik.ws.entity.user.dto.UpdateUserRequestDto;
import com.dikbiyik.ws.entity.user.dto.UserSaveRequestDto;
import com.dikbiyik.ws.entity.user.service.AppUserService;
import com.dikbiyik.ws.generic.rest.GenericApiResponse;

@RestController
@RequestMapping("/api/v1.0/users")
public class UserController {
    
    @Autowired
    private AppUserService userService;

    @PostMapping
    public GenericApiResponse saveUser(@RequestBody UserSaveRequestDto userSaveDtoRequest){
        return new GenericApiResponse(200, "Success", "654488964513", userService.save(userSaveDtoRequest));
    }

    @GetMapping("/all")
    public GenericApiResponse getAllUsers(){
        return new GenericApiResponse(200, "Success", "516816", userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public GenericApiResponse getUserById(@PathVariable Long id){
        return new GenericApiResponse(200, "Success", "62618413", userService.getUserById(id));
    }
    
    @GetMapping
    public GenericApiResponse getUserByUsername(@RequestParam String username){
        return new GenericApiResponse(200, "Success", "516816", userService.getUserByUsername(username));
    }

    @PutMapping("/{id}")
    public GenericApiResponse updateUser(@PathVariable Long id, @RequestBody UpdateUserRequestDto updateUserRequestDto){
        return new GenericApiResponse(200, "Success", "1658435", userService.updateUser(id, updateUserRequestDto));
    }

    @DeleteMapping
    public GenericApiResponse deleteUser(@RequestBody DeleteUserRequestDto deleteUserRequestDto){
        userService.deleteUser(deleteUserRequestDto);
        return new GenericApiResponse(200, "Success", "2186435413");
    }

}
