// Problem: Maximum Subarray Sum using Brute Force Approach
// Description: Finds the maximum sum among all possible subarrays using triple nested loops
// Algorithm: Generate all possible subarrays and calculate their sums to find maximum
// Time Complexity: O(n³) - triple nested loops for generating and summing subarrays
// Space Complexity: O(1) - constant extra space
// Note: This is the classic brute force approach; Kadane's algorithm would be O(n)

package Arrays.MyArray;

public class MyMaxSubArraySum {
    public static void main(String[] args) {
        int[] arr={2,4,6,8,10};  // Test array (all positive values)
        int current;  // Current subarray sum
        int maxsum=Integer.MIN_VALUE;  // Maximum sum found so far

        // Outer loop for starting index of subarray
        for(int i=0; i<arr.length; i++){
            // Middle loop for ending index of subarray
            for (int j=i; j<arr.length; j++){
                current=0;  // Reset current sum for new subarray
                // Inner loop to calculate sum of subarray from i to j
                for (int k=i; k<=j; k++){
                    current+=arr[k];  // Add current element to sum
                }
                if (maxsum<current){  // Update maximum if current sum is greater
                    maxsum=current;
                }
            }
        }
        System.out.print("Maxsum:- "+ maxsum);  // Print maximum subarray sum
    }
}
