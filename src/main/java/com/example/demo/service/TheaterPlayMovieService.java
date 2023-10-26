package com.example.demo.service;

import com.example.demo.domain.dto.TheaterPlayMovieDTO;
import com.example.demo.mapper.TheaterPlayMovieMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TheaterPlayMovieService {

    private final TheaterPlayMovieMapper theaterPlayMovieMapper;

    public List<TheaterPlayMovieDTO> findTheaterPlayMovieId(TheaterPlayMovieDTO theaterPlayMovieDTO) {
        return theaterPlayMovieMapper.findTheaterPlayMovieId(theaterPlayMovieDTO);
    }

    public List<TheaterPlayMovieDTO> findTotalSeats() {
        return theaterPlayMovieMapper.findTotalSeats();
    }

}
