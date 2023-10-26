package com.example.demo.mapper;

import com.example.demo.domain.dto.PlayMovieDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TheaterMapper {

    public Integer findTotalSeats(int theaterId);

}
