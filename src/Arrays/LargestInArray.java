package Arrays;
import java.util.*;
public class LargestInArray {
    public static int Largest(int[] n){
        int largest =Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int i=0; i<n.length; i++){
            if (largest < n[i]){
                largest=n[i];
            }
            if (smallest > n[i]){
                smallest=n[i];
            }
        }
        System.out.println("smallest :- "+smallest);
        System.out.println("largest :- "+largest);

        return largest;
    }
    public static void main(String[] args) {
        int[] numbers={1,2,3,4,6,89,6,4,33,8};
        Largest(numbers);
    }
}
