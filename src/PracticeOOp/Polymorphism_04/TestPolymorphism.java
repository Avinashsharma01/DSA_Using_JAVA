/**
 * TestPolymorphism - Comprehensive demonstration of Polymorphism
 *
 * This class demonstrates:
 * - Runtime polymorphism through method overriding
 * - Compile-time polymorphism through method overloading
 * - Dynamic method dispatch
 * - Polymorphic arrays and collections
 * - instanceof operator usage
 * - Upcasting and downcasting
 */
package PracticeOOp.Polymorphism_04;

public class TestPolymorphism {
    public static void main(String[] args) {
        System.out.println("🎭 Welcome to Polymorphism Demonstration!");
        System.out.println("=========================================\n");

        // Test runtime polymorphism
        testRuntimePolymorphism();

        // Test method overloading (compile-time polymorphism)
        testMethodOverloading();

        // Test polymorphic arrays
        testPolymorphicArrays();

        // Test dynamic method dispatch
        testDynamicMethodDispatch();

        // Test instanceof and casting
        testInstanceOfAndCasting();

        System.out.println("\n🎉 Polymorphism demonstration completed!");
        System.out.println("\nKey Polymorphism Benefits Demonstrated:");
        System.out.println("✅ One interface, multiple implementations");
        System.out.println("✅ Runtime method resolution (late binding)");
        System.out.println("✅ Code flexibility and extensibility");
        System.out.println("✅ Reduced code duplication");
    }

    private static void testRuntimePolymorphism() {
        System.out.println("🎯 TESTING RUNTIME POLYMORPHISM");
        System.out.println("===============================\n");

        // Create different shapes - all reference type is Shape
        Shape circle = new Circle("Red", true, 5.0);
        Shape rectangle = new Rectangle("Blue", false, 10.0, 6.0);
        Shape square = new Rectangle("Green", true, 4.0); // Square is special rectangle

        System.out.println("🔍 Same method calls, different behaviors:");

        // Polymorphic method calls - same method name, different implementations
        circle.displayInfo();      // Calls Circle's implementation
        rectangle.displayInfo();   // Calls Rectangle's implementation
        square.displayInfo();      // Calls Rectangle's implementation

        // All shapes can be painted polymorphically
        circle.paint("Yellow");
        rectangle.paint("Purple");
        square.paint("Orange");

        System.out.println("=".repeat(50) + "\n");
    }

    private static void testMethodOverloading() {
        System.out.println("🔄 TESTING METHOD OVERLOADING (Compile-time Polymorphism)");
        System.out.println("========================================================\n");

        Calculator calc = new Calculator();

        System.out.println("🧮 Method overloading examples:");
        System.out.println("add(5, 3) = " + calc.add(5, 3));
        System.out.println("add(5.5, 3.2) = " + calc.add(5.5, 3.2));
        System.out.println("add(1, 2, 3) = " + calc.add(1, 2, 3));
        System.out.println("add(\"Hello\", \"World\") = " + calc.add("Hello", "World"));

        System.out.println("\n=".repeat(50) + "\n");
    }

    private static void testPolymorphicArrays() {
        System.out.println("📊 TESTING POLYMORPHIC ARRAYS");
        System.out.println("=============================\n");

        // Array of Shape references holding different shape objects
        Shape[] shapes = {
            new Circle("Red", true, 3.0),
            new Rectangle("Blue", false, 8.0, 5.0),
            new Circle("Green", false, 4.5),
            new Rectangle("Yellow", true, 6.0), // Square
            new Circle("Purple", true, 2.0)
        };

        System.out.println("🎨 Processing array of shapes polymorphically:");

        double totalArea = 0;
        double totalPerimeter = 0;

        for (int i = 0; i < shapes.length; i++) {
            Shape shape = shapes[i];

            System.out.println("\n--- Shape " + (i + 1) + " ---");
            System.out.println("Type: " + shape.getName());
            System.out.printf("Area: %.2f\n", shape.calculateArea());
            System.out.printf("Perimeter: %.2f\n", shape.calculatePerimeter());

            totalArea += shape.calculateArea();
            totalPerimeter += shape.calculatePerimeter();

            shape.draw(); // Polymorphic call - each shape draws differently
        }

        System.out.println("\n📈 Summary Statistics:");
        System.out.printf("Total Area: %.2f square units\n", totalArea);
        System.out.printf("Total Perimeter: %.2f units\n", totalPerimeter);
        System.out.printf("Average Area: %.2f square units\n", totalArea / shapes.length);

        System.out.println("\n=".repeat(50) + "\n");
    }

    private static void testDynamicMethodDispatch() {
        System.out.println("⚡ TESTING DYNAMIC METHOD DISPATCH");
        System.out.println("==================================\n");

        System.out.println("🔍 Runtime method resolution demonstration:");

        // Method calls resolved at runtime based on actual object type
        Shape unknownShape1 = createRandomShape("Mystery1");
        Shape unknownShape2 = createRandomShape("Mystery2");
        Shape unknownShape3 = createRandomShape("Mystery3");

        // JVM determines which method to call at runtime
        processShape(unknownShape1);
        processShape(unknownShape2);
        processShape(unknownShape3);

        System.out.println("=".repeat(50) + "\n");
    }

    private static void testInstanceOfAndCasting() {
        System.out.println("🔍 TESTING INSTANCEOF AND CASTING");
        System.out.println("=================================\n");

        Shape[] mixedShapes = {
            new Circle("Red", true, 5.0),
            new Rectangle("Blue", false, 10.0, 6.0),
            new Circle("Green", false, 3.0)
        };

        System.out.println("🎯 Type checking and casting demonstration:");

        for (Shape shape : mixedShapes) {
            System.out.println("\n--- Analyzing " + shape.getName() + " ---");

            // Check type and access specific methods
            if (shape instanceof Circle) {
                System.out.println("✅ This is a Circle!");
                Circle circle = (Circle) shape; // Downcast to access Circle-specific methods
                System.out.println("Radius: " + circle.getRadius());
                System.out.println("Diameter: " + circle.getDiameter());
                System.out.println("Can fit in 12x12 square? " + circle.canFitInSquare(12.0));

            } else if (shape instanceof Rectangle) {
                System.out.println("✅ This is a Rectangle!");
                Rectangle rectangle = (Rectangle) shape; // Downcast to access Rectangle-specific methods
                System.out.println("Length: " + rectangle.getLength());
                System.out.println("Width: " + rectangle.getWidth());
                System.out.println("Is square? " + rectangle.isSquare());
                System.out.println("Diagonal: " + String.format("%.2f", rectangle.getDiagonal()));
            }

            // All shapes have these methods (polymorphic behavior)
            System.out.println("Area: " + String.format("%.2f", shape.calculateArea()));
            System.out.println("Perimeter: " + String.format("%.2f", shape.calculatePerimeter()));
        }

        System.out.println("\n=".repeat(50) + "\n");
    }

    // Helper method that demonstrates polymorphism
    private static void processShape(Shape shape) {
        System.out.println("\n🔄 Processing shape dynamically:");
        System.out.println("Shape type determined at runtime: " + shape.getName());
        shape.displayInfo();

        // Method call resolved at runtime
        shape.draw();
    }

    // Method that creates different shapes randomly (simulates runtime determination)
    private static Shape createRandomShape(String name) {
        int random = (int)(Math.random() * 3);

        switch (random) {
            case 0:
                System.out.println("🎲 Runtime decision: Creating Circle for " + name);
                return new Circle("Random", true, 3.0 + Math.random() * 5);
            case 1:
                System.out.println("🎲 Runtime decision: Creating Rectangle for " + name);
                return new Rectangle("Random", false, 2.0 + Math.random() * 8, 2.0 + Math.random() * 6);
            default:
                System.out.println("🎲 Runtime decision: Creating Square for " + name);
                return new Rectangle("Random", true, 3.0 + Math.random() * 5);
        }
    }
}

// Helper class to demonstrate method overloading (compile-time polymorphism)
class Calculator {
    // Method overloading - same name, different parameters

    public int add(int a, int b) {
        System.out.println("📱 Called: add(int, int)");
        return a + b;
    }

    public double add(double a, double b) {
        System.out.println("📱 Called: add(double, double)");
        return a + b;
    }

    public int add(int a, int b, int c) {
        System.out.println("📱 Called: add(int, int, int)");
        return a + b + c;
    }

    public String add(String a, String b) {
        System.out.println("📱 Called: add(String, String)");
        return a + " " + b;
    }

    // Method with variable arguments (varargs)
    public int add(int... numbers) {
        System.out.println("📱 Called: add(int... numbers) with " + numbers.length + " arguments");
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}
