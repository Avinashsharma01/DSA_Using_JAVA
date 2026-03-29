package CollectionFrameWork.HashMap;

import java.util.HashMap;
import java.util.Map;

public class Top_K_Frequent_Elements_347 {


    public static void main(String[] args) {
        int[] arr = {1,2,1,2,1,2,3,1,3,2};
        int k=2;

        Top_K_Frequent(arr,k);
    }

    /**
     * Problem 347: Top K Frequent Elements
     * Given an integer array nums and an integer k, return the k most frequent elements.
     *
     * Current implementation just prints the frequencies.
     *
     * Typical Algorithm to solve this (not fully implemented here):
     * 1. Frequency Map: Create a HashMap to count the frequency of each element in the array.
     *    - Key: The element.
     *    - Value: Its frequency.
     * 2. Priority Queue (Min-Heap): Create a PriorityQueue to keep track of the top k elements.
     *    - Sort the PriorityQueue based on the frequency (values of the map).
     * 3. Iterate through map entries:
     *    - Add each entry to the PriorityQueue.
     *    - If the PriorityQueue size exceeds `k`, remove the top element (which has the lowest frequency).
     * 4. Result Construction: Extract the remaining `k` elements from the PriorityQueue into the result array.
     *
     * Time Complexity (using min-heap): O(N log K), where N is number of elements.
     */
    public static int[] Top_K_Frequent(int[] arr, int k){

        Map<Integer, Integer> freq = new HashMap<>();

        for (int element : arr){
            if (!freq.containsKey(element)){
                freq.put(element, 1);
            }else {
                freq.put(element, freq.get(element)+1);
            }
        }



        System.out.println(freq);
        return new int[1];
    }
 }
