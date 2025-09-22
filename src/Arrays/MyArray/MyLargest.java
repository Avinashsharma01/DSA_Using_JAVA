// Problem: Find Largest and Smallest Elements in Array (Multiple Approaches)
// Description: Demonstrates different methods to find maximum and minimum elements
// Algorithm: Single pass through array with comparison-based approach
// Time Complexity: O(n) - linear time to traverse entire array
// Space Complexity: O(1) - constant extra space
// Approaches: Using Integer constants vs array element initialization

package Arrays.MyArray;

public class MyLargest {

    // Method to find largest element using Integer.MIN_VALUE initialization
    // Parameter: arr[] - input array
    // Advantage: Works with all negative arrays, handles edge cases safely
    public static void LargestWIthINT(int[]arr){
        int largestNum= Integer.MIN_VALUE;  // Initialize to smallest possible integer
        for(int i=0; i<arr.length; i++){
            if(largestNum < arr[i]){  // Update if current element is larger
                largestNum=arr[i];
            }
        }
        System.out.println("Largest number:- "+ largestNum);
    }

    // Method to find smallest element using Integer.MAX_VALUE initialization
    // Parameter: arr[] - input array
    // Advantage: Works with all positive arrays, handles edge cases safely
    public static void SmallestWIthINT(int[] arr){
        int smallestNum= Integer.MAX_VALUE;  // Initialize to largest possible integer
        for(int i=0; i<arr.length;i++){
            if(smallestNum > arr[i]){  // Update if current element is smaller
                smallestNum=arr[i];
            }
        }
        System.out.println("Smallest value:- " + smallestNum);
    }

    // Method to find largest element using first array element as initial value
    // Parameter: arr[] - input array
    // Note: Assumes array has at least one element
    public static void Largest(int[] arr){
        int largest=arr[0];  // Initialize with first element
        for(int i=0; i<arr.length; i++){
            if(largest < arr[i]){  // Update if current element is larger
                largest=arr[i];
            }
        }
        System.out.println("Largest number:- "+ largest);
    }

    // Method to find smallest element using arbitrary array element as initial value
    // Parameter: arr[] - input array
    // Note: Uses arr[2] as initial value (assumes array has at least 3 elements)
    public static void Smallest(int[] arr){
        // Pick any random index value of array then compare with all elements
        int smallest = arr[2];  // Initialize with element at index 2
        for (int i=0; i<arr.length; i++){
            if (smallest > arr[i]){  // Update if current element is smaller
                smallest=arr[i];
            }
        }
        System.out.println("Smallest number:- "+ smallest);
    }

    public static void main(String[] args) {
        int[] arr = {5,6,5,99,1,4,3344,334,222};  // Test array
        SmallestWIthINT(arr);  // Find smallest using Integer.MAX_VALUE
        Smallest(arr);         // Find smallest using arr[2] as initial
        LargestWIthINT(arr);   // Find largest using Integer.MIN_VALUE
        Largest(arr);         // Find largest using first element as initial
    }
}
