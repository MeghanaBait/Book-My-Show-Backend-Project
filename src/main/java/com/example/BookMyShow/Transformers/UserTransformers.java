package com.example.BookMyShow.Transformers;

import com.example.BookMyShow.Dtos.ResponseDtos.UserDetailsResponse;
import com.example.BookMyShow.Models.User;
import com.example.BookMyShow.Dtos.RequestDtos.AddUserRequest;

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

    public static UserDetailsResponse convertUserDetailsResponseTODto(User user){
        UserDetailsResponse userDetailsResponse = UserDetailsResponse.builder()
                .age(user.getAge())
                .name(user.getName())
                .mobNo(user.getMobNo())
                .email(user.getEmail())
                .build();

        return userDetailsResponse;
    }
}
