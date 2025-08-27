/**
 * TestAbstraction - Comprehensive demonstration of Abstraction concepts
 *
 * This class demonstrates:
 * - How abstract classes provide common interface
 * - Different implementations of abstract methods
 * - Benefits of hiding implementation complexity
 * - Template method pattern through abstraction
 */

package PracticeOOp.Abstraction_05;
public class TestAbstraction {
    public static void main(String[] args) {
        System.out.println("🎭 Welcome to Abstraction Demonstration!");
        System.out.println("========================================\n");

        // Test abstract class implementation
        testAbstractClassImplementation();

        // Test polymorphism through abstraction
        testPolymorphismThroughAbstraction();

        // Test template method pattern
        testTemplateMethodPattern();

        // Test abstraction benefits
        testAbstractionBenefits();

        System.out.println("\n🎉 Abstraction demonstration completed!");
        System.out.println("\nKey Abstraction Benefits Demonstrated:");
        System.out.println("✅ Implementation hiding - Users don't need to know HOW, just WHAT");
        System.out.println("✅ Common interface - Same methods, different implementations");
        System.out.println("✅ Code organization - Abstract classes provide structure");
        System.out.println("✅ Flexibility - Easy to add new implementations");
    }

    private static void testAbstractClassImplementation() {
        System.out.println("🏗️ TESTING ABSTRACT CLASS IMPLEMENTATION");
        System.out.println("========================================\n");

        // Cannot instantiate abstract class directly
        // Animal animal = new Animal(); // This would cause compilation error

        // But we can create concrete implementations
        Dog myDog = new Dog("Buddy", 3, 25.0, "Golden Retriever");

        // Show that Dog has all Animal functionality plus its own
        System.out.println("🔍 Testing inherited and implemented methods:");

        // Abstract methods implemented by Dog
        myDog.makeSound();           // Dog's implementation
        myDog.move();                // Dog's implementation
        myDog.eat("dog food");       // Dog's implementation
        System.out.println("Habitat: " + myDog.getHabitat()); // Dog's implementation

        // Concrete methods inherited from Animal
        myDog.breathe();             // Inherited from Animal
        myDog.sleep();               // Overridden in Dog
        myDog.grow();                // Inherited from Animal

        // Dog-specific methods
        myDog.train();
        myDog.sitCommand();
        myDog.fetch();

        myDog.displayBasicInfo();

        System.out.println("=".repeat(50) + "\n");
    }

    private static void testPolymorphismThroughAbstraction() {
        System.out.println("🎭 TESTING POLYMORPHISM THROUGH ABSTRACTION");
        System.out.println("==========================================\n");

        // Create different animals using Animal reference
        Animal[] animals = {
            new Dog("Rex", 4, 30.0, "German Shepherd"),
            new Dog("Bella", 2, 20.0, "Labrador"),
            new Dog("Max", 5, 35.0, "Bulldog")
        };

        System.out.println("🔍 Processing different animals polymorphically:");

        // Process all animals the same way, but each behaves differently
        for (int i = 0; i < animals.length; i++) {
            Animal animal = animals[i];

            System.out.println("\n--- Animal " + (i + 1) + " ---");
            System.out.println("Name: " + animal.getName());
            System.out.println("Species: " + animal.getSpecies());

            // Same method calls, different implementations
            animal.makeSound();      // Polymorphic call
            animal.move();           // Polymorphic call
            animal.eat("treats");    // Polymorphic call

            // Check if we can access specific methods
            if (animal instanceof Dog) {
                Dog dog = (Dog) animal;
                dog.fetch(); // Access Dog-specific method
            }
        }

        System.out.println("\n=".repeat(50) + "\n");
    }

    private static void testTemplateMethodPattern() {
        System.out.println("📋 TESTING TEMPLATE METHOD PATTERN");
        System.out.println("==================================\n");

        Dog dog1 = new Dog("Charlie", 2, 22.0, "Beagle");
        Dog dog2 = new Dog("Luna", 1, 15.0, "Poodle");

        System.out.println("🔍 Template method pattern demonstration:");
        System.out.println("Same routine structure, different implementations:");

        // performDailyRoutine() is a template method in Animal class
        // It calls abstract methods that are implemented differently by each subclass
        dog1.performDailyRoutine();
        dog2.performDailyRoutine();

        // Train one dog and see the difference
        dog1.train();
        dog1.dogDailyRoutine(); // Dog-specific routine

        System.out.println("=".repeat(50) + "\n");
    }

    private static void testAbstractionBenefits() {
        System.out.println("💡 TESTING ABSTRACTION BENEFITS");
        System.out.println("===============================\n");

        Dog smartDog = new Dog("Einstein", 3, 28.0, "Border Collie");

        System.out.println("🔍 Abstraction benefits in action:");

        // 1. Implementation hiding
        System.out.println("\n1️⃣ Implementation Hiding:");
        System.out.println("   User calls makeSound() without knowing HOW the sound is made");
        smartDog.makeSound(); // User doesn't need to know implementation details

        // 2. Common interface
        System.out.println("\n2️⃣ Common Interface:");
        System.out.println("   All animals have same interface but different behavior");
        processAnyAnimal(smartDog); // Works with any Animal subclass

        // 3. Extensibility
        System.out.println("\n3️⃣ Extensibility:");
        System.out.println("   Easy to add new animal types without changing existing code");
        System.out.println("   Just create new class extending Animal and implement abstract methods");

        // 4. Code reusability
        System.out.println("\n4️⃣ Code Reusability:");
        System.out.println("   Common functionality (breathe, sleep, grow) shared by all animals");
        smartDog.breathe(); // Reused from Animal class
        smartDog.grow();    // Reused from Animal class

        // 5. Complexity management
        System.out.println("\n5️⃣ Complexity Management:");
        System.out.println("   Complex animal behaviors simplified into clear methods");
        smartDog.displayBasicInfo(); // Complex info display made simple

        System.out.println("=".repeat(50) + "\n");
    }

    // Helper method demonstrating abstraction benefit
    private static void processAnyAnimal(Animal animal) {
        System.out.println("   Processing animal: " + animal.getName());
        animal.makeSound();  // Works with any Animal implementation
        animal.move();       // Works with any Animal implementation
        System.out.println("   Lives in: " + animal.getHabitat());
    }

    // Method demonstrating interaction through abstraction
    private static void demonstrateAnimalInteraction() {
        Animal dog1 = new Dog("Rocky", 4, 32.0, "Rottweiler");
        Animal dog2 = new Dog("Daisy", 3, 18.0, "Cocker Spaniel");

        System.out.println("🤝 Animal interaction through abstraction:");
        dog1.interact(dog2); // Uses abstract methods polymorphically
    }
}
