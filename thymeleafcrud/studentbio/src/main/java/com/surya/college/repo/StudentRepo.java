package com.surya.college.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surya.college.entities.College;

public interface StudentRepo extends JpaRepository<College, Long> {

}
