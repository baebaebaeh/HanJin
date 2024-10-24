package com.ssafy.myboard.main.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
    @PostMapping("/savePosition")
    @ResponseBody
    public ResponseEntity<String> savePosition(@RequestBody Map<String, Double> coordinates) {
        Double lat = coordinates.get("lat");
        Double lng = coordinates.get("lng");
        
        // 받은 좌표 값을 활용하여 처리
        System.out.println("Received Latitude: " + lat + ", Longitude: " + lng);
        
        // 필요한 처리 후 응답 반환
        return ResponseEntity.ok("Position received");
    }
}