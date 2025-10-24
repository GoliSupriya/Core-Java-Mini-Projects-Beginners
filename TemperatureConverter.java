
import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double temp, newTemp;
        String unit;

        System.out.println("Temperature Converter");
        System.out.print("Enter temperature:");
        temp = s.nextDouble();

        System.out.print("Enter unit (C for Celsius, F for Fahrenheit): ");
        unit = s.next().toUpperCase();
        if (unit.equals("C")) {
            newTemp = (temp * 9 / 5) + 32;
            System.out.printf("Temperature in Fahrenheit: %.2f F%n", newTemp);
        } else if (unit.equals("F")) {
            newTemp = (temp - 32) * 5 / 9;
            System.out.printf("Temperature in Celsius: %.2f C%n", newTemp);
        } else {
            System.out.println("Invalid unit");
        }

        s.close();
    }
}
