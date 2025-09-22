// Problem: Check if Array is Sorted using Recursion
// Description: Recursively verifies if an array is sorted in ascending order
// Algorithm: Compare current element with next, recurse for rest of array
// Time Complexity: O(n) - visits each element once
// Space Complexity: O(n) - recursion stack depth
// Base Case: Reached last element (array is sorted)
// Recursive Case: Current <= next and rest of array is sorted

package Recursion;

public class CheckArrayIsSorted {

    // Recursive method to check if array is sorted in ascending order
    // Parameters: arr[] - input array, i - current index being checked
    // Returns: true if array is sorted from index i onwards, false otherwise
    // Logic: Compare current with next element, then recurse for remaining array
    public static boolean CheckArrayIsSortedd(int[] arr, int i){

        // Base case: If we've reached the last element, array is sorted
        if (i == arr.length-1){
            return true;
        }

        // If current element is greater than next, array is not sorted
        if (arr[i] > arr[i+1]){
            return false;
        }

        // Recursive case: Current pair is in order, check rest of array
        return CheckArrayIsSortedd(arr, i+1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};  // Test array - sorted in ascending order
        System.out.println("Is array sorted? " + CheckArrayIsSortedd(arr, 0));
    }
}
