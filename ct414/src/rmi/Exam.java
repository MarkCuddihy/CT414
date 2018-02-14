package rmi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Exam implements Assessment {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date closingDate;
	private List<ExamQuestion> Questions = new ArrayList<ExamQuestion>();
	//private int Answers;
	private int studentId;
	
	public Exam() {
		super();
		//init questions
		this.Questions.add(new ExamQuestion(
			1,
			"A centaur was a mythical creature half way between a man and what?",
			new String[]{"Rabbit", "Horse", "Lion", "Elephant"},
			1
		));
		
		this.Questions.add(new ExamQuestion(
			2,
			"Bill Gates founded which computer corporation?",
			new String[]{"Apple", "Google", "Microsoft", "IBM"},
			2
		));
		
		this.Questions.add(new ExamQuestion(
			3,
			"What is the house number of the Simpsons?	",
			new String[]{"742", "247", "427", "724"},
			0
		));
		
		this.Questions.add(new ExamQuestion(
			4,
			"In what year was Google launched on the web?",
			new String[]{"1996", "1997", "1998", "1999"},
			2
		));
		
		this.Questions.add(new ExamQuestion(
			5,
			"What is the capital city of Australia ?	",
			new String[]{"Sydney", "Melbourne", "Brisbane", "Canberra"},
			3
		));
		//set closing date
		this.closingDate = new Date(2018, 2, 28);
		
	}

	@Override
	public String getInformation() {
		
		return "This is an example exam";
	}

	@Override
	public Date getClosingDate() {
		
		return closingDate;
	}

	@Override
	public List<ExamQuestion> getQuestions() {
		
		return Questions;
	}

	@Override
	public ExamQuestion getQuestion(int questionNumber) throws InvalidQuestionNumber {
		
		return Questions.get(questionNumber-1);
	}

	@Override
	public void selectAnswer(int questionNumber, int optionNumber) throws InvalidQuestionNumber, InvalidOptionNumber {
		//
		this.getQuestion(questionNumber).selectAnswer(optionNumber);

	}

	@Override
	public int getSelectedAnswer(int questionNumber) {
		//
		return this.getSelectedAnswer(questionNumber);
		
	}

	@Override
	public int getAssociatedID() {
		// 
		return this.studentId;
	}

}
