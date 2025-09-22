// Problem: Demonstrates array manipulation and the difference between pass-by-value and pass-by-reference
// Key Concepts:
// 1. Arrays are passed by reference - changes inside methods affect the original array
// 2. Primitive variables are passed by value - changes inside methods don't affect the original variable
// 3. Array elements can be modified within methods
// Time Complexity: O(n) for array traversal
// Space Complexity: O(1) - constant extra space

package Arrays;

public class Array_manipulation {
    // Method to demonstrate array manipulation and parameter passing
    // mark[] - array passed by reference (changes will affect original)
    // nonchange - primitive passed by value (changes won't affect original)
    public static void updateArray(int[] mark, int nonchange){
        nonchange = 20; // This change won't affect the original variable
        for (int i=0; i<mark.length; i++){
            System.out.println(mark[i]+=1); // Incrementing each array element by 1
        }
    }

    public static void main(String[] args) {
        int[] marks = new int[50]; // Creates an array of 50 elements (all initialized to 0)
        int[] mark = {11,22,33,44,55,66,77}; // Array literal initialization

        int nonchange = 10; // Primitive variable
        updateArray(mark, nonchange); // Calling method to modify array
        System.out.println(nonchange); // Will print 10 (unchanged)
    }
}
