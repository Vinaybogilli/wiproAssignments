package com.quizapp.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizapp.example.entities.CategoryLevel;
import com.quizapp.example.entities.DifficultyLevel;
import com.quizapp.example.entities.Question;


public interface questionrepo extends JpaRepository<Question, Long> {

    List<Question> findByCategoryAndDifficulty(CategoryLevel categoryEnum, DifficultyLevel levelEnum);

}
