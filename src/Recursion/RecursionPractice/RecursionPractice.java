// Problem: Recursion Practice - Collection of Fundamental Recursive Problems
// Description: Comprehensive practice set covering basic recursive patterns and digit operations
// Algorithms: Number printing, factorial, sum calculations, digit manipulations
// Time Complexity: O(n) for most functions - linear recursion depth
// Space Complexity: O(n) - recursion stack depth
// Educational: Perfect for understanding recursion fundamentals and patterns

package Recursion.RecursionPractice;

public class RecursionPractice {
    public static void main(String[] args) {
        // Uncomment to test different recursive functions
        System.out.println("1. Print numbers 1 to 5:");
        Print_Numbers_from_1_to_N(5);

        System.out.println("\n2. Print numbers 5 to 1:");
        Print_Numbers_from_N_to_1(5);

        System.out.println("\n3. Factorial of 5:");
        int fact = Factorial_of_a_Number(5);
        System.out.println("5! = " + fact);

        System.out.println("\n4. Sum of first 5 natural numbers:");
        int sum = Sum_of_First_N_Natural_Numbers(5);
        System.out.println("Sum = " + sum);

        System.out.println("\n5. Sum of digits (iterative):");
        SumOfNDigitWithoutRec(12345);

        System.out.println("\n6. Sum of digits (recursive):");
        int digitSum = SumOfNDigit(123456789);
        System.out.println("Sum = " + digitSum);

        System.out.println("\n7. Product of digits:");
        int product = productOfDigit(12345);
        System.out.println("Product = " + product);
    }

    // Problem 1: Print Numbers from 1 to N using Post-order Processing
    // Pattern: Recurse first, then print (creates ascending order)
    // Time Complexity: O(n), Space Complexity: O(n)
    public static void Print_Numbers_from_1_to_N(int n){
        if(n==0){
            return;  // Base case: no more numbers to print
        }
        Print_Numbers_from_1_to_N(n-1);  // First recurse to smaller numbers
        System.out.println(n);            // Then print current number (ascending)
    }

    // Problem 2: Print Numbers from N to 1 using Pre-order Processing
    // Pattern: Print first, then recurse (creates descending order)
    // Time Complexity: O(n), Space Complexity: O(n)
    public static void Print_Numbers_from_N_to_1(int n){
        if(n==0){
            return;  // Base case: no more numbers to print
        }
        System.out.println(n);            // First print current number
        Print_Numbers_from_N_to_1(n-1);   // Then recurse to smaller numbers (descending)
    }

    // Problem 3: Factorial of a Number
    // Mathematical formula: n! = n × (n-1)!, with 0! = 1! = 1
    // Time Complexity: O(n), Space Complexity: O(n)
    public static int Factorial_of_a_Number(int n){
        if(n<=1){
            return 1;  // Base case: 0! = 1! = 1
        }
        return n * Factorial_of_a_Number(n-1);  // n! = n × (n-1)!
    }

    // Problem 4: Sum of First N Natural Numbers
    // Mathematical formula: Sum(n) = n + Sum(n-1), with Sum(0) = 0
    // Alternative iterative formula: Sum = n×(n+1)/2
    // Time Complexity: O(n), Space Complexity: O(n)
    public static int Sum_of_First_N_Natural_Numbers(int n){
        if (n==0){
            return 0;  // Base case: sum of 0 numbers is 0
        }
        return n + Sum_of_First_N_Natural_Numbers(n-1);  // n + sum of previous numbers
    }

    // Iterative Solution: Sum of Digits (for comparison with recursive version)
    // Algorithm: Extract last digit using modulo, divide by 10 to remove last digit
    // Time Complexity: O(log n), Space Complexity: O(1)
    public static void SumOfNDigitWithoutRec(int n){
        int sum=0;
        while (n > 0){
            int digit = n % 10;  // Extract last digit
            sum += digit;        // Add to sum
            n = n / 10;          // Remove last digit
        }
        System.out.println("Sum (iterative): " + sum);
    }

    // Problem 5: Sum of Digits using Recursion
    // Algorithm: Extract last digit, add to sum of remaining digits
    // Time Complexity: O(log n), Space Complexity: O(log n)
    public static int SumOfNDigit(int n){
        if(n==0){
            return 0;  // Base case: no more digits to process
        }
        int digit = n % 10;  // Extract last digit
        n = n / 10;          // Remove last digit for next recursion
        return digit + SumOfNDigit(n);  // Add current digit to sum of remaining

        // Alternative one-liner:
        // return (n%10) + SumOfNDigit(n/10);
    }

    // Problem 6: Product of Digits using Recursion
    // Algorithm: Extract last digit, multiply with product of remaining digits
    // Time Complexity: O(log n), Space Complexity: O(log n)
    // Note: Returns 1 for n=0 (multiplicative identity)
    public static int productOfDigit(int n){
        if (n==0)
            return 1;  // Base case: multiplicative identity for empty digits

        return (n%10) * productOfDigit(n/10);  // Last digit × product of remaining
    }
}
