// Problem: 2D Array Input, Display, and Linear Search
// Description: Takes user input to fill a 2D array, displays it, and searches for a specific element
// Algorithm: Linear search in 2D matrix by checking each element sequentially
// Time Complexity: O(n*m) where n=rows, m=columns for search operation
// Space Complexity: O(1) - constant extra space for search
// Use Case: Basic 2D array operations and element searching

package Arrays.TwoDArray;

import java.util.Scanner;

public class InputDatain2DArray {

    // Method to search for a key in 2D matrix using linear search
    // Parameter: matrix[][] - 2D array to search in
    // Input: Takes key from user via Scanner
    // Output: Prints position if found, "not found" message otherwise
    public static void Search(int[][] matrix){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter key to find:- ");
        int key = sc.nextInt();  // Element to search for
        int n= matrix.length;     // Number of rows
        int m = matrix[0].length; // Number of columns

        // Linear search through entire 2D matrix
        for (int i=0; i<n; i++){      // Traverse each row
            for (int j=0; j<m; j++){  // Traverse each column
                if (matrix[i][j]==key){  // Element found
                    System.out.println(key+ " found at cell:- "+ "("+ i+ " "+j+ ")");
                    return;  // Exit immediately after finding first occurrence
                }
            }
        }
        System.out.println(key+" not found");  // Element not found in matrix
        return;
    }


    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);

        int[][] matrix = new int[3][3];  // Create 3x3 matrix
        int n=matrix.length;     // Number of rows
        int m=matrix[0].length;  // Number of columns

        // Input phase: Fill matrix with user input
        System.out.println("insert number to matrix:- ");
        for(int i=0; i<n; i++){      // For each row
            for (int j=0; j<m; j++){  // For each column
                matrix[i][j]=sc.nextInt();  // Read integer from user
            }
        }
        System.out.println("You have successfully insert the number into matrix ");

        // Display phase: Print the filled matrix
        for (int i=0; i<n; i++){      // For each row
            for (int j=0; j<m; j++){  // For each column
                System.out.print(matrix[i][j]+ " ");  // Print element with space
            }
            System.out.println();  // New line after each row
        }

        // Search phase: Find a specific element in matrix
        Search(matrix);
    }
}
