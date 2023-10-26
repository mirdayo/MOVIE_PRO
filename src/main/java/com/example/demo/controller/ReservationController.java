package com.example.demo.controller;

import com.example.demo.domain.dto.MemberDTO;
import com.example.demo.domain.dto.TheaterPlayMovieDTO;
import com.example.demo.service.PlayMovieService;
import com.example.demo.service.TheaterPlayMovieService;
import com.example.demo.service.TheaterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class ReservationController {

    private final TheaterPlayMovieService theaterPlayMovieService;

    private final PlayMovieService playMovieService;

    private final TheaterService theaterService;

    @GetMapping("/reservation")
    public void GETReservation(Model model) {

        log.info("예매 페이지 진입");
    }

    @PostMapping("/reservation")
    @ResponseBody
    public Map<String, Object> POSTReservation(Model model, @RequestBody TheaterPlayMovieDTO theaterPlayMovieDTO) {
        Integer totalSeats = theaterService.findTotalSeats(theaterPlayMovieDTO.getTheaterId());
        System.out.println("totalSeats : " + totalSeats);

        List<TheaterPlayMovieDTO> currentSeat = theaterPlayMovieService.findTheaterPlayMovieId(theaterPlayMovieDTO);
        System.out.println("current : " + currentSeat);

        String dateTime = playMovieService.findDateTime(theaterPlayMovieDTO.getPlayMovie());
        System.out.println("dateTime : " + dateTime);

        //endDate 값을 포함하는 Map 객체를 생성하고 반환합니다.
        Map<String, Object> response = new HashMap<>();
        response.put("endDate", dateTime);

        // 추가: totalSeats와 currentSeat 값도 응답에 포함시킵니다.
        response.put("totalSeats", totalSeats);
        if (!currentSeat.isEmpty()) {
            response.put("currentSeat", currentSeat.get(0).getCurrentSeat());
            response.put("theaterPlayMovieId", currentSeat.get(0).getTheaterPlayMovieId());
        } else {
            // Handle the case where currentSeat list is empty.
        }

        return response;
    }

    @PostMapping("/reservationSeat")
    public void PosetReservationSeat() {

    }
}