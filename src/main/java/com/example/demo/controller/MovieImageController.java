package com.example.demo.controller;

import com.example.demo.domain.dto.MovieImageDTO;
import com.example.demo.service.MovieImageService;
import com.example.demo.service.SecurityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MovieImageController {

    private final MovieImageService movieImageService;

    //이미지 뿌리기
    @GetMapping("/main")
    public void GETMovies(Model model){

//        System.out.println("GET /main...");
        List<MovieImageDTO> movies = movieImageService.selectRatingImage();

        model.addAttribute("movies", movies);

    }
}
