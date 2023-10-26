package com.example.BookMyShow.Transformers;

import com.example.BookMyShow.Models.User;
import com.example.BookMyShow.RequestDtos.AddUserRequest;

public class UserTransformers {

    public static User convertAddUserRequestToUserEntity(AddUserRequest addUserRequest){
        User userobj = User.builder()
                .age(addUserRequest.getAge())
                .email(addUserRequest.getEmail())
                .mobNo(addUserRequest.getMobNo())
                .name(addUserRequest.getName())
                .password(addUserRequest.getPassword())
                .build();

        return userobj;
    }
}
