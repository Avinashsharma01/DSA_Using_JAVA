// Problem: Bubble Sort using Recursion
// Description: Implements bubble sort algorithm using recursive approach instead of nested loops
// Algorithm: Recursively performs passes, swapping adjacent elements if out of order
// Time Complexity: O(n²) - same as iterative bubble sort
// Space Complexity: O(n) - recursion stack depth
// Pattern: Uses recursion to replace both outer and inner loops of traditional bubble sort

package Recursion.sorting;

public class bubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,5,4,2,1};  // Test array with unsorted elements

        System.out.print("Original array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        search(arr, arr.length-1, 0);  // Start recursive bubble sort

        System.out.print("Sorted array: ");
        for (int num : arr){
            System.out.print(num+ " ");
        }
        System.out.println();
    }

    // Recursive bubble sort method
    // Parameters: arr[] - array to sort, n - current pass range, initial - current position in pass
    // Logic: Performs bubble sort passes recursively, each pass bubbles largest element to end
    public static void search(int[] arr, int n, int initial){
        // Base case: No more passes needed (array is sorted)
        if (n==0){
            return;
        }

        // Still processing current pass
        if (initial < n){
            // Compare adjacent elements and swap if needed
            if(arr[initial] > arr[initial+1]){
                // Swap elements (bubble larger element towards end)
                int temp = arr[initial];
                arr[initial] = arr[initial+1];
                arr[initial+1] = temp;
            }
            // Continue with next pair in current pass
            search(arr, n, initial+1);
        } else {
            // Completed current pass, start next pass with reduced range
            // After each pass, the largest element is in its correct position
            search(arr, n-1, 0);
        }
    }
}
