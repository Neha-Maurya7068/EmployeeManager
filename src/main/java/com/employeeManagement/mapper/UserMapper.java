package com.employeeManagement.mapper;

import com.employeeManagement.dto.UserDto;
import com.employeeManagement.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    //Convert User JPA Entity into UserDto

    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDto;
    }
        //convert UserDto into User JPA Entity
        public static User mapToUser(UserDto userDto){
        User user=new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        return  user;

        }

    }

