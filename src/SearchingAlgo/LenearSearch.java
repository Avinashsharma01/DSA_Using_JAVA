package SearchingAlgo;

public class LenearSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Search(arr, 5);

    }

    public static void Search(int[] arr , int target){
        for (int i=0; i< arr.length-1; i++){
            if (arr[i]==target){
                System.out.println(target+ " found at index:- "+ i);
            }
        }
    }
}
