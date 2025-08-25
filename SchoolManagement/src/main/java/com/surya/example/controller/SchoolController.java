package com.surya.example.controller;

import com.surya.example.entities.School;

import com.surya.example.service.SchoolService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping("/add")
    public School add(@RequestBody School school) {
        return schoolService.createSchool(school);
    }

    @PutMapping("/{id}")
    public School update(@PathVariable Long id, @RequestBody School school) {
        return schoolService.updateSchool(id, school);
    }

    @PatchMapping("/{id}")
    public School patch(@PathVariable Long id, @RequestParam String address) {
        return schoolService.patchSchool(id, address);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        schoolService.deleteSchool(id);
    }

    @GetMapping
    public List<School> getAll() {
        return schoolService.getAllSchools();
    }

    @GetMapping("/withTeachers/{schoolName}")
    public School getSchoolWithTeachers(@PathVariable String schoolName) {
        return schoolService.getSchoolWithTeachers(schoolName);
    }
}
