package com.example.demo.service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.demo.model.Question;
import com.example.demo.utility.NumberUtilities;

public class GameService 
{	
	public static final String[] operationArr = new String[] {"+", "-", "*", "/"};
	public static final String[] operationArrWithoutDivide = new String[] {"+", "-", "*"};
	
	/**  
	 * This method initializes the list of all possible pairs along with their associated operators.
	 * @param
	 * @return
	 * List<Question>
	 */
	public static List<Question> initializeQuestions(int floor, int ceiling)
	{
		List<Question> result = new ArrayList<>();
		
		for (int i = floor; i <= ceiling; i++)
		{
			for (int j = floor; j <= ceiling; j++)
			{
				Question temp = new Question();
				temp.setQuestionString(phraseQuestion(i, j));
				result.add(temp);
			}
		}
		
		Collections.shuffle(result);
		
		return result;
	}
	
	public static String phraseQuestion(int firstNumber, int secondNumber)
	{
		String result = "";
		
		String operation = retrieveRandomOperation(operationArr);
		operation = validateQuestion(firstNumber, secondNumber, operation);
		
		result = String.format("%s %s %s =", firstNumber, operation, secondNumber);
		
		return result;
	}
	
	/**  
	 * This method validates the pair of numbers along with its associated operator. This is to prevent division by 0 as well as the first number not being a multiple
	 * of the second number.
	 * @param
	 * @return
	 * String
	 */
	public static String validateQuestion(int firstNumber, int secondNumber, String operation)
	{
		String operationResult = operation;
		if ((secondNumber == 0 && operation.equals("/")) || (secondNumber != 0 && firstNumber % secondNumber != 0))
		{
			operationResult = operationArrWithoutDivide[NumberUtilities.getRandomNumber(0, operationArrWithoutDivide.length)];
		}
		return operationResult;
	}
	
	public static String retrieveRandomOperation(String[] operationArr)
	{
		return operationArr[NumberUtilities.getRandomNumber(0, operationArr.length)];
	}
	
	public static boolean isAnswerCorrect(Question question)
	{
		boolean result = false;
		try
		{			
			result = computeAnswerFromQuestionString(question.getQuestionString()) == Integer.parseInt(question.getAnswer());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		question.setAnswerCorrect(result);
		return result;
	}
	
	public static int computeAnswerFromQuestionString(String questionString)
	{
		int result = 0;
		
		String[] questionStringArr = questionString.split(" ");
		int firstNumber = Integer.parseInt(questionStringArr[0]);
		String operator = questionStringArr[1];
		int secondNumber = Integer.parseInt(questionStringArr[2]);
		
		if (operator.equals("+"))
		{
			result = firstNumber + secondNumber;
		}
		else if (operator.equals("-"))
		{
			result = firstNumber - secondNumber;
		}
		else if (operator.equals("*"))
		{
			result = firstNumber * secondNumber;
		}
		else if (operator.equals("/"))
		{
			result = firstNumber / secondNumber;
		}
		
		return result;
	}
}
