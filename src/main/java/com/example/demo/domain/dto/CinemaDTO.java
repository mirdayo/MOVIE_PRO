package com.example.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Time;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaDTO {

    private int cinemaId;
    private String cinemaName;
    private String cinemaLocation;
}
