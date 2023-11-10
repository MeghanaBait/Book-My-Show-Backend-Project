package com.example.BookMyShow.Transformers;

import com.example.BookMyShow.Dtos.ResponseDtos.ShowDetailsResponse;
import com.example.BookMyShow.Dtos.ResponseDtos.ShowResponseForMovie;
import com.example.BookMyShow.Models.Show;
import com.example.BookMyShow.Dtos.RequestDtos.AddShowRequest;

public class ShowTransformers {
    public static Show convertAddRequestToEntity(AddShowRequest addShowRequest){
        Show show = Show.builder()
                .showDate(addShowRequest.getShowDate())
                .showTime(addShowRequest.getShowTime())
                .build();

        return show;
    }

    public static ShowDetailsResponse convertEntityToResponse(Show show) {
        ShowDetailsResponse showDetailsResponse = ShowDetailsResponse.builder()
                .movieDetailsResponse(MovieTransformers.convertMovieToMovieDetailsRepsonse(show.getMovie()))
                .theaterDetailsResponse(TheaterTransformers.convertTheatreToTheatreDetailsResponse(show.getTheater()))
                .showDate(show.getShowDate())
                .showTime(show.getShowTime()).build();

        return showDetailsResponse;
    }

    public static ShowResponseForMovie convertEntityToShowResponseForMovie(Show show){
        ShowResponseForMovie showResponseForMovie = ShowResponseForMovie.builder()
                .showId(show.getId())
                .showTime(show.getShowTime())
                .theaterDetailsResponse(TheaterTransformers.convertTheatreToTheatreDetailsResponse(show.getTheater()))
                .build();
        return showResponseForMovie;
    }
}

