package com.example.BookMyShow.Dtos.ResponseDtos;

import com.example.BookMyShow.Models.Movie;
import com.example.BookMyShow.Models.Theater;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
public class ShowDetailsResponse {
    private LocalDate showDate;
    private LocalTime showTime;
    private MovieDetailsResponse movieDetailsResponse;
    private TheaterDetailsResponse theaterDetailsResponse;

}
