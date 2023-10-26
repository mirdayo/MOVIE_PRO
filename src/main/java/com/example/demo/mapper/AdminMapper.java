package com.example.demo.mapper;

import com.example.demo.domain.dto.MovieDTO;
import com.example.demo.domain.dto.MovieImageDTO;
import com.example.demo.domain.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

    //영화 추가
    public void movie_insert(List<MovieDTO> movies);

    //영화 이미지 추가
    public void movie_image_insert(List<MovieImageDTO> movieImage);

    //영화수정
    public void update(MovieDTO movieDTO);

    //영화삭제
    public void delete(int movieId);

    //영화목록(리스트)
    public List<MovieDTO> movieGetList(Criteria criteria);

    //영화 총 갯수
    public int movieGetTotal();

    //영화 조회 페이지
    public MovieDTO movieGetDetail(int movieId);



}
