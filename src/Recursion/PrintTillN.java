// Problem: Collection of Basic Recursive Functions
// Description: Demonstrates various fundamental recursive algorithms and patterns
// Algorithms: Number printing, sum calculation, factorial, digit operations
// Time Complexity: O(n) for most functions - linear recursion
// Space Complexity: O(n) - recursion stack depth
// Educational: Shows different recursive patterns (pre-order vs post-order processing)

package Recursion;

public class PrintTillN {
    public static void main(String[] args) {
        // Uncomment to test different recursive functions
        PrintNincrement(10);     // Print 1 to 10 in ascending order
        PrintNdecriment(5);      // Print 5 to 1 in descending order
        PrintName(3);            // Print name with numbers 3 times

        int sum = SumOfN(5);     // Calculate sum 1+2+3+4+5 = 15
        System.out.println("Sum of first 5 numbers: " + sum);

        int fact = Fact(5);      // Calculate 5! = 120
        System.out.println("Factorial of 5: " + fact);

        int digitSum = SumOfDigit(12345);    // Sum of digits: 1+2+3+4+5 = 15
        System.out.println("Sum of digits in 12345: " + digitSum);

        int digitProduct = ProductOfDigit(234);  // Product of digits: 2×3×4 = 24
        System.out.println("Product of digits in 234: " + digitProduct);
    }

    // Prints numbers from 1 to n in ascending order using recursion
    // Pattern: Post-order processing (recurse first, then process)
    public static void PrintNincrement(int n){
        if (n==0){
            return;  // Base case: stop when n reaches 0
        }

        PrintNincrement(n-1);  // First recurse to smaller numbers
        System.out.println(n); // Then print current number (ascending order)
    }

    // Prints numbers from n to 1 in descending order using recursion
    // Pattern: Pre-order processing (process first, then recurse)
    public static void PrintNdecriment(int n){
        if (n==0){
            return;  // Base case: stop when n reaches 0
        }

        System.out.print(n+" ");  // First print current number
        PrintNdecriment(n-1);     // Then recurse to smaller numbers (descending order)
    }

    // Prints a name n times with sequential numbering
    // Demonstrates string printing with recursion
    public static void PrintName(int n){
        if (n==0){
            return;  // Base case: stop when n reaches 0
        }

        PrintName(n-1);  // Recurse first for proper numbering
        System.out.println(n + " Avinash Sharma");  // Print with current number
    }

    // Calculates sum of first n natural numbers using recursion
    // Mathematical formula: Sum(n) = n + Sum(n-1), with Sum(0) = 0
    // Alternative: Sum = n×(n+1)/2 (iterative formula)
    public static int SumOfN(int n){
        if(n==0){
            return 0;  // Base case: sum of 0 numbers is 0
        }

        return n + SumOfN(n-1);  // Add current number to sum of previous numbers
    }

    // Calculates factorial of n using recursion
    // Mathematical formula: n! = n × (n-1)!, with 0! = 1! = 1
    public static int Fact(int n){
        if (n == 0 || n == 1) {
            return 1;  // Base case: 0! = 1! = 1
        } else {
            return n * Fact(n-1);  // n! = n × (n-1)!
        }
    }

    // Calculates sum of individual digits in a number using recursion
    // Algorithm: Extract last digit (n%10), add to sum of remaining digits (n/10)
    public static int SumOfDigit(int n){
        if(n == 0){
            return 0;  // Base case: no more digits to process
        }

        return (n % 10) + SumOfDigit(n / 10);  // Last digit + sum of remaining digits
    }

    // Calculates product of individual digits in a number using recursion
    // Algorithm: Extract last digit (n%10), multiply with product of remaining digits (n/10)
    public static int ProductOfDigit(int n){
        if(n == 0){
            return 1;  // Base case: product identity element
        }

        return (n % 10) * ProductOfDigit(n / 10);  // Last digit × product of remaining digits
    }

}