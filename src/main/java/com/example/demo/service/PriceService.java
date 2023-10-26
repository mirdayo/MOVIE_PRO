package com.example.demo.service;

import com.example.demo.domain.dto.PriceDTO;
import com.example.demo.mapper.PriceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final PriceMapper priceMapper;

    //age별 가격정보 조회
    public PriceDTO getPriceByAge(String age){
        return priceMapper.getPriceByAge(age);
    }



}
