package com.vijay.dev.ob.dao;

import java.util.List;

import com.vijay.dev.ob.beans.Questions;

public interface QuestionsDao {

	Questions saveQuestion(Questions question);

	void updateQuestion(Questions savedQuestion);

	List<Questions> getAllQuestions();

	Questions getQuestionsById(Integer id);

}
