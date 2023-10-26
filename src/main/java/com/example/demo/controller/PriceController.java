package com.example.demo.controller;

import com.example.demo.domain.dto.PriceDTO;
import com.example.demo.service.PriceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PriceController {

    private final PriceService priceService;

    @PostMapping("/getPrice")
    public ResponseEntity<Map<String, Object>> getPrice(@RequestBody Map<String, String> payload) {
        String age = payload.get("age");

        // Validate age
        if (!(age.equals("어린이") || age.equals("청소년") || age.equals("성인"))) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "Invalid age value: " + age));
        }

        // Get PriceDTO from DB based on age...
        PriceDTO priceDto = priceService.getPriceByAge(age);

        // If no price found for the given age
        if (priceDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "No price found for the given age: " + age));
        }

        Integer price = priceDto.getPrice();

        Map<String, Object> response = new HashMap<>();
        response.put("price", price);

        return ResponseEntity.ok(response);
    }



}
