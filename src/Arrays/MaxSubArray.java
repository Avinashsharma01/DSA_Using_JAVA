// Problem: Maximum Subarray Sum using Brute Force Approach
// Description: Finds the maximum sum among all possible subarrays using triple nested loops
// Algorithm: Generate all possible subarrays and calculate their sums to find maximum
// Time Complexity: O(n³) - triple nested loops for generating and summing subarrays
// Space Complexity: O(1) - constant extra space
// Note: This is an inefficient approach; Kadane's algorithm would be O(n)

package Arrays;
public class MaxSubArray {
    
    // Method to find maximum subarray sum using brute force approach
    // Parameter: arr[] - input array of integers
    public static void MaxSubArrayFun(int arr[]){
        int currsum=0;  // Current subarray sum
        int maxsum= Integer.MIN_VALUE;  // Maximum sum found so far

        // Outer loop for starting index of subarray
        for(int i=0; i<arr.length; i++){
            int start=i;
            // Middle loop for ending index of subarray
            for (int j=i; j<arr.length; j++){
                int end=j;
                currsum=0;
                // Inner loop to calculate sum of subarray from start to end
                for (int k=start; k<=end; k++){
                    currsum+=arr[k];  // Add current element to sum
                }
                System.out.println(currsum);  // Print current subarray sum
                if (maxsum<currsum){  // Update maximum sum if current is greater
                    maxsum=currsum;
                }
            }
        }
        System.out.println("max sum:- "+ maxsum);
    }
    
    public static void main(String[] args) {
        int[] number={2,4,6,8,10};    // Test array 1
        int[] number1={1,2,3,4,5};    // Test array 2
        MaxSubArrayFun(number1);      // Find max subarray sum
    }
}
