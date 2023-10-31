package com.example.BookMyShow.Dtos.RequestDtos;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@Getter
@Setter
public class AddTicketReq {
    private String movieName;
    private Integer theaterId;
    private Integer userId;
    private LocalDate showDate;
    private LocalTime showTime;
    private List<String> requestedSeatNos;
}
