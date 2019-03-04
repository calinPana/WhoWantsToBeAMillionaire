package ro.jademy.millionaire;

import java.util.*;

public class Game {


    private ArrayList<Question> questions = new ArrayList<>();

    int currentQIndex = 0;
    int currentDifficulty = 1;

    public Game() {
        // initializam noi instante de intrebari
        // le adaugam la lista
        ArrayList<WrongAnswer> w1 = new ArrayList<>();
        w1.add(new WrongAnswer("Budapest"));
        w1.add(new WrongAnswer("Madrid"));
        w1.add(new WrongAnswer("Istanbul"));
        Question q1 = new Question("What is the capital of Romania?", new RightAnswer("Bucharest"), w1, 1);

        questions.add(q1);

        ArrayList<WrongAnswer> w2 = new ArrayList<>();
        w2.add(new WrongAnswer("English"));
        w2.add(new WrongAnswer("Spanish"));
        w2.add(new WrongAnswer("Brazillian"));
        Question q2 = new Question("What is the official language of Brazil?", new RightAnswer("Portuguese"), w2, 3);

        questions.add(q2);

        ArrayList<WrongAnswer> w3 = new ArrayList<>();
        w3.add(new WrongAnswer("Martin Scorsese"));
        w3.add(new WrongAnswer("Quentin Tarantino"));
        w3.add(new WrongAnswer("Clint Eastwood"));
        Question q3 = new Question("Who directed ET?", new RightAnswer("Steven Spielberg"), w3, 1);

        questions.add(q3);

        ArrayList<WrongAnswer> w4 = new ArrayList<>();
        w4.add(new WrongAnswer("Boeing 747"));
        w4.add(new WrongAnswer("Antonov 225"));
        w4.add(new WrongAnswer("McDonell Douglas MD 82"));
        Question q4 = new Question("What is the biggest passenger airplane in the world?", new RightAnswer("Airbus A380"), w4, 3);

        questions.add(q4);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return currentQIndex == game.currentQIndex &&
                Objects.equals(questions, game.questions);
    }

    @Override
    public int hashCode() {

        return Objects.hash(questions, currentQIndex);
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
            ArrayList<Question> sameDiffQuestions = new ArrayList<>();
            do {
                for (int i = 0; i < questions.size(); i++) {
                    if (questions.get(i).getDifficulty() == currentDifficulty) {
                        sameDiffQuestions.add(questions.get(i));
                    }
                }
                if (sameDiffQuestions.isEmpty()) {
                    currentDifficulty++;
                }
            } while (sameDiffQuestions.isEmpty() && currentDifficulty < 4);
            Collections.shuffle(sameDiffQuestions);
            currentDifficulty++;

            int whatAnswer = printQuestionRandAns(sameDiffQuestions.get(1));
            //System.out.println("whatAnswer este " + whatAnswer);
            correctAnswer = chooseAnswer(questions.get(currentQIndex), whatAnswer);
            currentQIndex++;
            if (correctAnswer) {
                score++;
            }
        } while ((correctAnswer) && currentQIndex < questions.size() && currentDifficulty < 10);

        endGame();
        System.out.print(score);
    }

/*
    public void printQuestion(Question q) {
        System.out.println(q.getText());
        System.out.println(q.getRightAns());

    getText();
        for(
    int i = 0;
    i< 3;i++)

    {
        System.out.println(q.getWrongAnss().get(i).getText());
    }

} */

    public int printQuestionRandAns(Question q) {
        int corrAnswer = 0;
        System.out.println(q.getText());
        ArrayList<Answer> answers = new ArrayList<>();
        answers.add(q.getRightAns());
        for (int i = 0; i < 3; i++) {
            answers.add(q.getWrongAnss().get(i));
        }
        //Random r = new Random();
        Collections.shuffle(answers);
        for (int j = 0; j < 4; j++) {
            System.out.println((j + 1) + ". " + answers.get(j).getText());
            if (q.getRightAns().equals(answers.get(j))) {
                corrAnswer = j + 1;
            }
        }
        return corrAnswer;
    }


    public boolean chooseAnswer(Question q, int whatAnswer) {
        System.out.println("What is your answer? 1, 2, 3 or 4?");
        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();
        boolean isCorrect = true;
        do {
            if (answer == whatAnswer) {
                System.out.println("Correct answer! Let's move to the next question!");
                return true;

            } else if (answer != whatAnswer) {
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
