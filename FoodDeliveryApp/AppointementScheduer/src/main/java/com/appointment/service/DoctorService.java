package com.appointment.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.appointment.entity.DoctorDTO;

public interface DoctorService {

	DoctorDTO createdoctor(DoctorDTO doctorDTO);

	Page<DoctorDTO> getAllDoctors(Pageable pageable);

	DoctorDTO changeDoctor(Long id, DoctorDTO doctorDTO);

	 boolean deleteDoctor(Long id);

	 List<DoctorDTO> getDoctorsBySpeciality(String speciality);

}
