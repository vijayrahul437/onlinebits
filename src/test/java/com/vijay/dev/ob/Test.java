package com.vijay.dev.ob;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vijay.dev.ob.beans.Answer;
import com.vijay.dev.ob.beans.Options;
import com.vijay.dev.ob.beans.Questions;

public class Test {

	public static void main1(String[] args) {
		new Test().test();
	}
	
	public void test() {
		Questions questions = new Questions();
		questions.setDomainId(123455);
		questions.setQuestion("text question");
		questions.setQuestionType("TEXT");
		questions.setSubDomainId(1234);
		Answer answer = new Answer();
		answer.setAnswerValue("this is an answer");
		answer.setExplanation(null);
		answer.setOptionId(null);
		questions.setAnswer(answer);
		
		Questions questions1 = new Questions();
		questions1.setDomainId(123455);
		questions1.setQuestion("multiple question");
		questions1.setQuestionType("MUL");
		questions1.setSubDomainId(1234);
		
		Options optionsa = new Options();
		optionsa.setOptionKey("A");
		optionsa.setOptionValue("option a");
		Options optionsb = new Options();
		optionsb.setOptionKey("B");
		optionsb.setOptionValue("option b");
		Options optionsc = new Options();
		optionsc.setOptionKey("C");
		optionsc.setOptionValue("option c");
		Options optionsd = new Options();
		optionsd.setOptionKey("D");
		optionsd.setOptionValue("option d");
		
		List<Options> options = new ArrayList<>();
		options.add(optionsa);
		options.add(optionsb);
		options.add(optionsc);
		options.add(optionsd);
		
		Answer answer1 = new Answer();
		answer1.setAnswerValue("option a");
		answer1.setExplanation("explanation");
		answer1.setExplanation(null);
		answer1.setOptionId(null);
		questions1.setAnswer(answer1);
		questions1.setOptions(options);
		
		try {
			System.out.println(new ObjectMapper().writeValueAsString(questions));
			System.out.println(new ObjectMapper().writeValueAsString(questions1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
        String excelFilePath = "F:\\Development\\onlinebits\\excelupload template.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
         
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Row headerrow = firstSheet.getRow(0);
        
//        short minCol = headerrow.getFirstCellNum();
//        short maxCol = headerrow.getLastCellNum();
//        for(short colIx=minCol; colIx<maxCol; colIx++) {
//          Cell cell = headerrow.getCell(colIx);
//          if(cell == null) {
//            continue;
//          }
//          System.out.println(cell.getStringCellValue()+"*");
//        }
        
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
