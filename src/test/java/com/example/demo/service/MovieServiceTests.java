package com.example.demo.service;

import com.example.demo.domain.paging.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class MovieServiceTests {

    @Autowired
    private MovieService movieService;

    //영화 조회(페이징적용)
//    @Test
//    public void getListPagingTest(){
//
//        Criteria criteria = new Criteria();
//
//        List list = movieService.getListPaging(criteria);
//
//        list.forEach(movie -> log.info("" + movie));
//    }
}
