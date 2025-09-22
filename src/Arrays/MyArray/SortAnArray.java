// Problem: Array Sorting Algorithms Implementation
// Description: Demonstrates three fundamental sorting algorithms: Bubble Sort, Selection Sort, and Insertion Sort
// Algorithms: Comparison-based sorting with different approaches and complexities
// Time Complexities: All three are O(n²) in worst case, but have different characteristics
// Space Complexity: O(1) - all are in-place sorting algorithms

package Arrays.MyArray;
import java.util.Arrays;
public class SortAnArray {

    // Bubble Sort Algorithm
    // Description: Repeatedly steps through list, compares adjacent elements and swaps if in wrong order
    // Time Complexity: O(n²) worst/average case, O(n) best case (optimized version)
    // Space Complexity: O(1)
    // Characteristics: Stable, adaptive (with optimization), in-place
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;  // Optimization flag to detect if array is already sorted
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            // Last i elements are already in place after i iterations
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap adjacent elements if they are in wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Array is already sorted, exit early
        }
    }

    // Selection Sort Algorithm
    // Description: Finds minimum element and places it at beginning, repeat for remaining array
    // Time Complexity: O(n²) in all cases (worst, average, best)
    // Space Complexity: O(1)
    // Characteristics: Not stable, not adaptive, in-place, performs minimum number of swaps
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;  // Assume current position has minimum element
            // Find the minimum element in remaining unsorted array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;  // Update index of minimum element
                }
            }
            // Swap the found minimum element with the first element of unsorted part
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    // Insertion Sort Algorithm
    // Description: Builds sorted array one element at a time by inserting each element in correct position
    // Time Complexity: O(n²) worst/average case, O(n) best case
    // Space Complexity: O(1)
    // Characteristics: Stable, adaptive, in-place, efficient for small datasets
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];  // Current element to be positioned
            int j = i - 1;

            // Move elements that are greater than key to one position ahead
            // This creates space for inserting the key at correct position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];  // Shift element to right
                j = j - 1;
            }
            arr[j + 1] = key;  // Insert key at correct position
        }
    }

    // Main method for testing sorting algorithms
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};  // Test array

        System.out.println("Original Array: " + Arrays.toString(arr));

        // Choose a sorting method to test:
        // bubbleSort(arr);     // O(n²) - good for educational purposes
        // selectionSort(arr);  // O(n²) - minimum swaps
        insertionSort(arr);     // O(n²) - good for small/nearly sorted arrays

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
