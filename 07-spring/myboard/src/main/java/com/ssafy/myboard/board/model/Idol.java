package com.ssafy.myboard.board.model;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

@Schema(name = "Idol(아이돌 정보 표현)",  description = "아이돌 정보를 표현하는 DTO 객체")
public class Idol {
	@Schema(name = "no(아이돌 구분 번호)")
	private int no;
	@Schema(name = "name(이름)", requiredMode = RequiredMode.REQUIRED)
	private String name;
	@Schema(name = "gender(성별)", example = "아이돌의 성별을 나타낸다.")
	private String gender;

	public Idol() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Idol(int no, String name, String gender) {
		super();
		this.no = no;
		this.name = name;
		this.gender = gender;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
