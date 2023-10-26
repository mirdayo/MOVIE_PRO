package com.example.demo.service;

import com.example.demo.domain.dto.ReserveDTO;
import com.example.demo.mapper.ReserveMapper;
import com.example.demo.mapper.TheaterPlayMovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReserveService {

    private final ReserveMapper reserveMapper;

    private final TheaterPlayMovieMapper theaterPlayMovieMapper;

    //결제내역 DB 저장
    @Transactional
    public void insertReserve(ReserveDTO reserveDTO) throws Exception {
        // tbl_reserve에 데이터 추가하기
        reserveMapper.insertReserve(reserveDTO);
        System.out.println("reserveDTO2 : " + reserveDTO);

        // tbl_theaterplaymovie의 currentSeat 값 업데이트하기
        theaterPlayMovieMapper.updateCurrentSeat(reserveDTO.getTheaterPlayMovieId(), -reserveDTO.getSelectSeatNum());

    }

    public List<String> getReservedSeats(int theaterPlayMovieId) {
        System.out.println("GET SERVICE ReservedSeats : " + theaterPlayMovieId);
        return reserveMapper.getReservedSeats(theaterPlayMovieId);
    }
}
