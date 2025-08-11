package com.quizapp.example.service;

import java.util.List;

import com.quizapp.example.entities.QuestionWrapper;
import com.quizapp.example.entities.Quiz;
import com.quizapp.example.entities.Response;

public interface Quizservice {

    Quiz createQuiz(String category, String level, String title);

    List<QuestionWrapper> getQuizquestions(Long id);

    Integer calculateResult(int id, List<Response> responses);
}
