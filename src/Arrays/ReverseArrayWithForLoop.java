// Problem: Reverse an Array using For Loop (Alternative Implementation)
// Description: Reverses an array in-place using a for loop with two variables
// Algorithm: Use for loop with two variables (first and last) to swap elements from both ends
// Time Complexity: O(n) - single pass through half the array
// Space Complexity: O(1) - constant extra space (in-place reversal)
// Note: Alternative to while loop approach, using for loop for cleaner syntax

package Arrays;

public class ReverseArrayWithForLoop {

    // Method to reverse an array using for loop with two pointers
    // Parameter: array[] - input array to be reversed
    public static void ReverseWithFor(int[] array){

        // For loop with two variables: first starts at 0, last starts at end
        for(int first=0, last=array.length-1; first<=last; first++, last--){
            int temp;  // Temporary variable for swapping
            temp=array[last];     // Store last element
            array[last]=array[first];  // Move first element to last position
            array[first]=temp;    // Move stored last element to first position
        }
    }

    public static void main(String[] args) {
        int[] arr={9,8,7,6,5,4,3,2,1};  // Test array in descending order
        ReverseWithFor(arr);  // Reverse the array

        // Print reversed array (will print in ascending order: 1,2,3,4,5,6,7,8,9)
        for(int i: arr){
            System.out.print(i+ ",");
        }
    }
}
