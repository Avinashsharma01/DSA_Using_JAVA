/**
 * CustomExceptions - Creating and Using Custom Exception Classes
 *
 * This class demonstrates:
 * - How to create custom exception classes
 * - When to use custom exceptions vs built-in ones
 * - Checked vs unchecked custom exceptions
 * - Exception chaining and cause tracking
 * - Best practices for custom exception design
 */

// ================== CUSTOM EXCEPTION CLASSES ==================

/**
 * Custom checked exception for banking operations
 */

package ExaptionHandling;

class InsufficientFundsException extends Exception {
    private double availableBalance;
    private double requestedAmount;

    public InsufficientFundsException(double availableBalance, double requestedAmount) {
        super(String.format("Insufficient funds: Available=%.2f, Requested=%.2f",
                          availableBalance, requestedAmount));
        this.availableBalance = availableBalance;
        this.requestedAmount = requestedAmount;
    }

    public double getAvailableBalance() { return availableBalance; }
    public double getRequestedAmount() { return requestedAmount; }
    public double getShortfall() { return requestedAmount - availableBalance; }
}

/**
 * Custom unchecked exception for invalid age
 */
class InvalidAgeException extends RuntimeException {
    private int providedAge;
    private int minAge;
    private int maxAge;

    public InvalidAgeException(int providedAge, int minAge, int maxAge) {
        super(String.format("Invalid age %d: Must be between %d and %d",
                          providedAge, minAge, maxAge));
        this.providedAge = providedAge;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public int getProvidedAge() { return providedAge; }
    public int getMinAge() { return minAge; }
    public int getMaxAge() { return maxAge; }
}

/**
 * Custom exception for email validation
 */

class InvalidEmailException extends Exception {
    private String email;
    private String reason;

    public InvalidEmailException(String email, String reason) {
        super("Invalid email '" + email + "': " + reason);
        this.email = email;
        this.reason = reason;
    }

    public String getEmail() { return email; }
    public String getReason() { return reason; }
}

/**
 * Custom exception hierarchy for student management
 */
class StudentManagementException extends Exception {
    public StudentManagementException(String message) {
        super(message);
    }

    public StudentManagementException(String message, Throwable cause) {
        super(message, cause);
    }
}

class DuplicateStudentException extends StudentManagementException {
    private String studentId;

    public DuplicateStudentException(String studentId) {
        super("Student with ID '" + studentId + "' already exists");
        this.studentId = studentId;
    }

    public String getStudentId() { return studentId; }
}

class StudentNotFoundException extends StudentManagementException {
    private String studentId;

    public StudentNotFoundException(String studentId) {
        super("Student with ID '" + studentId + "' not found");
        this.studentId = studentId;
    }

    public String getStudentId() { return studentId; }
}

// ================== CLASSES USING CUSTOM EXCEPTIONS ==================

/**
 * Bank Account class demonstrating custom exception usage
 */
class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    private static final double MIN_BALANCE = 100.0;

    public BankAccount(String accountNumber, String holderName, double initialBalance)
            throws InsufficientFundsException {
        if (initialBalance < MIN_BALANCE) {
            throw new InsufficientFundsException(initialBalance, MIN_BALANCE);
        }

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;

        System.out.println("✅ Account created: " + accountNumber + " with balance $" + balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }

        if (balance - amount < MIN_BALANCE) {
            throw new InsufficientFundsException(balance, amount + MIN_BALANCE);
        }

        balance -= amount;
        System.out.println("💸 Withdrawn $" + amount + ". New balance: $" + balance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }

        balance += amount;
        System.out.println("💰 Deposited $" + amount + ". New balance: $" + balance);
    }

    public double getBalance() { return balance; }
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
}

/**
 * Person class demonstrating validation with custom exceptions
 */
class Person {
    private String name;
    private int age;
    private String email;

    public Person(String name, int age, String email) throws InvalidAgeException, InvalidEmailException {
        setName(name);
        setAge(age);
        setEmail(email);

        System.out.println("✅ Person created: " + name + ", Age: " + age + ", Email: " + email);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name.trim();
    }

    public void setAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException(age, 0, 150);
        }
        this.age = age;
    }

    public void setEmail(String email) throws InvalidEmailException {
        if (email == null || email.trim().isEmpty()) {
            throw new InvalidEmailException(email, "Email cannot be empty");
        }

        if (!email.contains("@")) {
            throw new InvalidEmailException(email, "Email must contain @ symbol");
        }

        if (!email.contains(".")) {
            throw new InvalidEmailException(email, "Email must contain domain extension");
        }

        this.email = email.trim();
    }

    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
}

// ================== MAIN DEMONSTRATION CLASS ==================

public class CustomExceptions {

    public static void main(String[] args) {
        System.out.println("🎯 Custom Exceptions Demonstration");
        System.out.println("==================================\n");

        // Example 1: Banking operations with custom exceptions
        demonstrateBankingExceptions();

        // Example 2: Person validation with custom exceptions
        demonstratePersonValidation();

        // Example 3: Exception chaining and cause tracking
        demonstrateExceptionChaining();

        // Example 4: Multiple custom exceptions in one operation
        demonstrateComplexOperation();

        System.out.println("\n🎉 Custom exceptions demonstration completed!");
    }

    // Example 1: Banking operations
    public static void demonstrateBankingExceptions() {
        System.out.println("1️⃣ Banking Operations with Custom Exceptions:");
        System.out.println("---------------------------------------------");

        try {
            // Create account with insufficient initial balance
            BankAccount account1 = new BankAccount("ACC001", "John Doe", 50.0);

        } catch (InsufficientFundsException e) {
            System.out.println("❌ Account creation failed: " + e.getMessage());
            System.out.println("💡 Shortfall: $" + e.getShortfall());
        }

        try {
            // Create valid account
            BankAccount account2 = new BankAccount("ACC002", "Jane Smith", 1000.0);

            // Successful operations
            account2.deposit(200.0);
            account2.withdraw(150.0);

            // This will fail
            account2.withdraw(900.0);

        } catch (InsufficientFundsException e) {
            System.out.println("❌ Withdrawal failed: " + e.getMessage());
            System.out.println("💡 Available: $" + e.getAvailableBalance());
            System.out.println("💡 Requested: $" + e.getRequestedAmount());

        } catch (IllegalArgumentException e) {
            System.out.println("❌ Invalid argument: " + e.getMessage());
        }

        System.out.println();
    }

    // Example 2: Person validation
    public static void demonstratePersonValidation() {
        System.out.println("2️⃣ Person Validation with Custom Exceptions:");
        System.out.println("--------------------------------------------");

        // Valid person creation
        try {
            Person person1 = new Person("Alice Johnson", 25, "alice@email.com");

        } catch (InvalidAgeException | InvalidEmailException e) {
            System.out.println("❌ Person creation failed: " + e.getMessage());
        }

        // Invalid age
        try {
            Person person2 = new Person("Bob Smith", 200, "bob@email.com");

        } catch (InvalidAgeException e) {
            System.out.println("❌ Invalid age: " + e.getMessage());
            System.out.println("💡 Provided: " + e.getProvidedAge());
            System.out.println("💡 Valid range: " + e.getMinAge() + "-" + e.getMaxAge());

        } catch (InvalidEmailException e) {
            System.out.println("❌ Invalid email: " + e.getMessage());
        }

        // Invalid email
        try {
            Person person3 = new Person("Carol Davis", 30, "invalid-email");

        } catch (InvalidAgeException e) {
            System.out.println("❌ Invalid age: " + e.getMessage());

        } catch (InvalidEmailException e) {
            System.out.println("❌ Invalid email: " + e.getMessage());
            System.out.println("💡 Email: " + e.getEmail());
            System.out.println("💡 Reason: " + e.getReason());
        }

        System.out.println();
    }

    // Example 3: Exception chaining
    public static void demonstrateExceptionChaining() {
        System.out.println("3️⃣ Exception Chaining:");
        System.out.println("----------------------");

        try {
            performComplexOperation();

        } catch (StudentManagementException e) {
            System.out.println("❌ Student management error: " + e.getMessage());

            // Check if there's a cause
            if (e.getCause() != null) {
                System.out.println("🔗 Caused by: " + e.getCause().getClass().getSimpleName());
                System.out.println("🔗 Root cause: " + e.getCause().getMessage());
            }
        }

        System.out.println();
    }

    private static void performComplexOperation() throws StudentManagementException {
        try {
            // Simulate a database operation that fails
            simulateDatabaseOperation();

        } catch (RuntimeException e) {
            // Chain the exception - preserve the original cause
            throw new StudentManagementException("Failed to access student database", e);
        }
    }

    private static void simulateDatabaseOperation() {
        // Simulate database connection failure
        throw new RuntimeException("Database connection timeout");
    }

    // Example 4: Complex operation with multiple exception types
    public static void demonstrateComplexOperation() {
        System.out.println("4️⃣ Complex Operation with Multiple Exceptions:");
        System.out.println("----------------------------------------------");

        try {
            processStudentData("STU001", "John Doe", 20, "john@email.com", 1000.0);
            processStudentData("STU001", "Jane Smith", 22, "jane@email.com", 1500.0); // Duplicate ID

        } catch (DuplicateStudentException e) {
            System.out.println("❌ Duplicate student: " + e.getMessage());
            System.out.println("💡 Student ID: " + e.getStudentId());

        } catch (InvalidAgeException e) {
            System.out.println("❌ Invalid age: " + e.getMessage());

        } catch (InvalidEmailException e) {
            System.out.println("❌ Invalid email: " + e.getMessage());

        } catch (InsufficientFundsException e) {
            System.out.println("❌ Insufficient funds: " + e.getMessage());

        } catch (StudentManagementException e) {
            System.out.println("❌ General student management error: " + e.getMessage());
        }
    }

    private static void processStudentData(String id, String name, int age, String email, double balance)
            throws DuplicateStudentException, InvalidAgeException, InvalidEmailException, InsufficientFundsException {

        // Simulate checking for duplicate
        if (id.equals("STU001") && name.equals("Jane Smith")) {
            throw new DuplicateStudentException(id);
        }

        // Create person (validates age and email)
        Person person = new Person(name, age, email);

        // Create bank account (validates balance)
        BankAccount account = new BankAccount(id + "_ACC", name, balance);

        System.out.println("✅ Student processed successfully: " + name);
    }
}
