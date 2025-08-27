// Problem: Demonstrates various array and character array manipulations in Java
// Includes examples of initializing arrays, filling arrays, printing arrays, and working with character arrays (A-Z).
// Useful for understanding array initialization, iteration, and character operations.

package Arrays;

public class ArrThing {
    public static void main(String[] args) {
        // Example 1: Integer array initialization and printing
        // int[] arr =new int[5]; // 0,0,0,0,0
        // for(int i=0; i<arr.length; i++){  // 1,2,3,4
        //     arr[i]=i+1; // 1,2,3,4,5
        // }
        // for(int j: arr){
        //     System.out.println(j);
        // }

        // Example 2: Character array A-Z initialization and printing
        // char[] names = new char[26];
        // char c = 'A';
        // for(int i=0; i<names.length; i++){
        //     names[i]=c++ ;
        // }
        // for(char j: names){
        //     System.out.print(j + " ");
        // }

        // Example 3: Print characters from 'A' to 'Z' using a loop
        // for(char i='A'; i<='Z'; i++){
        //     System.out.println(i);
        // }

        // Example 4: Print first 26 uppercase letters using ASCII values
        char c='A';
        for(int i=0; i<100; i++){
            if(i==26){
                break;
            }
            System.out.println(c++);

        }
    }
}
