// Problem: Quick Sort Algorithm Implementation
// Description: Divide and conquer sorting algorithm using partitioning around a pivot element
// Algorithm: Choose pivot, partition array so smaller elements are left, larger on right, recurse
// Time Complexity: O(n log n) average case, O(n²) worst case, O(n log n) best case
// Space Complexity: O(log n) average case (recursion stack), O(n) worst case
// Characteristics: Not stable, in-place, adaptive to input distribution
// Best Use: General purpose sorting, when average case performance matters, memory constrained

package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};  // Test array with reverse sorted elements

        System.out.print("Original array: ");
        System.out.println(Arrays.toString(arr));

        SortQuick(arr, 0, arr.length-1);  // Sort using quick sort

        System.out.print("Sorted array: ");
        System.out.println(Arrays.toString(arr));
    }

    // Main quick sort method - recursively sorts array using divide and conquer
    // Parameters: arr[] - array to sort, low - starting index, high - ending index
    // Logic: Partition around pivot, then recursively sort left and right subarrays
    public static void SortQuick(int[] arr, int low,int high){

        // Base case: If low >= high, subarray has 0 or 1 element (already sorted)
        if (low< high){

            // Partition array and get pivot index
            // After partition: elements < pivot are left, elements > pivot are right
            int pivotIndex = partition(arr, low, high);

            // Recursively sort left subarray (elements smaller than pivot)
            SortQuick(arr, low, pivotIndex-1);

            // Recursively sort right subarray (elements larger than pivot)
            SortQuick(arr, pivotIndex+1, high);
        }
    }

    // Partition method - rearranges array around pivot element
    // Parameters: arr[] - array to partition, low - start index, high - end index
    // Returns: final position of pivot element after partitioning
    // Logic: Use last element as pivot, move smaller elements to left side
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];  // Choose last element as pivot
        int i = low-1;          // Index of smaller element (boundary of left partition)

        // Traverse through array and move smaller elements to left
        for (int j=low; j<high; j++){
            if (arr[j]<= pivot){    // Current element is smaller than or equal to pivot
                i++;                // Increment boundary of left partition
                // Swap current element with element at boundary
                int temp = arr[i];
                arr[i]= arr[j];
                arr[j]=temp;
            }
        }

        // Place pivot in correct position (between left and right partitions)
        int temp = arr[i+1];
        arr[i+1]= arr[high];    // Move pivot to correct position
        arr[high]=temp;

        return i+1;  // Return index of pivot in its final sorted position
    }
}
