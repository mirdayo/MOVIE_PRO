package com.example.demo.service;

import com.example.demo.domain.dto.PlayMovieDTO;
import com.example.demo.mapper.TheaterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TheaterService {

    private final TheaterMapper theaterMapper;

    public Integer findTotalSeats(int theaterId) {
        return theaterMapper.findTotalSeats(theaterId);
    }
}
