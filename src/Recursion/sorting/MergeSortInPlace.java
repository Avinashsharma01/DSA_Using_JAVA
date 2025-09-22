// Problem: In-Place Merge Sort using Recursion
// Description: Merge sort that modifies the original array instead of creating new arrays
// Algorithm: Divide array into halves, sort recursively, merge back into original array
// Time Complexity: O(n log n) - same as regular merge sort
// Space Complexity: O(n) - temporary array for merging + O(log n) recursion stack
// Advantage: Modifies original array, more memory efficient than creating new arrays

package Recursion.sorting;

import java.util.Arrays;

public class MergeSortInPlace {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};  // Test array with reverse sorted elements

        System.out.print("Original array: ");
        System.out.println(Arrays.toString(arr));

        mergeSort(arr, 0, arr.length);  // Sort in-place

        System.out.print("Sorted array: ");
        System.out.println(Arrays.toString(arr));
    }

    // Recursive in-place merge sort method
    // Parameters: arr[] - array to sort, s - start index, e - end index (exclusive)
    // Logic: Divide array range, recursively sort both halves, then merge in-place
    public static void mergeSort(int[] arr, int s, int e){
        // Base case: Single element or empty range
        if (e-s == 1){
            return;  // Single element is already sorted
        }

        int mid = s + (e-s)/2;  // Calculate middle point (overflow-safe)

        // Recursively sort left and right halves
        mergeSort(arr, s, mid);    // Sort left half [s, mid)
        mergeSort(arr, mid, e);    // Sort right half [mid, e)

        // Merge the two sorted halves back into original array
        mergeInPlace(arr, s, mid, e);
    }

    // In-place merge method - merges two sorted halves back into original array
    // Parameters: arr[] - original array, s - start, mid - middle point, e - end
    // Logic: Create temporary array, merge sorted halves, copy back to original
    private static void mergeInPlace(int[] arr, int s, int mid, int e) {
        int[] mix = new int[e-s];  // Temporary array for merging

        int i=s;    // Pointer for left half
        int j=mid;  // Pointer for right half
        int k=0;    // Pointer for temporary array

        // Merge elements from both halves in sorted order
        while (i<mid && j< e){
            // Bug fix: should compare arr[i] not arr[s]
            if (arr[i] < arr[j]){  // Fixed: was arr[s] < arr[j]
                mix[k++] = arr[i++];  // Take from left half
            }else {
                mix[k++] = arr[j++];  // Take from right half
            }
        }

        // Copy remaining elements from left half (if any)
        while (i<mid){
            mix[k++] = arr[i++];
        }

        // Copy remaining elements from right half (if any)
        while (j<e){
            mix[k++] = arr[j++];
        }

        // Copy merged result back to original array
        // Alternative manual approach (commented out):
        // for (int l=0; l<mix.length; l++){
        //     arr[s+l]=mix[l];
        // }

        // Efficient system method to copy array
        System.arraycopy(mix, 0, arr, s, mix.length);
    }
}
