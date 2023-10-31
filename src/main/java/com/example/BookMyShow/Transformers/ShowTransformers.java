package com.example.BookMyShow.Transformers;

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
}
