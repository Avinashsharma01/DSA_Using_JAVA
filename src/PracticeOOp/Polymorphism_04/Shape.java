/**
 * Shape - Abstract class demonstrating Runtime Polymorphism
 *
 * This abstract class defines the common interface for all shapes
 * while allowing each shape to implement its own specific behavior.
 */
package PracticeOOp.Polymorphism_04;

public abstract class Shape {
    // Protected attributes accessible to subclasses
    protected String color;
    protected boolean filled;
    protected String name;

    // Constructor
    public Shape(String name, String color, boolean filled) {
        this.name = name;
        this.color = color;
        this.filled = filled;
    }

    // Abstract methods - must be implemented by subclasses
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    public abstract void draw();

    // Concrete methods - can be used by all subclasses
    public void displayInfo() {
        System.out.println("\n🔷 ===== Shape Information =====");
        System.out.println("Shape: " + name);
        System.out.println("Color: " + color);
        System.out.println("Filled: " + (filled ? "Yes" : "No"));
        System.out.printf("Area: %.2f square units\n", calculateArea());
        System.out.printf("Perimeter: %.2f units\n", calculatePerimeter());
        draw(); // Polymorphic call - different for each shape
        System.out.println("==============================\n");
    }

    // Concrete method that can be overridden
    public void paint(String newColor) {
        String oldColor = this.color;
        this.color = newColor;
        System.out.println("🎨 " + name + " painted from " + oldColor + " to " + newColor);
    }

    // Getters
    public String getName() { return name; }
    public String getColor() { return color; }
    public boolean isFilled() { return filled; }

    // Setters
    public void setFilled(boolean filled) {
        this.filled = filled;
        System.out.println("✅ " + name + " fill status: " + (filled ? "Filled" : "Outline only"));
    }

    // Method that demonstrates polymorphism
    public void compareWith(Shape other) {
        System.out.println("\n📊 Comparing " + this.name + " with " + other.name + ":");
        System.out.printf("Area difference: %.2f\n", Math.abs(this.calculateArea() - other.calculateArea()));
        System.out.printf("Perimeter difference: %.2f\n", Math.abs(this.calculatePerimeter() - other.calculatePerimeter()));

        if (this.calculateArea() > other.calculateArea()) {
            System.out.println("🏆 " + this.name + " has larger area");
        } else if (this.calculateArea() < other.calculateArea()) {
            System.out.println("🏆 " + other.name + " has larger area");
        } else {
            System.out.println("🤝 Both shapes have equal area");
        }
    }

    @Override
    public String toString() {
        return String.format("%s{color='%s', filled=%s, area=%.2f}",
                           name, color, filled, calculateArea());
    }
}
