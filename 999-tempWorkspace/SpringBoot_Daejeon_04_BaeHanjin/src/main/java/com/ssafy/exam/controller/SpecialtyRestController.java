package com.ssafy.exam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.exam.model.dto.Specialty;
import com.ssafy.exam.model.service.SpecialtyService;

@RestController
@RequestMapping("/api/specialty")
public class SpecialtyRestController {
	private final SpecialtyService specialtyService;

	public SpecialtyRestController(SpecialtyService specialtyService) {
		super();
		this.specialtyService = specialtyService;
	}

	@PostMapping()
	public ResponseEntity<String> addSpecialty(@RequestBody Specialty specialty) {
		try {
			specialtyService.addSpecialty(specialty);
			return ResponseEntity.status(HttpStatus.CREATED).body("Specialty added successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed to add specialty");
		}
	}

	@GetMapping("/{code}")
	public ResponseEntity<Specialty> getSpecialty(@PathVariable("code") int code) {
		Specialty specialty = specialtyService.getSpecialtyByCode(code);
		if (specialty != null) {
			return ResponseEntity.status(HttpStatus.OK).body(specialty);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	

	@DeleteMapping("/{code}")
	public ResponseEntity<String> deleteSpecialty(@PathVariable("code") int code) {
		boolean isDelete = specialtyService.deleteSpecialty(code);
		if (isDelete) {			
			return ResponseEntity.status(HttpStatus.OK).body("Specialty deleted successfully");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete specialty");			
		}
	}
}