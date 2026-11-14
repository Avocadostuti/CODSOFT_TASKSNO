import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int maxAttempts = 7;
        int roundsPlayed = 0;
        int roundsWon = 0;
        int totalAttempts = 0;
        int score = 0;

        char playAgain;

        System.out.println("================================");
        System.out.println("       WELCOME TO NUMBER GAME");
        System.out.println("================================");

        do {

            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            roundsPlayed++;

            System.out.println("\nRound " + roundsPlayed);
            System.out.println("I have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts && !guessedCorrectly) {

                System.out.print("\nEnter your guess: ");

                if (!sc.hasNextInt()) {
                    System.out.println("Please enter a valid number!");
                    sc.next();
                    continue;
                }

                int guess = sc.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println("Enter a number between 1 and 100.");
                    continue;
                }

                attempts++;
                totalAttempts++;

                if (guess == secretNumber) {

                    System.out.println("Congratulations! Correct guess!");
                    guessedCorrectly = true;

                    roundsWon++;
                    score += 10;

                    System.out.println("You earned 10 points!");

                } else if (guess < secretNumber) {

                    System.out.println("Too low! Try a higher number.");

                } else {

                    System.out.println("Too high! Try a lower number.");

                }

                System.out.println("Attempts remaining: "
                        + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {

                System.out.println("\nGame Over!");
                System.out.println("The correct number was: " + secretNumber);

            }

            System.out.println("\n---------- ROUND SUMMARY ----------");
            System.out.println("Attempts used: " + attempts);
            System.out.println("Rounds won: " + roundsWon);
            System.out.println("Current score: " + score);
            System.out.println("-----------------------------------");

            System.out.print("\nDo you want to play again? (Y/N): ");

            playAgain = sc.next().toUpperCase().charAt(0);

        } while (playAgain == 'Y');

        System.out.println("\n================================");
        System.out.println("          FINAL SCORE");
        System.out.println("================================");

        System.out.println("Total rounds played: " + roundsPlayed);
        System.out.println("Rounds won: " + roundsWon);
        System.out.println("Total attempts: " + totalAttempts);
        System.out.println("Final score: " + score);

        System.out.println("\nThank you for playing!");

        sc.close();
    }
}