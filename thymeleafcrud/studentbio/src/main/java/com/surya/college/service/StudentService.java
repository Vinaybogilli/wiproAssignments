package com.surya.college.service;
import com.surya.college.entities.College;
import java.util.List;

public interface StudentService {
	List<College> getAllStudents();
    void saveStudent(College student);
	College getStudentById(Long id);
	void deleteStudentById(Long id);
}
