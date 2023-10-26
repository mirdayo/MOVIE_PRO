package com.example.demo.mapper;

import com.example.demo.domain.dto.PriceDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@SpringBootTest
@Slf4j
public class PriceMapperTests {

    @Autowired
    private PriceMapper priceMapper;

    @Test
    public void getPriceByAgeTest(){

        String age = "어린이";
        PriceDTO priceDTO = priceMapper.getPriceByAge(age);

        System.out.println(priceDTO);
    }
}
