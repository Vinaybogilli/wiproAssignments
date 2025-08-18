package com.surya.college.service;

import com.surya.college.entities.College;
import com.surya.college.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<College> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public void saveStudent(College student) {
        studentRepo.save(student);
    }

    @Override
    public College getStudentById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepo.deleteById(id);
    }
}
