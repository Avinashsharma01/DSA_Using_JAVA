// Problem: Search in Row-wise and Column-wise Sorted Matrix
// Description: Searches for a target element in a matrix where each row and column is sorted
// Algorithm: Staircase Search - starts from top-right or bottom-left corner
// Time Complexity: O(n+m) where n=rows, m=columns (much better than O(n*m) linear search)
// Space Complexity: O(1) - constant extra space
// Key Insight: Use sorted property to eliminate entire rows/columns in each step

package Arrays.TwoDArray;

public class SearchINsortedMatrix {

    // Staircase Search starting from top-right corner (going down-left)
    // Parameters: matrix[][] - sorted 2D array, key - element to search
    // Returns: true if found, false otherwise
    // Strategy: If current > key, move left; if current < key, move down
    public static boolean StairCaseDOWNSearch(int[][] matrix, int key){
        int row = 0;  // Start from top row
        int col = matrix[0].length-1;  // Start from rightmost column

        System.out.println("Starting search from top-right: " + matrix[row][col]);
        System.out.println("Bottom-left corner value: " + matrix[3][0]);

        // Continue until we go out of bounds
        while(row < matrix.length && col>=0){
            if(matrix[row][col]==key){  // Element found
                System.out.println("found key at (" + row + ", "+ col+ ")");
                return true;
            } else if (key< matrix[row][col]) {  // Key is smaller, move left
                col--;  // Eliminate current column (all elements below are larger)
            }else {  // Key is larger, move down
                row++;  // Eliminate current row (all elements left are smaller)
            }
        }
        System.out.println("Key not found");
        return false;
    }

    // Staircase Search starting from bottom-left corner (going up-right)
    // Parameters: matrix[][] - sorted 2D array, key - element to search
    // Returns: true if found, false otherwise
    // Strategy: If current > key, move up; if current < key, move right
    // Note: This method is incomplete in the original code
    public static boolean StairCaseUPSearch(int[][] matrix, int key){
        int row = matrix.length-1;  // Start from bottom row
        int col = 0;  // Start from leftmost column

        // TODO: Complete implementation
        // while(row >= 0 && col < matrix[0].length){
        //     if(matrix[row][col] == key) return true;
        //     else if(key < matrix[row][col]) row--;  // Move up
        //     else col++;  // Move right
        // }
        return false;
    }

    public static void main(String[] args) {
        // Example of row-wise and column-wise sorted matrix
        int [][] matrix = {
                {10,20,30,40},  // Each row is sorted
                {15,25,35,45},  // Each column is also sorted
                {27,29,37,48},  // Property: matrix[i][j] < matrix[i][j+1] and matrix[i][j] < matrix[i+1][j]
                {32,33, 39,50}
        };

        int key = 33;  // Element to search for

        StairCaseDOWNSearch(matrix, key);  // Perform staircase search
    }
}
