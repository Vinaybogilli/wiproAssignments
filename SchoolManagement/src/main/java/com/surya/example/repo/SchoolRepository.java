package com.surya.example.repo;


import com.surya.example.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School, Long> {

    
    List<School> findBySchoolName(String name);

    
    @Query(value = "SELECT * FROM school WHERE school_name = ?1", nativeQuery = true)
    List<School> getSchoolByNameNative(String name);
}
