package com.employeeManagement.controller;

import com.employeeManagement.dto.UserDto;
import com.employeeManagement.entity.User;
import com.employeeManagement.exception.ErrorDetails;
import com.employeeManagement.exception.ResourceNotFoundException;
import com.employeeManagement.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserService userService;
@PostMapping
    public ResponseEntity<UserDto>createUser(@Valid @RequestBody UserDto user){
        UserDto user1 = userService.createUser(user);

    return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<UserDto>getUserId(@PathVariable("id") Long userId){
        UserDto user = userService.getUserById(userId);
        return  new ResponseEntity<>(user,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<UserDto>>getAllUsers(){
        List<UserDto> allUser =
                userService.getAllUser();
    return new ResponseEntity<>(allUser,HttpStatus.OK);
}

@PutMapping("{id}")
public ResponseEntity<UserDto>updateUser(@PathVariable("id") Long userId,@RequestBody  @Valid UserDto user){
    user.setId(userId);
    UserDto user1 = userService.updateUser(user);
    return  new ResponseEntity<>(user1,HttpStatus.OK);
}
@DeleteMapping("{id}")
public ResponseEntity<String>deleteUser(@PathVariable("id") Long userId){
    userService.deleteUser(userId);
    return  new ResponseEntity<>("User deleted Successfully",HttpStatus.OK);
}


}
