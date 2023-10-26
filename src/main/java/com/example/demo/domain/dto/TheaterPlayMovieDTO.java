package com.example.demo.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.Date;

@Component
@Data
public class TheaterPlayMovieDTO {

    private int theaterPlayMovieId;
    private int theaterId;
    private int playMovieId;
    private String playMovie;
    private Date startDate;
    private Time startTime;
    private Time endTime;
    private int currentSeat;
    private boolean reserveOk;

    private int totalSeats;
}
