// Problem: Merge Sort using Recursion
// Description: Classic divide-and-conquer sorting algorithm implemented recursively
// Algorithm: Divide array into halves, recursively sort each half, then merge sorted halves
// Time Complexity: O(n log n) - consistent performance in all cases
// Space Complexity: O(n) - creates new arrays for each level of recursion
// Pattern: Pure recursive divide-and-conquer approach

package Recursion.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};  // Test array with reverse sorted elements

        System.out.print("Original array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        arr = sortt(arr);  // Sort using merge sort

        System.out.print("Sorted array: ");
        for (int num: arr){
            System.out.print(num+ " ");
        }
        System.out.println();
    }

    // Recursive merge sort method - divides array and sorts each half
    // Parameter: arr[] - array to be sorted
    // Returns: new sorted array (not in-place)
    // Logic: Divide until single elements, then merge sorted halves
    static int[] sortt(int[] arr){
        // Base case: Single element array is already sorted
        if (arr.length==1){
            return arr;
        }

        int mid = arr.length/2;  // Find middle point to divide array

        // Recursively sort left and right halves
        int[] left = sortt(Arrays.copyOfRange(arr, 0, mid));           // Sort left half [0, mid)
        int[] right = sortt(Arrays.copyOfRange(arr, mid, arr.length)); // Sort right half [mid, length)

        // Merge the two sorted halves to get final sorted array
        return merge(left, right);
    }

    // Merge method - combines two sorted arrays into one sorted array
    // Parameters: first[] - first sorted array, second[] - second sorted array
    // Returns: merged sorted array containing all elements from both arrays
    // Logic: Compare elements from both arrays and pick smaller one
    private static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];  // Result array
        int i=0, j=0, k=0;  // Pointers for first, second, and result arrays

        // Compare elements from both arrays and merge in sorted order
        while (i < first.length && j < second.length){
            if(first[i] < second[j]){
                mix[k] = first[i];  // Take from first array
                i++;
            }else {
                mix[k] = second[j]; // Take from second array
                j++;
            }
            k++;
        }

        // Copy remaining elements from first array (if any)
        while (i < first.length){
            mix[k] = first[i];
            i++;
            k++;
        }

        // Copy remaining elements from second array (if any)
        // Bug: should be j < second.length, not j < first.length
        while (j < second.length){  // Fixed: was j < first.length
            mix[k] = second[j];     // Fixed: was first[j]
            j++;
            k++;
        }

        return mix;  // Return merged sorted array
    }
}
