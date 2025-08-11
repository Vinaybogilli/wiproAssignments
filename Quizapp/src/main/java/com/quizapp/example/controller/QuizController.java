package com.quizapp.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.quizapp.example.entities.QuestionWrapper;
import com.quizapp.example.entities.Quiz;
import com.quizapp.example.entities.Response;
import com.quizapp.example.service.Quizservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/quiz")
public class QuizController {

    private final Quizservice quizservice;

    @PostMapping("/create")
    public Quiz createquiz(
            @RequestParam String category,
            @RequestParam String level,
            @RequestParam String title) {
        return quizservice.createQuiz(category, level, title);
    }

    @GetMapping("/getquizbyid/{id}")
    public List<QuestionWrapper> getQuizQuestions(@PathVariable Long id) {
        return quizservice.getQuizquestions(id);
    }

    @PostMapping("/submitQuiz/{id}")
    public Integer submitQuiz(@PathVariable int id, @RequestBody List<Response> responses) {
        return quizservice.calculateResult(id, responses);
    }
}
