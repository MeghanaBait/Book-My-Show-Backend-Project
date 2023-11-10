package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.Dtos.RequestDtos.AddShowRequest;
import com.example.BookMyShow.Dtos.RequestDtos.AddShowSeatReq;
import com.example.BookMyShow.Dtos.ResponseDtos.ShowDetailsResponse;
import com.example.BookMyShow.Dtos.ResponseDtos.ShowResponseForMovie;
import com.example.BookMyShow.Dtos.ResponseDtos.UserDetailsResponse;
import com.example.BookMyShow.Models.Show;
import com.example.BookMyShow.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("show")
public class ShowController {
    @Autowired
    ShowService showService;
    @PostMapping("/add")
    public ResponseEntity addShow(@RequestBody AddShowRequest addShowRequest){
        String result = showService.addShow(addShowRequest);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @PostMapping("/createShowSeats")
    public ResponseEntity enableShowSeats(@RequestBody AddShowSeatReq addShowSeatReq) throws Exception {
        String result = showService.createShowSeats(addShowSeatReq);
        return new ResponseEntity(result,HttpStatus.OK);
    }

    @GetMapping("/most-recommended-movie")
    public ResponseEntity getMovieName(AddShowRequest addShowRequest){
        String result = showService.getMovieName(addShowRequest);
        return new ResponseEntity(result,HttpStatus.OK);
    }

    @GetMapping("/availableSeats/{showId}")
    public ResponseEntity getAvailableShowSeats(@PathVariable("showId") Integer showId){
        try {
            List<String> showSeats = showService.getAvailableShowSeats(showId);
            return new ResponseEntity(showSeats,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{showId}")
    public ResponseEntity getShowDetails(@PathVariable ("showId") Integer showId){
        try{
            ShowDetailsResponse userDetailsResponse = showService.getShowDetails(showId);
            return new ResponseEntity(userDetailsResponse, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{movieId}")
    public ResponseEntity getShowsForAMovieOnAParticularDay(@PathVariable("movieId") Integer movieId, @RequestParam("date")Date date){
        try {
            List<ShowResponseForMovie> showList = showService.getShowsForAMovieOnAParticularDay(movieId,date);
            return new ResponseEntity(showList,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
