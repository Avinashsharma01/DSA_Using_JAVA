/**
 * Dog - Concrete implementation of Animal abstract class
 *
 * This class demonstrates:
 * - Implementation of all abstract methods from Animal
 * - Dog-specific behaviors and attributes
 * - How abstraction allows different implementations
 */
package PracticeOOp.Abstraction_05;
public class Dog extends Animal {
    // Dog-specific attributes
    private String breed;
    private boolean isTrained;
    private String favoriteActivity;

    // Constructor
    public Dog(String name, int age, double weight, String breed) {
        super(name, "Canis lupus", age, weight); // Call parent constructor
        this.breed = breed;
        this.isTrained = false;
        this.favoriteActivity = "playing fetch";
        System.out.println("🐕 Dog-specific features initialized for " + breed);
    }

    // Implementation of abstract method from Animal
    @Override
    public void makeSound() {
        System.out.println("🐕 " + name + " says: WOOF WOOF! BARK BARK!");
    }

    // Implementation of abstract method from Animal
    @Override
    public void move() {
        System.out.println("🏃 " + name + " is running and wagging tail enthusiastically!");
    }

    // Implementation of abstract method from Animal
    @Override
    public String getHabitat() {
        return "Domestic homes and yards";
    }

    // Implementation of abstract method from Animal
    @Override
    public void eat(String food) {
        if (food.equalsIgnoreCase("dog food") || food.equalsIgnoreCase("meat") || food.equalsIgnoreCase("treats")) {
            System.out.println("🍖 " + name + " is happily eating " + food + " - tail wagging!");
        } else {
            System.out.println("🤔 " + name + " sniffs " + food + " but prefers dog food");
        }
    }

    // Dog-specific methods
    public void fetch() {
        System.out.println("🎾 " + name + " is playing fetch - running to get the ball!");
    }

    public void sitCommand() {
        if (isTrained) {
            System.out.println("🐕 " + name + " sits obediently on command");
        } else {
            System.out.println("🤷 " + name + " doesn't understand the sit command yet");
        }
    }

    public void stayCommand() {
        if (isTrained) {
            System.out.println("🐕 " + name + " stays in place, waiting for next command");
        } else {
            System.out.println("🏃 " + name + " gets distracted and starts running around");
        }
    }

    public void train() {
        if (!isTrained) {
            isTrained = true;
            System.out.println("🎓 " + name + " has been trained! Now responds to commands");
        } else {
            System.out.println("✅ " + name + " is already well-trained");
        }
    }

    public void guard() {
        System.out.println("🛡️ " + name + " is guarding the house - alert and protective!");
        makeSound(); // Dogs bark when guarding
    }

    public void playWith(Dog otherDog) {
        System.out.println("🎮 " + this.name + " is playing with " + otherDog.name);
        System.out.println("🏃‍♂️ Both dogs are running around and having fun!");
        this.makeSound();
        otherDog.makeSound();
    }

    // Override sleep method to add dog-specific behavior
    @Override
    public void sleep() {
        System.out.println("💤 " + name + " is sleeping in a cozy dog bed, dreaming of " + favoriteActivity);
    }

    // Dog-specific daily routine
    public void dogDailyRoutine() {
        System.out.println("\n🐕 " + name + "'s Special Dog Day:");
        makeSound();            // Morning bark
        fetch();                // Play fetch
        eat("dog food");        // Eat breakfast
        guard();                // Guard the house
        if (isTrained) {
            sitCommand();
            stayCommand();
        }
        sleep();                // Afternoon nap
        System.out.println("🌙 " + name + " had a perfect dog day!\n");
    }

    // Getters and setters
    public String getBreed() { return breed; }
    public boolean isTrained() { return isTrained; }
    public String getFavoriteActivity() { return favoriteActivity; }

    public void setFavoriteActivity(String activity) {
        this.favoriteActivity = activity;
        System.out.println("🎯 " + name + "'s favorite activity is now: " + activity);
    }

    @Override
    public void displayBasicInfo() {
        super.displayBasicInfo(); // Call parent method
        System.out.println("🐕 ===== Dog-Specific Info =====");
        System.out.println("Breed: " + breed);
        System.out.println("Trained: " + (isTrained ? "Yes" : "No"));
        System.out.println("Favorite Activity: " + favoriteActivity);
        System.out.println("============================\n");
    }

    @Override
    public String toString() {
        return String.format("Dog{name='%s', breed='%s', age=%d, trained=%s}",
                           name, breed, age, isTrained);
    }
}
