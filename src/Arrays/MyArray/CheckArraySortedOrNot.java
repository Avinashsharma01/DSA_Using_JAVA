// Problem: Check if an Array is Sorted (Ascending or Descending)
// Description: Determines if an array is sorted in ascending or descending order
// Algorithm: Single pass through array comparing adjacent elements
// Time Complexity: O(n) - linear time to check all adjacent pairs
// Space Complexity: O(1) - constant extra space
// Use Cases: Data validation, preprocessing for binary search

package Arrays.MyArray;

public class CheckArraySortedOrNot {

    // Method to check if array is sorted in ascending (non-decreasing) order
    // Parameter: arr[] - input array to check
    // Returns: true if sorted in ascending order, false otherwise
    public static boolean checkSortedArrayA(int[] arr){
        // Check for ascending order - each element should be <= next element
        for (int i=0; i< arr.length-1; i++){
            if (arr[i] > arr[i+1]){  // If current > next, not sorted ascending
                return false;
            }
        }
        return true;  // All elements are in non-decreasing order
    }

    // Method to check if array is sorted in descending (non-increasing) order
    // Parameter: arr[] - input array to check
    // Returns: true if sorted in descending order, false otherwise
    public static boolean checkSortedArrayD(int[] arr){
        // Check for descending order - each element should be >= next element
        for(int i=0; i<arr.length-1; i++){
            if (arr[i]< arr[i+1]){  // If current < next, not sorted descending
                return false;
            }
        }
        return true;  // All elements are in non-increasing order
    }

    public static void main(String[] args) {
        // Test arrays for demonstration
        int[] arrA ={1,2,3,4,5};  // Ascending sorted array
        int[] arrD={5,4,3,2,1};   // Descending sorted array

        System.out.println("Ascending check: " + checkSortedArrayA(arrA));  // Should print true
        System.out.println("Descending check: " + checkSortedArrayD(arrD)); // Should print true
    }
}
