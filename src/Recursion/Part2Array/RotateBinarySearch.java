// Problem: Binary Search in Rotated Sorted Array using Recursion
// Description: Searches for target in a rotated sorted array (e.g., [4,5,6,7,1,2,3])
// Algorithm: Modified binary search that handles rotation by checking which half is sorted
// Time Complexity: O(log n) - eliminates half the search space each time
// Space Complexity: O(log n) - recursion stack depth
// Key Insight: At least one half of the array will always be properly sorted

package Recursion.Part2Array;

public class RotateBinarySearch {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,1,2,3};  // Rotated sorted array (rotation point at index 4)
        int target = 1;
        int result = searchB(arr, target, 0, arr.length-1);

        if(result != -1) {
            System.out.println("Element " + target + " found at index: " + result);
        } else {
            System.out.println("Element " + target + " not found");
        }
    }

    // Recursive binary search for rotated sorted array
    // Parameters: arr[] - rotated sorted array, target - element to find, start/end - search boundaries
    // Returns: index of target if found, -1 if not found
    // Logic: Determine which half is sorted, then decide which half to search
    public static int searchB(int[] arr, int target, int start, int end){
        // Base case: Invalid range means element not found
        if (start > end){
            return -1;
        }

        // Calculate middle index
        int mid = start + (end-start)/2;

        // Base case: Target found at middle
        if (target == arr[mid]){
            return mid;
        }

        // Check if left half is sorted (no rotation point in left half)
        if (arr[start] <= arr[mid]){
            // Left half is sorted, check if target lies within this sorted range
            if (target >= arr[start] && target < arr[mid]){
                // Target is in sorted left half
                return searchB(arr, target, start, mid-1);
            } else {
                // Target is in right half (which may contain rotation point)
                return searchB(arr, target, mid+1, end);
            }
        }

        // Right half is sorted (rotation point is in left half)
        // Check if target lies within the sorted right half
        if (target > arr[mid] && target <= arr[end]){
            // Target is in sorted right half
            return searchB(arr, target, mid+1, end);
        } else {
            // Target is in left half (which contains rotation point)
            return searchB(arr, target, start, mid-1);
        }
    }
}
