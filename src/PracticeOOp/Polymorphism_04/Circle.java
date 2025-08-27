/**
 * Circle - Concrete implementation of Shape demonstrating Polymorphism
 *
 * This class extends the abstract Shape class and provides specific
 * implementations for circle-related calculations and behaviors.
 */
package PracticeOOp.Polymorphism_04;

public class Circle extends Shape {
    private double radius;

    // Constructor
    public Circle(String color, boolean filled, double radius) {
        super("Circle", color, filled); // Call parent constructor
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
        this.radius = radius;
    }

    // Implementation of abstract method from Shape
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Implementation of abstract method from Shape
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    // Implementation of abstract method from Shape
    @Override
    public void draw() {
        System.out.println("🔵 Drawing a circle with radius " + radius);
        System.out.println("   ⭕ Circle drawn!");
    }

    // Circle-specific methods
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            System.out.println("❌ Radius must be positive");
            return;
        }
        this.radius = radius;
        System.out.println("✅ Circle radius updated to: " + radius);
    }

    public double getDiameter() {
        return 2 * radius;
    }

    public double getCircumference() {
        return calculatePerimeter(); // Same as perimeter for circle
    }

    // Override paint method to add circle-specific behavior
    @Override
    public void paint(String newColor) {
        super.paint(newColor); // Call parent implementation
        System.out.println("🎨 Circle painting complete - smooth circular brush strokes used");
    }

    // Circle-specific utility methods
    public boolean canFitInSquare(double squareSide) {
        return getDiameter() <= squareSide;
    }

    public Circle scale(double factor) {
        if (factor <= 0) {
            System.out.println("❌ Scale factor must be positive");
            return this;
        }
        return new Circle(color, filled, radius * factor);
    }

    @Override
    public String toString() {
        return String.format("Circle{radius=%.2f, color='%s', area=%.2f}",
                           radius, color, calculateArea());
    }
}
