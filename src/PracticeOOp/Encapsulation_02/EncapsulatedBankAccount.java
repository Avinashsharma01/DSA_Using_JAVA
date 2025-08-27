/**
 * EncapsulatedBankAccount - Advanced Encapsulation with Security
 *
 * This class demonstrates:
 * - Multiple levels of access control
 * - Security through encapsulation
 * - Business logic protection
 * - Read-only properties
 * - Computed properties
 */
package PracticeOOp.Encapsulation_02;

public class EncapsulatedBankAccount {
    // Private static variables (class-level encapsulation)
    private static int nextAccountNumber = 1000;
    private static final double MINIMUM_BALANCE = 100.0;
    private static final double OVERDRAFT_LIMIT = 500.0;
    private static final int MAX_DAILY_TRANSACTIONS = 10;

    // Private instance variables (complete data hiding)
    private final String accountNumber; // Read-only after creation
    private String accountHolderName;
    private double balance;
    private String pin; // Highly sensitive data
    private boolean isActive;
    private boolean isLocked;
    private int failedPinAttempts;
    private int dailyTransactionCount;
    private double dailyWithdrawalAmount;
    private long lastTransactionDate;

    // Package-private variables (accessible within same package)
    String accountType;

    // Protected variable (accessible to subclasses)
    protected double interestRate;

    // Constructor with validation
    public EncapsulatedBankAccount(String accountHolderName, String initialPin, String accountType) {
        // Validate inputs
        if (!isValidName(accountHolderName)) {
            throw new IllegalArgumentException("Invalid account holder name");
        }

        if (!isValidPin(initialPin)) {
            throw new IllegalArgumentException("PIN must be exactly 4 digits");
        }

        // Initialize account
        this.accountNumber = "ACC" + String.format("%06d", nextAccountNumber++);
        this.accountHolderName = accountHolderName.trim();
        this.pin = hashPin(initialPin); // Store hashed PIN for security
        this.accountType = validateAccountType(accountType);
        this.balance = 0.0;
        this.isActive = true;
        this.isLocked = false;
        this.failedPinAttempts = 0;
        this.dailyTransactionCount = 0;
        this.dailyWithdrawalAmount = 0.0;
        this.lastTransactionDate = System.currentTimeMillis();
        this.interestRate = getDefaultInterestRate(this.accountType);

        System.out.println("✅ Secure account created: " + accountNumber);
    }

    // Public getters (controlled read access)
    public String getAccountNumber() {
        return accountNumber; // Safe to expose - it's read-only
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountType() {
        return accountType;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isLocked() {
        return isLocked;
    }

    // Secured balance access - requires PIN verification
    public double getBalance(String pin) {
        if (!authenticatePin(pin)) {
            return -1; // Error indicator
        }
        return balance;
    }

    // Read-only computed properties
    public double getAvailableBalance(String pin) {
        if (!authenticatePin(pin)) {
            return -1;
        }
        return balance + OVERDRAFT_LIMIT;
    }

    public int getRemainingDailyTransactions() {
        resetDailyLimitsIfNewDay();
        return MAX_DAILY_TRANSACTIONS - dailyTransactionCount;
    }

    // Controlled setters with business logic
    public boolean changePin(String currentPin, String newPin) {
        if (!authenticatePin(currentPin)) {
            return false;
        }

        if (!isValidPin(newPin)) {
            System.out.println("❌ New PIN must be exactly 4 digits");
            return false;
        }

        if (currentPin.equals(newPin)) {
            System.out.println("❌ New PIN must be different from current PIN");
            return false;
        }

        this.pin = hashPin(newPin);
        System.out.println("✅ PIN changed successfully");
        return true;
    }

    public boolean updateAccountHolderName(String pin, String newName) {
        if (!authenticatePin(pin)) {
            return false;
        }

        if (!isValidName(newName)) {
            System.out.println("❌ Invalid name format");
            return false;
        }

        this.accountHolderName = newName.trim();
        System.out.println("✅ Account holder name updated");
        return true;
    }

    // Secured banking operations
    public boolean deposit(double amount) {
        if (!validateTransactionPreconditions(amount)) {
            return false;
        }

        if (amount <= 0) {
            System.out.println("❌ Deposit amount must be positive");
            return false;
        }

        if (amount > 50000) {
            System.out.println("❌ Large deposits require manager approval");
            return false;
        }

        balance += amount;
        dailyTransactionCount++;
        System.out.printf("✅ Deposited $%.2f. New balance: $%.2f\n", amount, balance);
        return true;
    }

    public boolean withdraw(String pin, double amount) {
        if (!authenticatePin(pin)) {
            return false;
        }

        if (!validateTransactionPreconditions(amount)) {
            return false;
        }

        if (amount <= 0) {
            System.out.println("❌ Withdrawal amount must be positive");
            return false;
        }

        resetDailyLimitsIfNewDay();

        if (dailyWithdrawalAmount + amount > 2000) {
            System.out.println("❌ Daily withdrawal limit ($2000) exceeded");
            return false;
        }

        if (balance - amount < -OVERDRAFT_LIMIT) {
            System.out.printf("❌ Insufficient funds (including $%.2f overdraft)\n", OVERDRAFT_LIMIT);
            return false;
        }

        balance -= amount;
        dailyWithdrawalAmount += amount;
        dailyTransactionCount++;

        if (balance < 0) {
            System.out.printf("⚠️ Withdrew $%.2f. Balance: $%.2f (Overdraft used)\n", amount, balance);
        } else {
            System.out.printf("✅ Withdrew $%.2f. New balance: $%.2f\n", amount, balance);
        }

        return true;
    }

    public boolean transfer(String pin, EncapsulatedBankAccount targetAccount, double amount) {
        if (!authenticatePin(pin)) {
            return false;
        }

        if (targetAccount == null || !targetAccount.isActive()) {
            System.out.println("❌ Invalid or inactive target account");
            return false;
        }

        if (this.withdraw(pin, amount)) {
            if (targetAccount.deposit(amount)) {
                System.out.printf("✅ Transferred $%.2f to %s\n", amount, targetAccount.getAccountNumber());
                return true;
            } else {
                // Refund if target deposit fails
                this.deposit(amount);
                System.out.println("❌ Transfer failed - amount refunded");
                return false;
            }
        }

        return false;
    }

    // Account management methods
    public boolean lockAccount(String pin) {
        if (!authenticatePin(pin)) {
            return false;
        }

        isLocked = true;
        System.out.println("🔒 Account locked successfully");
        return true;
    }

    public boolean unlockAccount(String pin) {
        if (!isValidPin(pin) || !hashPin(pin).equals(this.pin)) {
            System.out.println("❌ Invalid PIN for unlocking");
            return false;
        }

        isLocked = false;
        failedPinAttempts = 0;
        System.out.println("🔓 Account unlocked successfully");
        return true;
    }

    // Private helper methods (internal implementation)
    private boolean authenticatePin(String inputPin) {
        if (isLocked) {
            System.out.println("❌ Account is locked. Cannot perform operations.");
            return false;
        }

        if (!isActive) {
            System.out.println("❌ Account is inactive");
            return false;
        }

        if (!isValidPin(inputPin) || !hashPin(inputPin).equals(this.pin)) {
            failedPinAttempts++;
            System.out.println("❌ Invalid PIN. Attempts: " + failedPinAttempts + "/3");

            if (failedPinAttempts >= 3) {
                isLocked = true;
                System.out.println("🔒 Account locked due to multiple failed PIN attempts");
            }
            return false;
        }

        failedPinAttempts = 0; // Reset on successful authentication
        return true;
    }

    private boolean validateTransactionPreconditions(double amount) {
        if (!isActive) {
            System.out.println("❌ Account is inactive");
            return false;
        }

        if (isLocked) {
            System.out.println("❌ Account is locked");
            return false;
        }

        resetDailyLimitsIfNewDay();

        if (dailyTransactionCount >= MAX_DAILY_TRANSACTIONS) {
            System.out.println("❌ Daily transaction limit reached");
            return false;
        }

        return true;
    }

    private void resetDailyLimitsIfNewDay() {
        long currentTime = System.currentTimeMillis();
        long dayInMillis = 24 * 60 * 60 * 1000;

        if (currentTime - lastTransactionDate > dayInMillis) {
            dailyTransactionCount = 0;
            dailyWithdrawalAmount = 0.0;
            lastTransactionDate = currentTime;
        }
    }

    private boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty() && name.trim().length() >= 2;
    }

    private boolean isValidPin(String pin) {
        return pin != null && pin.matches("\\d{4}");
    }

    private String hashPin(String pin) {
        // Simple hash for demonstration (in real apps, use proper hashing)
        return "HASH_" + pin.hashCode();
    }

    private String validateAccountType(String type) {
        if (type == null) return "SAVINGS";

        switch (type.toUpperCase()) {
            case "SAVINGS": return "SAVINGS";
            case "CHECKING": return "CHECKING";
            case "BUSINESS": return "BUSINESS";
            default: return "SAVINGS";
        }
    }

    private double getDefaultInterestRate(String accountType) {
        switch (accountType) {
            case "SAVINGS": return 0.02; // 2%
            case "CHECKING": return 0.001; // 0.1%
            case "BUSINESS": return 0.015; // 1.5%
            default: return 0.01; // 1%
        }
    }

    // Public method to display account information (with PIN verification)
    public void displayAccountInfo(String pin) {
        if (!authenticatePin(pin)) {
            System.out.println("❌ Cannot display account info - authentication failed");
            return;
        }

        System.out.println("\n🏦 ===== Secure Account Information =====");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Type: " + accountType);
        System.out.printf("Balance: $%.2f\n", balance);
        System.out.printf("Available Balance: $%.2f\n", getAvailableBalance(pin));
        System.out.printf("Interest Rate: %.3f%%\n", interestRate * 100);
        System.out.println("Status: " + (isActive ? "Active" : "Inactive"));
        System.out.println("Security: " + (isLocked ? "Locked" : "Unlocked"));
        System.out.println("Daily Transactions Used: " + dailyTransactionCount + "/" + MAX_DAILY_TRANSACTIONS);
        System.out.printf("Daily Withdrawal Used: $%.2f/$2000.00\n", dailyWithdrawalAmount);
        System.out.println("======================================\n");
    }

    @Override
    public String toString() {
        // Don't expose sensitive information in toString
        return String.format("EncapsulatedBankAccount{accountNumber='%s', holder='%s', type='%s', active=%s}",
                           accountNumber, accountHolderName, accountType, isActive);
    }
}
