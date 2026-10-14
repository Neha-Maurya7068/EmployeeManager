package com.employeeManagement.exception;

import lombok.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ErrorDetails {
private LocalDateTime timestamp;
private String message;
private String path;
private String errorCode;

}
