// Problem: Generate All Subarrays and Calculate Sums by Starting Index
// Description: Prints all possible subarrays and calculates sum of elements for each starting index
// Algorithm: Triple nested loops to generate subarrays and track sums based on starting position
// Time Complexity: O(n³) - triple nested loops for generating and processing subarrays
// Space Complexity: O(1) - constant extra space
// Note: Inefficient approach with hardcoded sum calculations for each starting index

package Arrays;

public class SubArray {
    public static void main(String[] args) {
        int total=0;  // Counter for total number of subarrays
        int f=0, s=0, t=0, fo=0, fi=0;  // Sum variables for each starting index (0,1,2,3,4)
        int[] number={1,2,3,4,5};  // Test array

        // Outer loop for starting index of subarray
        for (int i=0; i<number.length; i++){
            int start=i;
            // Middle loop for ending index of subarray
            for(int j=i; j<number.length; j++){
                int end = j;
                // Inner loop to print subarray elements and calculate sums
                for (int k=start; k<=end; k++){  // Print the subarray elements
                    System.out.print(number[k]+" ");
                    // Calculate sum based on starting index (hardcoded approach)
                    if (start==0){
                        f=f+number[k];  // Sum for subarrays starting at index 0
                    }
                    if (start==1){
                        s+=number[k];   // Sum for subarrays starting at index 1
                    }
                    if (start==2){
                        t+=number[k];   // Sum for subarrays starting at index 2
                    }
                    if (start==3){
                        fo+=number[k];  // Sum for subarrays starting at index 3
                    }
                    if (start==4){
                        fi+=number[k];  // Sum for subarrays starting at index 4
                    }
                }
                System.out.println();  // New line after each subarray
                total++;  // Increment subarray counter
            }
            System.out.println();  // Extra line between different starting indices
        }
        System.out.println("total sub array:- " + total);
        System.out.println("first sum:- "+  f);   // Sum of all subarrays starting at index 0
        System.out.println("second sum:- "+  s);  // Sum of all subarrays starting at index 1
        System.out.println("third sum:- "+  t);   // Sum of all subarrays starting at index 2
        System.out.println("fourth sum:- "+  fo); // Sum of all subarrays starting at index 3
        System.out.println("fifth sum:- "+  fi);  // Sum of all subarrays starting at index 4
    }
}
