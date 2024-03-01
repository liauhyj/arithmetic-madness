package com.example.demo.model;

public class Question 
{
	private String questionString;
	private String answer;
	private boolean isAnswerCorrect;
	
	public String getQuestionString() {
		return questionString;
	}
	public void setQuestionString(String questionString) {
		this.questionString = questionString;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public boolean isAnswerCorrect() {
		return isAnswerCorrect;
	}
	public void setAnswerCorrect(boolean isAnswerCorrect) {
		this.isAnswerCorrect = isAnswerCorrect;
	}
}
