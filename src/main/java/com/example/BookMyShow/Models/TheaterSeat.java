package com.example.BookMyShow.Models;

import com.example.BookMyShow.Enum.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "theater_seat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TheaterSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn
    private Theater theater;
}
