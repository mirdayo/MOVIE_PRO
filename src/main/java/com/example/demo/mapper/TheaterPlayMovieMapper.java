package com.example.demo.mapper;

import com.example.demo.domain.dto.TheaterPlayMovieDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Mapper
public interface TheaterPlayMovieMapper {

    // 상영영화, 상영일자, 영화시작시간을 받아 조회
    public List<TheaterPlayMovieDTO> findTheaterPlayMovieId(TheaterPlayMovieDTO theaterPlayMovieDTO);

    // 총 좌석수 조회
    public List<TheaterPlayMovieDTO> findTotalSeats();

    //좌석 수 감소
    public int updateCurrentSeat(@Param("theaterPlayMovieId") int theaterPlayMovieId, @Param("seatChange") int seatChange);

}
