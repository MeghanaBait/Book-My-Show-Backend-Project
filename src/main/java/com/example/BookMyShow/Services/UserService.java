package com.example.BookMyShow.Services;

import com.example.BookMyShow.Models.User;
import com.example.BookMyShow.Repository.UserRepository;
import com.example.BookMyShow.RequestDtos.AddUserRequest;
import com.example.BookMyShow.Transformers.UserTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public String addUser(AddUserRequest addUserRequest ) {
       // User user = new User();
//        user.setAge(addUserRequest.getAge());
//        user.setEmail(addUserRequest.getEmail());
//        user.setName(addUserRequest.getName());
//        user.setPassword(addUserRequest.getPassword());
//        user.setMobNo(addUserRequest.getMobNo());

        //@builder used to create object
        //Allargsconstructor is mandatory for builder constructor as it use constructor to assign values

        User userObj = UserTransformers.convertAddUserRequestToUserEntity(addUserRequest);

        userRepository.save(userObj);

        return "User added successfully";
    }
}
