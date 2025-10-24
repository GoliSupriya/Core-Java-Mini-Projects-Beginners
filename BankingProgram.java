
import java.util.Scanner;

public class BankingProgram {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // declare variables
        double balance = 0.0;
        boolean isActive = true;
        int choice;

        while (isActive) {
            // Display welcome message
            System.out.println("******");
            System.out.println("Welcome to the Banking Program!");
            System.out.println("******");
            System.out.println("1.Show Balance");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Exit");

            // Get and process user choice
            System.out.print("Enter your choice(1-4):");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> showBalance(balance);
                case 2 -> balance = balance + deposit(balance);
                case 3 -> balance = balance - withdraw(balance);
                case 4 -> isActive = false;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for using the Banking Program. Goodbye!");
        scanner.close();

    }

    static void showBalance(double balance) {
        System.out.printf("$%.2f\n", balance);
    }

    static double deposit(double balance) {
        double amount;

        System.out.print("Enter deposit amount: ");
        amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully deposited $%.2f\n", amount);
            return balance;
        } else if (amount < 0) {
            System.out.println("Deposit amount must be positive.");
            return 0;
        }

        return amount;
    }

    static double withdraw(double balance) {

        double amount;
        System.out.print("Enter withdraw amount: ");
        amount = scanner.nextDouble();
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return 0;
        } else if (amount < 0) {
            System.out.println("Withdraw amount must be positive.");
            return 0;
        } else {
            return amount;
        }
    }
}
