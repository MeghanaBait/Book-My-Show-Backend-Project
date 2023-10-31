package com.example.BookMyShow.Dtos.RequestDtos;

import com.example.BookMyShow.Enum.Genre;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
@Getter
@Setter
public class AddMovieRequest {
    private String movieName;
    private Double rating;
    private Genre genre;
    private LocalDate releaseDate;
}
