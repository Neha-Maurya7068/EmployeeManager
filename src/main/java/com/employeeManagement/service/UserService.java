package com.employeeManagement.service;

import com.employeeManagement.dto.UserDto;
import com.employeeManagement.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long userId);

     List<UserDto> getAllUser();

     UserDto updateUser(UserDto user);

     void deleteUser(Long userId);


}
