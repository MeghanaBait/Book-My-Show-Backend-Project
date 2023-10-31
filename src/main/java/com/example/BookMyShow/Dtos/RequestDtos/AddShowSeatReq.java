package com.example.BookMyShow.Dtos.RequestDtos;

import lombok.Data;

@Data
public class AddShowSeatReq {
    private int showId;
    private int priceForClassicSeats;
    private int priceForPremiumSeats;
}
