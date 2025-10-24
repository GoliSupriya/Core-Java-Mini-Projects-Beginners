
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Rock, Paper, Scissors Game");
        String[] choices = { "Rock", "Paper", "Scissors" };
        String playerChoice;
        String playAgain = "yes";

        do {
            // User input
            System.out.print("Enter your choice (Rock, Paper, Scissors): ");
            playerChoice = scanner.nextLine().toLowerCase();

            if (!playerChoice.equals("rock") && !playerChoice.equals("paper") && !playerChoice.equals("scissors")) {
                System.out.println("Invalid choice. Please choose Rock, Paper, or Scissors.");
                continue;
            }

            // Computer choice
            String computerChoice = choices[random.nextInt(3)];
            System.out.println("Computer chose: " + computerChoice);

            // Determine winner
            if (playerChoice.equalsIgnoreCase(computerChoice)) {
                System.out.println("It's a tie!");
            } else if ((playerChoice.equalsIgnoreCase("rock") && computerChoice.equals("scissors"))
                    || (playerChoice.equalsIgnoreCase("paper") && computerChoice.equals("rock"))
                    || (playerChoice.equalsIgnoreCase("scissors") && computerChoice.equals("paper"))) {
                System.out.println("You win!");
            } else {
                System.out.println("You loss!");
            }
            System.out.println("Play again? (yes/no): ");
            playAgain = scanner.nextLine().toLowerCase();

        } while (playAgain.equals("yes"));
        System.out.println("Thanks for playing! Goodbye.");
        scanner.close();
    }
}
