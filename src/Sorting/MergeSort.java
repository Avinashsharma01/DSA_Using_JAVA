// Problem: Merge Sort Algorithm Implementation
// Description: Divide and conquer sorting algorithm that splits array and merges sorted halves
// Algorithm: Recursively divide array into halves, sort them, then merge sorted halves
// Time Complexity: O(n log n) in all cases (worst, average, best) - consistent performance
// Space Complexity: O(n) - requires additional space for temporary arrays
// Characteristics: Stable, not adaptive, excellent for large datasets and external sorting
// Best Use: Large datasets, when stable sorting is required, external sorting

package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};  // Test array with reverse sorted elements

        System.out.print("Original array: ");
        for (int num : arr){
            System.out.print(num+" ");
        }
        System.out.println();

        int[] newArr = sort(arr);  // Sort using merge sort

        System.out.print("Sorted array: ");
        for (int num : newArr){
            System.out.print(num+" ");
        }
        System.out.println();
    }

    // Recursive merge sort method - divides array and sorts each half
    // Parameter: arr[] - array to be sorted
    // Returns: new sorted array (not in-place)
    // Logic: Divide until single elements, then merge sorted halves
    static int[] sort(int[] arr){
        int n = arr.length;

        // Base case: Single element array is already sorted
        if (n==1){
            return arr;
        }

        int mid = n/2;  // Find middle point to divide array

        // Recursively sort left and right halves
        // Arrays.copyOfRange creates new arrays for each half
        int[] left = sort(Arrays.copyOfRange(arr,0,mid));      // Sort left half [0, mid)
        int[] right = sort(Arrays.copyOfRange(arr, mid,n));    // Sort right half [mid, n)

        // Merge the two sorted halves to get final sorted array
        return merge(left, right);
    }

    // Merge method - combines two sorted arrays into one sorted array
    // Parameters: arr1[] - first sorted array, arr2[] - second sorted array
    // Returns: merged sorted array containing all elements from both arrays
    // Logic: Compare elements from both arrays and pick smaller one
    private static int[] merge(int[] arr1, int[] arr2) {
        int n1 = arr1.length;  // Length of first array
        int n2 = arr2.length;  // Length of second array

        int[] mixed = new int[n1+n2];  // Result array to hold merged elements
        int i=0, j=0, k=0;  // Pointers for arr1, arr2, and mixed array respectively

        // Compare elements from both arrays and merge in sorted order
        while (i< n1 && j<n2){
            if (arr1[i] < arr2[j]){
                mixed[k++] = arr1[i++];  // Take from first array
            }else {
                mixed[k++]= arr2[j++];   // Take from second array
            }
        }

        // Copy remaining elements from first array (if any)
        while (i< n1){
            mixed[k++] = arr1[i++];
        }

        // Copy remaining elements from second array (if any)
        while (j< n2){
            mixed[k++]= arr2[j++];
        }

        return mixed;  // Return merged sorted array
    }
}
