/**
 * Drawable Interface - Demonstrates Interface-based Abstraction
 *
 * This interface shows:
 * - Pure abstraction through interfaces
 * - Contract that implementing classes must follow
 * - Multiple inheritance through interfaces
 * - Default and static methods (Java 8+)
 */

public interface Drawable {
    // Abstract methods (implicitly public and abstract)
    void draw();
    void erase();
    void resize(double factor);

    // Default method (Java 8+) - provides implementation in interface
    default void display() {
        System.out.println("🎨 Displaying drawable object:");
        draw(); // Calls the implementing class's draw method
        System.out.println("✅ Display complete");
    }

    // Static method (Java 8+) - belongs to interface, not instances
    static void printDrawingInstructions() {
        System.out.println("📋 Drawing Instructions:");
        System.out.println("1. Call draw() to render the object");
        System.out.println("2. Use resize() to change size");
        System.out.println("3. Call erase() to remove from canvas");
        System.out.println("4. Use display() for complete visualization");
    }

    // Constants (implicitly public, static, final)
    String CANVAS_TYPE = "Digital Canvas";
    int MAX_SIZE = 1000;
    int MIN_SIZE = 1;
}

/**
 * Colorable Interface - Demonstrates Multiple Interface Inheritance
 */
interface Colorable {
    void setColor(String color);
    String getColor();

    // Default method with implementation
    default void paintBrush() {
        System.out.println("🎨 Using brush to apply " + getColor() + " color");
    }
}

/**
 * Circle class implementing multiple interfaces
 */
class DrawableCircle implements Drawable, Colorable {
    private double radius;
    private String color;
    private boolean isVisible;

    public DrawableCircle(double radius, String color) {
        this.radius = radius;
        this.color = color;
        this.isVisible = false;
    }

    // Implementation of Drawable interface methods
    @Override
    public void draw() {
        isVisible = true;
        System.out.println("🔵 Drawing circle with radius " + radius + " in " + color);
        System.out.println("   ⭕ Circle rendered on " + CANVAS_TYPE);
    }

    @Override
    public void erase() {
        if (isVisible) {
            isVisible = false;
            System.out.println("🔄 Erasing " + color + " circle");
        } else {
            System.out.println("❌ Circle is not visible, nothing to erase");
        }
    }

    @Override
    public void resize(double factor) {
        if (factor <= 0) {
            System.out.println("❌ Resize factor must be positive");
            return;
        }

        double newRadius = radius * factor;
        if (newRadius > MAX_SIZE) {
            System.out.println("⚠️ Circle too large, setting to maximum size");
            radius = MAX_SIZE;
        } else if (newRadius < MIN_SIZE) {
            System.out.println("⚠️ Circle too small, setting to minimum size");
            radius = MIN_SIZE;
        } else {
            radius = newRadius;
            System.out.println("📏 Circle resized by factor " + factor + ", new radius: " + radius);
        }
    }

    // Implementation of Colorable interface methods
    @Override
    public void setColor(String color) {
        this.color = color;
        System.out.println("🎨 Circle color changed to " + color);
    }

    @Override
    public String getColor() {
        return color;
    }

    // Circle-specific methods
    public double getRadius() { return radius; }
    public boolean isVisible() { return isVisible; }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return String.format("DrawableCircle{radius=%.2f, color='%s', visible=%s}",
                           radius, color, isVisible);
    }
}

/**
 * Rectangle class implementing multiple interfaces
 */
class DrawableRectangle implements Drawable, Colorable {
    private double width, height;
    private String color;
    private boolean isVisible;

    public DrawableRectangle(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
        this.isVisible = false;
    }

    @Override
    public void draw() {
        isVisible = true;
        System.out.println("🔳 Drawing rectangle " + width + "x" + height + " in " + color);
        System.out.println("   ⬜ Rectangle rendered on " + CANVAS_TYPE);
    }

    @Override
    public void erase() {
        if (isVisible) {
            isVisible = false;
            System.out.println("🔄 Erasing " + color + " rectangle");
        } else {
            System.out.println("❌ Rectangle is not visible, nothing to erase");
        }
    }

    @Override
    public void resize(double factor) {
        if (factor <= 0) {
            System.out.println("❌ Resize factor must be positive");
            return;
        }

        width *= factor;
        height *= factor;
        System.out.println("📏 Rectangle resized by factor " + factor);
        System.out.println("   New dimensions: " + width + "x" + height);
    }

    @Override
    public void setColor(String color) {
        this.color = color;
        System.out.println("🎨 Rectangle color changed to " + color);
    }

    @Override
    public String getColor() {
        return color;
    }

    public double getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return String.format("DrawableRectangle{width=%.2f, height=%.2f, color='%s', visible=%s}",
                           width, height, color, isVisible);
    }
}
