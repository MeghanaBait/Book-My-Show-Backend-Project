package com.example.BookMyShow.Dtos.RequestDtos;

import com.example.BookMyShow.Enum.City;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddTheaterRequest {
    public String name;
    private String address;
    private City city;

    private Integer noOfClassicSeats;
    private Integer noOfPremiumSeats;
    private Integer noOfSeatPerRow;

}
