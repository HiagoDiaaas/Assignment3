package Problem2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");

        System.out.print("Please, enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Please, enter your last name: ");
        String lastName = scanner.nextLine();

        LocalDate birthDate = null;
        while (birthDate == null) {
            System.out.print("Please, enter your birth date in the format-(yyyy-MM-dd)-Example 1989-4-14: ");
            String birthDateString = scanner.nextLine();
            try {
                birthDate = LocalDate.parse(birthDateString, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }

        HeartRates heartRates = new HeartRates(firstName, lastName, birthDate);

        heartRates.printTargetHeartRateRange();
        System.out.println(heartRates);
    }
}

