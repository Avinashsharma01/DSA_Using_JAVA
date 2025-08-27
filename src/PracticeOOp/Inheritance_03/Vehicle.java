/**
 * Vehicle Class - Base class demonstrating Inheritance
 *
 * This is the parent class that contains common properties and behaviors
 * that all vehicles share. Child classes will inherit these features.
 */
package PracticeOOp.Inheritance_03;

public class Vehicle {
    // Protected variables - accessible to subclasses
    protected String brand;
    protected String model;
    protected int year;
    protected String color;
    protected double price;
    protected int mileage;
    protected boolean isRunning;
    protected double fuelLevel;
    protected double maxFuelCapacity;

    // Private variables - not directly accessible to subclasses
    private String vin; // Vehicle Identification Number
    private String owner;
    private boolean isRegistered;

    // Constructor
    public Vehicle(String brand, String model, int year, String color, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.mileage = 0;
        this.isRunning = false;
        this.fuelLevel = 0.0;
        this.maxFuelCapacity = 50.0; // Default fuel capacity
        this.vin = generateVIN();
        this.owner = "Unknown";
        this.isRegistered = false;

        System.out.println("🚗 Vehicle created: " + year + " " + brand + " " + model);
    }

    // Public methods that subclasses can use
    public void startEngine() {
        if (fuelLevel <= 0) {
            System.out.println("❌ Cannot start - no fuel!");
            return;
        }

        if (!isRunning) {
            isRunning = true;
            System.out.println("🔥 " + brand + " " + model + " engine started!");
        } else {
            System.out.println("⚠️ Engine is already running");
        }
    }

    public void stopEngine() {
        if (isRunning) {
            isRunning = false;
            System.out.println("🛑 " + brand + " " + model + " engine stopped");
        } else {
            System.out.println("⚠️ Engine is already off");
        }
    }

    public void drive(int miles) {
        if (!isRunning) {
            System.out.println("❌ Cannot drive - engine is not running!");
            return;
        }

        if (fuelLevel <= 0) {
            System.out.println("❌ Cannot drive - out of fuel!");
            return;
        }

        if (miles <= 0) {
            System.out.println("❌ Miles must be positive");
            return;
        }

        // Calculate fuel consumption (basic formula)
        double fuelUsed = miles * 0.05; // 20 mpg average

        if (fuelUsed > fuelLevel) {
            int maxMiles = (int)(fuelLevel / 0.05);
            System.out.println("⛽ Not enough fuel! You can only drive " + maxMiles + " miles");
            mileage += maxMiles;
            fuelLevel = 0;
        } else {
            mileage += miles;
            fuelLevel -= fuelUsed;
            System.out.println("🚙 Drove " + miles + " miles. Total mileage: " + mileage);
            System.out.printf("⛽ Fuel remaining: %.1f/%.1f gallons\n", fuelLevel, maxFuelCapacity);
        }
    }

    public void refuel(double gallons) {
        if (gallons <= 0) {
            System.out.println("❌ Fuel amount must be positive");
            return;
        }

        double newFuelLevel = fuelLevel + gallons;
        if (newFuelLevel > maxFuelCapacity) {
            double overflow = newFuelLevel - maxFuelCapacity;
            fuelLevel = maxFuelCapacity;
            System.out.printf("⛽ Refueled! Tank full. %.1f gallons overflow\n", overflow);
        } else {
            fuelLevel = newFuelLevel;
            System.out.printf("⛽ Added %.1f gallons. Fuel level: %.1f/%.1f\n",
                            gallons, fuelLevel, maxFuelCapacity);
        }
    }

    public void honk() {
        System.out.println("📯 " + brand + " " + model + " says: BEEP BEEP!");
    }

    // Getters for protected variables (accessible to subclasses)
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public String getColor() { return color; }
    public double getPrice() { return price; }
    public int getMileage() { return mileage; }
    public boolean isRunning() { return isRunning; }
    public double getFuelLevel() { return fuelLevel; }
    public double getMaxFuelCapacity() { return maxFuelCapacity; }

    // Getters for private variables (controlled access)
    public String getVIN() { return vin; }
    public String getOwner() { return owner; }
    public boolean isRegistered() { return isRegistered; }

    // Setters with validation
    public void setOwner(String owner) {
        if (owner != null && !owner.trim().isEmpty()) {
            this.owner = owner.trim();
            System.out.println("✅ Owner set to: " + this.owner);
        } else {
            System.out.println("❌ Invalid owner name");
        }
    }

    public void setRegistered(boolean registered) {
        this.isRegistered = registered;
        System.out.println("✅ Registration status: " + (registered ? "Registered" : "Not Registered"));
    }

    public void setColor(String color) {
        if (color != null && !color.trim().isEmpty()) {
            this.color = color.trim();
            System.out.println("✅ Color changed to: " + this.color);
        }
    }

    // Protected method that subclasses can override or extend
    protected double calculateDepreciation() {
        int age = 2024 - year;
        double depreciationRate = 0.10; // 10% per year
        return Math.max(price * Math.pow(1 - depreciationRate, age), price * 0.1);
    }

    // Method that subclasses might want to override
    public double getCurrentValue() {
        return calculateDepreciation();
    }

    public String getVehicleType() {
        return "Generic Vehicle"; // Subclasses should override this
    }

    // Private helper method
    private String generateVIN() {
        return "VIN" + System.currentTimeMillis() % 1000000;
    }

    // Method to display vehicle information
    public void displayInfo() {
        System.out.println("\n🚗 ===== Vehicle Information =====");
        System.out.println("Type: " + getVehicleType());
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("VIN: " + vin);
        System.out.println("Owner: " + owner);
        System.out.println("Registered: " + (isRegistered ? "Yes" : "No"));
        System.out.printf("Original Price: $%.2f\n", price);
        System.out.printf("Current Value: $%.2f\n", getCurrentValue());
        System.out.println("Mileage: " + mileage + " miles");
        System.out.printf("Fuel: %.1f/%.1f gallons\n", fuelLevel, maxFuelCapacity);
        System.out.println("Engine: " + (isRunning ? "Running" : "Off"));
        System.out.println("===============================\n");
    }

    @Override
    public String toString() {
        return String.format("%s{brand='%s', model='%s', year=%d, mileage=%d}",
                           getVehicleType(), brand, model, year, mileage);
    }
}
