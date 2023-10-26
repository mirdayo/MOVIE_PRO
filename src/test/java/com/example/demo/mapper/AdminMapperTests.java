package com.example.demo.mapper;

import com.example.demo.domain.dto.MovieDTO;
import com.example.demo.domain.paging.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class AdminMapperTests {

    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void movieGetListTest(){
        Criteria criteria = new Criteria();

        criteria.setPageNum(1);
        criteria.setAmount(10);

        List<MovieDTO> movies = adminMapper.movieGetList(criteria);

        for(MovieDTO movie : movies){
            System.out.println(movie);
        }
    }

    @Test
    public void movieGetDetailTest(){

        int movieId = 5;

        MovieDTO result = adminMapper.movieGetDetail(movieId);
        System.out.println("영화 조회 데이터 : " + result);
    }


}
