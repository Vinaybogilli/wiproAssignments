package com.surya.example.repo;



import com.surya.example.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    
    List<Teacher> findBySchoolName(String schoolName);

    
    @Query(value = "SELECT * FROM teacher WHERE school_name = ?1", nativeQuery = true)
    List<Teacher> getTeachersBySchoolNameNative(String schoolName);
}
