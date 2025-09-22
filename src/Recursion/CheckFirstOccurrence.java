// Problem: Find First Occurrence of Element using Recursion
// Description: Recursively searches for the first occurrence of a target element in array
// Algorithm: Check current element, if not found recurse to next index
// Time Complexity: O(n) - worst case visits all elements
// Space Complexity: O(n) - recursion stack depth
// Base Case: Reached end of array (element not found) OR found element
// Recursive Case: Current element doesn't match, search in remaining array

package Recursion;

public class CheckFirstOccurrence {

    // Recursive method to find first occurrence of key in array
    // Parameters: arr[] - input array, key - element to search, index - current position
    // Returns: index of first occurrence if found, -1 if not found
    // Logic: Linear search using recursion from left to right
    public static int checkOccurrence(int[] arr, int key, int index){
        // Base case: Reached end of array without finding element
        if (index == arr.length){
            return -1;  // Element not found
        }

        // Base case: Found the target element at current index
        if (arr[index]== key){
            return index;  // Return the index where element was found
        }

        // Recursive case: Element not found at current index, search next position
        return  checkOccurrence(arr, key, index+1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};  // Test array
        int target = 3;  // Element to search for
        int result = checkOccurrence(arr, target, 0);

        if(result != -1) {
            System.out.println("First occurrence of " + target + " found at index: " + result);
        } else {
            System.out.println("Element " + target + " not found in array");
        }
    }
}
