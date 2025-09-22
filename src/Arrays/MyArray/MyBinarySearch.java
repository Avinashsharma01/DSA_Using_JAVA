// Problem: Binary Search Algorithm Implementation (Two Versions)
// Description: Implements binary search to find target element in sorted array
// Algorithm: Divide and conquer - repeatedly divide search space in half
// Time Complexity: O(log n) - logarithmic time for sorted arrays
// Space Complexity: O(1) - constant space (iterative approach)
// Note: Uses overflow-safe mid calculation: low + (high-low)/2

package Arrays.MyArray;

public class MyBinarySearch {

    // Primary binary search implementation with debug output
    // Parameters: arr[] - sorted input array, key - element to search for
    // Returns: index of element if found, -1 if not found
    public static int MyBinary(int[] arr, int key){
        int low = 0;  // Start of search range
        int high = arr.length - 1;  // End of search range

        while (low <= high) {
            // Overflow-safe calculation of middle index
            int mid = low + (high-low)/2;  // Equivalent to (low+high)/2 but prevents overflow
            System.out.println(mid + "mid");  // Debug output showing mid calculation

            if (arr[mid] == key) {  // Element found at middle
                return mid;
            }
            if (arr[mid] < key) {  // Search in right half
                low = mid + 1;
            } else {  // Search in left half
                high = mid - 1;
            }
        }
        return -1;  // Element not found
    }

    // Alternative binary search implementation (cleaner version)
    // Parameters: arr[] - sorted input array, key - element to search for
    // Returns: index of element if found, -1 if not found
    public static int mmmm(int[] arr, int key) {
        int low = 0, high = arr.length-1;

        while (low<=high){
            int mid = low + (high-low)/2;  // Overflow-safe mid calculation
            if(key== arr[mid]){  // Element found
                return mid;
            }
            if (key> arr[mid]){  // Search in right half
                low=mid+1;
            }else {  // Search in left half
                high=mid-1;
            }
        }
        return -1;  // Element not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  // Sorted test array
        int key = 3;  // Element to search for
        int resultIndex = MyBinary(arr, key);  // Perform binary search

        if (resultIndex != -1) {
            System.out.println("Index no :- " + resultIndex + " Element :- " + arr[resultIndex]);
        } else {
            System.out.println("Element not found");
        }
    }
}
