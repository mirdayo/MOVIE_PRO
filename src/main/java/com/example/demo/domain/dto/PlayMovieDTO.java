package com.example.demo.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class PlayMovieDTO {

    private int playMovieId;
    private int imgId;
    private String imgLink;
    private String playMovie;
    private Date openDate;
    private Date endDate;

}
