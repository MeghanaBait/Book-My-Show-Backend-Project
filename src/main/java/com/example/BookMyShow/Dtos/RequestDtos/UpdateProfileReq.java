package com.example.BookMyShow.Dtos.RequestDtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProfileReq {
    private Integer userId;
    private String updatedName;
    private String updatedEmail;
    private String updatedMobNo;
    private Integer updatedAge;
    private String updatedPassword;
}
