package com.example.demo.mapper;

import com.example.demo.domain.dto.ReserveDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReserveMapper {

    //결제정보DB에추가
    public void insertReserve(ReserveDTO reserveDTO);

    //영화 시트 조회
    public List<String> getReservedSeats(int theaterPlayMovieId);
}
