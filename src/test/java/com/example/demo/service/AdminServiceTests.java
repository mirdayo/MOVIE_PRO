package com.example.demo.service;

import com.example.demo.domain.dto.MovieDTO;
import com.example.demo.domain.paging.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class AdminServiceTests {

    @Autowired
    private AdminService adminService;

    @Test
    public void movieGetListTest(){
        Criteria criteria = new Criteria();

        criteria.setPageNum(1);
        criteria.setAmount(10);

        List<MovieDTO> movies = adminService.movieGetList(criteria);

        for(MovieDTO movie : movies){
            System.out.println(movie);
        }
    }
}
