package com.example.BookMyShow.Services;

import com.example.BookMyShow.Dtos.RequestDtos.AddTicketReq;
import com.example.BookMyShow.Exceptions.SeatNotAvailable;
import com.example.BookMyShow.Models.*;
import com.example.BookMyShow.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;


    public String bookTicket(AddTicketReq addTicketReq) throws Exception {
        Show show = findRightShow(addTicketReq);

        List<ShowSeat> showSeatList = show.getShowSeatList();
        int totalPrice = 0;

        User user = userRepository.findById(addTicketReq.getUserId()).get();


        for(ShowSeat showSeat : showSeatList){
            //mark requested seats unavailable in show seats
            //Calculate total price
            // Add as booked seats against user entity
            if(addTicketReq.getRequestedSeatNos().contains(showSeat.getShowSeatNo())){
                if(showSeat.getIsAvailable()){
                    showSeat.setIsAvailable(false);
                    totalPrice = totalPrice + showSeat.getPrice();
                }else{
                    throw new SeatNotAvailable(showSeat.getShowSeatNo()+" is already booked");
                }
            }
        }

        Ticket ticket = Ticket.builder()
                .movieName(show.getMovie().getMovieName())
                .theaterAddress(show.getTheater().getAddress())
                .showTime(show.getShowTime())
                .showDate(show.getShowDate())
                .bookedSeats(addTicketReq.getRequestedSeatNos().toString())
                .totalPrice(totalPrice)
                .user(user)
                .show(show)
                .build();

        show.getTicketList().add(ticket);
        user.getTicketList().add(ticket);

        ticketRepository.save(ticket);

        return "Ticket has been booked";
    }

    private Show findRightShow(AddTicketReq addTicketReq){
        Movie movie = movieRepository.findMovieByMovieName(addTicketReq.getMovieName());

        Theater theater = theaterRepository.findById(addTicketReq.getTheaterId()).get();

        Show show = showRepository.findShowByShowDateAndShowTimeAndMovieAndTheater(addTicketReq.getShowDate(),addTicketReq.getShowTime(),movie, theater);

        return show;
    }
}
