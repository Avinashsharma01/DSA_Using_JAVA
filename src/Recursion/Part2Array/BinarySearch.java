// Problem: Binary Search using Recursion
// Description: Recursively searches for a target element in a sorted array using divide and conquer
// Algorithm: Compare target with middle element, recurse on appropriate half
// Time Complexity: O(log n) - eliminates half the search space each time
// Space Complexity: O(log n) - recursion stack depth
// Base Case: start > end (element not found) OR target found at mid
// Recursive Case: Search in left or right half based on comparison

package Recursion.Part2Array;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};  // Sorted array (prerequisite for binary search)
        int target = 5;
        int result = searchB(arr, target, 0, arr.length-1);

        if(result != -1) {
            System.out.println("Element " + target + " found at index: " + result);
        } else {
            System.out.println("Element " + target + " not found in array");
        }
    }

    // Recursive binary search method
    // Parameters: arr[] - sorted array, target - element to find, start - left boundary, end - right boundary
    // Returns: index of target if found, -1 if not found
    // Logic: Divide search space in half, recurse on appropriate side
    public static int searchB(int[] arr, int target, int start, int end) {
        // Base case: Invalid range means element not found
        if (start > end) {
            return -1;
        }

        // Calculate middle index using overflow-safe formula
        int mid = start + (end - start) / 2;

        // Base case: Target found at middle index
        if (target == arr[mid]) {
            return mid;
        }

        // Recursive cases: Search in appropriate half
        if (target < arr[mid]) {
            // Target is smaller, search in left half
            return searchB(arr, target, start, mid - 1);
        } else {
            // Target is larger, search in right half
            return searchB(arr, target, mid + 1, end);
        }
    }
}
