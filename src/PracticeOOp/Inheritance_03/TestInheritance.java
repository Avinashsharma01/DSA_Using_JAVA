/**
 * TestInheritance - Comprehensive demonstration of inheritance concepts
 *
 * This class demonstrates:
 * - Single inheritance (Car extends Vehicle)
 * - Method overriding
 * - Use of super keyword
 * - Polymorphism through inheritance
 * - Access to inherited members
 */
package PracticeOOp.Inheritance_03;

public class TestInheritance {
    public static void main(String[] args) {
        System.out.println("🧬 Welcome to Inheritance Demonstration!");
        System.out.println("========================================\n");

        // Test basic inheritance
        testBasicInheritance();

        // Test method overriding
        testMethodOverriding();

        // Test polymorphism through inheritance
        testPolymorphism();

        // Test access to inherited members
        testInheritedMembers();

        System.out.println("\n🎉 Inheritance demonstration completed!");
        System.out.println("\nKey Inheritance Benefits Demonstrated:");
        System.out.println("✅ Code Reusability - Car inherits all Vehicle functionality");
        System.out.println("✅ Method Overriding - Car customizes Vehicle behaviors");
        System.out.println("✅ Polymorphism - Same interface, different implementations");
        System.out.println("✅ IS-A Relationship - Car IS-A Vehicle");
    }

    private static void testBasicInheritance() {
        System.out.println("🚗 TESTING BASIC INHERITANCE");
        System.out.println("============================\n");

        // Create a Car object - notice it inherits from Vehicle
        Car myCar = new Car("Toyota", "Camry", 2023, "Blue", 35000.0, 4, "Automatic");

        // Car automatically has all Vehicle properties and methods
        System.out.println("🔍 Testing inherited properties and methods:");

        // Using inherited methods from Vehicle
        myCar.setOwner("John Doe");
        myCar.setRegistered(true);
        myCar.refuel(10.0);

        // Display inherited information
        System.out.println("Brand (inherited): " + myCar.getBrand());
        System.out.println("Model (inherited): " + myCar.getModel());
        System.out.println("VIN (inherited): " + myCar.getVIN());
        System.out.println("Fuel Level (inherited): " + myCar.getFuelLevel());

        // Car-specific properties
        System.out.println("Number of Doors (car-specific): " + myCar.getNumberOfDoors());
        System.out.println("Transmission (car-specific): " + myCar.getTransmissionType());

        myCar.displayInfo(); // This calls the overridden version

        System.out.println("=".repeat(50) + "\n");
    }

    private static void testMethodOverriding() {
        System.out.println("🔄 TESTING METHOD OVERRIDING");
        System.out.println("============================\n");

        // Create Vehicle and Car objects
        Vehicle genericVehicle = new Vehicle("Generic", "Model", 2023, "White", 20000.0);
        Car sportsCar = new Car("BMW", "M3", 2023, "Red", 65000.0, 2, "Manual");

        System.out.println("🔍 Comparing Vehicle vs Car method implementations:");

        // Test getVehicleType() method - overridden in Car
        System.out.println("Generic Vehicle Type: " + genericVehicle.getVehicleType());
        System.out.println("Car Vehicle Type: " + sportsCar.getVehicleType());

        System.out.println("\n🔊 Testing honk() method - overridden in Car:");
        genericVehicle.honk(); // Vehicle's implementation
        sportsCar.honk();      // Car's overridden implementation

        System.out.println("\n🚙 Testing drive() method - overridden in Car:");
        genericVehicle.refuel(5.0);
        sportsCar.refuel(8.0);

        genericVehicle.startEngine();
        sportsCar.startEngine();

        System.out.println("Vehicle driving:");
        genericVehicle.drive(50); // Vehicle's implementation

        System.out.println("\nCar driving:");
        sportsCar.drive(150); // Car's overridden implementation (notice additional behavior)

        System.out.println("=".repeat(50) + "\n");
    }

    private static void testPolymorphism() {
        System.out.println("🎭 TESTING POLYMORPHISM THROUGH INHERITANCE");
        System.out.println("==========================================\n");

        // Polymorphism: Vehicle reference can point to Car object
        Vehicle[] vehicles = {
            new Vehicle("Honda", "Generic", 2022, "Black", 25000.0),
            new Car("Tesla", "Model 3", 2023, "White", 45000.0, 4, "Automatic"),
            new Car("Ford", "Mustang", 2023, "Yellow", 55000.0, 2, "Manual")
        };

        System.out.println("🔍 Processing different vehicle types polymorphically:");

        for (int i = 0; i < vehicles.length; i++) {
            Vehicle vehicle = vehicles[i];

            System.out.println("\n--- Vehicle " + (i + 1) + " ---");
            System.out.println("Type: " + vehicle.getVehicleType()); // Calls appropriate overridden method
            System.out.println("Details: " + vehicle.toString());

            // All vehicles can use these inherited methods
            vehicle.refuel(5.0);
            vehicle.startEngine();
            vehicle.honk(); // Calls appropriate overridden method
            vehicle.drive(30);
            vehicle.stopEngine();

            // Check if it's actually a Car (downcasting)
            if (vehicle instanceof Car) {
                Car car = (Car) vehicle; // Downcast to access Car-specific methods
                System.out.println("This is a Car! Category: " + car.getCarCategory());
                car.openTrunk();
            }
        }

        System.out.println("\n=".repeat(50) + "\n");
    }

    private static void testInheritedMembers() {
        System.out.println("🧬 TESTING ACCESS TO INHERITED MEMBERS");
        System.out.println("=====================================\n");

        Car testCar = new Car("Audi", "A4", 2023, "Silver", 45000.0, 4, "Automatic", 5);

        System.out.println("🔍 Demonstrating access to different types of inherited members:");

        // Public inherited methods - accessible everywhere
        System.out.println("✅ Public inherited methods:");
        System.out.println("  Brand: " + testCar.getBrand()); // Inherited public method
        System.out.println("  Year: " + testCar.getYear());   // Inherited public method
        System.out.println("  Running: " + testCar.isRunning()); // Inherited public method

        // Protected inherited members - accessible in subclass
        System.out.println("\n✅ Protected inherited members (accessible in Car class):");
        System.out.println("  Note: Car class can directly access protected variables like 'brand', 'model', etc.");
        System.out.println("  This allows Car to use them in its own methods without getters");

        // Private inherited members - not directly accessible
        System.out.println("\n❌ Private inherited members (NOT directly accessible):");
        System.out.println("  Car cannot directly access Vehicle's private variables like 'vin', 'owner'");
        System.out.println("  Must use public getters: VIN = " + testCar.getVIN());
        System.out.println("  Must use public getters: Owner = " + testCar.getOwner());

        // Demonstrate car-specific features alongside inherited ones
        System.out.println("\n🚗 Car-specific features demonstration:");
        testCar.demonstrateCarFeatures();

        // Show that Car enhances inherited functionality
        System.out.println("🔧 Enhanced inherited functionality:");
        System.out.println("Original Value Calculation vs Car's Enhanced Calculation:");

        Vehicle basicVehicle = new Vehicle("Basic", "Vehicle", 2020, "Gray", 20000.0);
        System.out.printf("Basic Vehicle Value: $%.2f\n", basicVehicle.getCurrentValue());

        testCar.setSunroof(true); // Add luxury feature
        System.out.printf("Car with Sunroof Value: $%.2f\n", testCar.getCurrentValue());

        System.out.println("\n=".repeat(50) + "\n");
    }
}
