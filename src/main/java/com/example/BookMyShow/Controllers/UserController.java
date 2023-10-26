package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.Models.User;
import com.example.BookMyShow.RequestDtos.AddUserRequest;
import com.example.BookMyShow.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody AddUserRequest addUserRequest){
        String response = userService.addUser(addUserRequest);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}
