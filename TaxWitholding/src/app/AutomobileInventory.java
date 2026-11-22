package app;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class AutomobileInventory {

    // predefined location for the output file
    private static final String FILE_PATH = "C:\\Temp\\Autos.txt";

    public static void main(String[] args) {
        try {
            // create the vehicle with the parameterized constructor
            Automobile car = new Automobile("Honda", "Civic", "Blue", 2012, 85000);

            // list the values and loop through the array
            System.out.println("Starting vehicle:");
            printDetails(car.listVehicle());

            // remove the vehicle to clear the variables
            System.out.println();
            System.out.println(car.removeVehicle());

            // add a new vehicle
            System.out.println(car.addVehicle("Toyota", "Camry", "Silver", 2018, 42000));

            // list the new vehicle
            System.out.println();
            System.out.println("New vehicle:");
            printDetails(car.listVehicle());

            // update the vehicle
            System.out.println();
            System.out.println(car.updateVehicle("Toyota", "Camry", "Black", 2018, 45500));

            // list the updated vehicle
            System.out.println();
            System.out.println("Updated vehicle:");
            String[] finalDetails = car.listVehicle();
            printDetails(finalDetails);

            // ask if the user wants the info printed to a file
            System.out.println();
            System.out.print("Do you want to print the information to a file? (Y or N): ");
            Scanner input = new Scanner(System.in);
            String answer = input.next();

            if (answer.equalsIgnoreCase("Y")) {
                System.out.println(printToFile(finalDetails));
            } else {
                System.out.println("A file will not be printed.");
            }
            input.close();

        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    // loops through the array and prints each line
    private static void printDetails(String[] details) {
        for (String line : details) {
            System.out.println(line);
        }
    }

    // writes the vehicle info to the predefined file location
    private static String printToFile(String[] details) {
        try {
            File file = new File(FILE_PATH);
            File folder = file.getParentFile();
            if (folder != null && !folder.exists()) {
                folder.mkdirs();
            }
            PrintWriter writer = new PrintWriter(new FileWriter(file));
            for (String line : details) {
                writer.println(line);
            }
            writer.close();
            return "Success: file printed to " + FILE_PATH;
        } catch (Exception e) {
            return "Failure: could not print file, " + e.getMessage();
        }
    }
}
