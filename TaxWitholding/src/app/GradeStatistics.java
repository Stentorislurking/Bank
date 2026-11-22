package app;

import java.util.Scanner;

public class GradeStatistics {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // the loop counter stops at 10, so the loop cant run forever
        final int NUM_GRADES = 10;

        double total = 0;
        double max = 0;
        double min = 0;

        for (int i = 1; i <= NUM_GRADES; i++) {
            System.out.print("Enter grade " + i + ": ");
            double grade = input.nextDouble();

            total += grade;

            if (i == 1) {
                max = grade;
                min = grade;
            } else {
                if (grade > max) {
                    max = grade;
                }
                if (grade < min) {
                    min = grade;
                }
            }
        }

        double average = total / NUM_GRADES;

        System.out.println("Average: " + average);
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);

        input.close();
    }
}