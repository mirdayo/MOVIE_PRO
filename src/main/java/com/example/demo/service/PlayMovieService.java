package com.example.demo.service;

import com.example.demo.domain.dto.PlayMovieDTO;
import com.example.demo.mapper.PlayMovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayMovieService {

    private final PlayMovieMapper playMovieMapper;

    public List<PlayMovieDTO> selectPlayMovie() {
        return playMovieMapper.selectPlayMovie();
    }

    public String findDateTime(String playMovie) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date opedTIme = playMovieMapper.findDateTime(playMovie);
        String dateTime = dateFormat.format(opedTIme);

        return dateTime;
    }
}
