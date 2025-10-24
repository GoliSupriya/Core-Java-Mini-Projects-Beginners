
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int guess;
        int attempts = 0;
        int randomNumber = random.nextInt(10) + 1; // Generates number between 1 and 10

        System.out.println("🎯 Number Guessing Game 🎯");
        System.out.println("Try to guess the number between 1 and 10!");

        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("🎉 Congratulations! You guessed the number " + randomNumber +
                        " in " + attempts + " attempts.");
            }

        } while (guess != randomNumber);

        scanner.close();
    }
}
