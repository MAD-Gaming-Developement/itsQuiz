package subject.trivia;

import java.util.ArrayList;
import java.util.List;

public class AnswerString {

    private String question;
    private List<String> answers = new ArrayList<>();
    private String rightAnswer;

    public AnswerString(String question, String rightAnswer, String... answers) {
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.answers.add(answers[0]);
        this.answers.add(answers[1]);
        this.answers.add(answers[2]);
        this.answers.add(answers[3]);
    }

    public String getAnswerString() {
        return question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public String getOptionA() {
        return answers.get(0);
    }

    public String getOptionB() {
        return answers.get(1);
    }

    public String getOptionC() {
        return answers.get(2);
    }

    public String getOptionD() {
        return answers.get(3);
    }

}
