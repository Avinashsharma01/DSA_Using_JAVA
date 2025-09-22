// Problem: Linear Search Algorithm Implementation
// Description: Searches for a target element by checking each element sequentially
// Algorithm: Traverse array from start to end until element is found or array ends
// Time Complexity: O(n) - worst case requires checking all elements
// Space Complexity: O(1) - constant extra space
// Note: Works with both sorted and unsorted arrays (unlike binary search)
// Bug Alert: Current implementation has off-by-one error in loop condition

package SearchingAlgo;

public class LenearSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};  // Test array (can be unsorted too)
        Search(arr, 5);  // Search for target element 5
    }

    // Linear search method to find target element in array
    // Parameters: arr[] - input array (sorted or unsorted), target - element to search for
    // Returns: void (prints result directly)
    // Bug: Loop condition should be i < arr.length, not i < arr.length-1
    public static void Search(int[] arr , int target){
        // Sequential search through array elements
        for (int i=0; i< arr.length; i++){  // BUG FIXED: Changed to i < arr.length
            if (arr[i]==target){  // Element found at current index
                System.out.println(target+ " found at index:- "+ i);
                return;  // Exit after finding first occurrence
            }
        }
        System.out.println(target + " not found in array");  // Target not found message
    }
}
