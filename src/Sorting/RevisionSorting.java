// Problem: Sorting Algorithms Revision - Multiple Implementations
// Description: Contains implementations of three fundamental sorting algorithms for practice
// Algorithms: Bubble Sort, Insertion Sort, and Selection Sort
// Purpose: Educational review and comparison of basic O(n²) sorting algorithms
// Time Complexity: All three algorithms have O(n²) worst/average case complexity
// Space Complexity: O(1) - all are in-place sorting algorithms

package Sorting;

public class RevisionSorting {
    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };  // Test array with unsorted elements

        System.out.print("Original array: ");
        for(int num : arr){
            System.out.print(num+ " ");
        }
        System.out.println();

        bubbleSort(arr);  // Sort using bubble sort (can switch to other methods)

        System.out.print("Sorted array: ");
        for(int num : arr){
            System.out.print(num+ " ");
        }
        System.out.println();
    }

    // Bubble Sort Implementation - Adjacent element swapping approach
    // Time Complexity: O(n²) worst/average, O(n) best case (with optimization)
    // Space Complexity: O(1) - in-place sorting
    // Characteristics: Stable, adaptive (with swap flag)
    public static void bubbleSort(int[] arr){
        int n=  arr.length;
        boolean isSwapped;  // Optimization flag for early termination

        // Outer loop: Number of passes (n-1 passes needed)
        for (int i=0; i<n-1; i++){
            isSwapped=false;  // Reset flag for each pass

            // Inner loop: Compare adjacent elements
            // Range decreases by i each pass (last i elements are sorted)
            for (int j=0; j<n-i-1; j++){
                if (arr[j] > arr[j+1]){  // Adjacent elements in wrong order
                    // Swap adjacent elements
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    isSwapped=true;  // Mark that swap occurred
                }
            }

            // Optimization: If no swaps in this pass, array is sorted
            if(!isSwapped){
                break;  // Early termination saves time
            }
        }
    }

    // Insertion Sort Implementation - Build sorted array one element at a time
    // Time Complexity: O(n²) worst/average, O(n) best case (already sorted)
    // Space Complexity: O(1) - in-place sorting
    // Characteristics: Stable, adaptive, online (good for streaming data)
    public static void insertionSort(int[] arr){
        int n= arr.length;

        // Start from second element (first is trivially sorted)
        for (int i=1; i<n; i++){
            int key =arr[i];  // Element to be positioned
            int j=i-1;        // Last index of sorted portion

            // Shift elements greater than key one position right
            while (j>=0 && arr[j]> key){
                arr[j+1]=arr[j];  // Shift element right
                j--;              // Move to previous element
            }

            arr[j+1] =key;  // Insert key at correct position
        }
    }

    // Selection Sort Implementation - Repeatedly find minimum and place at beginning
    // Time Complexity: O(n²) in all cases (not adaptive)
    // Space Complexity: O(1) - in-place sorting
    // Characteristics: Not stable, not adaptive, minimum number of swaps
    public static void selectionSort(int[] arr){
        int n =  arr.length;

        // Outer loop: Build sorted portion from left
        for (int i=0; i<n-1; i++){
            int min_index=i;  // Assume current position has minimum

            // Inner loop: Find actual minimum in unsorted portion
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[min_index]){
                    min_index=j;  // Update minimum index
                }
            }

            // Swap minimum element with first unsorted element
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index]=temp;
        }
    }
}
