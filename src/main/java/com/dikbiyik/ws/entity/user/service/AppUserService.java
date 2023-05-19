package com.dikbiyik.ws.entity.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dikbiyik.ws.base.service.BaseService;
import com.dikbiyik.ws.entity.user.User;
import com.dikbiyik.ws.entity.user.dto.DeleteUserRequestDto;
import com.dikbiyik.ws.entity.user.dto.GetUserResponseDto;
import com.dikbiyik.ws.entity.user.dto.UpdateUserRequestDto;
import com.dikbiyik.ws.entity.user.dto.UpdateUserResponseDto;
import com.dikbiyik.ws.entity.user.dto.UserSaveRequestDto;
import com.dikbiyik.ws.entity.user.dto.UserSaveResponseDto;
import com.dikbiyik.ws.entity.user.mapper.UserMapper;
import com.dikbiyik.ws.entity.user.repository.UserRepository;

@Service
public class AppUserService extends BaseService<User, UserRepository> {

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    public AppUserService(UserMapper userMapper, UserRepository userRepository) {
        super(userRepository);
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public UserSaveResponseDto save(UserSaveRequestDto userSaveDtoRequest) {
        return userMapper.userToUserSaveDtoResponse(this.save(userMapper.userSaveRequestDtoToUser(userSaveDtoRequest)));
    }

    public GetUserResponseDto getUserById(Long id) {
        return userMapper.userToGetUserResponseDto(this.findByIdWithControl(id));
    }

    public GetUserResponseDto getUserByUsername(String username) {
        return userMapper.userToGetUserResponseDto(userRepository.findByUsername(username));
    }

    public List<GetUserResponseDto> getAllUsers() {
        return userMapper.usersToGetUserDtoResponses(this.findAll());
    }

    public UpdateUserResponseDto updateUser(Long id, UpdateUserRequestDto updateUserRequestDto) {
        User user = this.findByIdWithControl(id);
        user = userMapper.updateUserRequestDtoToUser(updateUserRequestDto);
        user.setId(id);
        user.setBaseAdditionalFields(updateBaseAdditionalFields());
        userRepository.save(user);

        return userMapper.userToUpdateUserResponseDto(user);
    }

    public void deleteUser(DeleteUserRequestDto userRequestDto) {

        User userInDb = userRepository.findByUsernameAndPhoneNumber(userRequestDto.username(),
                userRequestDto.phoneNumber());
        this.delete(userInDb);
    }

}