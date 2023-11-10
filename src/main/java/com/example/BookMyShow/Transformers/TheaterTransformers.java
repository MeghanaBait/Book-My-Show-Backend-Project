package com.example.BookMyShow.Transformers;

import com.example.BookMyShow.Dtos.ResponseDtos.TheaterDetailsResponse;
import com.example.BookMyShow.Models.Theater;
import com.example.BookMyShow.Dtos.RequestDtos.AddTheaterRequest;

public class TheaterTransformers {
    public static Theater convertAddTheaterReqToTheaterEntity(AddTheaterRequest addTheaterRequest){
        Theater theater = Theater.builder()
                .name(addTheaterRequest.getName())
                .address(addTheaterRequest.getAddress())
                .city(addTheaterRequest.getCity())
                .build();

        return theater;

    }

    public static TheaterDetailsResponse convertTheatreToTheatreDetailsResponse(Theater theater){
        TheaterDetailsResponse theaterDetailsResponse = TheaterDetailsResponse.builder()
                .name(theater.getName())
                .address(theater.getAddress())
                .city(theater.getCity())
                .build();

        return theaterDetailsResponse;
    }
}

