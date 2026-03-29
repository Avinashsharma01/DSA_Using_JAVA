/**
 * Car Class - Demonstrates Constructor Overloading and Object Initialization
 *
 * This class shows:
 * - Multiple constructors (constructor overloading)
 * - Different ways to initialize objects
 * - Method chaining
 * - Object state management
 */

package PracticeOOp.Classes_And_Objects_01;
public class Car {
    // Instance variables
    private String brand;
    private String model;
    private int year;
    private String color;
    private double price;
    private int mileage;
    private boolean isRunning;

    // Constructor 1: Default constructor
    public Car() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.year = 2020;
        this.color = "White";
        this.price = 0.0;
        this.mileage = 0;
        this.isRunning = false;
        System.out.println("Car created with default values");
    }

    // Constructor 2: Brand and model only
    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.year = 2023; // Default to current year
        this.color = "White"; // Default color
        this.price = 0.0;
        this.mileage = 0;
        this.isRunning = false;
        System.out.println("Car created: " + brand + " " + model);
    }

    // Constructor 3: Brand, model, and year
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = "White"; // Default color
        this.price = 0.0;
        this.mileage = 0;
        this.isRunning = false;
        System.out.println("Car created: " + year + " " + brand + " " + model);
    }

    // Constructor 4: All basic details
    public Car(String brand, String model, int year, String color, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.mileage = 0; // New car has 0 mileage
        this.isRunning = false;
        System.out.println("Car created: " + year + " " + color + " " + brand + " " + model + " - $" + price);
    }

    // Constructor 5: Copy constructor (creates a copy of another car)
    public Car(Car otherCar) {
        this.brand = otherCar.brand;
        this.model = otherCar.model;
        this.year = otherCar.year;
        this.color = otherCar.color;
        this.price = otherCar.price;
        this.mileage = otherCar.mileage;
        this.isRunning = false; // New copy starts turned off
        System.out.println("Car copied from existing car");
    }

    // Getter methods
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public String getColor() { return color; }
    public double getPrice() { return price; }
    public int getMileage() { return mileage; }
    public boolean isRunning() { return isRunning; }

    // Setter methods with validation
    public void setBrand(String brand) {
        if (brand != null && !brand.trim().isEmpty()) {
            this.brand = brand;
        }
    }

    public void setModel(String model) {
        if (model != null && !model.trim().isEmpty()) {
            this.model = model;
        }
    }

    public void setYear(int year) {
        if (year >= 1886 && year <= 2025) { // First car was invented in 1886
            this.year = year;
        } else {
            System.out.println("Invalid year. Please enter a year between 1886 and 2025");
        }
    }

    public void setColor(String color) {
        if (color != null && !color.trim().isEmpty()) {
            this.color = color;
        }
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Price cannot be negative");
        }
    }

    // Car behavior methods
    public void startEngine() {
        if (!isRunning) {
            isRunning = true;
            System.out.println("🚗 " + brand + " " + model + " engine started!");
        } else {
            System.out.println("Engine is already running");
        }
    }

    public void stopEngine() {
        if (isRunning) {
            isRunning = false;
            System.out.println("🛑 " + brand + " " + model + " engine stopped");
        } else {
            System.out.println("Engine is already off");
        }
    }

    public void drive(int miles) {
        if (isRunning) {
            if (miles > 0) {
                mileage += miles;
                System.out.println("🚙 Drove " + miles + " miles. Total mileage: " + mileage);
            } else {
                System.out.println("Miles must be positive");
            }
        } else {
            System.out.println("Cannot drive. Please start the engine first!");
        }
    }

    public void honk() {
        System.out.println("📯 " + brand + " " + model + " says: BEEP BEEP!");
    }

    // Utility methods
    public int getCarAge() {
        return 2024 - year;
    }

    public String getCarCategory() {
        int age = getCarAge();
        if (age <= 2) {
            return "New";
        } else if (age <= 5) {
            return "Recent";
        } else if (age <= 10) {
            return "Used";
        } else {
            return "Vintage";
        }
    }

    public double getEstimatedValue() {
        // Simple depreciation calculation
        int age = getCarAge();
        double depreciationRate = 0.1; // 10% per year
        return Math.max(price * Math.pow(1 - depreciationRate, age), price * 0.1);
    }

    // Method to display full car information
    public void displayCarInfo() {
        System.out.println("\n🚗 ===== Car Information =====");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("Original Price: $" + String.format("%.2f", price));
        System.out.println("Current Mileage: " + mileage + " miles");
        System.out.println("Engine Status: " + (isRunning ? "Running" : "Off"));
        System.out.println("Car Age: " + getCarAge() + " years");
        System.out.println("Category: " + getCarCategory());
        System.out.println("Estimated Value: $" + String.format("%.2f", getEstimatedValue()));
        System.out.println("============================\n");
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %s ($%.2f, %d miles)",
                           year, color, brand, model, price, mileage);
    }
}
