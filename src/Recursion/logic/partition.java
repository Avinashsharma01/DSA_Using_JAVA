// Problem: Partition Array for QuickSort Algorithm
// Description: Implements the partitioning logic used in QuickSort algorithm
// Algorithm: Lomuto partition scheme - uses last element as pivot
// Time Complexity: O(n) - single pass through the array
// Space Complexity: O(1) - in-place partitioning
// Purpose: Rearranges array so elements ≤ pivot are on left, elements > pivot are on right

package Recursion.logic;

public class partition {

    public static void main(String[] args) {
        int[] arr = {5,7,1,3,2,4};  // Test array for partitioning
        System.out.print("Original array: ");
        printArray(arr);

        int pivotIndex = partitionForQuickSort(arr, 0, arr.length-1);

        System.out.print("After partitioning: ");
        printArray(arr);
        System.out.println("Pivot is now at index: " + pivotIndex);
    }

    // Partition method for QuickSort using Lomuto scheme
    // Parameters: arr[] - array to partition, low - start index, high - end index
    // Returns: final position of pivot element after partitioning
    // Logic: Move all elements ≤ pivot to left side, elements > pivot to right side
    private static int partitionForQuickSort(int[] arr, int low, int high) {
        int pivot = arr[high];  // 1️⃣ Choose last element as pivot
        int i = (low - 1);      // 2️⃣ Index of boundary between smaller and larger elements

        // 3️⃣ Traverse array from low to high-1
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {  // Current element is smaller than or equal to pivot
                i++;  // Increment boundary of smaller elements
                // 4️⃣ Swap current element with element at boundary
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 5️⃣ Place pivot in its correct final position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];  // Move pivot to correct position
        arr[high] = temp;

        return i + 1;  // 6️⃣ Return pivot's final index
    }

    // Helper method to print array
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
