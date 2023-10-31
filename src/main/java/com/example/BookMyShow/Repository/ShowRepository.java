package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Models.Movie;
import com.example.BookMyShow.Models.Show;
import com.example.BookMyShow.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ShowRepository extends JpaRepository<Show,Integer> {
    Show findShowByShowDateAndShowTimeAndMovieAndTheater(LocalDate showDate, LocalTime showTime, Movie movie, Theater theater);

    @Query(value = "select movie_id from shows group by movie_id order by count(*) desc limit 1;",nativeQuery = true)
    Integer getMostShowedMovie(LocalDate showDate);
}
