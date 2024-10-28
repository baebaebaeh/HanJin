package com.ssafy.exam.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.exam.model.dao.DoctorDao;
import com.ssafy.exam.model.dto.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {
	private final DoctorDao doctorDao;
	public DoctorServiceImpl(DoctorDao doctorDao) {
		super();
		this.doctorDao = doctorDao;
	}

	@Override
	public boolean addDoctor(Doctor doctor) {
		System.out.println(doctor);
		doctorDao.insertDoctor(doctor);
		return false;
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorDao.selectAllDoctors();
	}

	@Override
	public Doctor getDoctorById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateDoctor(int id, Doctor doctor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDoctor(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
