package CollectionFrameWork.HashMap;

import java.util.HashMap;
import java.util.Map;

public class CountFreq {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,21,2,1,1,1,1,5,3,2};
        CountF(arr);
    }


    /**
     * Finds the element with the highest frequency in an array using a HashMap.
     *
     * Algorithm Steps:
     * 1. Frequency Map Creation: Iterate through the array and populate a HashMap.
     *    - Key: The element from the array.
     *    - Value: The frequency (count) of that element.
     * 2. Finding the Maximum Frequency:
     *    - Initialize `maxFreq` to tracker highest seen frequency and `AnswerKey` for the corresponding element.
     *    - Iterate through the entry set of the map.
     *    - If the current entry's value (frequency) is greater than `maxFreq`, update `maxFreq` and `AnswerKey`.
     * 3. Print the element with the highest frequency.
     *
     * Time Complexity: O(N) where N is length of array (one pass for map creation, one pass over map entries).
     * Space Complexity: O(N) in worst case where all elements are distinct.
     */
    public static void CountF(int[] arr){

        Map<Integer, Integer> freq = new HashMap<>();

        for(int el: arr){
            if (!freq.containsKey(el)){
                freq.put(el, 1);
            }else {
                freq.put(el, freq.get(el)+1);
            }
        }

        int maxFreq =0;
        int AnswerKey =-1;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()){
            if (entry.getValue()> maxFreq){
                maxFreq= entry.getValue();
                AnswerKey = entry.getKey();
            }
        }


        System.out.println(AnswerKey+" --> "+ maxFreq);
    }

    /**
     * Same logic as CountF but uses a traditional for-loop (counter-controlled)
     * instead of enhanced for-loop.
     */
    public static int CountFrequenceWithTraditionLoop(int[] arr){
        int n = arr.length-1;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int i=0; i<=n; i++){
            if (!freq.containsKey(arr[i])){
                freq.put(arr[i], 1);
            }else {
                freq.put(arr[i], freq.get(arr[i])+1);
            }
        }


        int maxFreq=0;
        int answerKey = -1;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()){
            if (entry.getValue() > maxFreq){
                maxFreq = entry.getValue();
                answerKey =entry.getKey();
            }
        }
        System.out.println(answerKey +" -> "+ maxFreq);
        return maxFreq;
    }
}
