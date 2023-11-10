package com.example.BookMyShow.Dtos.ResponseDtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Setter
@Getter
@Builder

public class ShowResponseForMovie {
    private Integer showId;
    private LocalTime showTime;
    private TheaterDetailsResponse theaterDetailsResponse;

}
