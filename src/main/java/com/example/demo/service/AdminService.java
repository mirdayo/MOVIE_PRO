package com.example.demo.service;

import com.example.demo.domain.dto.MovieDTO;
import com.example.demo.domain.dto.MovieImageDTO;
import com.example.demo.domain.paging.Criteria;
import com.example.demo.mapper.AdminMapper;
import com.example.demo.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminMapper adminMapper;

    //영화 추가
    @Transactional
    public void movie_insert(List<MovieDTO> movies) {
        adminMapper.movie_insert(movies);
    }

    //영화 이미지 추가
    @Transactional
    public void movie_image_insert(List<MovieImageDTO> movieImage) {
        adminMapper.movie_image_insert(movieImage);
    }

    //영화 수정
    public void update(MovieDTO movieDTO){
        adminMapper.update(movieDTO);
    }

    //영화 삭제
    public void delete(int movieId){
        adminMapper.delete(movieId);
    }

    //영화목록(리스트)
    public List<MovieDTO> movieGetList(Criteria criteria){
        return adminMapper.movieGetList(criteria);
    }

    //영화 총 갯수
    public int movieGetTotal(){
        return adminMapper.movieGetTotal();
    }

    //영화 조회 페이지
    public MovieDTO movieGetDetail(int movieId){
        return adminMapper.movieGetDetail(movieId);
    }



}
