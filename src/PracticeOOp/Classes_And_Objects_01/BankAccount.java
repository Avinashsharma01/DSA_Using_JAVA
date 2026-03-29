/**
 * BankAccount Class - Real-world Example with Validation and Security
 *
 * This class demonstrates:
 * - Data validation
 * - Security considerations
 * - Business logic implementation
 * - Error handling
 * - State management
 */

package PracticeOOp.Classes_And_Objects_01;

public class BankAccount {
    // Instance variables
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String accountType;
    private boolean isActive;
    private int transactionCount;
    private static int totalAccounts = 0; // Static variable to track total accounts

    // Constants
    private static final double MINIMUM_BALANCE = 100.0;
    private static final double DAILY_WITHDRAWAL_LIMIT = 5000.0;
    private static final int FREE_TRANSACTIONS_PER_MONTH = 5;
    private static final double TRANSACTION_FEE = 2.5;

    // Constructor
    public BankAccount(String accountHolderName, String accountType, double initialDeposit) {
        if (accountHolderName == null || accountHolderName.trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be empty");
        }

        if (initialDeposit < MINIMUM_BALANCE) {
            throw new IllegalArgumentException("Initial deposit must be at least $" + MINIMUM_BALANCE);
        }

        this.accountHolderName = accountHolderName.trim();
        this.accountType = validateAccountType(accountType);
        this.balance = initialDeposit;
        this.accountNumber = generateAccountNumber();
        this.isActive = true;
        this.transactionCount = 0;
        totalAccounts++;

        System.out.println("✅ Account created successfully!");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Welcome, " + accountHolderName + "!");
    }

    // Private helper method to validate account type
    private String validateAccountType(String accountType) {
        if (accountType == null) {
            return "Savings"; // Default
        }

        String type = accountType.trim().toLowerCase();
        switch (type) {
            case "savings":
                return "Savings";
            case "checking":
                return "Checking";
            case "business":
                return "Business";
            default:
                System.out.println("Invalid account type. Defaulting to Savings.");
                return "Savings";
        }
    }

    // Private helper method to generate account number
    private String generateAccountNumber() {
        return "ACC" + String.format("%06d", totalAccounts);
    }

    // Getter methods
    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolderName() { return accountHolderName; }
    public double getBalance() { return balance; }
    public String getAccountType() { return accountType; }
    public boolean isActive() { return isActive; }
    public int getTransactionCount() { return transactionCount; }
    public static int getTotalAccounts() { return totalAccounts; }

    // Deposit money
    public boolean deposit(double amount) {
        if (!isActive) {
            System.out.println("❌ Account is inactive. Cannot perform deposit.");
            return false;
        }

        if (amount <= 0) {
            System.out.println("❌ Deposit amount must be positive.");
            return false;
        }

        if (amount > 50000) {
            System.out.println("❌ Large deposit detected. Please visit the branch for deposits over $50,000.");
            return false;
        }

        balance += amount;
        transactionCount++;

        // Apply transaction fee if exceeded free transactions
        if (transactionCount > FREE_TRANSACTIONS_PER_MONTH) {
            balance -= TRANSACTION_FEE;
            System.out.println("💰 $" + amount + " deposited successfully!");
            System.out.println("💳 Transaction fee: $" + TRANSACTION_FEE);
            System.out.println("💵 Current balance: $" + String.format("%.2f", balance));
        } else {
            System.out.println("💰 $" + amount + " deposited successfully!");
            System.out.println("💵 Current balance: $" + String.format("%.2f", balance));
        }

        return true;
    }

    // Withdraw money
    public boolean withdraw(double amount) {
        if (!isActive) {
            System.out.println("❌ Account is inactive. Cannot perform withdrawal.");
            return false;
        }

        if (amount <= 0) {
            System.out.println("❌ Withdrawal amount must be positive.");
            return false;
        }

        if (amount > DAILY_WITHDRAWAL_LIMIT) {
            System.out.println("❌ Daily withdrawal limit is $" + DAILY_WITHDRAWAL_LIMIT);
            return false;
        }

        double totalDeduction = amount;

        // Add transaction fee if exceeded free transactions
        if (transactionCount >= FREE_TRANSACTIONS_PER_MONTH) {
            totalDeduction += TRANSACTION_FEE;
        }

        // Check if account will maintain minimum balance
        if (balance - totalDeduction < MINIMUM_BALANCE) {
            System.out.println("❌ Insufficient funds. Minimum balance of $" + MINIMUM_BALANCE + " must be maintained.");
            System.out.println("💵 Current balance: $" + String.format("%.2f", balance));
            System.out.println("💳 Attempted withdrawal (including fees): $" + String.format("%.2f", totalDeduction));
            return false;
        }

        balance -= totalDeduction;
        transactionCount++;

        System.out.println("💸 $" + amount + " withdrawn successfully!");
        if (totalDeduction > amount) {
            System.out.println("💳 Transaction fee: $" + TRANSACTION_FEE);
        }
        System.out.println("💵 Current balance: $" + String.format("%.2f", balance));

        return true;
    }

    // Transfer money to another account
    public boolean transfer(BankAccount targetAccount, double amount) {
        if (targetAccount == null) {
            System.out.println("❌ Invalid target account.");
            return false;
        }

        if (targetAccount == this) {
            System.out.println("❌ Cannot transfer to the same account.");
            return false;
        }

        if (!targetAccount.isActive()) {
            System.out.println("❌ Target account is inactive.");
            return false;
        }

        System.out.println("🔄 Initiating transfer...");

        // Attempt withdrawal from this account
        if (this.withdraw(amount)) {
            // If withdrawal successful, deposit to target account
            if (targetAccount.deposit(amount)) {
                System.out.println("✅ Transfer completed successfully!");
                System.out.println("📤 From: " + this.accountNumber + " (" + this.accountHolderName + ")");
                System.out.println("📥 To: " + targetAccount.accountNumber + " (" + targetAccount.accountHolderName + ")");
                System.out.println("💰 Amount: $" + amount);
                return true;
            } else {
                // If deposit failed, refund the amount
                this.balance += amount;
                System.out.println("❌ Transfer failed. Amount refunded.");
                return false;
            }
        }

        return false;
    }

    // Check balance
    public void checkBalance() {
        System.out.println("\n💰 ===== Balance Inquiry =====");
        System.out.println("Account: " + accountNumber);
        System.out.println("Holder: " + accountHolderName);
        System.out.println("Balance: $" + String.format("%.2f", balance));
        System.out.println("Status: " + (isActive ? "Active" : "Inactive"));
        System.out.println("============================\n");
    }

    // Calculate monthly fees
    public void calculateMonthlyFees() {
        double fees = 0.0;

        // Account maintenance fee
        if (balance < 1000) {
            fees += 10.0;
        }

        // Transaction fees for excess transactions
        if (transactionCount > FREE_TRANSACTIONS_PER_MONTH) {
            fees += (transactionCount - FREE_TRANSACTIONS_PER_MONTH) * TRANSACTION_FEE;
        }

        if (fees > 0) {
            balance -= fees;
            System.out.println("💳 Monthly fees applied: $" + String.format("%.2f", fees));
            System.out.println("💵 New balance: $" + String.format("%.2f", balance));
        } else {
            System.out.println("✅ No monthly fees applied.");
        }

        // Reset transaction count for new month
        transactionCount = 0;
    }

    // Close account
    public boolean closeAccount() {
        if (!isActive) {
            System.out.println("❌ Account is already closed.");
            return false;
        }

        if (balance > MINIMUM_BALANCE) {
            System.out.println("💰 Please withdraw remaining balance: $" + String.format("%.2f", balance));
            System.out.println("❌ Cannot close account with remaining balance.");
            return false;
        }

        isActive = false;
        System.out.println("✅ Account " + accountNumber + " has been closed.");
        System.out.println("Thank you for banking with us, " + accountHolderName + "!");
        return true;
    }

    // Display complete account information
    public void displayAccountInfo() {
        System.out.println("\n🏦 ===== Account Information =====");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Type: " + accountType);
        System.out.println("Current Balance: $" + String.format("%.2f", balance));
        System.out.println("Account Status: " + (isActive ? "Active" : "Inactive"));
        System.out.println("Transactions This Month: " + transactionCount);
        System.out.println("Free Transactions Remaining: " +
                         Math.max(0, FREE_TRANSACTIONS_PER_MONTH - transactionCount));
        System.out.println("================================\n");
    }

    @Override
    public String toString() {
        return String.format("BankAccount{accountNumber='%s', holder='%s', balance=%.2f, type='%s', active=%s}",
                           accountNumber, accountHolderName, balance, accountType, isActive);
    }
}
