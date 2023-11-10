package com.example.BookMyShow.Transformers;

import com.example.BookMyShow.Dtos.ResponseDtos.MovieDetailsResponse;
import com.example.BookMyShow.Models.Movie;
import com.example.BookMyShow.Dtos.RequestDtos.AddMovieRequest;

public class MovieTransformers {
    public static Movie convertAddMovieReqToMovie(AddMovieRequest addMovieRequest){
        Movie movie = Movie.builder()
                .movieName(addMovieRequest.getMovieName())
                .genre(addMovieRequest.getGenre())
                .releaseDate(addMovieRequest.getReleaseDate())
                .rating(addMovieRequest.getRating())
                .build();

        return movie;
    }

    public static MovieDetailsResponse convertMovieToMovieDetailsRepsonse(Movie movie){
        MovieDetailsResponse movieDetailsResponse = MovieDetailsResponse.builder()
                .movieName(movie.getMovieName())
                .genre((movie.getGenre()))
                .rating(movie.getRating())
                .releaseDate(movie.getReleaseDate())
                .build();

        return movieDetailsResponse;
    }
}
