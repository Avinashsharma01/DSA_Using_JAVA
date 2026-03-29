/**
 * TestClasses - Main class to demonstrate all OOP examples
 *
 * This class shows:
 * - How to create objects using different constructors
 * - How to call methods on objects
 * - Object interaction and relationships
 * - Practical usage of all the classes we've created
 */

package PracticeOOp.Classes_And_Objects_01;

public class TestClasses {
    public static void main(String[] args) {
        System.out.println("🎓 Welcome to Object-Oriented Programming Demo!");
        System.out.println("================================================\n");

        // Test Student Class
        testStudentClass();

        // Test Car Class
        testCarClass();

        // Test BankAccount Class
        testBankAccountClass();

        // Test Static vs Instance Members
        testStaticExample();

        System.out.println("\n🎉 Demo completed! You've learned the basics of Classes and Objects!");
    }

    // Test Student Class functionality
    private static void testStudentClass() {
        System.out.println("📚 TESTING STUDENT CLASS");
        System.out.println("========================\n");

        // Creating students using different constructors
        Student student1 = new Student(); // Default constructor
        Student student2 = new Student("Alice Johnson", 20, "STU001");
        Student student3 = new Student("Bob Smith", 22, "STU002", 3.8, "Computer Science");

        // Display initial information
        student1.displayInfo();
        student2.displayInfo();
        student3.displayInfo();

        // Modify student1 using setters
        System.out.println("🔧 Updating student1 information...");
        student1.setName("Charlie Brown");
        student1.setAge(19);
        student1.setGpa(3.2);
        student1.setMajor("Mathematics");

        student1.displayInfo();

        // Test student behavior
        student2.study("Java Programming");
        student2.attendClass("Object-Oriented Programming");
        student3.study("Data Structures");

        // Test validation
        System.out.println("\n🧪 Testing validation...");
        student1.setAge(-5); // Should show error
        student1.setGpa(5.0); // Should show error
        student1.setName(""); // Should show error

        System.out.println("\n" + student3.toString());
        System.out.println("Is " + student3.getName() + " eligible for honors? " + student3.isEligibleForHonors());

        System.out.println("\n" + "=".repeat(50) + "\n");
    }

    // Test Car Class functionality
    private static void testCarClass() {
        System.out.println("🚗 TESTING CAR CLASS");
        System.out.println("===================\n");

        // Creating cars using different constructors
        Car car1 = new Car(); // Default constructor
        Car car2 = new Car("Toyota", "Camry");
        Car car3 = new Car("Honda", "Civic", 2022);
        Car car4 = new Car("BMW", "X5", 2023, "Black", 65000.0);

        // Test copy constructor
        Car car5 = new Car(car4); // Copy of car4

        System.out.println("\n📋 Displaying all cars:");
        car1.displayCarInfo();
        car2.displayCarInfo();
        car3.displayCarInfo();
        car4.displayCarInfo();
        car5.displayCarInfo();

        // Test car behaviors
        System.out.println("🚙 Testing car behaviors...\n");

        car3.startEngine();
        car3.drive(50);
        car3.honk();
        car3.drive(25);
        car3.stopEngine();
        car3.drive(10); // Should show error - engine is off

        System.out.println();
        car4.startEngine();
        car4.drive(100);
        car4.honk();
        car4.stopEngine();

        // Test validation
        System.out.println("\n🧪 Testing validation...");
        car1.setYear(1800); // Should show error
        car1.setPrice(-1000); // Should show error

        System.out.println("\n" + "=".repeat(50) + "\n");
    }

    // Test BankAccount Class functionality
    private static void testBankAccountClass() {
        System.out.println("🏦 TESTING BANK ACCOUNT CLASS");
        System.out.println("=============================\n");

        try {
            // Creating bank accounts
            BankAccount account1 = new BankAccount("John Doe", "Savings", 1000.0);
            BankAccount account2 = new BankAccount("Jane Smith", "Checking", 1500.0);
            BankAccount account3 = new BankAccount("Bob Johnson", "Business", 5000.0);

            // Display account information
            account1.displayAccountInfo();
            account2.displayAccountInfo();
            account3.displayAccountInfo();

            // Test banking operations
            System.out.println("💰 Testing banking operations...\n");

            account1.checkBalance();
            account1.deposit(500.0);
            account1.withdraw(200.0);
            account1.checkBalance();

            System.out.println();
            account2.deposit(1000.0);
            account2.withdraw(300.0);

            // Test transfer between accounts
            System.out.println("\n🔄 Testing transfer...");
            account1.transfer(account2, 250.0);

            account1.checkBalance();
            account2.checkBalance();

            // Test multiple transactions to trigger fees
            System.out.println("💳 Testing transaction limits...");
            for (int i = 1; i <= 7; i++) {
                account3.deposit(100.0);
                System.out.println("Transaction #" + i + " completed\n");
            }

            // Test validation and error cases
            System.out.println("🧪 Testing validation...");
            account1.withdraw(-100); // Negative amount
            account1.withdraw(10000); // Exceeds daily limit
            account1.withdraw(900); // Would violate minimum balance

            // Test account closure
            System.out.println("\n🔒 Testing account closure...");
            account1.withdraw(300); // Reduce balance close to minimum
            account1.displayAccountInfo();

            System.out.println("Total accounts created: " + BankAccount.getTotalAccounts());

        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error creating account: " + e.getMessage());
        }

        // Test invalid account creation
        System.out.println("\n🧪 Testing invalid account creation...");
        try {
            BankAccount invalidAccount = new BankAccount("", "Savings", 50.0);
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Expected error: " + e.getMessage());
        }

        try {
            BankAccount invalidAccount2 = new BankAccount("Test User", "Savings", 50.0);
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Expected error: " + e.getMessage());
        }

        System.out.println("\n" + "=".repeat(50) + "\n");
    }

    // Test Static vs Instance Members
    private static void testStaticExample() {
        System.out.println("⚡ TESTING STATIC VS INSTANCE MEMBERS");
        System.out.println("====================================\n");

        StaticExample.demonstrateStaticVsInstance();

        System.out.println("\n" + "=".repeat(50) + "\n");
    }
}
