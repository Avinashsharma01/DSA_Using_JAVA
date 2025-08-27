/**
 * TestAdvancedConcepts - Comprehensive demonstration of Advanced OOP Concepts
 *
 * This class demonstrates:
 * - Interface implementation and multiple inheritance
 * - Design patterns in action (Singleton, Factory, Observer, Strategy)
 * - Composition vs Inheritance differences
 * - Real-world application of advanced OOP principles
 */

public class TestAdvancedConcepts {
    public static void main(String[] args) {
        System.out.println("🚀 Welcome to Advanced OOP Concepts Demonstration!");
        System.out.println("==================================================\n");

        // Test Interface concepts
        testInterfaceConcepts();

        // Test Design Patterns
        testDesignPatterns();

        // Test Composition vs Inheritance
        testCompositionVsInheritance();

        System.out.println("\n🎉 Advanced OOP Concepts demonstration completed!");
        System.out.println("\nKey Advanced Concepts Demonstrated:");
        System.out.println("✅ Interfaces - Pure abstraction and multiple inheritance");
        System.out.println("✅ Design Patterns - Proven solutions to common problems");
        System.out.println("✅ Composition - Flexible HAS-A relationships");
        System.out.println("✅ Advanced OOP principles for real-world applications");
    }

    private static void testInterfaceConcepts() {
        System.out.println("🎨 TESTING INTERFACE CONCEPTS");
        System.out.println("=============================\n");

        // Test static method in interface
        System.out.println("📋 Interface static method:");
        Drawable.printDrawingInstructions();

        // Create objects implementing multiple interfaces
        DrawableCircle circle = new DrawableCircle(5.0, "Red");
        DrawableRectangle rectangle = new DrawableRectangle(8.0, 6.0, "Blue");

        System.out.println("\n🔍 Testing multiple interface implementation:");

        // Test Drawable interface methods
        circle.draw();
        circle.resize(1.5);
        circle.display(); // Default method from interface

        rectangle.draw();
        rectangle.resize(0.8);
        rectangle.display(); // Default method from interface

        // Test Colorable interface methods
        circle.setColor("Green");
        circle.paintBrush(); // Default method from Colorable

        rectangle.setColor("Purple");
        rectangle.paintBrush(); // Default method from Colorable

        // Polymorphism with interfaces
        System.out.println("\n🎭 Interface polymorphism:");
        Drawable[] drawables = {circle, rectangle};
        for (Drawable drawable : drawables) {
            drawable.erase();
        }

        System.out.println("\n" + "=".repeat(50) + "\n");
    }

    private static void testDesignPatterns() {
        System.out.println("🎯 TESTING DESIGN PATTERNS");
        System.out.println("==========================\n");

        // Test Singleton Pattern
        testSingletonPattern();

        // Test Factory Pattern
        testFactoryPattern();

        // Test Observer Pattern
        testObserverPattern();

        // Test Strategy Pattern
        testStrategyPattern();

        System.out.println("=".repeat(50) + "\n");
    }

    private static void testSingletonPattern() {
        System.out.println("1️⃣ SINGLETON PATTERN");
        System.out.println("--------------------");

        // Get database connections - should be the same instance
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();

        System.out.println("Same instance? " + (db1 == db2)); // Should be true

        db1.connect();
        db2.executeQuery("SELECT * FROM users"); // Same connection
        db1.disconnect();

        System.out.println();
    }

    private static void testFactoryPattern() {
        System.out.println("2️⃣ FACTORY PATTERN");
        System.out.println("------------------");

        // Create different vehicles without knowing exact classes
        FactoryVehicle car = VehicleFactory.createVehicle("car", "Toyota", "Camry");
        FactoryVehicle motorcycle = VehicleFactory.createVehicle("motorcycle", "Harley", "Davidson");
        FactoryVehicle truck = VehicleFactory.createVehicle("truck", "Ford", "F-150");

        // Use them polymorphically
        FactoryVehicle[] vehicles = {car, motorcycle, truck};
        for (FactoryVehicle vehicle : vehicles) {
            vehicle.start();
            vehicle.stop();
            System.out.println("Created: " + vehicle.toString());
        }

        System.out.println();
    }

    private static void testObserverPattern() {
        System.out.println("3️⃣ OBSERVER PATTERN");
        System.out.println("-------------------");

        // Create news agency (subject)
        NewsAgency newsAgency = new NewsAgency();

        // Create observers
        NewsChannel cnn = new NewsChannel("CNN");
        NewsChannel bbc = new NewsChannel("BBC");
        MobileApp newsApp = new MobileApp("NewsApp");

        // Subscribe observers
        newsAgency.addObserver(cnn);
        newsAgency.addObserver(bbc);
        newsAgency.addObserver(newsApp);

        // Publish news - all observers get notified
        newsAgency.publishNews("Breaking: New OOP Tutorial Released!");

        System.out.println("\n📱 Adding another subscriber:");
        MobileApp anotherApp = new MobileApp("TechNews");
        newsAgency.addObserver(anotherApp);

        newsAgency.publishNews("Java 21 Features Announced!");

        System.out.println();
    }

    private static void testStrategyPattern() {
        System.out.println("4️⃣ STRATEGY PATTERN");
        System.out.println("-------------------");

        // Create shopping cart
        ShoppingCart cart = new ShoppingCart();

        // Add items
        cart.addItem("Laptop", 999.99);
        cart.addItem("Mouse", 29.99);
        cart.addItem("Keyboard", 79.99);

        // Try different payment strategies
        System.out.println("\n💳 Testing Credit Card Payment:");
        cart.setPaymentStrategy(new CreditCardPayment("1234567890123456", "John Doe"));
        cart.checkout();

        // Add more items and try PayPal
        cart.addItem("Monitor", 299.99);
        cart.addItem("Webcam", 89.99);

        System.out.println("🌐 Testing PayPal Payment:");
        cart.setPaymentStrategy(new PayPalPayment("john.doe@email.com"));
        cart.checkout();

        // Add items and try Bank Transfer
        cart.addItem("Speakers", 129.99);

        System.out.println("🏦 Testing Bank Transfer Payment:");
        cart.setPaymentStrategy(new BankTransferPayment("1234567890", "Chase Bank"));
        cart.checkout();

        System.out.println();
    }

    private static void testCompositionVsInheritance() {
        System.out.println("🔧 TESTING COMPOSITION VS INHERITANCE");
        System.out.println("=====================================\n");

        // Test Composition approach
        CompositionVsInheritanceDemo.demonstrateComposition();

        // Test Inheritance approach
        CompositionVsInheritanceDemo.demonstrateInheritance();

        // Test Aggregation
        CompositionVsInheritanceDemo.demonstrateAggregation();

        // Compare approaches
        CompositionVsInheritanceDemo.compareApproaches();

        System.out.println("\n" + "=".repeat(50) + "\n");
    }
}
