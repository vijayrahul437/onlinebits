package com.vijay.dev.ob.service;

import java.util.List;

import com.vijay.dev.ob.beans.Questions;

public interface QuestionsService {

	boolean saveQuestion(Questions question);

	List<Questions> getAllQuestions();

	Questions getQuestion(Integer id);

}
