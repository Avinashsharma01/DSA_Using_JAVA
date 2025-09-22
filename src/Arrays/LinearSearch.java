// Problem: Linear Search Algorithm Implementation
// Description: Searches for a target element in an array by checking each element sequentially
// Algorithm: Traverse array from start to end until element is found or array ends
// Time Complexity: O(n) - worst case requires checking all elements
// Space Complexity: O(1) - constant extra space
// Note: There's a bug - loop starts from index 1, missing index 0

package Arrays;

public class LinearSearch {

    // Linear search method to find the index of a key in an array
    // Parameters: number[] - input array, key - element to search for
    // Returns: index of the key if found, -1 if not found
    // Bug: Loop starts from index 1, should start from 0
    public static int update(int[] number, int key){
        for (int i=1; i<number.length; i++){ // Bug: starts from index 1, not 0
            if (number[i]==key){ // Check if current element matches the key
                return i; // Return index if found
            }
        }
        return -1; // Return -1 if element not found
    }

    public static void main(String[] args) {
        int[] number={1,2,3,5,10,1,5,7,3,8,9,55}; // Test array with indices 0-11
        int key=10; // Element to search for
        int data= update(number, key); // Perform linear search

        if (data==-1){ // Check if element was not found
            System.out.println("no data found");
        }else {
            System.out.println("key is at index :- "+ data);
        }
    }
}
