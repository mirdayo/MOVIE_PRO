package com.example.demo.mapper;


import com.example.demo.domain.dto.MovieDTO;
import com.example.demo.domain.dto.Search;
import com.example.demo.domain.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MovieMapper {

    //영화조회(단건)
    public MovieDTO select(int movieId);

    //영화전체조회
    public List<MovieDTO> selectAll(MovieDTO movieDTO);

    //영화목록조회(전체)
    public List<MovieDTO> getList(@Param("cri")Criteria criteria, @Param("search") Search search);

    //영화목록(페이징적용)
    public List<MovieDTO> getListPaging(@Param("cri")Criteria criteria, @Param("search") Search search);

    //영화 총 갯수
    public int getTotal(Search search);

    //영화 검색 기능
    public List<MovieDTO> searchMovie(Criteria criteria);

    //영화 검색 갯수
    public int searchCountAll(@Param("search")Search search);



}