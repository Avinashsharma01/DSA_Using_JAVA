// Problem: Find First Occurrence of an Element in Array
// Description: Searches for the first occurrence of a target element and returns its index
// Algorithm: Linear search from beginning until element is found or array ends
// Time Complexity: O(n) - worst case requires checking all elements
// Space Complexity: O(1) - constant extra space
// Use Case: Finding the first position of a duplicate element

package Arrays.MyArray;

public class FirstOccurrence {

    // Method to find and print the first occurrence of a key in an array
    // Parameters: arr[] - input array, key - element to search for
    // Returns: void (prints result directly)
    public static void checkOccurrence(int[] arr, int key){
        // Linear search from start to find first occurrence
        for (int i=0; i< arr.length; i++){
            if (arr[i]==key){  // Element found at current index
                System.out.println("First occurrence at index: " + i);
                return;  // Exit immediately after finding first occurrence
            }
        }
        System.out.println("Key not found at any index");  // Element not found
    }

    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5,6,5,7,8,9,10};  // Array with duplicate 5s at indices 4 and 6

        checkOccurrence(arr, 5);  // Should find first occurrence at index 4
    }
}
