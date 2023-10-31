package com.example.BookMyShow.Services;

import com.example.BookMyShow.Enum.SeatType;
import com.example.BookMyShow.Models.Theater;
import com.example.BookMyShow.Models.TheaterSeat;
import com.example.BookMyShow.Repository.TheaterRepository;
import com.example.BookMyShow.Dtos.RequestDtos.AddTheaterRequest;
import com.example.BookMyShow.Transformers.TheaterTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TheaterService {

    @Autowired
    TheaterRepository theaterRepository;
    public String addTheater(AddTheaterRequest addTheaterRequest) {
        //1.Create the theater Entity
        Theater theater = TheaterTransformers.convertAddTheaterReqToTheaterEntity(addTheaterRequest);


        //2. Create the theater seats Entity
        createTheaterSeats(theater, addTheaterRequest);
        return "Theater has been added to the DB";
    }

    private void createTheaterSeats(Theater theater, AddTheaterRequest addTheaterRequest) {

        int noOfClassicSeats = addTheaterRequest.getNoOfClassicSeats();
        int noOfPremiumSeats = addTheaterRequest.getNoOfPremiumSeats();
        int seatsPerRow = addTheaterRequest.getNoOfSeatPerRow();

        //Create the classic seat entities
        List<TheaterSeat> theaterSeatList = new ArrayList<>();

        int row = 0;
        char ch = 'A';
        for(int i = 1; i <= noOfClassicSeats; i++){
            if(i % seatsPerRow == 1){
                row++;
                ch = 'A';
            }
            String seatNo = row +""+ch;
            ch++;

            TheaterSeat theaterSeat = TheaterSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.CLASSIC)
                    .theater(theater)//setting the FK
                    .build();

            theaterSeatList.add(theaterSeat);
        }

        //Similar numbering for premium Seats

        ch = 'A';
        for (int i = 1; i <= noOfPremiumSeats; i++){
            if(i % seatsPerRow == 1){
                row++;
                ch = 'A';
            }
            String seatNo = row+""+ch;
            ch++;

            TheaterSeat theaterSeat = TheaterSeat.builder()
                    .seatType(SeatType.PREMIUM)
                    .seatNo(seatNo)
                    .theater(theater)
                    .build();

            theaterSeatList.add(theaterSeat);
        }

        theater.setTheaterSeatList(theaterSeatList);

        theaterRepository.save(theater);

    }
}
