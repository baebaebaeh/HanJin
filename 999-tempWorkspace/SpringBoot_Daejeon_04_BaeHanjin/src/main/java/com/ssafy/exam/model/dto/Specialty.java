package com.ssafy.exam.model.dto;

public class Specialty {
	private int specialtyCode;
	private String specialtyName;

	
	
	public Specialty() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Specialty(int specialtyCode, String specialtyName) {
		super();
		this.specialtyCode = specialtyCode;
		this.specialtyName = specialtyName;
	}

	public int getSpecialtyCode() {
		return specialtyCode;
	}

	public void setSpecialtyCode(int specialtyCode) {
		this.specialtyCode = specialtyCode;
	}

	public String getSpecialtyName() {
		return specialtyName;
	}

	public void setSpecialtyName(String specialtyName) {
		this.specialtyName = specialtyName;
	}

	@Override
	public String toString() {
		return "Specialty [specialtyCode=" + specialtyCode + ", specialtyName=" + specialtyName + "]";
	}
	
	
}