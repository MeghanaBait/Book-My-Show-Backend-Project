package com.example.BookMyShow.Services;

import com.example.BookMyShow.Dtos.RequestDtos.AddShowSeatReq;
import com.example.BookMyShow.Enum.SeatType;
import com.example.BookMyShow.Exceptions.ShowNotFound;
import com.example.BookMyShow.Models.*;
import com.example.BookMyShow.Repository.MovieRepository;
import com.example.BookMyShow.Repository.ShowRepository;
import com.example.BookMyShow.Repository.ShowSeatRepository;
import com.example.BookMyShow.Repository.TheaterRepository;
import com.example.BookMyShow.Dtos.RequestDtos.AddShowRequest;
import com.example.BookMyShow.Transformers.ShowTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;

    public String addShow(AddShowRequest addShowRequest){

        //Goal is to set the attributes of the Show Entity and save it to db.

        Show show = ShowTransformers.convertAddRequestToEntity(addShowRequest);

        //fk entities
        Movie movie = movieRepository.findMovieByMovieName(addShowRequest.getMovieName());

        Optional<Theater> optionalTheater = theaterRepository.findById(addShowRequest.getTheaterId());
        Theater theater = optionalTheater.get();

        //Setting the FK values
        show.setMovie(movie);
        show.setTheater(theater);

        //Setting the bidirectional mapping
        theater.getShowList().add(show);
        movie.getShowList().add(show);

        //saving child entity so instead of saving 2 times as 2 parent entities ae there
        show = showRepository.save(show);

        return "Show has been saved to the DB with showId "+show.getId();

    }

    public String createShowSeats(AddShowSeatReq addShowSeatReq) throws Exception {


        //I need to create the show Seats and save to the DB.

        Optional<Show> optionalShow = showRepository.findById(addShowSeatReq.getShowId());

        //Validation check
        if(!optionalShow.isPresent()){
            throw new ShowNotFound("Invalid show ID");
        }

        //valid show
        Show show = optionalShow.get();

        //get theater seats
        Theater theater = show.getTheater();
        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();

        //Each seat needs to be added in
        List<ShowSeat> showSeatList = show.getShowSeatList();

        for(TheaterSeat theaterSeat : theaterSeatList){
            ShowSeat showSeat = ShowSeat.builder()
                    .showSeatNo(theaterSeat.getSeatNo())
                    .seatType(theaterSeat.getSeatType())
                    .isAvailable(true)
                    .isFoodAttached(false)
                    .show(show)
                    .build();

            if(theaterSeat.getSeatType().equals(SeatType.CLASSIC)){
                showSeat.setPrice(addShowSeatReq.getPriceForClassicSeats());
            }else{
                showSeat.setPrice(addShowSeatReq.getPriceForPremiumSeats());
            }

            showSeatList.add(showSeat);
        }

        show.setShowSeatList(showSeatList);

        // Eirher dave parent or save child
        //child is list if of seats - can be saved in list format

        showRepository.save(show);


        return "Show seats has been added successfully";
    }

    public String getMovieName(AddShowRequest addShowRequest) {
        Integer movieId = showRepository.getMostShowedMovie(addShowRequest.getShowDate());

        Movie movie = movieRepository.findById(movieId).get();

        return movie.getMovieName();
    }
}