package com.example.demo.mapper;

import com.example.demo.domain.dto.MovieDTO;
import com.example.demo.domain.dto.MovieImageDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j

public class MovieImageMapperTests {

    @Autowired
    MovieImageMapper movieImageMapper;

    @Test
    public void selectImageTest(){

        MovieImageDTO movieImageDTO = movieImageMapper.selectImage(5);

        System.out.println("결과값 : " + movieImageDTO );
    }

    @Test
    public void selectRatingImageTest(){


        List<MovieImageDTO> images = movieImageMapper.selectRatingImage();
        for(MovieImageDTO image : images){
            System.out.println("imageId : " + image.getImgId());
            System.out.println("imageLink : " + image.getImgLink() );
            System.out.println("movieName : " + image.getMovieName());
        }

    }
}
