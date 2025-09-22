// Problem: Selection Sort Algorithm Implementation
// Description: Sorts array by repeatedly finding minimum element and placing it at beginning
// Algorithm: Find minimum element in unsorted portion and swap with first unsorted element
// Time Complexity: O(n²) in all cases (worst, average, best) - always performs n² comparisons
// Space Complexity: O(1) - in-place sorting algorithm
// Characteristics: Not stable, not adaptive, performs minimum number of swaps (n-1)
// Best Use: When memory writes are costly, small datasets where simplicity matters

package Sorting;

public class SelectionSort {

    // Selection sort method - repeatedly selects minimum element
    // Parameter: arr[] - array to be sorted in ascending order
    // Logic: Divide array into sorted (left) and unsorted (right) portions
    public static void selectionSort(int[] arr){
        int n = arr.length;

        // Outer loop: Expand sorted portion by one element each iteration
        for (int i=0; i<n-1; i++){
            int minIndex = i;  // Assume current position has minimum element

            // Inner loop: Find actual minimum element in unsorted portion
            for (int j=i+1; j<n; j++){
                if (arr[j]< arr[minIndex]){  // Found smaller element
                    minIndex =j;  // Update index of minimum element
                }
            }

            // Swap minimum element with first element of unsorted portion
            // This places minimum element in correct sorted position
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i]=temp;
        }
    }

    // Helper method to print array elements
    // Parameter: arrr[] - array to print
    static void printArr(int[] arrr){
        for (int num: arrr){
            System.out.print(num + " ");  // Print with space separator
        }
        System.out.println();  // New line after printing array
    }

    public static void main(String[] args) {
        int[]  arrrr ={3,4,2,1};  // Test array with unsorted elements

        System.out.println("Before sorting:");
        printArr(arrrr);  // Print original array

        selectionSort(arrrr);  // Sort using selection sort

        System.out.println("After sorting:");
        printArr(arrrr);  // Print sorted array
    }
}
