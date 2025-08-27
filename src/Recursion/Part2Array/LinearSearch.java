// Problem: Linear Search using Recursion
// This program demonstrates how to search for an element in an array using recursion.
// It provides two methods:
// 1. linearSInt: Returns the index of the target if found, otherwise -1.
// 2. linearSBoolean: Returns true if the target is found, otherwise false.
// Useful for understanding recursive search logic in arrays.

package Recursion.Part2Array;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int[]  arr = {1,2,3,4,5,5,5,6};
        // Search for 5 in the array, print index if found
        System.out.println(linearSInt(arr, 5, 0));
        // Search for 5 in the array, print true if found
        System.out.println(linearSBoolean(arr, 5, 0));
        System.out.println(findIndex(arr,0,5));
        findAllIndex(arr, 5, 0);
        System.out.println(list);

//        System.out.println(findAllIndex2(arr, 5 , 0 ,new ArrayList<>()));

        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(findAllIndex2(arr,5,0,list));


        System.out.println(findAllIndex3(arr, 5,0));

    }

    // Recursive method to return index of target, or -1 if not found
    public static int linearSInt(int[] arr, int target, int index){
        if (index == arr.length){
            return -1;
        }

        if (target== arr[index]){
            return index;
        }

        return linearSInt(arr, target, index+1);
    }

    // Recursive method to return true if target is found, false otherwise
    public static boolean linearSBoolean(int[] arr, int target, int index){
        if (index == arr.length){
            return false;
        }

        if (target==arr[index]){
            return true;
        }

        return linearSBoolean(arr, target,index+1 );
    }


    public static int findIndex(int[] arr, int index, int target){
        if (index==arr.length){
            return -1;
        }

//        if (target == arr[index]){
//            return index;
//        }
//        return findIndex(arr, index+1, target);

        return target==arr[index] ? index : findIndex(arr,index+1, target);
    }


    // This example does not follow the recursion properly because of outside ArrayList
    static ArrayList<Integer> list =  new ArrayList<>();
    public static void findAllIndex(int[] arr, int target, int index){
        if (index==arr.length){
            return;
        }

        if (arr[index]==target){
            list.add(index);
        }

        findAllIndex(arr, target, index+1);
    }


    // This example follow the proper recursion
    public static ArrayList<Integer> findAllIndex2(int[] arr, int target, int index, ArrayList<Integer> list){
        if (index==arr.length){
            return list;
        }

        if (target==arr[index]){
            list.add(index);
        }

        return findAllIndex2(arr, target, index+1, list);
    }


    public static ArrayList<Integer> findAllIndex3(int[] arr, int target, int index){

        ArrayList<Integer> list = new ArrayList<>();
        if (index==arr.length){
            return list;
        }

        if (arr[index] == target){
            list.add(index);
        }

        ArrayList<Integer> resultFromBelow = findAllIndex3(arr, target, index+1);

        list.addAll(resultFromBelow);
        return list;

    }

//    Example run
//
//    For arr = {1, 2, 3, 2, 4, 2}, target = 2:
//
//    At index=5 (arr[5] = 2): creates [5]
//
//    At index=4 (arr[4] = 4): creates [] + [5] → [5]
//
//    At index=3 (arr[3] = 2): creates [3] + [5] → [3, 5]
//
//    At index=2 (arr[2] = 3): creates [] + [3, 5] → [3, 5]
//
//    At index=1 (arr[1] = 2): creates [1] + [3, 5] → [1, 3, 5]
//
//    At index=0 (arr[0] = 1): creates [] + [1, 3, 5] → [1, 3, 5]
//    ✅ Final result: [1, 3, 5]
//

}
