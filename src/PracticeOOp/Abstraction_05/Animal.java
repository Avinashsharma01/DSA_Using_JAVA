/**
 * Animal - Abstract class demonstrating Abstraction
 *
 * This abstract class shows:
 * - Abstract methods (must be implemented by subclasses)
 * - Concrete methods (shared by all animals)
 * - How to hide implementation complexity
 * - Common interface for all animals
 */
package PracticeOOp.Abstraction_05;

public abstract class Animal {
    // Protected attributes accessible to subclasses
    protected String name;
    protected String species;
    protected int age;
    protected boolean isAlive;
    protected double weight;

    // Constructor for abstract class
    public Animal(String name, String species, int age, double weight) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.weight = weight;
        this.isAlive = true;
        System.out.println("🐾 Animal created: " + name + " (" + species + ")");
    }

    // Abstract methods - MUST be implemented by subclasses
    public abstract void makeSound();           // Every animal makes sound differently
    public abstract void move();                // Every animal moves differently
    public abstract String getHabitat();        // Every animal lives in different habitat
    public abstract void eat(String food);      // Every animal eats differently

    // Concrete methods - shared by all animals (common behavior)
    public void sleep() {
        System.out.println("💤 " + name + " is sleeping peacefully...");
    }

    public void breathe() {
        if (isAlive) {
            System.out.println("🫁 " + name + " is breathing");
        } else {
            System.out.println("💀 " + name + " is not breathing");
        }
    }

    public void grow() {
        age++;
        weight += 0.5; // Simple growth simulation
        System.out.println("📈 " + name + " grew! Now " + age + " years old, weighs " + weight + " kg");
    }

    // Template method pattern - uses abstract methods
    public void performDailyRoutine() {
        System.out.println("\n🌅 " + name + "'s Daily Routine:");
        breathe();              // Concrete method
        makeSound();            // Abstract method - different for each animal
        move();                 // Abstract method - different for each animal
        eat("food");            // Abstract method - different for each animal
        sleep();                // Concrete method
        System.out.println("🌙 Daily routine completed for " + name + "\n");
    }

    // Method that demonstrates abstraction benefit
    public void displayBasicInfo() {
        System.out.println("\n🐾 ===== Animal Information =====");
        System.out.println("Name: " + name);
        System.out.println("Species: " + species);
        System.out.println("Age: " + age + " years");
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Status: " + (isAlive ? "Alive" : "Deceased"));
        System.out.println("Habitat: " + getHabitat()); // Abstract method call
        System.out.println("==============================\n");
    }

    // Concrete method with business logic
    public boolean canReproduce() {
        return isAlive && age >= 2; // Simple reproduction logic
    }

    public void interact(Animal otherAnimal) {
        System.out.println("🤝 " + this.name + " is interacting with " + otherAnimal.name);

        // Both animals make sounds during interaction
        this.makeSound();           // Polymorphic call
        otherAnimal.makeSound();    // Polymorphic call

        if (this.species.equals(otherAnimal.species)) {
            System.out.println("👫 Same species - friendly interaction!");
        } else {
            System.out.println("🌍 Different species - cautious interaction");
        }
    }

    // Getters and setters
    public String getName() { return name; }
    public String getSpecies() { return species; }
    public int getAge() { return age; }
    public double getWeight() { return weight; }
    public boolean isAlive() { return isAlive; }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        }
    }

    // Method to demonstrate lifecycle
    public void age(int years) {
        for (int i = 0; i < years; i++) {
            grow();
        }
    }

    @Override
    public String toString() {
        return String.format("%s{name='%s', species='%s', age=%d, weight=%.1f}",
                           getClass().getSimpleName(), name, species, age, weight);
    }
}
