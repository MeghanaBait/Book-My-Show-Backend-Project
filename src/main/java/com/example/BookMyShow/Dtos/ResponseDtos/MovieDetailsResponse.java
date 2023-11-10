package com.example.BookMyShow.Dtos.ResponseDtos;

import com.example.BookMyShow.Enum.Genre;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class MovieDetailsResponse {
    private String movieName;
    private double rating;
    private Genre genre;
    private LocalDate releaseDate;
}
