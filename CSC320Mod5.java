import java.util.ArrayList;
import java.util.Scanner;

public class CSC320Mod5 {

	public static void main(String[] args) {
		// ArrayLists to store days and temperatures
        ArrayList<String> days = new ArrayList<>();
        ArrayList<Double> temperatures = new ArrayList<>();

        // Add days of the week to the days ArrayList
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (String day : weekDays) {
            days.add(day);
        }

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user for temperatures for each day
        for (String day : days) {
            System.out.print("Enter the average temperature for " + day + ": ");
            double temp = scanner.nextDouble();
            temperatures.add(temp);
        }

        // Prompt user for day or "week"
        System.out.print("Enter a day of the week or Enter 'week' to display all temperatures: ");
        String input = scanner.next();

        // Display results based on user input
        if (input.equalsIgnoreCase("week")) {
            double total = 0;
            System.out.println("\nWeekly Temperatures:");
            for (int i = 0; i < days.size(); i++) {
                System.out.println(days.get(i) + ": " + temperatures.get(i) + "°C");
                total += temperatures.get(i);
            }
            double weeklyAverage = total / days.size();
            System.out.printf("Weekly Average Temperature: %.2f°C\n", weeklyAverage);
        } else {
            int index = days.indexOf(input);
            if (index != -1) {
                System.out.println(input + ": " + temperatures.get(index) + "°C");
            } else {
                System.out.println("Invalid day entered. Please try again.");
            }
        }

        scanner.close();

	}

}
