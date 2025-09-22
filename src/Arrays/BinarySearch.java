// Problem: Binary Search Algorithm Implementation
// Description: Searches for a target element in a sorted array using binary search
// Note: This implementation has a bug - the array should be sorted for binary search to work correctly
// Algorithm: Divide and conquer approach that repeatedly divides search space in half
// Time Complexity: O(log n) - logarithmic time for sorted arrays
// Space Complexity: O(1) - constant space (iterative approach)

package Arrays;

public class BinarySearch {

    // Binary search method to find the index of a key in an array
    // Parameters: array - input array (should be sorted), key - element to search
    // Returns: index of the key if found, -1 if not found
    public static int Binary(int[] array, int key){

        for (int start=0, end=array.length-1; start<=end;){
            int mid = (start+end)/2; // Calculate middle index

            if (array[mid]==key){ // Element found at middle
                return mid;
            }
            if (array[mid]<key){ // Search in right half
                start=mid+1;
            }else { // Search in left half
                end=mid-1;
            }
        }
        return -1; // Element not found
    }

    public static void main(String[] args) {
        int[] number = {1,2,5,6,3,8,9,5,6}; // Warning: Array is not sorted!
        int key=8; // Element to search for
        System.out.println("index is :- "+Binary(number,key));
    }
}
