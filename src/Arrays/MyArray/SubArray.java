// Problem: Generate All Subarrays and Find Maximum Sum
// Description: Prints all possible subarrays and calculates their sums to find maximum
// Algorithm: Triple nested loops to generate subarrays and track maximum sum
// Time Complexity: O(n³) - triple nested loops for generating and summing subarrays
// Space Complexity: O(1) - constant extra space
// Formula: For array of size n, total subarrays = n*(n+1)/2

package Arrays.MyArray;

public class SubArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};  // Test array

        int totalSubArr= 0;  // Counter for total number of subarrays

        int maxsum = Integer.MIN_VALUE;  // Maximum sum found so far
        int current;  // Current subarray sum

        // Outer loop for starting index of subarray
        for(int i=0; i<arr.length; i++){
            // Middle loop for ending index of subarray
            for (int j=i; j<arr.length; j++){
                current=0;  // Reset sum for new subarray
                // Inner loop to print and sum elements of subarray from i to j
                for(int k=i; k<=j; k++){
                    System.out.print(arr[k]);  // Print current element
                    current+=arr[k];  // Add to subarray sum
                }
                totalSubArr++;  // Increment subarray counter
                System.out.println();  // New line after each subarray

                if (maxsum< current){  // Update maximum sum if current is greater
                    maxsum=current;
                }
            }
            System.out.println();  // Extra line between different starting indices
        }
        System.out.println("Total sub array :- "+ totalSubArr);  // Should be n*(n+1)/2
        System.out.println("Max Sub array sum :- "+ maxsum);     // Maximum subarray sum
    }
}
