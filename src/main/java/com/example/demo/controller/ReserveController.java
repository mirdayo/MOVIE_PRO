package com.example.demo.controller;

import com.example.demo.domain.dto.ReserveDTO;
import com.example.demo.service.ReserveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ReserveController {

    @Autowired
    private ReserveService reserveService;

    @PostMapping("/reserve")
    @ResponseBody
    public ResponseEntity<?> reserve(@RequestBody ReserveDTO reserveDTO) {
        System.out.println("reserveDTO : " + reserveDTO);
        try {
            reserveService.insertReserve(reserveDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/reserve/{theaterPlayMovieId}")
    public List<String> getReservedSeats(@PathVariable int theaterPlayMovieId) {
        System.out.println("Get theaterPlayMovieId : " + theaterPlayMovieId);
        List<String> list = reserveService.getReservedSeats(theaterPlayMovieId);
        System.out.println("list : " + list);
        return list;
    }
}
