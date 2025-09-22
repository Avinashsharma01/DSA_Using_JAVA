// Problem: Array Reversal using Two Different Approaches
// Description: Demonstrates in-place reversal and creating new reversed array
// Algorithm 1: Two-pointer technique for in-place reversal
// Algorithm 2: Create new array with elements in reverse order
// Time Complexity: O(n) - both approaches require single pass
// Space Complexity: O(1) for in-place, O(n) for new array approach

package Arrays.MyArray;

public class MyreverseArray {

    // Method to reverse array in-place using two pointers
    // Parameter: array[] - input array to be reversed
    // Modifies: Original array is reversed
    public static void myReverse(int[] array){
        int first = 0;  // Pointer starting from beginning
        int last = array.length - 1;  // Pointer starting from end

        // Loop to reverse the array by swapping elements from both ends
        while (first <= last) {
            int temp=  array[first];    // Store first element temporarily
            array[first] = array[last]; // Move last element to first position
            array[last] = temp;         // Move stored first element to last position
            first++;  // Move first pointer forward
            last--;   // Move last pointer backward
        }
    }

    // Method to create a new reversed array (non-destructive approach)
    // Parameter: arr[] - input array
    // Returns: new array with elements in reverse order
    public static int[] RR(int[] arr){
        int[] temp = new int[arr.length];  // Create new array of same size
        for (int i=0; i<arr.length; i++){
            temp[i] = arr[arr.length-1-i];  // Copy elements in reverse order
        }
        return temp;  // Return new reversed array
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};  // Original array

        // Print the original array
        System.out.print("Original: ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();

        // Reverse the array in-place
        myReverse(arr);

        // Print the reversed array
        System.out.print("Reversed: ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();

        // Example of using RR method (commented out)
        // int[] mydata = RR(arr);
        // System.out.println("New reversed array:");
        // for (int num: mydata){
        //     System.out.print(num+ " ");
        // }
    }
}