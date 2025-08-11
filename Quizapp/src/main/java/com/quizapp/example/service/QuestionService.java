package com.quizapp.example.service;

import java.util.List;

import com.quizapp.example.entities.Question;
public interface QuestionService {

	List<Question> getquestions();

	Question save(Question question);

	

	Question patchupdatequestions(Long id, Question question);

	void  deletequestion(Long id);

	

}
