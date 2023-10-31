package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.Dtos.RequestDtos.AddShowRequest;
import com.example.BookMyShow.Dtos.RequestDtos.AddShowSeatReq;
import com.example.BookMyShow.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("show")
public class ShowController {
    @Autowired
    ShowService showService;
    @PostMapping("/add")
    public String addShow(@RequestBody AddShowRequest addShowRequest){
        String result = showService.addShow(addShowRequest);
        return result;
    }

    @PostMapping("/createShowSeats")
    public String enableShowSeats(@RequestBody AddShowSeatReq addShowSeatReq) throws Exception {
        String result = showService.createShowSeats(addShowSeatReq);
        return result;
    }

    @GetMapping("/most-recommended-movie")
    public String getMovieName(AddShowRequest addShowRequest){
        return showService.getMovieName(addShowRequest);
    }


}
