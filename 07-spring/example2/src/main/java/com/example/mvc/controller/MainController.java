package com.example.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

	@GetMapping({ "/", "/index" })
	public String home() {
		return "/index";
	}

	@PostMapping("/location")
	public String receiveLocation(@RequestBody Location location) {
		System.out.println("Received Latitude: " + location.getLatitude());
		System.out.println("Received Longitude: " + location.getLongitude());

		// 받은 위치 정보를 바탕으로 처리 로직을 추가
		// 예: 위치 기반 서비스, 데이터베이스 저장 등

		return "{\"status\": \"Location received successfully!\"}";
	}

	class Location {
		private double latitude;
		private double longitude;

		// Getter and Setter
		public double getLatitude() {
			return latitude;
		}

		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}

		public double getLongitude() {
			return longitude;
		}

		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}
	}

}
