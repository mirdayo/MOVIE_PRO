package com.example.demo.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;

@Component
@Data
public class ReserveDTO {

    private int reserveId;
    private String userId;
    private int theaterPlayMovieId;
    private String movieName;
    private Date reserveDate;
    private Date startDate;
    private Time startTime;
    private Time endTime;
    private String selectSeat;
    private int selectSeatNum;
    private int priceTotal;

}
