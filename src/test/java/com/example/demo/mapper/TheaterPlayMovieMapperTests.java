package com.example.demo.mapper;

import com.example.demo.domain.dto.TheaterPlayMovieDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@SpringBootTest
@Slf4j
public class TheaterPlayMovieMapperTests {

    @Autowired
    private TheaterPlayMovieMapper theaterPlayMovieMapper;

    @Test
    public void test() throws ParseException {
        String playmovie = "화란";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilStartDate = format.parse("2023-10-19"); // Change this to a date that exists in your database.
        java.sql.Date startDate = new java.sql.Date(utilStartDate.getTime());
        Time startTime = Time.valueOf("11:00:00"); // Change this to a time that exists in your database.
        int theaterId = 2;

        List<TheaterPlayMovieDTO> result = theaterPlayMovieMapper.findTheaterPlayMovieId(playmovie, startDate, startTime, theaterId);

        for (TheaterPlayMovieDTO dto : result) {
            System.out.println(dto);
        }
    }

    //총좌석수 조회
    @Test
    public void test2(){
        List<TheaterPlayMovieDTO> list = theaterPlayMovieMapper.findTotalSeats();

        for(TheaterPlayMovieDTO theaterPlayMovieDTO : list){
            System.out.println("theaterPlayMovieId : " + theaterPlayMovieDTO.getTheaterPlayMovieId());
            System.out.println("theaterId : " + theaterPlayMovieDTO.getTheaterId());
            System.out.println("총 좌석수 : " + theaterPlayMovieDTO.getTotalSeats());
            System.out.println("=============================");
        }
    }
}
