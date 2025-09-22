// Problem: Maximum Subarray Sum using Prefix Sum Optimization
// Description: Finds maximum subarray sum using prefix sum array to optimize calculation
// Algorithm: Create prefix sum array, then use it to calculate subarray sums in O(1) time
// Time Complexity: O(n²) - improved from O(n³) brute force approach
// Space Complexity: O(n) - extra space for prefix sum array
// Optimization: Reduces subarray sum calculation from O(n) to O(1)

package Arrays;

public class PrefixSubArraySum {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10};  // Original array
        int currentSum;  // Current subarray sum
        int maxSum=Integer.MIN_VALUE;  // Maximum sum found so far

        // Create prefix sum array where prefix[i] = sum of elements from 0 to i
        int[] prefix = new int[arr.length];
        prefix[0]=arr[0];  // First element is same as original
        for(int i=1; i<prefix.length; i++){
            prefix[i]=prefix[i-1]+arr[i];  // Each element = previous prefix + current element
        }

        // Generate all possible subarrays and calculate their sums using prefix array
        for(int i=0; i<arr.length; i++){  // Starting index
            for (int j=i; j<arr.length; j++){  // Ending index
                // Calculate sum from i to j using prefix sum
                // If i=0, sum = prefix[j], otherwise sum = prefix[j] - prefix[i-1]
                currentSum= i == 0 ? prefix[j]: prefix[j]-prefix[i-1];

                if(maxSum<currentSum){  // Update maximum sum if current is greater
                    maxSum=currentSum;
                }
            }
        }
        System.out.println(maxSum);  // Print maximum subarray sum
    }
}
