// Problem: Find Ceiling of a Number using Binary Search
// Description: Finds the smallest element greater than or equal to target in sorted array
// Ceiling Definition: Smallest number >= target (if target exists, return target itself)
// Algorithm: Modified binary search where we track the potential ceiling candidate
// Time Complexity: O(log n) - logarithmic time due to binary search
// Space Complexity: O(1) - constant extra space
// Edge Case: If target > all elements, no ceiling exists (should return -1 or handle appropriately)

package SearchingAlgo.BinarySearchQuestions;

public class ceilingOFaNumber {
    public static void main(String[] args) {
        int[] arr =  {9,14,16,17};  // Sorted array (prerequisite for binary search)
        System.out.println(FindCeiling(arr, 15));  // Find ceiling of 15 (should return 16)
    }

    // Method to find ceiling of target using binary search
    // Parameters: arr[] - sorted array in ascending order, target - number to find ceiling for
    // Returns: ceiling value if found, or arr[start] which represents the ceiling position
    // Note: Current implementation returns value, not index
    public static int FindCeiling(int[] arr, int target){
        int n = arr.length;
        int start=0;        // Left boundary
        int end = n-1;      // Right boundary

        // Edge case: if target is greater than the largest element
        if (target > arr[end]) {
            return -1;  // No ceiling exists (should add this check)
        }

        // Binary search to find ceiling
        while (start<=end){
            int mid = start + (end-start)/2;  // Overflow-safe mid calculation

            if (target==arr[mid]){      // Exact match found - target is its own ceiling
                return arr[mid];        // Return the target value itself
            } else if (arr[mid]< target) {  // Target is larger, search right half
                start = mid+1;          // Move start to eliminate left half
            }else {                     // arr[mid] > target, potential ceiling found
                end = mid-1;            // Move end to search for smaller ceiling in left half
            }
        }

        // When loop ends: start points to the ceiling (smallest element >= target)
        // This happens because start moves past end, and start points to next larger element
        return arr[start];  // Return ceiling value
    }
}
