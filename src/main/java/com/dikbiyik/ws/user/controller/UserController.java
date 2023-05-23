package com.dikbiyik.ws.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dikbiyik.ws.user.controller.contract.UserControllerContract;
import com.dikbiyik.ws.user.dto.DeleteUserRequestDto;
import com.dikbiyik.ws.user.dto.GetUserResponseDto;
import com.dikbiyik.ws.user.dto.UpdateUserRequestDto;
import com.dikbiyik.ws.user.dto.UpdateUserResponseDto;
import com.dikbiyik.ws.user.dto.UserSaveRequestDto;
import com.dikbiyik.ws.user.dto.UserSaveResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1.0/users")
@RequiredArgsConstructor
public class UserController {
    
    private final UserControllerContract userControllerContract;

    @PostMapping
    public ResponseEntity<UserSaveResponseDto> saveUser(@RequestBody UserSaveRequestDto userSaveDtoRequest){
        UserSaveResponseDto response = userControllerContract.saveUser(userSaveDtoRequest);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GetUserResponseDto>> getAllUsers(){
        List<GetUserResponseDto> response = userControllerContract.getAllUsers();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUserResponseDto> getUserById(@PathVariable Long id){
        GetUserResponseDto response = userControllerContract.getUserById(id);
        return ResponseEntity.ok().body(response);
    }
    
    @GetMapping
    public ResponseEntity<GetUserResponseDto> getUserByUsername(@RequestParam String username){
        GetUserResponseDto response = userControllerContract.getUserByUsername(username);
        return ResponseEntity.ok().body(response);

    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateUserResponseDto> updateUser(@PathVariable Long id, @RequestBody UpdateUserRequestDto updateUserRequestDto){
        UpdateUserResponseDto response = userControllerContract.updateUser(id, updateUserRequestDto);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestBody DeleteUserRequestDto deleteUserRequestDto){
        userControllerContract.deleteUser(deleteUserRequestDto);
        return ResponseEntity.ok().body("User deleted");
    }

}
