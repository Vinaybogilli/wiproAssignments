package com.surya.college.controller;

import com.surya.college.entities.College;
import com.surya.college.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "index";
    }

    
    @GetMapping("/students/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new College());
        return "addform";
    }

    
    @PostMapping("/students/save")
    public String saveStudent(@ModelAttribute("student") College student) {
        studentService.saveStudent(student);
        return "redirect:/";
    }

    
    @GetMapping("/students/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        College student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "addform";
    }

    
    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/";
    }
}
