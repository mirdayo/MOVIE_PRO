package com.example.demo.domain.paging;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Criteria {

    //현재 페이지
    private int pageNum;
    //한페이지당 보여질 게시물 갯수
    private int amount;
    //스킵 할 게시물 수 ((pageNum -1) * amount)
    private int skip;

    //검색 타입
    private String type;
    //검색 키워드
    private String keyword;


    //기본 생성자
    public Criteria(){
        this(1,10);
    }

    //검색 타입 데이터 배열 변환
    public String[] getTypeArr(){
        return type == null ? new String[] {}:type.split("");
    }

    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
        this.skip = (pageNum -1) * amount;
    }

    public void setPageNum(int pageNum) {
        this.skip = (pageNum -1 )*this.amount;
        this.pageNum = pageNum;
    }
    public void setAmount(int amount){
        this.skip = (pageNum -1) * amount;
        this.amount = amount;
    }
}
