// Problem: Order Agnostic Binary Search
// Description: Binary search that works on both ascending and descending sorted arrays
// Algorithm: First determine sort order, then apply appropriate binary search logic
// Time Complexity: O(log n) - same as regular binary search
// Space Complexity: O(1) - constant extra space
// Advantage: Single method handles both ascending and descending sorted arrays

package SearchingAlgo;

public class OrderAgnosticBS {
    public static void main(String[] args) {
        int[] arrA= {1,2,3,4,5,6,7,8,9,10};    // Ascending sorted array
        int[] arrD = {10,9,8,7,6,5,4,3,2,1};   // Descending sorted array

        int target = 4;  // Element to search for
        int ElementIndex = Search(arrD, target);  // Test with descending array

        System.out.println(target + " is located at index:- "+ ElementIndex );
    }

    // Order agnostic binary search method
    // Parameters: arr[] - sorted array (ascending or descending), target - element to search
    // Returns: index of target element if found, -1 if not found
    public static int Search(int[] arr, int target){
        int start =0;           // Left boundary
        int end= arr.length-1;  // Right boundary

        // Determine if array is sorted in ascending or descending order
        // Compare first and last elements to determine sort direction
        boolean IsAscending = arr[start] < arr[end];
        System.out.println("Array is ascending: " + IsAscending);

        // Binary search with order-aware logic
        while(start <=end){
            // Calculate middle index using overflow-safe formula
            int mid = start + (end - start) / 2;  // Prevents integer overflow

            if (target==arr[mid]){  // Target found at middle
                return mid;
            }

            // Apply different logic based on sort order
            if (IsAscending){  // For ascending order array
                if (target > arr[mid]){  // Target is greater, search right half
                    start = mid+1;
                }else {                  // Target is smaller, search left half
                    end = mid-1;
                }
            }else {            // For descending order array
                if (target < arr[mid]){  // Target is smaller, search right half (reversed logic)
                    start = mid+1;
                }else {                  // Target is greater, search left half (reversed logic)
                    end =  mid-1;
                }
            }
        }
        return -1;  // Target not found
    }
}
