package com.appointment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appointment.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	List<Doctor> findBySpecialityIgnoreCase(String speciality);

}
