package com.surya.example.service;

import com.surya.example.entities.School;
import com.surya.example.entities.Teacher;
import com.surya.example.repo.SchoolRepository;
import com.surya.example.repo.TeacherRepository;

import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepo;
    private final TeacherRepository teacherRepo;

    @Override
    public School createSchool(School school) {
        return schoolRepo.save(school);
    }

    @Override
    public School updateSchool(Long id, School updated) {
        School school = schoolRepo.findById(id).orElseThrow();
        school.setSchoolName(updated.getSchoolName());
        school.setSchoolAdress(updated.getSchoolAdress());
        return schoolRepo.save(school);
    }

    @Override
    public School patchSchool(Long id, String address) {
        School school = schoolRepo.findById(id).orElseThrow();
        school.setSchoolAdress(address);
        return schoolRepo.save(school);
    }

    @Override
    public void deleteSchool(Long id) {
        schoolRepo.deleteById(id);
    }

    @Override
    public List<School> getAllSchools() {
        return schoolRepo.findAll();
    }

    @Override
    public School getSchoolWithTeachers(String schoolName) {
        School school = schoolRepo.findBySchoolName(schoolName).get(0);
        List<Teacher> teachers = teacherRepo.findBySchoolName(schoolName);
        school.setTeachers(teachers);
        return school;
    }
}