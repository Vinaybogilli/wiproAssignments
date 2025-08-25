package com.surya.example.service;



import com.surya.example.entities.Teacher;
import com.surya.example.repo.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepo;

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Long id, Teacher updated) {
        Teacher teacher = teacherRepo.findById(id).orElseThrow();
        teacher.setTeacherName(updated.getTeacherName());
        teacher.setTeacherAdress(updated.getTeacherAdress());
        teacher.setQualification(updated.getQualification());
        teacher.setAge(updated.getAge());
        teacher.setDob(updated.getDob());
        teacher.setExperience(updated.getExperience());
        teacher.setSchoolName(updated.getSchoolName());
        return teacherRepo.save(teacher);
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepo.deleteById(id);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepo.findAll();
    }

    @Override
    public List<Teacher> getTeachersBySchoolName(String schoolName) {
        return teacherRepo.findBySchoolName(schoolName);
    }
}
