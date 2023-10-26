package com.example.demo.mapper;

import com.example.demo.domain.dto.PriceDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PriceMapper {

    //age별 가격정보 조회
    public PriceDTO getPriceByAge(String age);


}
