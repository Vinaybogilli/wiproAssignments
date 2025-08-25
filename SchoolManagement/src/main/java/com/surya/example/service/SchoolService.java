package com.surya.example.service;

import com.surya.example.entities.School;


import java.util.List;

public interface SchoolService {
    School createSchool(School school);
    School updateSchool(Long id, School school);
    School patchSchool(Long id, String address);
    void deleteSchool(Long id);
    List<School> getAllSchools();
    School getSchoolWithTeachers(String schoolName);
}
