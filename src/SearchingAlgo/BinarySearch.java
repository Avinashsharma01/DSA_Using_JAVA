package SearchingAlgo;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5,6,7,8,9,10};
       int element = Search(arr, 5);
        System.out.println(element);
    }


    public static int Search(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;

        while(start <=end){
            int mid = start + (end - start) / 2;
            if (target == arr[mid]){
                return mid;
            } else if (target > arr[mid]) {
                start = mid+1;
            }else {
                end = mid-1;
            }
        }

        return -1;
    }
}
