package com.example.BookMyShow.Dtos.ResponseDtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDetailsResponse {
    private String name;
    private String email;
    private String mobNo;
    private Integer age;

    private String statusCode;
    private String statusMessage;
}
