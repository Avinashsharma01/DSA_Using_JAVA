// Problem: Generate All Pairs from an Array
// Description: Creates and prints all possible pairs of elements from an array
// Algorithm: Use nested loops where inner loop starts from i+1 to avoid duplicate pairs
// Time Complexity: O(n²) - nested loops to generate all pairs
// Space Complexity: O(1) - constant extra space
// Output: Prints pairs in format (element1, element2)

package Arrays;

public class PairInArray {
    public static void main(String[] args) {
        int[] arr={2,4,6,8,10};  // Test array

        // Outer loop for first element of pair
        for(int i=0; i<arr.length; i++){
            // Inner loop for second element of pair (starts from i+1 to avoid duplicates)
            for (int j=i+1; j<arr.length; j++){
                System.out.print("("+arr[i]+ ","+ arr[j] + ")");  // Print current pair
            }
            System.out.println();  // New line after each row of pairs
        }
    }
}
