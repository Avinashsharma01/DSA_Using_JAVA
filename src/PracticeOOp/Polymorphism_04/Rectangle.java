/**
 * Rectangle - Another concrete Shape implementation demonstrating Polymorphism
 *
 * Shows how different shapes implement the same interface differently
 */
package PracticeOOp.Polymorphism_04;

public class Rectangle extends Shape {
    private double length;
    private double width;

    // Constructor
    public Rectangle(String color, boolean filled, double length, double width) {
        super("Rectangle", color, filled);
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Length and width must be positive");
        }
        this.length = length;
        this.width = width;
    }

    // Square constructor (special case of rectangle)
    public Rectangle(String color, boolean filled, double side) {
        this(color, filled, side, side);
        this.name = "Square"; // Update name for square
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    @Override
    public void draw() {
        System.out.println("🔳 Drawing a " + name.toLowerCase() + " with length " + length + " and width " + width);
        System.out.println("   ⬜ " + name + " drawn!");
    }

    // Rectangle-specific methods
    public double getLength() { return length; }
    public double getWidth() { return width; }

    public void setDimensions(double length, double width) {
        if (length <= 0 || width <= 0) {
            System.out.println("❌ Dimensions must be positive");
            return;
        }
        this.length = length;
        this.width = width;
        System.out.println("✅ Rectangle dimensions updated: " + length + " x " + width);
    }

    public boolean isSquare() {
        return Math.abs(length - width) < 0.001; // Account for floating point precision
    }

    public double getDiagonal() {
        return Math.sqrt(length * length + width * width);
    }

    @Override
    public void paint(String newColor) {
        super.paint(newColor);
        System.out.println("🎨 Rectangle painting complete - used roller for even coverage");
    }

    @Override
    public String toString() {
        return String.format("Rectangle{length=%.2f, width=%.2f, color='%s', area=%.2f}",
                           length, width, color, calculateArea());
    }
}
