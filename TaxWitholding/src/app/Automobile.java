package app;

public class Automobile {

    // attributes for one vehicle in the dealership inventory
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;

    // default constructor, makes an empty vehicle
    public Automobile() {
        make = "";
        model = "";
        color = "";
        year = 0;
        mileage = 0;
    }

    // parameterized constructor, fills in everything up front
    public Automobile(String make, String model, String color, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }

    // adds a new vehicle, only works if no vehicle is stored right now
    public String addVehicle(String make, String model, String color,
                             int year, int mileage) {
        try {
            if (!this.make.isEmpty()) {
                throw new IllegalStateException("a vehicle is already stored");
            }
            checkValues(make, model, color, year, mileage);
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;
            return "Success: vehicle added.";
        } catch (Exception e) {
            return "Failure: could not add vehicle, " + e.getMessage() + ".";
        }
    }

    // lists the vehicle info, returns it as a string array
    public String[] listVehicle() {
        try {
            if (make.isEmpty()) {
                throw new IllegalStateException("no vehicle is stored");
            }
            String[] details = new String[5];
            details[0] = "Make: " + make;
            details[1] = "Model: " + model;
            details[2] = "Color: " + color;
            details[3] = "Year: " + year;
            details[4] = "Mileage: " + mileage;
            return details;
        } catch (Exception e) {
            return new String[] { "Failure: could not list vehicle, " + e.getMessage() + "." };
        }
    }

    // removes the vehicle by clearing the variables
    public String removeVehicle() {
        try {
            if (make.isEmpty()) {
                throw new IllegalStateException("no vehicle is stored");
            }
            make = "";
            model = "";
            color = "";
            year = 0;
            mileage = 0;
            return "Success: vehicle removed.";
        } catch (Exception e) {
            return "Failure: could not remove vehicle, " + e.getMessage() + ".";
        }
    }

    // updates the vehicle attributes, only works if a vehicle is stored
    public String updateVehicle(String make, String model, String color,
                                int year, int mileage) {
        try {
            if (this.make.isEmpty()) {
                throw new IllegalStateException("no vehicle is stored");
            }
            checkValues(make, model, color, year, mileage);
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;
            return "Success: vehicle updated.";
        } catch (Exception e) {
            return "Failure: could not update vehicle, " + e.getMessage() + ".";
        }
    }

    // makes sure the values make sense before they get stored
    private void checkValues(String make, String model, String color, int year, int mileage) {
        if (make == null || make.isEmpty() || model == null || model.isEmpty()
                || color == null || color.isEmpty()) {
            throw new IllegalArgumentException("make, model, and color cannot be empty");
        }
        if (year < 1900 || year > 2027) {
            throw new IllegalArgumentException("year must be between 1900 and 2027");
        }
        if (mileage < 0) {
            throw new IllegalArgumentException("mileage cannot be negative");
        }
    }
}