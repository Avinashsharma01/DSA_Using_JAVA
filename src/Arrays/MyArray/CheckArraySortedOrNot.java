package Arrays.MyArray;

public class CheckArraySortedOrNot {
    public static Boolean checkSortedArray(int[] arr){
        System.out.println(arr.length);
        for (int i=0; i< arr.length-1; i++){
            if (arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        int[] arr ={1,2,8,4,5};
        System.out.println(checkSortedArray(arr));
    }
}
