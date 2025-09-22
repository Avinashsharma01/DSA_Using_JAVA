// Problem: Calculate Diagonal Sum of a Square Matrix
// Description: Computes sum of primary and secondary diagonals in a square matrix
// Algorithm: Two approaches - O(n²) brute force and O(n) optimized
// Primary Diagonal: Elements where i == j (top-left to bottom-right)
// Secondary Diagonal: Elements where i + j == n-1 (top-right to bottom-left)
// Time Complexity: O(n) - optimized approach, O(n²) - brute force
// Space Complexity: O(1) - constant extra space

package Arrays.TwoDArray;

public class DiagonalSum {
    public static void main(String[] args) {
        int[][]  matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        int pn= matrix.length;    // Number of rows
        int pm = matrix[0].length; // Number of columns
        int sum=0;

        // APPROACH 1: Brute Force - O(n²) time complexity
        // Iterate through entire matrix and check diagonal conditions
//        for (int i=0; i<pn; i++){ // Traverse each row
//            for (int j = 0; j< pm; j++){  // Traverse each column
//
//                if (i==j){  // Primary diagonal condition (top-left to bottom-right)
//                    System.out.println(matrix[i][j]);
//                    sum+=matrix[i][j];
//                } else if (i+j == matrix.length-1) {   // Secondary diagonal condition (top-right to bottom-left)
//                    sum+=matrix[i][j];
//                    System.out.println(matrix[i][j]);
//                }
//            }
//        }

        // APPROACH 2: Optimized - O(n) time complexity
        // Directly access diagonal elements without checking entire matrix
        for (int i=0;  i<matrix.length; i++){
            // Add primary diagonal element (i,i)
            sum+=matrix[i][i];

            // Add secondary diagonal element (i, n-1-i) if it's different from primary
            // This condition avoids double counting the center element in odd-sized matrices
            if (i != matrix.length-1-i){
                sum+=matrix[i][matrix.length-i-1];
            }
        }
        System.out.println("Total Diagonal Sum:- "+ sum);
    }
}
