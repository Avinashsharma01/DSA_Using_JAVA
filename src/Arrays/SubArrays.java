// Problem: Generate All Subarrays (Simple Implementation)
// Description: Prints all possible subarrays of an array using triple nested loops
// Algorithm: Use three nested loops to generate and print each subarray
// Time Complexity: O(n³) - triple nested loops for generating and printing subarrays
// Space Complexity: O(1) - constant extra space
// Note: Clean implementation without additional calculations, just prints subarrays

package Arrays;

public class SubArrays {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10};  // Test array

        // Outer loop for starting index of subarray
        for(int i=0; i<arr.length; i++){
            // Middle loop for ending index of subarray
            for(int j=i; j<arr.length; j++){
                // Inner loop to print elements of current subarray from i to j
                for(int k=i; k<=j; k++){
                    System.out.print(arr[k]+" ");  // Print current element
                }
                System.out.println();  // New line after each subarray
            }
            System.out.println();  // Extra line between different starting indices
        }
    }
}
