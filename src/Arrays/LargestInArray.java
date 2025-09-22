// Problem: Find Largest and Smallest Elements in an Array
// Description: Traverses through an array to find both maximum and minimum elements
// Algorithm: Single pass through array comparing each element with current max and min
// Time Complexity: O(n) - linear time to traverse entire array
// Space Complexity: O(1) - constant extra space

package Arrays;
import java.util.*;
public class LargestInArray {

    // Method to find largest and smallest elements in an array
    // Parameter: n[] - input array of integers
    // Returns: largest element in the array
    public static int Largest(int[] n){
        int largest = Integer.MIN_VALUE;  // Initialize to smallest possible integer
        int smallest = Integer.MAX_VALUE; // Initialize to largest possible integer

        // Single traversal to find both largest and smallest
        for (int i=0; i<n.length; i++){
            if (largest < n[i]){ // Update largest if current element is greater
                largest=n[i];
            }
            if (smallest > n[i]){ // Update smallest if current element is smaller
                smallest=n[i];
            }
        }
        System.out.println("smallest :- "+smallest);
        System.out.println("largest :- "+largest);

        return largest;
    }

    public static void main(String[] args) {
        int[] numbers={1,2,3,4,6,89,6,4,33,8}; // Test array
        Largest(numbers); // Find and display largest and smallest elements
    }
}
