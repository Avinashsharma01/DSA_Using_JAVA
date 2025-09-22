// Problem: Binary Search Algorithm Implementation
// Description: Searches for a target element in a sorted array using divide and conquer approach
// Algorithm: Repeatedly divides search space in half by comparing target with middle element
// Time Complexity: O(log n) - logarithmic time due to halving search space each iteration
// Space Complexity: O(1) - constant space (iterative implementation)
// Prerequisite: Array must be sorted in ascending order

package SearchingAlgo;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5,6,7,8,9,10};  // Sorted array (prerequisite for binary search)
        int element = Search(arr, 5);  // Search for target element 5
        System.out.println(element);   // Print index if found, -1 if not found
    }

    // Binary search method to find target element in sorted array
    // Parameters: arr[] - sorted input array, target - element to search for
    // Returns: index of target element if found, -1 if not found
    public static int Search(int[] arr, int target){
        int start = 0;              // Left boundary of search range
        int end = arr.length-1;     // Right boundary of search range

        // Continue searching while valid range exists
        while(start <=end){
            // Calculate middle index using overflow-safe formula
            int mid = start + (end - start) / 2;  // Prevents integer overflow

            if (target == arr[mid]){        // Target found at middle
                return mid;
            } else if (target > arr[mid]) { // Target is in right half
                start = mid+1;              // Eliminate left half
            }else {                         // Target is in left half
                end = mid-1;                // Eliminate right half
            }
        }
        return -1;  // Target not found in array
    }
}
