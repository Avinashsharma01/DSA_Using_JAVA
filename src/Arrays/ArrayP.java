// Problem: Demonstrates basic array usage and iteration in Java
// This example initializes an array and prints a message for each element except the last, then prints the array length.
// Useful for understanding array length and for-loop usage.

package Arrays;

public class ArrayP {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5};

        for (int i=0; i<arr.length-1; i++){
            System.out.println("hello");
        }

        System.out.println(arr.length);
    }
}
