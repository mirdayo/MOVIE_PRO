package com.example.demo.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TheaterDTO {

    private int theaterId;
    private int cinemaId;
    private String theaterName;
    private int totalSeats;

}
