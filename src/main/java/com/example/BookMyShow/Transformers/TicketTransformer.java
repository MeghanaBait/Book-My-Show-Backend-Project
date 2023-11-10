package com.example.BookMyShow.Transformers;

import com.example.BookMyShow.Dtos.ResponseDtos.UserTicketDetailsResponse;
import com.example.BookMyShow.Models.Ticket;

public class TicketTransformer {

    public static UserTicketDetailsResponse convertEntityTOResponse(Ticket ticket){
        UserTicketDetailsResponse userTicketDetailsResponse = UserTicketDetailsResponse.builder().
                movieName(ticket.getMovieName())
                .theaterName(ticket.getMovieName())
                .theaterAddress(ticket.getTheaterAddress())
                .showDate(ticket.getShowDate())
                .showTime(ticket.getShowTime())
                .bookedSeats(ticket.getBookedSeats())
                .totalPrice(ticket.getTotalPrice()).build();

        return userTicketDetailsResponse;
    }

}
