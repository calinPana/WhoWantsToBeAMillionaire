package ro.jademy.millionaire;

import java.util.ArrayList;

public class Question {
    private String text;
    private RightAnswer rightAns;
    private ArrayList<WrongAnswer> wrongAnss;
    private int difficulty;

    public Question(String text) {
        this.text = text;
    }

    public Question(String text, RightAnswer rightAns, ArrayList<WrongAnswer> wrongAnss) {
        this.text = text;
        this.rightAns = rightAns;
        this.wrongAnss = wrongAnss;
    }

    public Question(String text, RightAnswer rightAns, ArrayList<WrongAnswer> wrongAnss, int difficulty) {
        this.text = text;
        this.rightAns = rightAns;
        this.wrongAnss = wrongAnss;
        this.difficulty = difficulty;
    }

    public String getText() {
        return text;
    }

    public RightAnswer getRightAns() {
        return rightAns;
    }

    public ArrayList<WrongAnswer> getWrongAnss() {
        return wrongAnss;
    }

    public int getDifficulty() { return difficulty; }
}
