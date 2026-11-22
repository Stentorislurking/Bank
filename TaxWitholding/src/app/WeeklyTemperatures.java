package app;

import java.util.ArrayList;
import java.util.Scanner;

public class WeeklyTemperatures {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<String> days = new ArrayList<String>();
        ArrayList<Double> temps = new ArrayList<Double>();

        days.add("Monday");
        temps.add(68.0);
        days.add("Tuesday");
        temps.add(71.5);
        days.add("Wednesday");
        temps.add(73.0);
        days.add("Thursday");
        temps.add(69.5);
        days.add("Friday");
        temps.add(75.0);
        days.add("Saturday");
        temps.add(78.0);
        days.add("Sunday");
        temps.add(72.0);

        // the loop only ends when the user types exit
        boolean running = true;

        while (running) {
            System.out.print("Enter a day, \"week\" for all days, or \"exit\" to quit: ");
            String choice = input.next();

            if (choice.equalsIgnoreCase("exit")) {
                running = false;
            } else if (choice.equalsIgnoreCase("week")) {
                double total = 0;

                for (int i = 0; i < days.size(); i++) {
                    System.out.printf("%s: %.1f degrees F%n", days.get(i), temps.get(i));
                    total += temps.get(i);
                }

                double average = total / temps.size();
                System.out.printf("Weekly average: %.1f degrees F%n", average);
            } else {
                boolean found = false;

                for (int i = 0; i < days.size(); i++) {
                    if (days.get(i).equalsIgnoreCase(choice)) {
                        System.out.printf("%s: %.1f degrees F%n", days.get(i), temps.get(i));
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("That is not a day of the week, try again.");
                }
            }
        }

        input.close();
    }
}