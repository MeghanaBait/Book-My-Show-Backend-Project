package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.Dtos.RequestDtos.AddTheaterRequest;
import com.example.BookMyShow.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @PostMapping("/add")
    public ResponseEntity addTheater(@RequestBody AddTheaterRequest addTheaterRequest){
        try{
            String result = theaterService.addTheater(addTheaterRequest);
            return new ResponseEntity(result, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/revenue/{theaterId}")
    public ResponseEntity getTotalRevenue(@PathVariable("theaterId") Integer theaterId){
        try {
            Long revenue = theaterService.getTotalRevenue(theaterId);
            return new ResponseEntity(revenue,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
