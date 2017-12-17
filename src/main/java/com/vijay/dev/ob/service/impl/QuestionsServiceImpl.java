package com.vijay.dev.ob.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vijay.dev.ob.beans.Answer;
import com.vijay.dev.ob.beans.Options;
import com.vijay.dev.ob.beans.Questions;
import com.vijay.dev.ob.dao.QuestionsDao;
import com.vijay.dev.ob.service.QuestionsService;

@Component
public class QuestionsServiceImpl implements QuestionsService{

	@Autowired
	QuestionsDao questionsDao;
	
	@Override
	public boolean saveQuestion(Questions question) {
		Questions savedQuestion = null;
		savedQuestion = questionsDao.saveQuestion(question);
		if(savedQuestion!=null) {
			if(question.getOptions() !=null && !question.getOptions().isEmpty()) {
				Options correctOption=null;
				for (Options option : question.getOptions()) {
					if(option.isStatus()!=null && option.isStatus()) {
						correctOption = option;
					}
				}
				question.getAnswer().setOptionId(correctOption.getId());
				question.getAnswer().setAnswerValue(correctOption.getOptionValue());
				questionsDao.updateQuestion(savedQuestion);
			}
		}
		return true;
	}

	@Override
	public List<Questions> getAllQuestions() {
		return questionsDao.getAllQuestions();
	}

	@Override
	public Questions getQuestion(Integer id) {
		return questionsDao.getQuestionsById(id);
	}
	
	@Override
	public void excelUpload(){
	 String excelFilePath = "F:\\Development\\onlinebits\\excelupload template.xlsx";
     FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
      
     Workbook workbook = new XSSFWorkbook(inputStream);
     Sheet firstSheet = workbook.getSheetAt(0);
     Row headerrow = firstSheet.getRow(0);
     
     
     int firstrow = firstSheet.getFirstRowNum()+1;
     int lastrow = firstSheet.getLastRowNum();
     for(int rowNum=firstrow; rowNum<lastrow; rowNum++) {
     	Questions questions = new Questions();
         Row row = firstSheet.getRow(rowNum);
         if(row == null) {
           continue;
         }
         questions.setQuestion(row.getCell(0).getStringCellValue());
         
         String quesType = row.getCell(1).getStringCellValue();
         questions.setQuestionType(quesType);
         
         if(("TEXT").equalsIgnoreCase(quesType)) {
         	Answer answers = new Answer();
         	answers.setAnswerValue(row.getCell(10).getStringCellValue());
         	questions.setAnswer(answers);
         }else {
         	Answer answers = new Answer();
         	answers.setExplanation(row.getCell(9).getStringCellValue());
         	List<Options> options = new ArrayList<>();
         	Options optionA = new Options("A", row.getCell(4).getStringCellValue(), isValidOption("A", row.getCell(8).getStringCellValue()));
         	Options optionB = new Options("B", row.getCell(5).getStringCellValue(),  isValidOption("B", row.getCell(8).getStringCellValue()));
         	Options optionC = new Options("C", row.getCell(6).getStringCellValue(),  isValidOption("C", row.getCell(8).getStringCellValue()));
         	Options optionD = new Options("D", row.getCell(7).getStringCellValue(),  isValidOption("D", row.getCell(8).getStringCellValue()));
         	options.add(optionA);
         	options.add(optionB);
         	options.add(optionC);
         	options.add(optionD);
         	questions.setAnswer(answers);
         	questions.setOptions(options);
         }
         questions.setDomainId(22);
         questions.setSubDomainId(111);
         System.out.println(new ObjectMapper().writeValueAsString(questions));
       }
      
     workbook.close();
     inputStream.close();
 }
	private static boolean isValidOption(String column,String input) {
		if(column.equals(input)) {
			return true;
		}
		return false;
	}

}
