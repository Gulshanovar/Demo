import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalRounds;
        int userScore = 0;

        System.out.println("Welcome to the Number Guessing Game!"); 

        // Input the number of rounds
        System.out.print("Enter the number of rounds: ");
        totalRounds = scanner.nextInt();

        for (int round = 1; round <= totalRounds; round++) {
            System.out.println("\nRound " + round + ":");
            int randomNumber = random.nextInt(100) + 1;
            int userGuess;
            boolean correctGuess = false;

            do {
                System.out.print("Guess the number (between 1 and 100): ");
                userGuess = scanner.nextInt();

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    correctGuess = true;
                    userScore += 10;
                } else if (userGuess < randomNumber) {
                    System.out.println("Try a higher number.");
                } else {
                    System.out.println("Try a lower number.");
                }
            } while (!correctGuess);

            System.out.println("Score for Round " + round + ": " + userScore);
        }

        System.out.println("\nGame Over!");
        System.out.println("Total Score: " + userScore);

        scanner.close();
    }
}
