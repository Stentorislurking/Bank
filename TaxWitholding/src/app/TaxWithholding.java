package app;

import java.util.Scanner;

public class TaxWithholding {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your weekly income: ");
        double weeklyIncome = input.nextDouble();

        double taxRate;

        if (weeklyIncome < 500) {
            taxRate = 0.10;
        } else if (weeklyIncome < 1500) {
            taxRate = 0.15;
        } else if (weeklyIncome < 2500) {
            taxRate = 0.20;
        } else {
            taxRate = 0.30;
        }

        double withholding = weeklyIncome * taxRate;

        System.out.println("Tax rate: " + (taxRate * 100) + "%");
        System.out.println("Weekly tax withholding: $" + withholding);

        input.close();
    }
}