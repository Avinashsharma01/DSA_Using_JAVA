/**
 * CodeQuality - Demonstrates OOP Best Practices for Clean Code
 *
 * This file shows:
 * - Proper naming conventions
 * - Clean code principles
 * - Effective error handling
 * - Good class design
 * - Documentation best practices
 */

package  PracticeOOp.Best_Practices_07;
import java.util.*;
import java.time.LocalDate;

// ==================== NAMING CONVENTIONS ====================

/**
 * BankAccount - Example of proper class naming and design
 *
 * Class names should be:
 * - PascalCase (BankAccount, not bankAccount)
 * - Nouns (BankAccount, not ProcessAccount)
 * - Descriptive (BankAccount, not Account)
 */

class BankAccount { // Changed from public to package-private

    // ==================== CONSTANTS ====================
    // Constants use UPPER_SNAKE_CASE
    private static final double MINIMUM_BALANCE = 100.0;
    private static final double OVERDRAFT_LIMIT = 500.0;
    private static final int MAX_DAILY_TRANSACTIONS = 10;
    private static final String DEFAULT_CURRENCY = "USD";

    // ==================== INSTANCE VARIABLES ====================
    // Variables use camelCase and are descriptive
    private String accountNumber;           // Not: accNum, num
    private String accountHolderName;       // Not: name, holder
    private double currentBalance;          // Not: balance, bal
    private String accountType;             // Not: type
    private LocalDate creationDate;         // Not: date, created
    private int dailyTransactionCount;      // Not: transCount, dtc
    private boolean isAccountActive;        // Boolean starts with 'is', 'has', 'can'
    private List<String> transactionHistory; // Descriptive collection names

    // ==================== CONSTRUCTORS ====================

    /**
     * Creates a new bank account with specified details
     *
     * @param accountHolderName The full name of the account holder
     * @param accountType The type of account (SAVINGS, CHECKING, BUSINESS)
     * @param initialDeposit The initial deposit amount
     * @throws IllegalArgumentException if parameters are invalid
     */
    public BankAccount(String accountHolderName, String accountType, double initialDeposit) {
        // Input validation with meaningful error messages
        validateAccountHolderName(accountHolderName);
        validateAccountType(accountType);
        validateInitialDeposit(initialDeposit);

        // Initialize with descriptive assignments
        this.accountNumber = generateAccountNumber();
        this.accountHolderName = accountHolderName.trim();
        this.accountType = accountType.toUpperCase();
        this.currentBalance = initialDeposit;
        this.creationDate = LocalDate.now();
        this.dailyTransactionCount = 0;
        this.isAccountActive = true;
        this.transactionHistory = new ArrayList<>();

        // Log the creation
        addTransactionRecord("Account created with initial deposit: $" + initialDeposit);

        System.out.println("✅ Bank account created successfully: " + accountNumber);
    }

    // ==================== PUBLIC METHODS ====================
    // Method names use camelCase and are descriptive verbs

    /**
     * Deposits money into the account
     *
     * @param depositAmount The amount to deposit (must be positive)
     * @return true if deposit successful, false otherwise
     */
    public boolean depositMoney(double depositAmount) {
        // Method does exactly what its name suggests
        if (!isValidDepositAmount(depositAmount)) {
            return false;
        }

        if (!canPerformTransaction()) {
            return false;
        }

        currentBalance += depositAmount;
        dailyTransactionCount++;

        String transactionMessage = String.format("Deposited: $%.2f", depositAmount);
        addTransactionRecord(transactionMessage);

        System.out.printf("💰 %s - New balance: $%.2f\n", transactionMessage, currentBalance);
        return true;
    }

    /**
     * Withdraws money from the account
     *
     * @param withdrawalAmount The amount to withdraw
     * @return true if withdrawal successful, false otherwise
     */
    public boolean withdrawMoney(double withdrawalAmount) {
        if (!isValidWithdrawalAmount(withdrawalAmount)) {
            return false;
        }

        if (!canPerformTransaction()) {
            return false;
        }

        if (!hasSufficientFunds(withdrawalAmount)) {
            System.out.println("❌ Insufficient funds for withdrawal");
            return false;
        }

        currentBalance -= withdrawalAmount;
        dailyTransactionCount++;

        String transactionMessage = String.format("Withdrawn: $%.2f", withdrawalAmount);
        addTransactionRecord(transactionMessage);

        System.out.printf("💸 %s - New balance: $%.2f\n", transactionMessage, currentBalance);
        return true;
    }

    /**
     * Transfers money to another account
     *
     * @param targetAccount The account to transfer to
     * @param transferAmount The amount to transfer
     * @return true if transfer successful, false otherwise
     */
    public boolean transferMoneyTo(BankAccount targetAccount, double transferAmount) {
        // Clear method name indicates direction and purpose
        if (targetAccount == null) {
            System.out.println("❌ Target account cannot be null");
            return false;
        }

        if (targetAccount == this) {
            System.out.println("❌ Cannot transfer to the same account");
            return false;
        }

        if (!targetAccount.isAccountActive()) {
            System.out.println("❌ Target account is not active");
            return false;
        }

        // Use existing methods for consistency
        if (this.withdrawMoney(transferAmount)) {
            if (targetAccount.depositMoney(transferAmount)) {
                String transferMessage = String.format("Transferred: $%.2f to %s",
                                                      transferAmount, targetAccount.getAccountNumber());
                addTransactionRecord(transferMessage);

                System.out.println("✅ Transfer completed successfully");
                return true;
            } else {
                // Refund if target deposit fails
                this.depositMoney(transferAmount);
                System.out.println("❌ Transfer failed - amount refunded");
                return false;
            }
        }

        return false;
    }

    // ==================== QUERY METHODS ====================
    // Boolean methods start with is, has, can, should

    public boolean isAccountActive() {
        return isAccountActive;
    }

    public boolean hasMinimumBalance() {
        return currentBalance >= MINIMUM_BALANCE;
    }

    public boolean canPerformTransaction() {
        return isAccountActive && dailyTransactionCount < MAX_DAILY_TRANSACTIONS;
    }

    public boolean hasSufficientFunds(double amount) {
        return (currentBalance - amount) >= -OVERDRAFT_LIMIT;
    }

    // ==================== GETTER METHODS ====================
    // Getters have clear, descriptive names

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public String getAccountType() {
        return accountType;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public int getRemainingDailyTransactions() {
        return MAX_DAILY_TRANSACTIONS - dailyTransactionCount;
    }

    public List<String> getTransactionHistory() {
        // Return defensive copy to protect internal state
        return new ArrayList<>(transactionHistory);
    }

    // ==================== PRIVATE HELPER METHODS ====================
    // Private methods have clear, specific names

    private void validateAccountHolderName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be empty");
        }
        if (name.trim().length() < 2) {
            throw new IllegalArgumentException("Account holder name must be at least 2 characters");
        }
    }

    private void validateAccountType(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Account type cannot be null");
        }

        Set<String> validTypes = Set.of("SAVINGS", "CHECKING", "BUSINESS");
        if (!validTypes.contains(type.toUpperCase())) {
            throw new IllegalArgumentException("Invalid account type: " + type);
        }
    }

    private void validateInitialDeposit(double amount) {
        if (amount < MINIMUM_BALANCE) {
            throw new IllegalArgumentException(
                String.format("Initial deposit must be at least $%.2f", MINIMUM_BALANCE));
        }
    }

    private boolean isValidDepositAmount(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Deposit amount must be positive");
            return false;
        }
        if (amount > 50000) {
            System.out.println("❌ Large deposits require manager approval");
            return false;
        }
        return true;
    }

    private boolean isValidWithdrawalAmount(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Withdrawal amount must be positive");
            return false;
        }
        if (amount > 2000) {
            System.out.println("❌ Daily withdrawal limit is $2000");
            return false;
        }
        return true;
    }

    private String generateAccountNumber() {
        // Simple account number generation
        return "ACC" + System.currentTimeMillis() % 1000000;
    }

    private void addTransactionRecord(String transaction) {
        String timestampedTransaction = LocalDate.now() + ": " + transaction;
        transactionHistory.add(timestampedTransaction);

        // Keep only last 100 transactions to prevent memory issues
        if (transactionHistory.size() > 100) {
            transactionHistory.remove(0);
        }
    }

    // ==================== UTILITY METHODS ====================

    public void displayAccountSummary() {
        System.out.println("\n💼 ===== Account Summary =====");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Type: " + accountType);
        System.out.printf("Current Balance: $%.2f\n", currentBalance);
        System.out.println("Creation Date: " + creationDate);
        System.out.println("Status: " + (isAccountActive ? "Active" : "Inactive"));
        System.out.println("Daily Transactions Used: " + dailyTransactionCount + "/" + MAX_DAILY_TRANSACTIONS);
        System.out.println("Minimum Balance Met: " + (hasMinimumBalance() ? "Yes" : "No"));
        System.out.println("============================\n");
    }

    public void displayTransactionHistory() {
        System.out.println("\n📋 Transaction History:");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (int i = Math.max(0, transactionHistory.size() - 5); i < transactionHistory.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + transactionHistory.get(i));
            }
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return String.format("BankAccount{accountNumber='%s', holder='%s', balance=%.2f, type='%s'}",
                           accountNumber, accountHolderName, currentBalance, accountType);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        BankAccount that = (BankAccount) obj;
        return Objects.equals(accountNumber, that.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}
