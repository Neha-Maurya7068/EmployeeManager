package com.employeeManagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.stereotype.Service;


public class UserDto {
    private Long id;
    //User first name should not be null or empty
    @NotEmpty(message = "User first name should not be null or empty")

    private String firstName;
   //User last name should not ne null and empty
   @NotEmpty(message = "User last name should not be null or empty")
    private String lastName;
    //User email should not be null or empty
    //email address should be valida
    @NotEmpty(message = "User email should not be null or empty")
    @Email
    private String email;

    public UserDto() {
    }

    public UserDto(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}