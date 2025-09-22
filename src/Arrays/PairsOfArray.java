// Problem: Generate All Pairs from an Array (Alternative Implementation)
// Description: Creates and prints all possible pairs of elements from an array
// Algorithm: Use nested loops where inner loop starts from i+1 to avoid duplicate pairs
// Time Complexity: O(n²) - nested loops to generate all pairs
// Space Complexity: O(1) - constant extra space
// Note: Similar to PairInArray.java but uses a current variable for clarity

package Arrays;

public class PairsOfArray {
    public static void main(String[] args) {
        int[] number= {1,2,3,4,5,6,7,8,9,10};  // Test array with 10 elements

        // Outer loop for first element of pair
        for (int i=0; i<number.length; i++){
            int curr= number[i];  // Store current element for clarity
            // Inner loop for second element of pair (starts from i+1 to avoid duplicates)
            for (int j=i+1; j<number.length; j++){
                System.out.print(" ("+ curr+ "," + number[j]+ ") ");  // Print current pair
            }
            System.out.println();  // New line after each row of pairs
        }
    }
}
