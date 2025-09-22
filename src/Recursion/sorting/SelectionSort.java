// Problem: Selection Sort using Recursion (Two Approaches)
// Description: Implements selection sort using recursive approach instead of nested loops
// Algorithm: Recursively find maximum element and place it at end, reduce problem size
// Time Complexity: O(n²) - same as iterative selection sort
// Space Complexity: O(n) - recursion stack depth
// Pattern: Uses recursion to replace both outer and inner loops of traditional selection sort

package Recursion.sorting;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {3,2,1};  // Test array with reverse sorted elements

        System.out.print("Original array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        selectionSortRecursive(arr, arr.length, 0, 0);  // Sort using recursive selection sort

        System.out.print("Sorted array: ");
        for (int num: arr){
            System.out.print(num+" ");
        }
        System.out.println();
    }

    // Traditional iterative selection sort (for comparison)
    // Algorithm: Find minimum element in unsorted portion, swap with first unsorted element
    // Time Complexity: O(n²), Space Complexity: O(1)
    public static void MySS(int[] arr){
        int n = arr.length;

        // Outer loop: expand sorted portion from left
        for (int i=0; i<n-1; i++){
            int minIndex = i;  // Assume current position has minimum

            // Inner loop: find actual minimum in unsorted portion
            for(int j = i+1; j<n; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;  // Update minimum index
                }
            }

            // Swap minimum element with first unsorted element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Recursive selection sort - finds maximum and places it at end
    // Parameters: array - array to sort, unsortedLength - size of unsorted portion,
    //            currentIndex - current position being checked, maxIndexSoFar - index of current maximum
    // Logic: Find maximum in current pass, place at end, recurse with smaller problem
    public static void selectionSortRecursive(int[] array, int unsortedLength, int currentIndex, int maxIndexSoFar) {
        // Base case: No more elements to sort
        if (unsortedLength == 0) {
            return;
        }

        // Still scanning current pass to find maximum
        if (currentIndex < unsortedLength) {
            if (array[currentIndex] > array[maxIndexSoFar]) {
                // Found new maximum, update maxIndexSoFar and continue
                selectionSortRecursive(array, unsortedLength, currentIndex + 1, currentIndex);
            } else {
                // Current element is not maximum, continue with same maxIndexSoFar
                selectionSortRecursive(array, unsortedLength, currentIndex + 1, maxIndexSoFar);
            }
        } else {
            // Completed current pass, place maximum at end of unsorted portion
            int temp = array[maxIndexSoFar];
            array[maxIndexSoFar] = array[unsortedLength - 1];
            array[unsortedLength - 1] = temp;

            // Start next pass with reduced problem size
            selectionSortRecursive(array, unsortedLength - 1, 0, 0);
        }
    }
}
