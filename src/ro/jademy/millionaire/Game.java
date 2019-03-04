package ro.jademy.millionaire;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Game {

    private ArrayList<Question> questions = new ArrayList<>();

    int currentQIndex = 0;

    public Game() {
        // initializam noi instante de intrebari
        // le adaugam la lista
        ArrayList<WrongAnswer> w1 = new ArrayList<>();
        w1.add(new WrongAnswer("Budapest"));
        w1.add(new WrongAnswer("Madrid"));
        w1.add(new WrongAnswer("Istanbul"));
        Question q1 = new Question("What is the capital of Romania?", new RightAnswer("Bucharest"), w1);

        questions.add(q1);

        ArrayList<WrongAnswer> w2 = new ArrayList<>();
        w2.add(new WrongAnswer("English"));
        w2.add(new WrongAnswer("Spanish"));
        w2.add(new WrongAnswer("Brazillian"));
        Question q2 = new Question("What is the official language of Brazil?", new RightAnswer("Portuguese"), w2);

        questions.add(q2);

    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Who wants to be a millionaire! ");
        System.out.println("Are you ready?");
        System.out.println("Choose 1 for YES and 2 to exit");
        int choice = sc.nextInt();
        do {
            if (choice == 1) {
                System.out.println("Great! Let's begin!");

                // show questions
                break;

            } else if (choice == 2) {
                System.exit(0);
            } else {

                // change into a repetitive do-while statement
                // do show the menu options until 1 or 2 is chosen

                System.out.println("You have to choose between 1 and 2");
                choice = sc.nextInt();
            }
        } while (!(choice == 1 || choice == 2));


        // show questions
        boolean correctAnswer = true;
        int score = 0;
        do {

            printQuestion(questions.get(currentQIndex));
            correctAnswer = chooseAnswer(questions.get(currentQIndex));
            currentQIndex++;
            if (correctAnswer) {
                score++;
            }
        } while ((correctAnswer) && currentQIndex < questions.size());
        endGame();
        System.out.print(score);
    }


    public void printQuestion(Question q) {
        System.out.println(q.getText());
        System.out.println(q.getRightAns().getText());
        for (int i = 0; i < 3; i++) {
            System.out.println(q.getWrongAnss().get(i).getText());
        }

    }

    public boolean chooseAnswer(Question q) {
        System.out.println("What is your answer? 1, 2, 3 or 4?");
        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();
        boolean isCorrect = true;
        do {
            if (answer == 1) {
                System.out.println("Correct answer! Let's move to the next question!");
                return true;

            } else if (answer == 2 || answer == 3 || answer == 4) {
                System.out.println("Wrong answer! Game over!");
                isCorrect = false;
                return false;

            } else {
                System.out.println("You have to choose between 1 and 4");
                answer = sc.nextInt();
            }
        } while (!(answer == 1 || answer == 2 || answer == 3 || answer == 4));

        return false;

    }

    public void endGame() {
        System.out.print("This is the end of the game! Your score is ");
    }
}
