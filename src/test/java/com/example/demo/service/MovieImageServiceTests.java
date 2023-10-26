package com.example.demo.service;

import com.example.demo.domain.dto.MovieImageDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class MovieImageServiceTests {

    @Autowired
    MovieImageService movieImageService;


//    @Test
//    public void selectRatingImageTest(){
//        int page = 1;
//        final int PAGE_SIZE = 5;     //한 페이지에 표시할 데이터 수
//
//        List<MovieImageDTO> images = movieImageService.selectRatingImage(page);
//
//        assertEquals(PAGE_SIZE, images.size());
//
//
//        for(MovieImageDTO image : images){
//            System.out.println("imageId : " + image.getImgId());
//            System.out.println("imageLink : " + image.getImgLink() );
//            System.out.println("movieRating : " + image.getMovieRating());
//        }
//
//    }

    @Test
    public void selectRatingImageTest(){


        List<MovieImageDTO> images = movieImageService.selectRatingImage();
        for(MovieImageDTO image : images){
            System.out.println("imageId : " + image.getImgId());
            System.out.println("imageLink : " + image.getImgLink() );
            System.out.println("movieName : " + image.getMovieName());
        }

    }

}
