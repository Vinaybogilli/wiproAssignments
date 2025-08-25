package com.surya.example.service;
import com.surya.example.entities.Teacher;
import java.util.List;
public interface TeacherService {
	Teacher createTeacher(Teacher teacher);
    Teacher updateTeacher(Long id, Teacher teacher);
    void deleteTeacher(Long id);
    List<Teacher> getAllTeachers();
    List<Teacher> getTeachersBySchoolName(String schoolName);

}
