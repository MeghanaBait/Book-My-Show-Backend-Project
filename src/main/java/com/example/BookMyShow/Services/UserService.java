package com.example.BookMyShow.Services;

import com.example.BookMyShow.Dtos.ResponseDtos.UserDetailsResponse;
import com.example.BookMyShow.Dtos.ResponseDtos.UserTicketDetailsResponse;
import com.example.BookMyShow.Exceptions.InvalidUserId;
import com.example.BookMyShow.Models.Ticket;
import com.example.BookMyShow.Models.User;
import com.example.BookMyShow.Repository.TicketRepository;
import com.example.BookMyShow.Repository.UserRepository;
import com.example.BookMyShow.Dtos.RequestDtos.AddUserRequest;
import com.example.BookMyShow.Dtos.RequestDtos.UpdateProfileReq;
import com.example.BookMyShow.Transformers.TicketTransformer;
import com.example.BookMyShow.Transformers.UserTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TicketRepository ticketRepository;

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

    public String updateUserProfile(UpdateProfileReq updateProfileReq) {
        return "";
    }


    public UserDetailsResponse getUserDetails(Integer userId) throws Exception {
        List<User> users = userRepository.findAll();
        User user1 = null;
        for(User user : users){
            if(user.getId().equals(userId)){
                user1 = user;
            }
        }

        if(user1 == null){
            throw new InvalidUserId("No user Found");
        }

        //transform Entity into DTO
        UserDetailsResponse userDetailsResponse = UserTransformers.convertUserDetailsResponseTODto(user1);
        return userDetailsResponse;
    }

    public String cancelTicketBooking(Integer userId, Integer ticketId) {
        return "";
    }

    public List<UserTicketDetailsResponse> getUserBookings(Integer userId) throws Exception {
        Optional<User> optionalUser = userRepository.findById(userId);

        if(!optionalUser.isPresent()){
            throw new InvalidUserId("User id is invalid");
        }

        User user = optionalUser.get();

        List<Ticket> ticketList= user.getTicketList();
        List<UserTicketDetailsResponse> userTicketDetailsResponses = new ArrayList<>();

        for(Ticket ticket : ticketList){
            UserTicketDetailsResponse userTicketDetailsResponse = TicketTransformer.convertEntityTOResponse(ticket);
            userTicketDetailsResponses.add(userTicketDetailsResponse);
        }
        return userTicketDetailsResponses;
    }
}
