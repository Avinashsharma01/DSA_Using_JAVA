package SearchingAlgo;

public class OrderAgnosticBS {
    public static void main(String[] args) {
        int[] arrA= {1,2,3,4,5,6,7,8,9,10};
        int[] arrD = {10,9,8,7,6,5,4,3,2,1};

        int target = 4;
        int ElementIndex = Search(arrD, target);

        System.out.println(target + " is located at index:- "+ ElementIndex );
    }

    public static int Search(int[] arr, int target){
        int start =0;
        int end= arr.length-1;

        boolean IsAscending = arr[start] < arr[end];
        System.out.println(IsAscending);

        while(start <=end){
//            int mid = start + (end-start);
            int mid = start + (end - start) / 2;

            if (target==arr[mid]){
                return mid;
            }

            if (IsAscending){
                if (target > arr[mid]){
                    start = mid+1;
                }else {
                    end = mid-1;
                }
            }else {
                if (target < arr[mid]){
                    start = mid+1;
                }else {
                    end =  mid-1;
                }
            }

        }
        return -1;
    }
}
