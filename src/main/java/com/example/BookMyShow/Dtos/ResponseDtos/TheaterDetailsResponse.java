package com.example.BookMyShow.Dtos.ResponseDtos;

import com.example.BookMyShow.Enum.City;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TheaterDetailsResponse {
    private String name;
    private String address;
    private City city;
}
