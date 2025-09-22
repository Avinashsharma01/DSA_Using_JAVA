// Problem: Reverse an Array using Two Pointers Technique
// Description: Reverses an array in-place by swapping elements from both ends
// Algorithm: Use two pointers (start and end) and swap elements while moving towards center
// Time Complexity: O(n) - single pass through half the array
// Space Complexity: O(1) - constant extra space (in-place reversal)
// Technique: Two-pointer approach for efficient array reversal

package Arrays;

public class ReverseArray {

    // Method to reverse an array in-place using two pointers
    // Parameter: arr[] - input array to be reversed
    public static void reverseA(int[] arr){
        int fist=0;  // First pointer starting from beginning (typo: should be "first")
        int last= arr.length-1;  // Last pointer starting from end

        // Swap elements from both ends until pointers meet
        while (fist < last){
            int temp = arr[fist];  // Temporary variable for swapping
            arr[fist] =arr[last];  // Move last element to first position
            arr[last]=temp;        // Move first element to last position

            fist++;  // Move first pointer forward
            last--;  // Move last pointer backward
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[100000];  // Large array for demonstration
        // Initialize array with values 0 to 99999
        for(int i=0; i<arr.length; i++){
            arr[i] = i;
        }
        reverseA(arr);  // Reverse the array
        // Print reversed array (will print 99999 to 0)
        for (int j : arr){
            System.out.println(j);
        }
    }
}
