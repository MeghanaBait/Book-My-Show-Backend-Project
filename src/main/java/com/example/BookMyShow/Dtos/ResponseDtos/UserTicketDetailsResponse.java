package com.example.BookMyShow.Dtos.ResponseDtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class UserTicketDetailsResponse {
    private String movieName;
    private String theaterName;
    private String location;
    private LocalTime showTime;
    private LocalDate showDate;
    private String bookedSeats;
    private int totalPrice;
}
