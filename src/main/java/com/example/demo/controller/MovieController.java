package com.example.demo.controller;

import com.example.demo.domain.dto.MovieDTO;
import com.example.demo.domain.dto.MovieImageDTO;
import com.example.demo.domain.dto.PlayMovieDTO;
import com.example.demo.domain.dto.Search;
import com.example.demo.domain.paging.Criteria;
import com.example.demo.domain.paging.PageMakerDTO;
import com.example.demo.service.MovieImageService;
import com.example.demo.service.MovieService;
import com.example.demo.service.PlayMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.print.Pageable;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MovieController {

    private final MovieService movieService;

    private final MovieImageService movieImageService;

    private final PlayMovieService playMovieService;


    //영화검색 + 페이징
    @GetMapping("/movielist")
    public void GETMovieList(Search search, Criteria criteria, Model model){
//        System.out.println("GET movielist " + search);
        List<MovieDTO> list = movieService.getList(criteria, search);
        model.addAttribute("list", list);

        int total = movieService.getTotal(search);
//        System.out.println("Count : " + total);
        PageMakerDTO pageMaker = new PageMakerDTO(criteria, total);

        int totalMovieCount = movieService.getTotal(search);
        model.addAttribute("totalMovieCount", totalMovieCount);
        model.addAttribute("pageMaker", pageMaker);
    }

    @GetMapping("/movies/rating")
    public void GETMovieRating(Model model, PlayMovieDTO playMovieDTO) {
        List<PlayMovieDTO> list = playMovieService.selectPlayMovie();
        model.addAttribute("list", list);

        System.out.println("list : " + list);

//        log.info("레이팅순으로 정렬");
    }




}

