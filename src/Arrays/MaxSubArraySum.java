// Problem: Maximum Subarray Sum using Brute Force Approach (Alternative Implementation)
// Description: Finds the maximum sum among all possible subarrays using triple nested loops
// Algorithm: Generate all possible subarrays and calculate their sums to find maximum
// Time Complexity: O(n³) - triple nested loops for generating and summing subarrays
// Space Complexity: O(1) - constant extra space
// Note: Similar to MaxSubArray.java but with slightly different implementation

package Arrays;
public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10};  // Test array
        int currentSum=0;  // Current subarray sum
        int maxSum= Integer.MIN_VALUE;  // Maximum sum found so far

        // Outer loop for starting index of subarray
        for(int i=0; i<arr.length; i++){
            // Middle loop for ending index of subarray
            for(int j=i; j<arr.length; j++){
                currentSum=0;
                // Inner loop to calculate sum of subarray from i to j
                for(int k=i; k<=j; k++){
                    currentSum+=arr[k];  // Add current element to sum
                }
                System.out.println(currentSum);  // Print current subarray sum
                if (maxSum<currentSum){  // Update maximum if current sum is greater
                    maxSum=currentSum;
                }
            }
        }
        System.out.println("CurrentSum:- "+currentSum);  // Last calculated sum
        System.out.println("MaxSum:- "+maxSum);  // Maximum subarray sum
        System.out.println(Integer.MIN_VALUE);  // Display Integer.MIN_VALUE
        System.out.println(Integer.MAX_VALUE);  // Display Integer.MAX_VALUE
    }
}
