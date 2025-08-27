// Problem: Check if an array is sorted in non-decreasing order
// This function iterates through the array and returns false if any element is greater than its next element.
// Returns true if the array is sorted, false otherwise.
package Arrays.MyArray;

public class CheckArraySortedOrNot {
    public static boolean checkSortedArray(int[] arr){
        System.out.println(arr.length);
        for (int i=0; i< arr.length-1; i++){
            if (arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // Example usage: checks if the array is sorted
        int[] arr ={1,2,8,4,5};
        System.out.println(checkSortedArray(arr));
    }
}
