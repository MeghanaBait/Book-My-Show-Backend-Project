package com.example.BookMyShow.Models;

import com.example.BookMyShow.Enum.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Show_seats")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showSeatId;

    private String showSeatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private Boolean isAvailable;

    private Boolean isFoodAttached;

    private int price;

    //child
    @ManyToOne
    @JoinColumn
    private Show show;


}
