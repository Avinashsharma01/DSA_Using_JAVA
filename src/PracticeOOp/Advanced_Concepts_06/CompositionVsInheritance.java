/**
 * Composition vs Inheritance Examples
 *
 * This file demonstrates:
 * - HAS-A relationship (Composition) vs IS-A relationship (Inheritance)
 * - When to use composition over inheritance
 * - Aggregation vs Composition
 * - Delegation pattern
 */

import java.util.*;

// ================== COMPOSITION EXAMPLE ==================

/**
 * Engine class - Component for composition
 */
class Engine {
    private String type;
    private int horsepower;
    private boolean isRunning;

    public Engine(String type, int horsepower) {
        this.type = type;
        this.horsepower = horsepower;
        this.isRunning = false;
    }

    public void start() {
        if (!isRunning) {
            isRunning = true;
            System.out.println("🔥 " + type + " engine started (" + horsepower + " HP)");
        } else {
            System.out.println("⚠️ Engine is already running");
        }
    }

    public void stop() {
        if (isRunning) {
            isRunning = false;
            System.out.println("🛑 " + type + " engine stopped");
        } else {
            System.out.println("⚠️ Engine is already stopped");
        }
    }

    public boolean isRunning() { return isRunning; }
    public String getType() { return type; }
    public int getHorsepower() { return horsepower; }

    @Override
    public String toString() {
        return String.format("Engine{type='%s', hp=%d, running=%s}", type, horsepower, isRunning);
    }
}

/**
 * GPS System class - Another component for composition
 */
class GPSSystem {
    private String brand;
    private boolean isOn;
    private String currentLocation;

    public GPSSystem(String brand) {
        this.brand = brand;
        this.isOn = false;
        this.currentLocation = "Unknown";
    }

    public void turnOn() {
        isOn = true;
        currentLocation = "Current Position";
        System.out.println("🛰️ " + brand + " GPS system activated");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("📴 GPS system turned off");
    }

    public void navigate(String destination) {
        if (isOn) {
            System.out.println("🗺️ GPS navigating from " + currentLocation + " to " + destination);
        } else {
            System.out.println("❌ GPS is off - turn on first");
        }
    }

    public String getBrand() { return brand; }
    public boolean isOn() { return isOn; }
}

/**
 * Audio System class - Component for composition
 */
class AudioSystem {
    private String brand;
    private boolean isOn;
    private int volume;
    private String currentTrack;

    public AudioSystem(String brand) {
        this.brand = brand;
        this.isOn = false;
        this.volume = 0;
        this.currentTrack = "None";
    }

    public void turnOn() {
        isOn = true;
        volume = 10;
        System.out.println("🔊 " + brand + " audio system turned on");
    }

    public void turnOff() {
        isOn = false;
        volume = 0;
        System.out.println("🔇 Audio system turned off");
    }

    public void playMusic(String track) {
        if (isOn) {
            currentTrack = track;
            System.out.println("🎵 Playing: " + track + " (Volume: " + volume + ")");
        } else {
            System.out.println("❌ Audio system is off");
        }
    }

    public void setVolume(int volume) {
        if (isOn && volume >= 0 && volume <= 100) {
            this.volume = volume;
            System.out.println("🔊 Volume set to: " + volume);
        }
    }

    public String getBrand() { return brand; }
    public boolean isOn() { return isOn; }
}

/**
 * Car class using COMPOSITION (HAS-A relationship)
 * Car HAS-A Engine, HAS-A GPS, HAS-A AudioSystem
 */
class CompositionCar {
    private String brand;
    private String model;
    private Engine engine;          // Composition - Car HAS-A Engine
    private GPSSystem gps;          // Composition - Car HAS-A GPS
    private AudioSystem audio;      // Composition - Car HAS-A Audio

    public CompositionCar(String brand, String model, String engineType, int horsepower) {
        this.brand = brand;
        this.model = model;
        // Creating composed objects - Strong composition
        this.engine = new Engine(engineType, horsepower);
        this.gps = new GPSSystem("Garmin");
        this.audio = new AudioSystem("Bose");

        System.out.println("🚗 Car created: " + brand + " " + model);
        System.out.println("   Components installed: Engine, GPS, Audio");
    }

    // Delegation to composed objects
    public void startCar() {
        System.out.println("\n🔑 Starting " + brand + " " + model + "...");
        engine.start();     // Delegate to engine
        gps.turnOn();       // Delegate to GPS
        audio.turnOn();     // Delegate to audio
        System.out.println("✅ Car is ready to drive!\n");
    }

    public void stopCar() {
        System.out.println("\n🛑 Stopping " + brand + " " + model + "...");
        audio.turnOff();    // Delegate to audio
        gps.turnOff();      // Delegate to GPS
        engine.stop();      // Delegate to engine
        System.out.println("✅ Car stopped safely\n");
    }

    public void drive(String destination) {
        if (engine.isRunning()) {
            gps.navigate(destination);  // Delegate to GPS
            System.out.println("🚗 Driving to " + destination);
        } else {
            System.out.println("❌ Start the car first!");
        }
    }

    public void playMusic(String song) {
        audio.playMusic(song);  // Delegate to audio system
    }

    public void setVolume(int volume) {
        audio.setVolume(volume);  // Delegate to audio system
    }

    // Getters that expose composed objects' functionality
    public Engine getEngine() { return engine; }
    public GPSSystem getGPS() { return gps; }
    public AudioSystem getAudio() { return audio; }

    public void displayCarInfo() {
        System.out.println("\n🚗 ===== Car Information =====");
        System.out.println("Car: " + brand + " " + model);
        System.out.println("Engine: " + engine.toString());
        System.out.println("GPS: " + gps.getBrand() + " (On: " + gps.isOn() + ")");
        System.out.println("Audio: " + audio.getBrand() + " (On: " + audio.isOn() + ")");
        System.out.println("===========================\n");
    }
}

// ================== AGGREGATION EXAMPLE ==================

/**
 * Department class for aggregation example
 */
class Department {
    private String name;
    private List<Employee> employees;  // Aggregation - Department HAS employees

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    // Aggregation - employees can exist independently
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("👥 Employee " + employee.getName() + " added to " + name + " department");
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
        System.out.println("👋 Employee " + employee.getName() + " removed from " + name + " department");
    }

    public void listEmployees() {
        System.out.println("\n🏢 " + name + " Department Employees:");
        for (Employee emp : employees) {
            System.out.println("  - " + emp.getName() + " (" + emp.getPosition() + ")");
        }
        System.out.println("Total employees: " + employees.size() + "\n");
    }

    public String getName() { return name; }
    public List<Employee> getEmployees() { return new ArrayList<>(employees); }
}

/**
 * Employee class for aggregation example
 */
class Employee {
    private String name;
    private String position;
    private double salary;

    public Employee(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getName() { return name; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return String.format("Employee{name='%s', position='%s', salary=%.2f}", name, position, salary);
    }
}

// ================== INHERITANCE VS COMPOSITION COMPARISON ==================

/**
 * Base Vehicle class for inheritance example
 */
abstract class InheritanceVehicle {
    protected String brand;
    protected String model;
    protected boolean isRunning;

    public InheritanceVehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.isRunning = false;
    }

    public abstract void start();
    public abstract void stop();

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public boolean isRunning() { return isRunning; }
}

/**
 * InheritanceCar using INHERITANCE (IS-A relationship)
 * InheritanceCar IS-A Vehicle
 */
class InheritanceCar extends InheritanceVehicle {
    private int numberOfDoors;

    public InheritanceCar(String brand, String model, int numberOfDoors) {
        super(brand, model);  // IS-A relationship
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void start() {
        isRunning = true;
        System.out.println("🚗 " + brand + " " + model + " car started (Inheritance approach)");
    }

    @Override
    public void stop() {
        isRunning = false;
        System.out.println("🛑 " + brand + " " + model + " car stopped (Inheritance approach)");
    }

    public int getNumberOfDoors() { return numberOfDoors; }
}

/**
 * Demonstration class showing the differences
 */
class CompositionVsInheritanceDemo {

    public static void demonstrateComposition() {
        System.out.println("🔧 COMPOSITION EXAMPLE (HAS-A Relationship)");
        System.out.println("===========================================");

        CompositionCar car = new CompositionCar("Toyota", "Camry", "V6", 268);
        car.displayCarInfo();

        // Car delegates to its components
        car.startCar();
        car.drive("Shopping Mall");
        car.playMusic("Rock Anthem");
        car.setVolume(25);
        car.stopCar();

        // We can access individual components
        System.out.println("🔍 Accessing individual components:");
        System.out.println("Engine HP: " + car.getEngine().getHorsepower());
        System.out.println("GPS Brand: " + car.getGPS().getBrand());
        System.out.println("Audio Brand: " + car.getAudio().getBrand());
    }

    public static void demonstrateInheritance() {
        System.out.println("\n🧬 INHERITANCE EXAMPLE (IS-A Relationship)");
        System.out.println("==========================================");

        InheritanceCar car = new InheritanceCar("Honda", "Civic", 4);

        // Car inherits behavior from Vehicle
        car.start();
        System.out.println("Car is running: " + car.isRunning());
        car.stop();

        System.out.println("Brand: " + car.getBrand());
        System.out.println("Doors: " + car.getNumberOfDoors());
    }

    public static void demonstrateAggregation() {
        System.out.println("\n👥 AGGREGATION EXAMPLE");
        System.out.println("======================");

        // Create employees (they exist independently)
        Employee emp1 = new Employee("Alice Johnson", "Software Engineer", 75000);
        Employee emp2 = new Employee("Bob Smith", "Project Manager", 85000);
        Employee emp3 = new Employee("Carol Davis", "Designer", 65000);

        // Create department and add employees (aggregation)
        Department engineering = new Department("Engineering");
        engineering.addEmployee(emp1);
        engineering.addEmployee(emp2);
        engineering.addEmployee(emp3);

        engineering.listEmployees();

        // Employees can be removed but still exist
        engineering.removeEmployee(emp2);
        engineering.listEmployees();

        System.out.println("📝 Note: Bob Smith still exists as an employee object even after removal from department");
        System.out.println("Employee info: " + emp2.toString());
    }

    public static void compareApproaches() {
        System.out.println("\n📊 COMPOSITION VS INHERITANCE COMPARISON");
        System.out.println("=======================================");

        System.out.println("✅ COMPOSITION Benefits:");
        System.out.println("  - More flexible (can change behavior at runtime)");
        System.out.println("  - Better encapsulation");
        System.out.println("  - Follows 'favor composition over inheritance' principle");
        System.out.println("  - Can combine multiple classes");
        System.out.println("  - Easier to test individual components");

        System.out.println("\n✅ INHERITANCE Benefits:");
        System.out.println("  - Code reuse through common base class");
        System.out.println("  - Polymorphism through IS-A relationship");
        System.out.println("  - Natural modeling of hierarchical relationships");
        System.out.println("  - Method overriding for specialized behavior");

        System.out.println("\n💡 WHEN TO USE:");
        System.out.println("  - Use COMPOSITION when: HAS-A relationship, need flexibility");
        System.out.println("  - Use INHERITANCE when: IS-A relationship, shared behavior");
    }
}
