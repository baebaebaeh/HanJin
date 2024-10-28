package com.ssafy.exam.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.exam.model.dao.SpecialtyDao;
import com.ssafy.exam.model.dto.Specialty;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {
	private final SpecialtyDao specialtyDao;
	public SpecialtyServiceImpl(SpecialtyDao specialtyDao) {
		super();
		this.specialtyDao = specialtyDao;
	}

	@Override
	public boolean addSpecialty(Specialty specialty) {
		int isAdd = specialtyDao.insertSpecialty(specialty);
		if (isAdd == 1) {
			return true;
		} else {
			return false;
		}
 	}

	@Override
	public Specialty getSpecialtyByCode(int code) {
		Specialty specialty = specialtyDao.selectSpecialtyByCode(code);
		return specialty;
	}

	@Override
	public boolean deleteSpecialty(int code) {
		int isDelete = specialtyDao.deleteSpecialty(code);
		if (isDelete == 1) {
			return true;
		} else {
			return false;
		}
	}

}
