package com.quizapp.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizapp.example.entities.Quiz;

public interface Quizrepo extends JpaRepository<Quiz, Long> {

}
