/**
 * TestEncapsulation - Demonstrates Encapsulation Concepts
 *
 * This class shows:
 * - How encapsulation provides data security
 * - Benefits of controlled access through methods
 * - Data validation in action
 * - Different levels of access control
 */
package PracticeOOp.Encapsulation_02;

public class TestEncapsulation {
    public static void main(String[] args) {
        System.out.println("🔒 Welcome to Encapsulation Demonstration!");
        System.out.println("==========================================\n");

        // Test Person Class - Basic Encapsulation
        testPersonEncapsulation();

        // Test EncapsulatedBankAccount - Advanced Security
        testBankAccountEncapsulation();

        // Test Employee Class - Business Rules
        testEmployeeEncapsulation();

        // Demonstrate Access Modifier Effects
        demonstrateAccessModifiers();

        System.out.println("\n🎉 Encapsulation demonstration completed!");
        System.out.println("Key takeaways:");
        System.out.println("✅ Private variables protect data from unauthorized access");
        System.out.println("✅ Public getters/setters provide controlled access");
        System.out.println("✅ Validation in setters ensures data integrity");
        System.out.println("✅ Encapsulation enables business rule enforcement");
    }

    private static void testPersonEncapsulation() {
        System.out.println("👤 TESTING PERSON CLASS ENCAPSULATION");
        System.out.println("====================================\n");

        // Create person with valid data
        Person person1 = new Person("john doe", 25);
        person1.setEmail("john.doe@email.com");
        person1.setPhoneNumber("1234567890");
        person1.setHeight(175.0);
        person1.setWeight(70.0);
        person1.setAddress("123 Main St, City, State");

        person1.displayPersonInfo();

        // Test validation
        System.out.println("🧪 Testing validation in Person class:");
        person1.setName(""); // Should fail
        person1.setAge(-5); // Should fail
        person1.setEmail("invalid-email"); // Should fail
        person1.setPhoneNumber("123"); // Should fail
        person1.setHeight(-10); // Should fail
        person1.setWeight(0); // Should fail

        // Test computed properties
        System.out.println("\n📊 Computed properties:");
        System.out.printf("BMI: %.2f (%s)\n", person1.getBMI(), person1.getBMICategory());
        System.out.println("Age category: " + person1.getAgeCategory());
        System.out.println("Driver's license eligible: " + person1.isValidForDriversLicense());

        System.out.println("\n" + "=".repeat(50) + "\n");
    }

    private static void testBankAccountEncapsulation() {
        System.out.println("🏦 TESTING ENCAPSULATED BANK ACCOUNT");
        System.out.println("===================================\n");

        try {
            // Create secure bank account
            EncapsulatedBankAccount account = new EncapsulatedBankAccount(
                "Alice Johnson", "1234", "SAVINGS");

            String correctPin = "1234";
            String wrongPin = "9999";

            // Test PIN-protected operations
            System.out.println("💰 Testing secure operations:");
            account.displayAccountInfo(correctPin);

            // Test deposits (no PIN required)
            account.deposit(1000.0);
            account.deposit(-100.0); // Should fail

            // Test withdrawals (PIN required)
            account.withdraw(correctPin, 200.0);
            account.withdraw(wrongPin, 100.0); // Should fail - wrong PIN
            account.withdraw(correctPin, 50.0);

            // Test account locking mechanism
            System.out.println("\n🔒 Testing security features:");
            account.withdraw(wrongPin, 10.0); // Attempt 1
            account.withdraw(wrongPin, 10.0); // Attempt 2
            account.withdraw(wrongPin, 10.0); // Attempt 3 - should lock account

            // Try operation on locked account
            account.withdraw(correctPin, 10.0); // Should fail - account locked

            // Unlock account
            account.unlockAccount(correctPin);
            account.withdraw(correctPin, 10.0); // Should work now

            // Test PIN change
            account.changePin(correctPin, "5678");
            account.withdraw("5678", 50.0); // Should work with new PIN

        } catch (IllegalArgumentException e) {
            System.out.println("❌ Account creation failed: " + e.getMessage());
        }

        System.out.println("\n" + "=".repeat(50) + "\n");
    }

    private static void testEmployeeEncapsulation() {
        System.out.println("👨‍💼 TESTING EMPLOYEE CLASS ENCAPSULATION");
        System.out.println("========================================\n");

        try {
            // Create employee with business rules
            Employee emp1 = new Employee("Jane", "Smith", "Engineering",
                                       "Software Developer", 75000.0);

            emp1.displayEmployeeInfo();

            // Test business rule validations
            System.out.println("🧪 Testing business rule validations:");
            emp1.setBaseSalary(25000.0); // Should fail - below minimum
            emp1.setBaseSalary(600000.0); // Should fail - above maximum
            emp1.setBaseSalary(90000.0); // Should work - within 20% increase

            emp1.setBonus(-1000.0); // Should fail - negative bonus
            emp1.setBonus(50000.0); // Should fail - exceeds 50% of salary
            emp1.setBonus(15000.0); // Should work

            // Test vacation management
            System.out.println("\n🏖️ Testing vacation management:");
            emp1.requestVacation(5); // Should work
            emp1.requestVacation(12); // Should work
            emp1.requestVacation(10); // Should fail - exceeds remaining days

            // Test performance rating and automatic bonus calculation
            System.out.println("\n⭐ Testing performance management:");
            emp1.setPerformanceRating(4.5); // Should calculate bonus automatically
            emp1.displayEmployeeInfo();

            // Test promotion
            System.out.println("\n📈 Testing promotion:");
            emp1.promoteEmployee("Senior Software Developer", 10000.0);
            emp1.displayEmployeeInfo();

        } catch (IllegalArgumentException e) {
            System.out.println("❌ Employee creation failed: " + e.getMessage());
        }

        System.out.println("\n" + "=".repeat(50) + "\n");
    }

    private static void demonstrateAccessModifiers() {
        System.out.println("🔑 DEMONSTRATING ACCESS MODIFIERS");
        System.out.println("=================================\n");

        Employee employee = new Employee("Bob", "Wilson", "HR", "Manager", 65000.0);
        EncapsulatedBankAccount account = new EncapsulatedBankAccount(
            "Bob Wilson", "1111", "CHECKING");

        System.out.println("📋 What we CAN access from outside the class:");

        // Public members - accessible everywhere
        System.out.println("✅ Public: employee.getEmployeeId() = " + employee.getEmployeeId());
        System.out.println("✅ Public: employee.getFullName() = " + employee.getFullName());
        System.out.println("✅ Public: account.getAccountNumber() = " + account.getAccountNumber());

        // Package-private members - accessible within same package
        System.out.println("✅ Package: account.accountType = " + account.accountType);
        // Note: In a different package, this would not be accessible

        // Protected members - accessible to subclasses and same package
        System.out.println("✅ Protected: employee.performanceRating = " + employee.performanceRating);

        System.out.println("\n📋 What we CANNOT access from outside the class:");
        System.out.println("❌ Private: employee.firstName - COMPILATION ERROR if attempted");
        System.out.println("❌ Private: employee.baseSalary - COMPILATION ERROR if attempted");
        System.out.println("❌ Private: account.balance - COMPILATION ERROR if attempted");
        System.out.println("❌ Private: account.pin - COMPILATION ERROR if attempted");

        // Demonstrate that we must use public methods for access
        System.out.println("\n📋 Accessing private data through public methods:");
        System.out.println("✅ Via getter: employee.getFirstName() = " + employee.getFirstName());
        System.out.println("✅ Via getter: employee.getBaseSalary() = $" + employee.getBaseSalary());
        System.out.println("✅ Via secured method: account.getBalance(\"1111\") = $" + account.getBalance("1111"));

        System.out.println("\n💡 Key Benefits Demonstrated:");
        System.out.println("🔐 Data is protected from direct manipulation");
        System.out.println("✅ Validation occurs in setter methods");
        System.out.println("🎯 Business rules are enforced automatically");
        System.out.println("🔄 Internal implementation can change without affecting external code");

        System.out.println("\n" + "=".repeat(50) + "\n");
    }
}
