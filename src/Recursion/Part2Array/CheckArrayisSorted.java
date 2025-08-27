// Problem: Check if an array is sorted using recursion
// This program checks if a given array is sorted in non-decreasing order by recursively comparing each element with the next.
// The checkArraySorted method returns true if the array is sorted, otherwise false.
// Useful for understanding recursive logic in array problems.

package Recursion.Part2Array;

public class CheckArrayisSorted {
    public static void main(String[] args) {

        int[] arr = {1,3,4,5,6,7};
        boolean isSorted = checkArraySorted(arr, 0);
        if (isSorted){
            System.out.println("sorted");
        }else {
            System.out.println("not sorted");
        }
    }

    // Recursive method to check if array is sorted
    public static boolean checkArraySorted(int[] arr, int index){
        if (index == arr.length-1){
            return true;
        }
        // Returns false if current element is greater than next
        // Otherwise, recursively checks the rest of the array


        if(arr[index] < arr[index+1]){
            return checkArraySorted(arr, index+1);
        }else {
            return false;
        }
//        return arr[index] < arr[index+1] && checkArraySorted(arr, index+1);
    }
}
