package com.ssafy.myboard.board.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.myboard.board.model.Idol;
import com.ssafy.myboard.board.model.service.IdolService;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/idol")
@Tag(name="IdolController(아이돌 관리 컨트롤러)", description = "아이돌 정보를 처리하는 컨트롤러 클래스 입니다")
public class IdolController {
	private final IdolService idolService;
	
	
	public IdolController(IdolService idolService) {
		this.idolService = idolService;
	}
	/*
	 * R -> GET list(전체보기) /board detail(상세보기) /board/100 상세보기는 url뒤에 id를 달아서 보내준다.
	 * C -> POST /board {"name": "홍길동", "gender": "F"} body에 담아 보낸다. U -> PUT, PATCH
	 * /board/100 {"no":100, "name": "홍길동", "gender": "F"} D -> DELET /board/100
	 */

	/*
	 * 이거 질문 이해가 안감
	 * 
	 * 응답 시작라인(200 HTTP/1.1 Ok) 헤더 키:값 키:값 빈줄~~~~ 바디
	 * 
	 * 
	 */

	/*
	 * JSON map : {} DTO : {} LIST, 배열 : []
	 * 
	 * 
	 * 이런식으로 보내준다. [{ "no": 100, "name": "홍길동", "gender": "F" }, {}]
	 * 
	 * 
	 * 
	 * json formatter??
	 */
	@Operation(	summary = "아이돌 전체 목록조회", 
				description = "모든 아이돌 목록을 반환합니다", 
				responses = {
						@ApiResponse(responseCode = "200", description = "조회 성공"),
						@ApiResponse(responseCode = "204", description = "조회된 데이터 없음"),
						@ApiResponse(responseCode = "500", description = "서버 실행시 에러")
				})
	@GetMapping
	@CrossOrigin
	public ResponseEntity<Object> list() {
		// list 데이터를 브자우저에서 사용하도록 문자열로 반환해서 전송해줘야 한다.
		// 객체를 반환하면 객체의 내용을 json으로 변환해준다 : jackson
		ResponseEntity<Object> responseEntity;
		try {
			
		List<Idol> list = idolService.list();
		if (list.isEmpty()) {
			responseEntity = new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
		} else {
			HttpHeaders headers = new HttpHeaders();
			headers.add("mykey", "abcde21345");
			responseEntity = new ResponseEntity<>(list,headers, HttpStatus.OK);
		}
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>("문제가 발생했습니다", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	
	/*
	 * 	정상일경우 200
	 * 	요청 번호에 해당하는 데이터가 없을 경우 204
	 * 	
	 */
	
	// url에 온 데이터를 no로 받아주겠다.
	@GetMapping("{no}")
	@Operation(
//			hidden = true,
			summary = "아이돌 상세 조회",
			description = "번호에 해당하는 아돌의 상세 정보를 반환합니다",
			responses = {
					@ApiResponse(responseCode = "200", description = "정상조회"),
					@ApiResponse(responseCode = "204", description = "데이터가 존재하지 않음")
			},
			parameters = {
					@Parameter(
							name = "no", 
							description = "아이돌 번호",
							required = true
					)
			}
	)
	// 받아준 no를 int no에 담아주겠다
//	@Hidden
	public ResponseEntity<Idol> detail(@PathVariable("no") int no) {
		Idol idol = idolService.detail(no);
		if (idol == null) {
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//			return ResponseEntity.noContent().build();  // 위아래 방식 같은데 빌더패턴이 없으면 위방식으로 쓰자
		}
		
		// 빌더 패턴방식 최근 방식
//		return ResponseEntity.ok(idol); // 역시 마찬가지로 아래 코드와 같다.
		return ResponseEntity.status(HttpStatus.OK).body(idol);
		
		
		// 기존 객체 생성 방식
//		return new ResponseEntity<Idol>(idol, HttpStatus.OK);
		
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
	public void modify(@RequestBody Idol idol, @PathVariable("no") int no) {
		System.out.println("수정");
		idol.setNo(no);
		idolService.modify(idol);
	}

}
