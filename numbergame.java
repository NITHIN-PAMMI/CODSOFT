import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalRoundsWon = 0;
        while (true) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;

            System.out.println("THIS IS A NUMBER GUESSING GAME");
            System.out.println("Now think of a number between 1 and 10 where you will have 10 attempts to guess the number");
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + numberToGuess + " in " + attempts + " attempts.");
                    totalRoundsWon++;
                    break;
                }
            }
            if (attempts == maxAttempts) {
                System.out.println("Sorry! You've used all " + maxAttempts + " attempts. The number was " + numberToGuess + ".");
            }
            System.out.print("Do you want to play another round? (YES/NO): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }
        System.out.println("You won " + totalRoundsWon + " round(s). Thanks for playing!");
        scanner.close();
    }
}

