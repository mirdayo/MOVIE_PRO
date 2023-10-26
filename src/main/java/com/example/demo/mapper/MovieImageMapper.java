package com.example.demo.mapper;

import com.example.demo.domain.dto.MovieImageDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MovieImageMapper {

    //이미지 조회
    public MovieImageDTO selectImage(int imgId);

    //평점순 이미지 조회
    public List<MovieImageDTO> selectRatingImage();

    //이미지 등록
    public void insertImage(MovieImageDTO movieImageDTO);
}
