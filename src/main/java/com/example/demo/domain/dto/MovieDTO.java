package com.example.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

    private int movieId;
    private String movieName;
    private String movieRelease;
    private int movieRating;
    private String movieType;
    private String movieInfo;

    private String imgLink;


}
