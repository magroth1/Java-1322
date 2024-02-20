import java.util.Scanner;
import java.util.ArrayList;

public class mgroth1_lab3 {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        quiz q1 = new quiz();
        int userOption;
        do {
            System.out.println(
                    "What would you like to do \n1. Add a question \n2. Remove a Question from the quiz \n3.modify a question in the quiz \n4. take the quiz \n5. Quit");
            userOption = s1.nextInt();

            if (userOption == 1) {
                q1.add_question();
            } else if (userOption == 2) {
                q1.remove_question();
            } else if (userOption == 3) {
                q1.modify_question();
            } else if (userOption == 4) {
                q1.give_quiz();
            }
        } while (userOption != 5);

    }
}

class questions {
    private String question;
    private String answer;
    private int difficulty;

    public questions(String question, String answer, int difficult) {
        this.question = question;
        this.answer = answer;
        setDifficulty(difficulty);

    }

    // getters
    public String getQuestion() {
        return this.question;
    }

    public String getAnswer() {
        return this.answer;
    }

    public int getDifficulty() {
        return this.difficulty;
    }

    // setters
    public void setQuestion(String newQuestion) {
        this.question = newQuestion;
    }

    public void setAnswer(String newAnswer) {
        this.answer = newAnswer;
    }

    public void setDifficulty(int newDifficulty) {
        this.difficulty = newDifficulty;
    }
}

class quiz {
    Scanner s1 = new Scanner(System.in);
    ArrayList<questions> quiz = new ArrayList<>();

    public void add_question() {
        System.out.println("Enter new quiz question?");
        String question = s1.nextLine();
        System.out.println("What is the answer?");
        String answer = s1.nextLine();
        System.out.println("On a scale 1-3 how difficult is the question?");
        int difficulty = s1.nextInt();
        s1.nextLine();
        quiz.add(new questions(question, answer, difficulty));
    }

    public void remove_question() {
        for (int i = 0; i < quiz.size(); i++) {
            System.out.println(i + ":" + quiz.get(i).getQuestion());
        }
        System.out.println("which question would you like to remove");
        int removeQuestion = s1.nextInt();
        s1.nextLine();
        quiz.get(removeQuestion).getQuestion();
    }

    public void modify_question() {
        for (int i = 0; i < quiz.size(); i++) {
            System.out.println(i + ": " + quiz.get(i).getQuestion());
        }
        System.out.println("which question would you like to Modify");
        int modifyQuestion = s1.nextInt();
        s1.nextLine();
        System.out.println("What would you like to change the question to?");
        String newQuestion = s1.nextLine();
        quiz.get(modifyQuestion).setQuestion(newQuestion);
    }

    public void give_quiz() {
        int count = 0;
        for (int i = 0; i < quiz.size(); i++) {
            System.out.println(i + ": " + quiz.get(i).getQuestion());
            String Answer = s1.nextLine();
            if (Answer.equalsIgnoreCase(quiz.get(i).getAnswer())) {
                System.out.println("Correct");
                count++;
            } else {
                System.out.println("Incorrect");
            }

        }
        System.out.println("you got " + count + " out of " + quiz.size() + " right");
    }
}
