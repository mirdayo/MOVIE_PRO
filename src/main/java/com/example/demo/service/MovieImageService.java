package com.example.demo.service;

import com.example.demo.domain.dto.MovieImageDTO;
import com.example.demo.mapper.MovieImageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieImageService {

    private final MovieImageMapper movieImageMapper;

    //영화 조회
    public MovieImageDTO selectImage(int imgId) {
        return movieImageMapper.selectImage(imgId);
    }

    //평점순 이미지 조회
    public List<MovieImageDTO> selectRatingImage(){
        return movieImageMapper.selectRatingImage();
    }

}
