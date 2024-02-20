import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private static final int QUIZ_DURATION = 60; // Quiz duration in seconds
    private static final int NUM_QUESTIONS = 6; // Number of questions in the quiz

    private static int score = 0;
    private static int currentQuestion = 0;
    private static Timer timer;
    private static Scanner scanner = new Scanner(System.in);

    private static String[] questions = {
            "What is the capital of France?",
            "What is the largest planet in our solar system?",
            "Who wrote 'Romeo and Juliet'?",
            "What is the chemical symbol for water?",
            "Who painted the Mona Lisa?",
            "what is the full form of ISRO?"
    };

    private static String[][] options = {
            {"A. London", "B. Paris", "C. Berlin", "D. Rome"},
            {"A. Mars", "B. Jupiter", "C. Earth", "D. Saturn"},
            {"A. Charles Dickens", "B. William Shakespeare", "C. Jane Austen", "D. Mark Twain"},
            {"A. Wa", "B. Wt", "C. H2O", "D. W"},
            {"A. Vincent van Gogh", "B. Leonardo da Vinci", "C. Pablo Picasso", "D. Michelangelo"},
            {"A. Indian Space research organization", "B. nhi pta", "C. nhi btaunga ", "D. none"}
    };

    private static String[] answers = {"B", "B", "B", "C", "B","A"};

    public static void main(String[] args) {
        startQuiz();
    }

    private static void startQuiz() {
        System.out.println("Welcome to the Quiz! You have " + QUIZ_DURATION + " seconds to complete.");
        timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                endQuiz();
            }
        }, QUIZ_DURATION * 1000);

        displayQuestion();
    }

    private static void displayQuestion() {
        if (currentQuestion < NUM_QUESTIONS) {
            System.out.println("\nQuestion " + (currentQuestion + 1) + ": " + questions[currentQuestion]);
            for (String option : options[currentQuestion]) {
                System.out.println(option);
            }
            System.out.print("Your answer: ");
            String answer = scanner.nextLine().toUpperCase();

            if (answer.equals(answers[currentQuestion])) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer is " + answers[currentQuestion]);
            }

            currentQuestion++;
            displayQuestion();
        } else {
            endQuiz();
        }
    }

    private static void endQuiz() {
        timer.cancel();
        System.out.println("\nQuiz finished!");
        System.out.println("Your score: " + score + " out of " + NUM_QUESTIONS);
    }
}
