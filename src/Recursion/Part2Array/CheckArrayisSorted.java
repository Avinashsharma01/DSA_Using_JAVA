// Problem: Check if Array is Sorted using Recursion (Enhanced Version)
// Description: Recursively verifies if an array is sorted in non-decreasing order
// Algorithm: Compare current element with next, recurse for remaining array
// Time Complexity: O(n) - visits each element once
// Space Complexity: O(n) - recursion stack depth
// Base Case: Reached last element (array is sorted)
// Recursive Case: Current < next AND rest of array is sorted

package Recursion.Part2Array;

public class CheckArrayisSorted {
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,6,7};  // Test array - sorted in ascending order
        boolean isSorted = checkArraySorted(arr, 0);

        if (isSorted){
            System.out.println("Array is sorted");
        }else {
            System.out.println("Array is not sorted");
        }
    }

    // Recursive method to check if array is sorted in non-decreasing order
    // Parameters: arr[] - input array to check, index - current position being checked
    // Returns: true if array is sorted from index onwards, false otherwise
    // Logic: Each element must be ≤ next element for array to be sorted
    public static boolean checkArraySorted(int[] arr, int index){
        // Base case: If we've reached the last element, array is sorted
        if (index == arr.length-1){
            return true;
        }

        // Check if current element is less than next element
        if(arr[index] < arr[index+1]){
            // Current pair is in order, recursively check rest of array
            return checkArraySorted(arr, index+1);
        }else {
            // Current element is greater than next, array is not sorted
            return false;
        }

        // Alternative concise implementation (commented out):
        // return arr[index] < arr[index+1] && checkArraySorted(arr, index+1);
    }
}
