package com.lw.answer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


public class ExamPaper {
    private List<SingleChoice> singleChoices;
    private List<MultipleChoice> multipleChoices;
    private List<TrueFalseQuestion> trueFalseQuestions;
	public List<SingleChoice> getSingleChoices() {
		return singleChoices;
	}
	public void setSingleChoices(List<SingleChoice> singleChoices) {
		this.singleChoices = singleChoices;
	}
	public List<MultipleChoice> getMultipleChoices() {
		return multipleChoices;
	}
	public void setMultipleChoices(List<MultipleChoice> multipleChoices) {
		this.multipleChoices = multipleChoices;
	}
	public List<TrueFalseQuestion> getTrueFalseQuestions() {
		return trueFalseQuestions;
	}
	public void setTrueFalseQuestions(List<TrueFalseQuestion> trueFalseQuestions) {
		this.trueFalseQuestions = trueFalseQuestions;
	}
	public ExamPaper(List<SingleChoice> singleChoices, List<MultipleChoice> multipleChoices,
			List<TrueFalseQuestion> trueFalseQuestions) {
		super();
		this.singleChoices = singleChoices;
		this.multipleChoices = multipleChoices;
		this.trueFalseQuestions = trueFalseQuestions;
	}
	public ExamPaper() {
		super();
	}
    
}
