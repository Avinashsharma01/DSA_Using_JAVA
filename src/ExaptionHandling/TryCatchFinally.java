/**
 * TryCatchFinally - Complete Try-Catch-Finally Examples
 *
 * This class demonstrates:
 * - Try-catch-finally block structure
 * - Multiple catch blocks for different exceptions
 * - Finally block execution in all scenarios
 * - Resource management with finally
 * - Try-with-resources (automatic resource management)
 */
package ExaptionHandling;
import java.io.*;
import java.util.Scanner;


public class TryCatchFinally {

    public static void main(String[] args) {
        System.out.println("🔄 Try-Catch-Finally Examples");
        System.out.println("=============================\n");

        // Example 1: Basic try-catch-finally
        demonstrateBasicTryCatchFinally();

        // Example 2: Multiple catch blocks
        demonstrateMultipleCatchBlocks();

        // Example 3: Finally block always executes
        demonstrateFinallyAlwaysExecutes();

        // Example 4: Resource management with finally
        demonstrateResourceManagement();

        // Example 5: Try-with-resources (modern approach)
        demonstrateTryWithResources();

        System.out.println("\n🎉 Try-Catch-Finally examples completed!");
    }

    // Example 1: Basic structure of try-catch-finally
    public static void demonstrateBasicTryCatchFinally() {
        System.out.println("1️⃣ Basic Try-Catch-Finally Structure:");
        System.out.println("------------------------------------");

        try {
            System.out.println("🔄 Entering try block");

            // Simulate some operation that might fail
            int[] numbers = {10, 20, 30};
            System.out.println("Array created with 3 elements");

            // This will cause an exception
            System.out.println("Accessing element at index 5...");
            int value = numbers[5];

            System.out.println("This line will not execute");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("❌ Caught in catch block: " + e.getMessage());

        } finally {
            System.out.println("✅ Finally block always executes");
            System.out.println("🧹 Cleanup operations happen here");
        }

        System.out.println("🔄 Program continues after try-catch-finally\n");
    }

    // Example 2: Multiple catch blocks for different exception types
    public static void demonstrateMultipleCatchBlocks() {
        System.out.println("2️⃣ Multiple Catch Blocks:");
        System.out.println("-------------------------");

        // Test different scenarios
        testMultipleCatchScenario(1); // Array exception
        testMultipleCatchScenario(2); // Arithmetic exception
        testMultipleCatchScenario(3); // Number format exception
        testMultipleCatchScenario(4); // No exception
    }

    public static void testMultipleCatchScenario(int scenario) {
        System.out.println("\n🧪 Testing scenario " + scenario + ":");

        try {
            switch (scenario) {
                case 1:
                    // Array index exception
                    int[] arr = {1, 2, 3};
                    System.out.println("Accessing array[10]: " + arr[10]);
                    break;

                case 2:
                    // Arithmetic exception
                    int result = 10 / 0;
                    System.out.println("10 / 0 = " + result);
                    break;

                case 3:
                    // Number format exception
                    int num = Integer.parseInt("abc");
                    System.out.println("Parsed number: " + num);
                    break;

                case 4:
                    // No exception
                    System.out.println("Normal operation: 5 + 3 = " + (5 + 3));
                    break;
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("❌ Array Error: " + e.getMessage());

        } catch (ArithmeticException e) {
            System.out.println("❌ Math Error: " + e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println("❌ Number Format Error: " + e.getMessage());

        } catch (Exception e) {
            // Generic catch for any other exception
            System.out.println("❌ General Error: " + e.getMessage());

        } finally {
            System.out.println("🧹 Cleanup for scenario " + scenario);
        }
    }

    // Example 3: Finally block executes in all scenarios
    public static void demonstrateFinallyAlwaysExecutes() {
        System.out.println("\n3️⃣ Finally Block Always Executes:");
        System.out.println("----------------------------------");

        // Scenario 1: Exception occurs
        System.out.println("\n📋 Scenario 1: Exception occurs");
        try {
            System.out.println("Attempting division by zero...");
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("❌ Exception caught");
        } finally {
            System.out.println("✅ Finally executed (with exception)");
        }

        // Scenario 2: No exception
        System.out.println("\n📋 Scenario 2: No exception");
        try {
            System.out.println("Performing normal calculation...");
            int result = 10 / 2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("❌ This won't execute");
        } finally {
            System.out.println("✅ Finally executed (no exception)");
        }

        // Scenario 3: Early return
        System.out.println("\n📋 Scenario 3: Early return");
        demonstrateEarlyReturn();
    }

    public static void demonstrateEarlyReturn() {
        try {
            System.out.println("Before return statement");
            return; // Early return
        } catch (Exception e) {
            System.out.println("❌ No exception here");
        } finally {
            System.out.println("✅ Finally executed (even with return)");
        }
    }

    // Example 4: Resource management with finally
    public static void demonstrateResourceManagement() {
        System.out.println("\n4️⃣ Resource Management with Finally:");
        System.out.println("------------------------------------");

        FileWriter writer = null;

        try {
            System.out.println("📝 Opening file for writing...");
            writer = new FileWriter("temp_example.txt");

            System.out.println("✍️ Writing to file...");
            writer.write("Hello, Exception Handling!");
            writer.write("\nThis is a test file.");

            System.out.println("✅ File operations completed");

        } catch (IOException e) {
            System.out.println("❌ File operation failed: " + e.getMessage());

        } finally {
            // Always close resources
            System.out.println("🧹 Cleaning up resources...");
            if (writer != null) {
                try {
                    writer.close();
                    System.out.println("📁 File closed successfully");
                } catch (IOException e) {
                    System.out.println("❌ Error closing file: " + e.getMessage());
                }
            }
        }
    }

    // Example 5: Try-with-resources (Java 7+)
    public static void demonstrateTryWithResources() {
        System.out.println("\n5️⃣ Try-with-Resources (Modern Approach):");
        System.out.println("----------------------------------------");

        // Resources are automatically closed
        try (FileWriter writer = new FileWriter("temp_modern.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            System.out.println("📝 Writing with try-with-resources...");
            bufferedWriter.write("This file is managed automatically!");
            bufferedWriter.newLine();
            bufferedWriter.write("Resources will be closed automatically.");

            System.out.println("✅ File operations completed");

        } catch (IOException e) {
            System.out.println("❌ File operation failed: " + e.getMessage());
        }
        // No finally needed - resources auto-closed!
        System.out.println("🎉 Resources automatically closed!");
    }

    // Bonus: Nested try-catch blocks
    public static void demonstrateNestedTryCatch() {
        System.out.println("\n🔄 Bonus: Nested Try-Catch:");
        System.out.println("---------------------------");

        try {
            System.out.println("Outer try block");

            try {
                System.out.println("Inner try block");
                int[] arr = new int[3];
                arr[5] = 10; // This will throw exception

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("❌ Inner catch: Array index error");

                // Simulate another operation that might fail
                String str = null;
                str.length(); // This will throw NullPointerException
            }

        } catch (NullPointerException e) {
            System.out.println("❌ Outer catch: Null pointer error");

        } finally {
            System.out.println("✅ Outer finally block");
        }
    }
}
