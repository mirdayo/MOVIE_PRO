package com.example.demo.controller.admin;

import com.example.demo.domain.dto.MovieDTO;
import com.example.demo.domain.dto.Search;
import com.example.demo.domain.paging.Criteria;
import com.example.demo.domain.paging.PageMakerDTO;
import com.example.demo.service.AdminService;
import com.example.demo.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private MovieService movieService;

    //관리자 메인페이지 이동
    @GetMapping("/main")
    public void GETMain(){

        log.info("관리자 페이지 진입");

    }

    //영화 목록 및 검색
    @GetMapping("/movieManage")
    public void showList(Search search, Criteria criteria, Model model){
//        System.out.println("GET movieManage "+search);
        List<MovieDTO> list = movieService.getList(criteria, search);
        model.addAttribute("list", list);
        int total = movieService.getTotal(search);
//        System.out.println("Count : " + total);

        PageMakerDTO pageMaker = new PageMakerDTO(criteria, total);

        int totalMovieCount = movieService.getTotal(search);
        model.addAttribute("totalMovieCount", totalMovieCount);
        model.addAttribute("pageMaker", pageMaker);
    }


    //영화 등록 페이지
    @GetMapping("/movieEnroll")
    public void GETMovieEnroll(){

    }

    //영화 조회 페이지
    @GetMapping("/movieDetail")
    public void GETMovieDetail(@RequestParam Optional<Integer> movieId, Criteria criteria, Model model) throws Exception{

        model.addAttribute("criteria", criteria);

        if(movieId.isPresent()){
            int id = movieId.get();
            model.addAttribute("movieDetail", adminService.movieGetDetail(id));
        }else{
            model.addAttribute("movieDetail", null);
        }


    }
}
