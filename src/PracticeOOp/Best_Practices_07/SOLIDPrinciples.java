/**
 * SOLID Principles - Fundamental OOP Design Principles
 *
 * This file demonstrates the five SOLID principles:
 * S - Single Responsibility Principle
 * O - Open/Closed Principle
 * L - Liskov Substitution Principle
 * I - Interface Segregation Principle
 * D - Dependency Inversion Principle
 */

import java.util.*;

// ==================== S - SINGLE RESPONSIBILITY PRINCIPLE ====================
// A class should have only one reason to change

// ❌ BAD EXAMPLE - Multiple responsibilities
class BadUser {
    private String name;
    private String email;

    public BadUser(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Responsibility 1: User data management
    public String getName() { return name; }
    public String getEmail() { return email; }

    // Responsibility 2: Email validation (should be separate)
    public boolean validateEmail() {
        return email.contains("@") && email.contains(".");
    }

    // Responsibility 3: Database operations (should be separate)
    public void saveToDatabase() {
        System.out.println("Saving user to database...");
    }

    // Responsibility 4: Email sending (should be separate)
    public void sendWelcomeEmail() {
        System.out.println("Sending welcome email to " + email);
    }
}

// ✅ GOOD EXAMPLE - Single responsibility per class
class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Only responsible for user data
    public String getName() { return name; }
    public String getEmail() { return email; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
}

class EmailValidator {
    // Only responsible for email validation
    public static boolean isValid(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
}

class UserRepository {
    // Only responsible for database operations
    public void save(User user) {
        System.out.println("✅ Saving user " + user.getName() + " to database");
    }

    public User findByEmail(String email) {
        System.out.println("🔍 Finding user by email: " + email);
        return new User("Found User", email);
    }
}

class EmailService {
    // Only responsible for email operations
    public void sendWelcomeEmail(User user) {
        if (EmailValidator.isValid(user.getEmail())) {
            System.out.println("📧 Sending welcome email to " + user.getEmail());
        } else {
            System.out.println("❌ Invalid email address");
        }
    }
}

// ==================== O - OPEN/CLOSED PRINCIPLE ====================
// Classes should be open for extension but closed for modification

// ✅ GOOD EXAMPLE - Open for extension, closed for modification
abstract class Shape {
    public abstract double calculateArea();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) { this.radius = radius; }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

class AreaCalculator {
    // No need to modify this class when adding new shapes
    public double calculateTotalArea(List<Shape> shapes) {
        double total = 0;
        for (Shape shape : shapes) {
            total += shape.calculateArea(); // Polymorphism
        }
        return total;
    }
}

// ==================== L - LISKOV SUBSTITUTION PRINCIPLE ====================
// Objects of a superclass should be replaceable with objects of subclasses

// ✅ GOOD EXAMPLE - Subtypes are substitutable
abstract class Bird {
    public abstract void move();
}

class FlyingBird extends Bird {
    @Override
    public void move() {
        fly();
    }

    public void fly() {
        System.out.println("🦅 Flying through the sky");
    }
}

class SwimmingBird extends Bird {
    @Override
    public void move() {
        swim();
    }

    public void swim() {
        System.out.println("🐧 Swimming in water");
    }
}

class BirdMover {
    public void moveBird(Bird bird) {
        bird.move(); // Works with any Bird subtype
    }
}

// ==================== I - INTERFACE SEGREGATION PRINCIPLE ====================
// Clients should not be forced to depend on interfaces they don't use

// ❌ BAD EXAMPLE - Fat interface
interface BadWorker {
    void work();
    void eat();
    void sleep();
    void program(); // Not all workers program
    void manage();  // Not all workers manage
}

// ✅ GOOD EXAMPLE - Segregated interfaces
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

interface Sleepable {
    void sleep();
}

interface Programmable {
    void program();
}

interface Manageable {
    void manage();
}

class Developer implements Workable, Eatable, Sleepable, Programmable {
    @Override
    public void work() { System.out.println("👨‍💻 Developer working"); }

    @Override
    public void eat() { System.out.println("🍕 Developer eating"); }

    @Override
    public void sleep() { System.out.println("😴 Developer sleeping"); }

    @Override
    public void program() { System.out.println("💻 Developer programming"); }
}

class Manager implements Workable, Eatable, Sleepable, Manageable {
    @Override
    public void work() { System.out.println("👔 Manager working"); }

    @Override
    public void eat() { System.out.println("🥗 Manager eating"); }

    @Override
    public void sleep() { System.out.println("😴 Manager sleeping"); }

    @Override
    public void manage() { System.out.println("📊 Manager managing team"); }
}

// ==================== D - DEPENDENCY INVERSION PRINCIPLE ====================
// High-level modules should not depend on low-level modules. Both should depend on abstractions.

// ✅ GOOD EXAMPLE - Depend on abstractions
interface NotificationService {
    void send(String message, String recipient);
}

class EmailNotification implements NotificationService {
    @Override
    public void send(String message, String recipient) {
        System.out.println("📧 Email sent to " + recipient + ": " + message);
    }
}

class SMSNotification implements NotificationService {
    @Override
    public void send(String message, String recipient) {
        System.out.println("📱 SMS sent to " + recipient + ": " + message);
    }
}

class OrderService {
    private NotificationService notificationService; // Depends on abstraction

    public OrderService(NotificationService notificationService) {
        this.notificationService = notificationService; // Dependency injection
    }

    public void processOrder(String orderDetails, String customer) {
        System.out.println("🛒 Processing order: " + orderDetails);
        // Business logic here...
        notificationService.send("Order confirmed: " + orderDetails, customer);
    }
}

// ==================== DEMONSTRATION CLASS ====================
public class SOLIDPrinciples {

    public static void demonstrateSingleResponsibility() {
        System.out.println("1️⃣ SINGLE RESPONSIBILITY PRINCIPLE");
        System.out.println("===================================");

        User user = new User("John Doe", "john@email.com");
        UserRepository repository = new UserRepository();
        EmailService emailService = new EmailService();

        // Each class has a single responsibility
        System.out.println("User created: " + user.getName());
        System.out.println("Email valid: " + EmailValidator.isValid(user.getEmail()));
        repository.save(user);
        emailService.sendWelcomeEmail(user);

        System.out.println("✅ Each class has a single, well-defined responsibility\n");
    }

    public static void demonstrateOpenClosed() {
        System.out.println("2️⃣ OPEN/CLOSED PRINCIPLE");
        System.out.println("========================");

        List<Shape> shapes = Arrays.asList(
            new Circle(5),
            new Rectangle(4, 6),
            new Circle(3)
        );

        AreaCalculator calculator = new AreaCalculator();
        double totalArea = calculator.calculateTotalArea(shapes);

        System.out.println("Total area of all shapes: " + String.format("%.2f", totalArea));
        System.out.println("✅ Can add new shapes without modifying AreaCalculator\n");
    }

    public static void demonstrateLiskovSubstitution() {
        System.out.println("3️⃣ LISKOV SUBSTITUTION PRINCIPLE");
        System.out.println("=================================");

        BirdMover mover = new BirdMover();

        Bird eagle = new FlyingBird();
        Bird penguin = new SwimmingBird();

        // Both subtypes can be used interchangeably
        mover.moveBird(eagle);   // Flies
        mover.moveBird(penguin); // Swims

        System.out.println("✅ Subtypes are perfectly substitutable for their base type\n");
    }

    public static void demonstrateInterfaceSegregation() {
        System.out.println("4️⃣ INTERFACE SEGREGATION PRINCIPLE");
        System.out.println("===================================");

        Developer dev = new Developer();
        Manager mgr = new Manager();

        // Each class implements only the interfaces it needs
        dev.work();
        dev.program(); // Only developers program

        mgr.work();
        mgr.manage(); // Only managers manage

        System.out.println("✅ Classes implement only the interfaces they actually use\n");
    }

    public static void demonstrateDependencyInversion() {
        System.out.println("5️⃣ DEPENDENCY INVERSION PRINCIPLE");
        System.out.println("==================================");

        // High-level OrderService depends on abstraction, not concrete implementation
        OrderService emailOrderService = new OrderService(new EmailNotification());
        OrderService smsOrderService = new OrderService(new SMSNotification());

        emailOrderService.processOrder("Laptop", "john@email.com");
        smsOrderService.processOrder("Phone", "+1234567890");

        System.out.println("✅ High-level modules depend on abstractions, not concretions\n");
    }

    public static void main(String[] args) {
        System.out.println("🎯 SOLID PRINCIPLES DEMONSTRATION");
        System.out.println("=================================\n");

        demonstrateSingleResponsibility();
        demonstrateOpenClosed();
        demonstrateLiskovSubstitution();
        demonstrateInterfaceSegregation();
        demonstrateDependencyInversion();

        System.out.println("🎉 All SOLID principles demonstrated!");
        System.out.println("These principles lead to:");
        System.out.println("✅ More maintainable code");
        System.out.println("✅ Better testability");
        System.out.println("✅ Reduced coupling");
        System.out.println("✅ Increased cohesion");
        System.out.println("✅ Enhanced flexibility");
    }
}
