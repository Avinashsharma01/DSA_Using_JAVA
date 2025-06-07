package Recursion;

public class CheckFirstOccurrence {

    public static int checkOccurrence(int[] arr, int key, int index){
        if (index == arr.length){
            return -1;
        }
        if (arr[index]== key){
            return index;
        }

        return  checkOccurrence(arr, key, index+1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(checkOccurrence(arr, 3, 0));
    }
}
