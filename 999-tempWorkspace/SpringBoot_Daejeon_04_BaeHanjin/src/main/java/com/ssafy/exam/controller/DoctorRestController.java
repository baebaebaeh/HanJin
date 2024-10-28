package com.ssafy.exam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.exam.model.dto.Doctor;
import com.ssafy.exam.model.service.DoctorService;

@RestController
@RequestMapping("/api/doctor")
public class DoctorRestController {
	private final DoctorService doctorService;
	public DoctorRestController(DoctorService doctorService) {
		super();
		this.doctorService = doctorService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Doctor> getDoctorById() {
		return null;
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateDoctor() {
		return null;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDoctor() {
		return null;
	}

	@GetMapping
	public ResponseEntity<List<Doctor>> getAllDoctors() {
		List<Doctor> list =  doctorService.getAllDoctors();
		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@PostMapping
	public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor) {
		
		try {
			doctorService.addDoctor(doctor);			
			return ResponseEntity.status(HttpStatus.CREATED).body("Doctor added successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add doctor");
		}
	}
}
