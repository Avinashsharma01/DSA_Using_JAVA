/**
 * BasicExceptions - Introduction to Exception Handling
 *
 * This class demonstrates:
 * - What happens without exception handling
 * - Basic try-catch syntax
 * - How exceptions prevent program crashes
 * - Simple error handling examples
 */

package ExaptionHandling;

public class BasicExceptions {

    public static void main(String[] args) {
        System.out.println("🎯 Welcome to Exception Handling Basics!");
        System.out.println("========================================\n");

        // Example 1: Program crash without exception handling
        demonstrateWithoutExceptionHandling();

        // Example 2: Graceful handling with try-catch
        demonstrateWithExceptionHandling();

        // Example 3: Multiple operations with exception handling
        demonstrateMultipleOperations();

        System.out.println("\n🎉 Exception handling examples completed!");
    }

    // Example 1: What happens WITHOUT exception handling
    public static void demonstrateWithoutExceptionHandling() {
        System.out.println("1️⃣ WITHOUT Exception Handling:");
        System.out.println("------------------------------");

        try {
            // This would crash the program if not in try block
            int[] numbers = {1, 2, 3};
            System.out.println("Array created: [1, 2, 3]");
            System.out.println("Trying to access index 5...");

            // This will throw ArrayIndexOutOfBoundsException
            int value = numbers[5];
            System.out.println("Value at index 5: " + value);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("❌ Caught exception: Array index 5 is out of bounds!");
            System.out.println("💡 Without try-catch, program would crash here");
        }

        System.out.println("✅ Program continues running!\n");
    }

    // Example 2: Basic try-catch structure
    public static void demonstrateWithExceptionHandling() {
        System.out.println("2️⃣ WITH Exception Handling:");
        System.out.println("----------------------------");

        // Division by zero example
        try {
            System.out.println("🧮 Performing division operation...");
            int dividend = 10;
            int divisor = 0;

            System.out.println("Calculating: " + dividend + " ÷ " + divisor);
            int result = dividend / divisor; // This throws ArithmeticException

            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("❌ Error caught: Cannot divide by zero!");
            System.out.println("🔧 Exception type: " + e.getClass().getSimpleName());
            System.out.println("📝 Exception message: " + e.getMessage());
        }

        System.out.println("✅ Division operation handled gracefully!\n");
    }

    // Example 3: Multiple operations with different exceptions
    public static void demonstrateMultipleOperations() {
        System.out.println("3️⃣ Multiple Operations with Exception Handling:");
        System.out.println("===============================================");

        // Array operations
        performArrayOperation();

        // String operations
        performStringOperation();

        // Number parsing operations
        performNumberParsingOperation();
    }

    public static void performArrayOperation() {
        System.out.println("\n🔢 Array Operations:");

        try {
            int[] scores = {95, 87, 92, 78, 85};
            System.out.println("Student scores: [95, 87, 92, 78, 85]");

            // Safe access
            System.out.println("First score: " + scores[0]);
            System.out.println("Last score: " + scores[4]);

            // This will cause an exception
            System.out.println("Trying to access score at index 10...");
            System.out.println("Score at index 10: " + scores[10]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("❌ Array index error: " + e.getMessage());
            System.out.println("💡 Array has only 5 elements (indices 0-4)");
        }
    }

    public static void performStringOperation() {
        System.out.println("\n📝 String Operations:");

        try {
            String text = null;
            System.out.println("Working with string: " + text);

            // This will throw NullPointerException
            System.out.println("String length: " + text.length());

        } catch (NullPointerException e) {
            System.out.println("❌ Null pointer error: Cannot perform operations on null string");
            System.out.println("🔧 Solution: Initialize string before using it");
        }
    }

    public static void performNumberParsingOperation() {
        System.out.println("\n🔢 Number Parsing Operations:");

        try {
            String numberText = "abc123";
            System.out.println("Trying to parse: '" + numberText + "' as integer");

            // This will throw NumberFormatException
            int number = Integer.parseInt(numberText);
            System.out.println("Parsed number: " + number);

        } catch (NumberFormatException e) {
            System.out.println("❌ Number format error: '" + e.getMessage() + "'");
            System.out.println("💡 String must contain only numeric characters");
        }

        // Example of successful parsing
        try {
            String validNumber = "456";
            System.out.println("Trying to parse: '" + validNumber + "' as integer");
            int number = Integer.parseInt(validNumber);
            System.out.println("✅ Successfully parsed: " + number);

        } catch (NumberFormatException e) {
            System.out.println("❌ This shouldn't happen with valid input");
        }
    }

    // Utility method to demonstrate exception information
    public static void demonstrateExceptionInfo() {
        System.out.println("\n🔍 Exception Information:");
        System.out.println("------------------------");

        try {
            String[] fruits = {"apple", "banana", "orange"};
            System.out.println("Accessing invalid array index...");
            String fruit = fruits[5];

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception Details:");
            System.out.println("📁 Class: " + e.getClass().getName());
            System.out.println("📝 Message: " + e.getMessage());
            System.out.println("📍 Stack trace (first few lines):");

            // Print limited stack trace
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (int i = 0; i < Math.min(3, stackTrace.length); i++) {
                System.out.println("   at " + stackTrace[i]);
            }
        }
    }
}
