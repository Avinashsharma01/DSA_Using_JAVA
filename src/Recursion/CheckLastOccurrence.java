// Problem: Find Last Occurrence of Element using Recursion
// Description: Recursively searches for the last occurrence of a target element in array
// Algorithm: Recurse to end first, then check current element while unwinding
// Time Complexity: O(n) - visits all elements
// Space Complexity: O(n) - recursion stack depth
// Base Case: Reached end of array (start unwinding)
// Recursive Case: Check deeper indices first, then current index during backtrack

package Recursion;

public class CheckLastOccurrence {

    // Recursive method to find last occurrence of key in array
    // Parameters: arr[] - input array, key - element to search, index - current position
    // Returns: index of last occurrence if found, -1 if not found
    // Logic: Post-order traversal - recurse first, then process current element
    public static int checkOccurrence(int[] arr, int key, int index){
        // Base case: Reached end of array, start unwinding
        if (index == arr.length){
            return -1;  // No element found in this path
        }

        // Recursive call first - search in remaining array (right side)
        // This ensures we find the rightmost occurrence first during unwinding
        int isFound = checkOccurrence(arr, key, index + 1);

        // If found in deeper recursive call (rightmost occurrence), return that
        if (isFound != -1) {
            return isFound;  // Propagate the rightmost occurrence found
        }

        // Check current index only if not found in right side
        // This happens during unwinding from recursion
        if (arr[index] == key) {
            return index;  // Found at current index (leftmost among remaining)
        }

        return -1;  // Not found at current index or right side
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 5};  // Array with duplicate 3s at indices 2 and 4
        int target = 3;
        int result = checkOccurrence(arr, target, 0);

        if(result != -1) {
            System.out.println("Last occurrence of " + target + " found at index: " + result);
        } else {
            System.out.println("Element " + target + " not found in array");
        }
    }
}
