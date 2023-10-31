package com.example.BookMyShow.Dtos.RequestDtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class AddUserRequest {
    //DTO is a class wich contains customized parameters as per our need. this is used for security purpose
    //2.DTOs are light weight classes: t
    //request will have only parameters which we will enter through postman as parameters
    //FK and PK should not be added
    private String name;
    private String email;
    private String mobNo;
    private Integer age;
    private String password;
}
