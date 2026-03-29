package Arrays.PracticeLeetCode;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 9;

        int[] result =  twoSumFun(arr, target);

        for (int num : result){
            System.out.println(num);
        }

    }

    public static int[] twoSumFun(int[] arr, int target){


        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(1,21);
        map.put(2,25);
        map.put(3,52);
        map.put(4,42);
        map.put(5,23);
        System.out.println(map.get(2));
        return new int[]{1,2,0};
    }


}
