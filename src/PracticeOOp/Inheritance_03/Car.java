/**
 * Car Class - Demonstrates Single Inheritance
 *
 * This class extends Vehicle, inheriting all its properties and methods
 * while adding car-specific features and behaviors.
 */

package PracticeOOp.Inheritance_03;


public class Car extends Vehicle {
    // Car-specific attributes
    private int numberOfDoors;
    private String transmissionType;
    private boolean hasAirConditioning;
    private boolean hasSunroof;
    private int numberOfSeats;
    private String driveType; // FWD, RWD, AWD

    // Constructor - must call parent constructor
    public Car(String brand, String model, int year, String color, double price,
               int numberOfDoors, String transmissionType) {
        // Call parent constructor using super()
        super(brand, model, year, color, price);

        this.numberOfDoors = numberOfDoors;
        this.transmissionType = transmissionType;
        this.hasAirConditioning = true; // Default features
        this.hasSunroof = false;
        this.numberOfSeats = 5; // Default for most cars
        this.driveType = "FWD"; // Default
        this.maxFuelCapacity = 15.0; // Cars typically have larger tanks

        System.out.println("🚗 Car-specific features initialized");
    }

    // Overloaded constructor with more options
    public Car(String brand, String model, int year, String color, double price,
               int numberOfDoors, String transmissionType, int numberOfSeats) {
        super(brand, model, year, color, price);

        this.numberOfDoors = numberOfDoors;
        this.transmissionType = transmissionType;
        this.numberOfSeats = numberOfSeats;
        this.hasAirConditioning = true;
        this.hasSunroof = false;
        this.driveType = "FWD";
        this.maxFuelCapacity = 15.0;
    }

    // Car-specific methods
    public void openTrunk() {
        System.out.println("🎒 " + brand + " " + model + " trunk opened");
    }

    public void closeTrunk() {
        System.out.println("🎒 " + brand + " " + model + " trunk closed");
    }

    public void turnOnAC() {
        if (hasAirConditioning) {
            if (isRunning) {
                System.out.println("❄️ Air conditioning turned ON");
            } else {
                System.out.println("❌ Cannot turn on AC - engine must be running");
            }
        } else {
            System.out.println("❌ This car doesn't have air conditioning");
        }
    }

    public void turnOffAC() {
        System.out.println("❄️ Air conditioning turned OFF");
    }

    public void openSunroof() {
        if (hasSunroof) {
            System.out.println("☀️ Sunroof opened - enjoying the sky!");
        } else {
            System.out.println("❌ This car doesn't have a sunroof");
        }
    }

    public void parkCar() {
        if (isRunning) {
            stopEngine(); // Using inherited method
            System.out.println("🅿️ Car parked safely");
        } else {
            System.out.println("🅿️ Car is already parked");
        }
    }

    // Method overriding - providing car-specific implementation
    @Override
    public String getVehicleType() {
        return "Car";
    }

    // Override the drive method to add car-specific behavior
    @Override
    public void drive(int miles) {
        System.out.println("🚗 Car driving mode activated");
        super.drive(miles); // Call parent's drive method

        // Add car-specific driving behavior
        if (miles > 100) {
            System.out.println("🛣️ Long distance detected - cruise control recommended");
        }
    }

    // Override honk method for car-specific sound
    @Override
    public void honk() {
        System.out.println("🚗 Car horn: HONK HONK!");
    }

    // Enhanced fuel calculation for cars
    @Override
    protected double calculateDepreciation() {
        double baseDepreciation = super.calculateDepreciation();

        // Cars depreciate faster if they have high mileage
        if (mileage > 100000) {
            baseDepreciation *= 0.8; // Additional 20% depreciation
        }

        // Luxury features add to resale value
        if (hasSunroof) baseDepreciation *= 1.05;
        if (hasAirConditioning) baseDepreciation *= 1.02;

        return baseDepreciation;
    }

    // Car-specific getters
    public int getNumberOfDoors() { return numberOfDoors; }
    public String getTransmissionType() { return transmissionType; }
    public boolean hasAirConditioning() { return hasAirConditioning; }
    public boolean hasSunroof() { return hasSunroof; }
    public int getNumberOfSeats() { return numberOfSeats; }
    public String getDriveType() { return driveType; }

    // Car-specific setters
    public void setAirConditioning(boolean hasAC) {
        this.hasAirConditioning = hasAC;
        System.out.println("✅ Air conditioning: " + (hasAC ? "Available" : "Not available"));
    }

    public void setSunroof(boolean hasSunroof) {
        this.hasSunroof = hasSunroof;
        System.out.println("✅ Sunroof: " + (hasSunroof ? "Available" : "Not available"));
    }

    public void setDriveType(String driveType) {
        if (driveType != null && (driveType.equals("FWD") || driveType.equals("RWD") || driveType.equals("AWD"))) {
            this.driveType = driveType;
            System.out.println("✅ Drive type set to: " + driveType);
        } else {
            System.out.println("❌ Invalid drive type. Use FWD, RWD, or AWD");
        }
    }

    // Car-specific utility methods
    public boolean isSportsCar() {
        return numberOfDoors == 2 && transmissionType.equalsIgnoreCase("manual");
    }

    public boolean isFamilyCar() {
        return numberOfDoors >= 4 && numberOfSeats >= 5;
    }

    public String getCarCategory() {
        if (isSportsCar()) return "Sports Car";
        if (isFamilyCar()) return "Family Car";
        if (numberOfDoors == 2) return "Coupe";
        return "Standard Car";
    }

    // Override displayInfo to include car-specific information
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call parent's displayInfo first

        // Add car-specific information
        System.out.println("🚗 ===== Car-Specific Details =====");
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Transmission: " + transmissionType);
        System.out.println("Number of Seats: " + numberOfSeats);
        System.out.println("Drive Type: " + driveType);
        System.out.println("Air Conditioning: " + (hasAirConditioning ? "Yes" : "No"));
        System.out.println("Sunroof: " + (hasSunroof ? "Yes" : "No"));
        System.out.println("Category: " + getCarCategory());
        System.out.println("=================================\n");
    }

    // Car-specific demonstration method
    public void demonstrateCarFeatures() {
        System.out.println("\n🚗 === Car Features Demonstration ===");

        startEngine(); // Inherited method
        turnOnAC();    // Car-specific method

        if (hasSunroof) {
            openSunroof();
        }

        drive(50);     // Overridden method
        honk();        // Overridden method
        openTrunk();   // Car-specific method
        closeTrunk();  // Car-specific method
        parkCar();     // Car-specific method

        System.out.println("=================================\n");
    }

    @Override
    public String toString() {
        return String.format("Car{brand='%s', model='%s', year=%d, doors=%d, transmission='%s'}",
                           brand, model, year, numberOfDoors, transmissionType);
    }
}
