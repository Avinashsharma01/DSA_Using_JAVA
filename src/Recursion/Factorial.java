// Problem: Calculate Factorial using Recursion
// Description: Recursively computes factorial of a number (n! = n × (n-1) × ... × 1)
// Algorithm: n! = n × (n-1)! with base case 0! = 1
// Time Complexity: O(n) - makes n recursive calls
// Space Complexity: O(n) - recursion stack depth
// Base Case: n < 1 returns 1 (0! = 1, handles edge cases)
// Recursive Case: n × factorial(n-1)

package Recursion;

public class Factorial {

    // Recursive method to calculate factorial of n
    // Parameter: n - non-negative integer to calculate factorial for
    // Returns: factorial of n (n!)
    // Mathematical definition: n! = n × (n-1) × (n-2) × ... × 1, with 0! = 1
    public static int factorial(int n){
        // Base case: factorial of 0 and negative numbers is 1
        if (n < 1) {
            return 1;  // 0! = 1 by mathematical definition
        }

        // Recursive case: n! = n × (n-1)!
        return n * factorial(n-1);
    }

    public static void main(String[] args) {
        int n = 5;  // Calculate 5! = 5 × 4 × 3 × 2 × 1 = 120
        System.out.println("Factorial of " + n + " = " + factorial(n));
    }
}
