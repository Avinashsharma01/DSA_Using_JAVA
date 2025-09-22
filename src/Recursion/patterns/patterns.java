// Problem: Pattern Printing using Recursion
// Description: Demonstrates recursive approaches to print triangle patterns
// Algorithm: Uses recursion to control both rows and columns for pattern generation
// Time Complexity: O(n²) - prints n*(n+1)/2 stars total
// Space Complexity: O(n) - recursion stack depth
// Educational: Shows how recursion can replace nested loops for pattern printing

package Recursion.patterns;

public class patterns {
    public static void main(String[] args) {
        System.out.println("Iterative triangle pattern:");
        ppp(5);  // Iterative approach for comparison

        System.out.println("\nRecursive triangle pattern (normal order):");
        triangle1(5, 0);  // Recursive approach - prints stars first, then newline

        System.out.println("\nRecursive triangle pattern (reverse order):");
        triangle2(5, 0);  // Recursive approach - prints newline first, then stars
    }

    // Iterative approach for triangle pattern (for comparison)
    // Prints decreasing triangle: 5 stars, 4 stars, 3 stars, etc.
    public static void ppp(int n){
        for (int i=0; i< n; i++){
            for (int j=1; j< n-i; j++){  // Print (n-i-1) stars in each row
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Recursive triangle pattern - Method 1 (Pre-order processing)
    // Parameters: row - current row number, col - current column in row
    // Pattern: Print stars first, then move to next line
    // Logic: For each row, print 'row' number of stars
    public static void triangle1(int row, int col){
        if (row==0){
            return;  // Base case: no more rows to print
        }

        if (col < row){
            // Still have stars to print in current row
            System.out.print("* ");
            triangle1(row, col+1);  // Print next star in same row
        }else {
            // Finished current row, move to next line
            System.out.println();
            triangle1(row-1, 0);  // Move to next row, reset column
        }
    }

    // Recursive triangle pattern - Method 2 (Post-order processing)
    // Parameters: row - current row number, col - current column in row
    // Pattern: Process recursion first, then print (creates reverse effect)
    // Logic: Recurse first, then print during unwinding
    public static void triangle2(int row, int col){
        if (row==0){
            return;  // Base case: no more rows to print
        }

        if (col < row){
            // First recurse to deeper calls
            triangle2(row, col+1);
            // Then print star during unwinding (reverse order within row)
            System.out.print("* ");
        }else{
            // First recurse to next row
            triangle2(row-1, 0);
            // Then print newline during unwinding
            System.out.println();
        }
    }
}
