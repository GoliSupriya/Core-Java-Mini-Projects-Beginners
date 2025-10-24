
import java.util.Scanner;

public class WeightConverter {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double weight;
        double newWeight;
        int choice;

        System.out.println("Weight Converter");
        System.out.println("1. Convert lbs to kgs");
        System.out.println("2. Convert kgs to lbs");

        System.out.print("Choose an option: ");
        choice = s.nextInt();

        if (choice == 1) {
            System.out.print("Enter weight in lbs: ");
            weight = s.nextDouble();
            newWeight = weight * 0.453592;
            System.out.printf("Weight in kgs: %.2f%n", newWeight);
        } else if (choice == 2) {
            System.out.print("Enter weight in kgs: ");
            weight = s.nextDouble();
            newWeight = weight / 0.453592;
            System.out.printf("Weight in lbs: %.2f%n", newWeight);
        } else {
            System.out.println("Invalid choice");
        }

        s.close();
    }
}
