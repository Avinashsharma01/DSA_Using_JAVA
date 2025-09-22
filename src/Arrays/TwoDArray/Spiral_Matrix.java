// Problem: Print Matrix Elements in Spiral Order
// Description: Traverses and prints matrix elements in spiral pattern (clockwise from outside to inside)
// Algorithm: Use four boundaries (top, right, bottom, left) and shrink them after each traversal
// Pattern: Top Row → Right Column → Bottom Row → Left Column → Repeat for inner layers
// Time Complexity: O(n*m) - visits each element exactly once
// Space Complexity: O(1) - constant extra space

package Arrays.TwoDArray;
import java.util.Scanner;

public class Spiral_Matrix {

    // Method to print matrix in spiral order (clockwise)
    // Parameter: matrix[][] - 2D array to traverse
    // Approach: Maintain four boundaries and traverse in layers
    public static void printSpiral(int[][] matrix){
        int startRow=0;               // Top boundary
        int startCol=0;               // Left boundary
        int endRow=matrix.length-1;   // Bottom boundary
        int endCol= matrix[0].length-1; // Right boundary

        // Continue until all layers are processed
        while (startRow<=endRow && startCol<=endCol){

            // Traverse top boundary (left to right)
            for (int j=startCol; j<=endCol; j++){
                System.out.print(matrix[startRow][j]+" ");
            }

            // Traverse right boundary (top to bottom, excluding top corner)
            for (int i=startRow+1; i<=endRow; i++){
                System.out.print(matrix[i][endCol]+ " ");
            }

            // Traverse bottom boundary (right to left, excluding right corner)
            for (int j =endCol-1; j>=startCol; j--){
                if (startRow==endRow){ // Avoid double printing in single row case
                    break;
                }
                System.out.print(matrix[endRow][j]+" ");
            }

            // Traverse left boundary (bottom to top, excluding corners)
            for (int i=endRow-1; i>= startRow+1; i--){
                if (startCol==endCol){ // Avoid double printing in single column case
                    break;
                }
                System.out.print(matrix[i][startCol]+" ");
            }

            // Shrink boundaries for next inner layer
            startRow++; // Move top boundary down
            startCol++; // Move left boundary right
            endRow--;   // Move bottom boundary up
            endCol--;   // Move right boundary left
        }
        System.out.println();
        System.out.println("Successfully printed the spiral matrix");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Option 1: Predefined matrix (commented out)
        // int[][] matrix= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        // Option 2: User input matrix
        int[][] matrix = new int[4][4];  // Create 4x4 matrix
        int n = matrix.length;     // Number of rows
        int m = matrix[0].length;  // Number of columns

        // Input phase: Fill matrix with user input
        System.out.println("Insert the value into matrix");
        for (int i=0; i<n; i++){      // For each row
            for (int j =0; j<m; j++){  // For each column
                matrix[i][j]=sc.nextInt();  // Read integer from user
            }
        }

        System.out.println("You have successfully inserted the element into matrix");
        printSpiral(matrix);  // Print matrix in spiral order
    }
}
