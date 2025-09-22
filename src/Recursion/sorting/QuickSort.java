// Problem: Quick Sort using Recursion
// Description: Divide-and-conquer sorting algorithm using partitioning around a pivot element
// Algorithm: Choose pivot, partition array, recursively sort left and right subarrays
// Time Complexity: O(n log n) average case, O(n²) worst case, O(n log n) best case
// Space Complexity: O(log n) average case (recursion stack), O(n) worst case
// Pattern: In-place sorting with recursive partitioning

package Recursion.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,7,1,3,2,4};  // Test array with unsorted elements

        System.out.print("Original array: ");
        System.out.println(Arrays.toString(arr));

        // Demonstrate partition operation first
        int pivotI = partition(arr.clone(), 0, arr.length - 1);
        System.out.println("Pivot will be placed at index: " + pivotI);

        // Perform complete quick sort
        sort(arr, 0, arr.length-1);
        System.out.print("Sorted array: ");
        System.out.println(Arrays.toString(arr));
    }

    // Main recursive quick sort method
    // Parameters: arr[] - array to sort, low - start index, high - end index
    // Logic: Partition around pivot, then recursively sort left and right subarrays
    public static void sort(int[] arr, int low, int high){
        // Base case: If low >= high, subarray has 0 or 1 element (already sorted)
        if (low < high){
            // Partition array and get pivot's final position
            int pivotIndex = partition(arr, low, high);

            // Recursively sort left subarray (elements smaller than pivot)
            sort(arr, low, pivotIndex - 1);

            // Recursively sort right subarray (elements larger than pivot)
            sort(arr, pivotIndex + 1, high);
        }
    }

    // Partition method using Lomuto scheme - rearranges array around pivot
    // Parameters: arr[] - array to partition, low - start index, high - end index
    // Returns: final position of pivot element after partitioning
    // Logic: Use last element as pivot, move smaller elements to left side
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];  // Choose last element as pivot
        int i = low;            // Index for boundary of smaller elements

        // Traverse array and move elements smaller than pivot to left side
        for (int j = low; j < high; j++){
            if (arr[j] <= pivot){   // Current element is smaller than or equal to pivot
                // Swap current element to left side of partition
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;                // Increment boundary of smaller elements
            }
        }

        // Place pivot in its correct final position
        int temp = arr[i];
        arr[i] = arr[high];     // Move pivot to boundary position
        arr[high] = temp;

        return i;  // Return final position of pivot
    }
}
