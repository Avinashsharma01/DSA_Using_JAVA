// Problem: Bubble Sort Algorithm Implementation
// Description: Sorts array by repeatedly swapping adjacent elements if they are in wrong order
// Algorithm: Compare adjacent elements and bubble larger elements towards the end
// Time Complexity: O(n²) worst/average case, O(n) best case (with optimization)
// Space Complexity: O(1) - in-place sorting algorithm
// Characteristics: Stable, adaptive (with swap flag), comparison-based
// Best Use: Educational purposes, small datasets, nearly sorted arrays

package Sorting;

public class BubbleSort {

    // Bubble sort method with optimization using swap flag
    // Parameter: arr[] - array to be sorted in ascending order
    // Optimization: Early termination if no swaps occur (array already sorted)
    public static void bubbleSort(int[] arr){
        int n = arr.length;
        boolean swap;  // Flag to detect if any swaps occurred in current pass

        // Outer loop: n-1 passes needed to sort n elements
        for (int i=0; i<n-1; i++){
            swap = false;  // Reset swap flag for each pass

            // Inner loop: Compare adjacent elements
            // Range reduces by i after each pass (last i elements are sorted)
            for (int j=0; j<n-1-i;  j++){
                if(arr[j]> arr[j+1]){  // Adjacent elements in wrong order
                    // Swap elements using temporary variable
                    int temp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]= temp;
                    swap = true;  // Mark that a swap occurred
                }
            }

            // Optimization: If no swaps occurred, array is already sorted
            if (!swap){
                return;  // Early termination saves unnecessary iterations
            }
        }
    }

    // Method 1: Print array using enhanced for loop (for-each)
    // Parameter: a[] - array to print
    // Advantage: Cleaner syntax, less error-prone
    public static void PrintArr(int[] a){
        for (int num: a){  // Enhanced for loop iterates through all elements
            System.out.print(num+ " ");  // Print with space separator
        }
        System.out.println();  // New line after printing array
    }

    // Method 2: Print array using traditional for loop with index
    // Parameter: b[] - array to print
    // Advantage: Access to index if needed for formatting
    public static void PrintH(int[] b){
        for (int i=0;  i<b.length; i++){  // Traditional indexed loop
            System.out.print(b[i]+ " ");  // Print element with space
        }
        System.out.println();  // New line after printing array
    }

    public static void main(String[] args) {
        int[] myarray= {1,3,2,8,6,5};  // Test array with unsorted elements

        System.out.print("Original array: ");
        PrintArr(myarray);  // Print original array

        bubbleSort(myarray);  // Sort the array using bubble sort

        System.out.print("Sorted array: ");
        PrintH(myarray);  // Print sorted array
    }
}
