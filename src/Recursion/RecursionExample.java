// Problem: Basic Recursion Examples - Number Printing Patterns
// Description: Demonstrates fundamental recursion concepts with number printing in different orders
// Algorithm: Shows difference between pre-order and post-order recursive processing
// Time Complexity: O(n) - makes n recursive calls
// Space Complexity: O(n) - recursion stack depth
// Educational: Perfect introduction to understand recursion call stack behavior

package Recursion;

public class RecursionExample {

    // Prints numbers from n to 1 in decreasing order using recursion
    // Pattern: Pre-order processing - print first, then recurse
    // Parameters: n - starting number to print from
    // Logic: Process current value before making recursive call
    public static void PrintDecOrder(int n){
        if(n==1){
            System.out.println(n);  // Base case: print 1 and stop
            return;
        }

        System.out.println(n);    // Print current number first (decreasing order)
        PrintDecOrder(n-1);       // Then recurse to smaller number
    }

    // Prints numbers from 1 to n in increasing order using recursion
    // Pattern: Post-order processing - recurse first, then print
    // Parameters: n - maximum number to print up to
    // Logic: Make recursive call first, process current value during unwinding
    public static void PrintIncOrder(int n){
        if(n==1){
            System.out.println(n);  // Base case: print 1 and start unwinding
            return;
        }

        PrintIncOrder(n-1);       // First recurse to smaller number
        System.out.println(n);    // Then print current number (increasing order)
    }

    public static void main(String[] args) {
        int n = 5;  // Test with number 5

        System.out.println("Decreasing order (5 to 1):");
        PrintDecOrder(n);         // Prints: 5, 4, 3, 2, 1

        System.out.println("----------------------");

        System.out.println("Increasing order (1 to 5):");
        PrintIncOrder(n);         // Prints: 1, 2, 3, 4, 5
    }
}
