// Problem: Insertion Sort Algorithm Implementation
// Description: Builds sorted array one element at a time by inserting each element in correct position
// Algorithm: Take element from unsorted part and insert it at correct position in sorted part
// Time Complexity: O(n²) worst/average case, O(n) best case (already sorted)
// Space Complexity: O(1) - in-place sorting algorithm
// Characteristics: Stable, adaptive, online (can sort as data arrives)
// Best Use: Small datasets, nearly sorted arrays, online algorithms

package Sorting;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {3,2,1};  // Test array with reverse sorted elements

        System.out.print("Original array: ");
        for (int num : arr){
            System.out.print(num+ " ");
        }
        System.out.println();

        insertionSort(arr);  // Sort the array using insertion sort

        System.out.print("Sorted array: ");
        for (int num : arr){
            System.out.print(num+ " ");
        }
        System.out.println();
    }

    // Insertion sort method - builds sorted array one element at a time
    // Parameter: arr[] - array to be sorted in ascending order
    // Logic: Maintain sorted portion on left, insert each new element in correct position
    public static void insertionSort(int[] arr){
        int n = arr.length;

        // Start from second element (index 1) as first element is trivially sorted
        for(int i=1; i<n; i++){
            int key = arr[i];  // Current element to be positioned (key to insert)
            int j = i-1;       // Index of last element in sorted portion

            // Shift elements of sorted portion that are greater than key
            // Move them one position ahead to make space for key
            while (j>=0 && arr[j]> key){
                arr[j+1]= arr[j];  // Shift element to right
                j--;               // Move to previous element
            }

            // Insert key at correct position (j+1)
            // At this point, all elements to the left of j+1 are <= key
            arr[j+1]=key;
        }
    }
}
