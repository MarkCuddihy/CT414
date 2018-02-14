package rmi;

public class ExamQuestion implements Question {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int questionNumber;
	private String questionDetails;
	private String questionAnswers[];
	private int answerCorrect;
	private int answerSelected;
	
	public ExamQuestion() {
		super();
	}
	
	public ExamQuestion(int qNum, String qDetails, String[] qAnswers, int aCorrect) {
		super();
		this.questionNumber = qNum;
		this.questionDetails = qDetails;
		this.questionAnswers = qAnswers;
		this.answerCorrect = aCorrect;
	}

	@Override
	public int getQuestionNumber() {
		return questionNumber;
	}

	@Override
	public String getQuestionDetail() {
		
		return questionDetails;
	}

	@Override
	public String[] getAnswerOptions() {
		return questionAnswers;
	}
	
	public int getCorrectAnswer() {
		return answerCorrect;
	}
	
	public void selectAnswer(int answer) {
		this.answerSelected = answer;
	}
	
	public int getSelectedAnswer() {
		return answerSelected;
	}

}
