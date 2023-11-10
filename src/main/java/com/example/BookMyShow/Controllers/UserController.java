package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.Dtos.RequestDtos.AddUserRequest;
import com.example.BookMyShow.Dtos.RequestDtos.UpdateProfileReq;
import com.example.BookMyShow.Dtos.ResponseDtos.UserDetailsResponse;
import com.example.BookMyShow.Dtos.ResponseDtos.UserTicketDetailsResponse;
import com.example.BookMyShow.Models.Ticket;
import com.example.BookMyShow.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody AddUserRequest addUserRequest){
        try{
            String response = userService.addUser(addUserRequest);
            return new ResponseEntity(response, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update-user-profile")
    public ResponseEntity updateUserProfile(@RequestBody UpdateProfileReq updateProfileReq){
        try{
            String result = userService.updateUserProfile(updateProfileReq);
            return new ResponseEntity(result, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity getUserDetails(@PathVariable ("userId") Integer userId){
        try{
            UserDetailsResponse userDetailsResponse = userService.getUserDetails(userId);
            return new ResponseEntity(userDetailsResponse, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Bookings/{userId}")
    public ResponseEntity getUserBookings(@PathVariable("userId") Integer userId){
        try{
            List<UserTicketDetailsResponse> userTicketDetailsResponses = userService.getUserBookings(userId);
            return new ResponseEntity(userTicketDetailsResponses,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{userId}/{ticketId}")
    public ResponseEntity cancelTicketBooking(@PathVariable ("userId") Integer userId, @PathVariable ("ticketId") Integer ticketId){
        try{
            String result = userService.cancelTicketBooking(userId,ticketId);
            return new ResponseEntity(result, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
