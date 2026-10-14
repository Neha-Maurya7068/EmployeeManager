package com.employeeManagement.service.Impl;

import com.employeeManagement.dto.UserDto;
import com.employeeManagement.entity.User;
import com.employeeManagement.exception.ResourceNotFoundException;
import com.employeeManagement.mapper.UserMapper;
import com.employeeManagement.repository.UserRepository;
import com.employeeManagement.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class UserServiceImpl implements UserService {
@Autowired
    private UserRepository userRepository;
@Autowired
    private final UserMapper userMapper;
@Autowired
private ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.modelMapper = modelMapper;
    }

    //post
    @Override
    public UserDto createUser(UserDto userDto) {
        //convert UserDto into User JPA Entity

      //  User user= UserMapper.mapToUser(userDto);
        //User savedUser=userRepository.save(user);
        //convert User JPA entity to UserDto

    //UserDto  savedUserDto=userMapper.mapToUserDto(savedUser);

        User user=modelMapper.map(userDto,User.class);
        User savedUser=userRepository.save(user);

        UserDto savedUserDto=modelMapper.map(savedUser,UserDto.class);
        return  savedUserDto;

    }

    @Override
    public UserDto getUserById(Long userId) {
     User user=userRepository.findById(userId).orElseThrow(
             ()->new ResourceNotFoundException("User","id",userId)
     );
     return  modelMapper.map(user,UserDto.class);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User>users=userRepository.findAll();

        //  return  users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    return  users.stream().map((user)->modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {

        User existinguser = userRepository.findById(user.getId()).orElseThrow(
                ()->new ResourceNotFoundException("User","id",user.getId())
        );
        existinguser.setFirstName(user.getFirstName());
        existinguser.setLastName(user.getLastName());
        existinguser.setEmail(user.getEmail());
        User save = userRepository.save(existinguser);
        return modelMapper.map(save,UserDto.class);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
