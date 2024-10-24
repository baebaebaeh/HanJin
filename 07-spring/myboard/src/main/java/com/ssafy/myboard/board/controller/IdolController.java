package com.ssafy.myboard.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.myboard.board.model.Idol;
import com.ssafy.myboard.board.model.service.IdolService;

import ch.qos.logback.core.model.Model;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/idol")
public class IdolController {
	private final IdolService idolService;
	public IdolController(IdolService idolService) {
		this.idolService = idolService;
	}
	/*
	 * R -> GET
	 * 		list(전체보기)					/board
	 * 		detail(상세보기)				/board/100
	 * 상세보기는 url뒤에 id를 달아서 보내준다.
	 * C -> POST						/board			{"name": "홍길동", "gender": "F"} body에 담아 보낸다.
	 * U -> PUT, PATCH					/board/100		{"no":100, "name": "홍길동", "gender": "F"}
	 * D -> DELET						/board/100
	 */
	
	/* 이거 질문 이해가 안감
	 * 
	 * 응답
	 * 시작라인(200 HTTP/1.1 Ok)
	 * 헤더		키:값
	 * 			키:값
	 * 빈줄~~~~
	 * 바디
	 * 
	 * 
	 */
	
	
	/*
	 * JSON
	 * map : {}
	 * DTO : {}
	 * LIST, 배열 : []
	 * 
	 * 
	 * 이런식으로 보내준다.
	 * [{
	 * 		"no": 100,
	 * 		"name": "홍길동",
	 * 		"gender": "F"
	 * }, {}]
	 * 
	 * 
	 * 
	 * json formatter??
	 */
	
	
	@GetMapping
	public List<Idol> list() {
		// list 데이터를 브자우저에서 사용하도록 문자열로 반환해서 전송해줘야 한다.
		// 객체를 반환하면 객체의 내용을 json으로 변환해준다 : jackson
		List<Idol> list = idolService.list();
		return list;
	}
	
	
	// url에 온 데이터를 no로 받아주겠다.
	@GetMapping("{no}")
	// 받아준 no를 int no에 담아주겠다
	public Idol detail(@PathVariable("no") int no) {
		return idolService.detail(no);
	}
	
	
	@DeleteMapping("{no}")
	public void remove(@PathVariable("no") int no) {
		idolService.remove(no);
	}
	
	@PostMapping
	public void regist(@RequestBody Idol idol) {
		idolService.regist(idol);
	}
	
	@PutMapping("{no}")
	public void modify(@RequestBody Idol idol) {
		idolService.modify(idol);
	}
	
}


