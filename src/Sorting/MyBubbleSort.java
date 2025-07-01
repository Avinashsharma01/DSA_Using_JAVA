package Sorting;

public class MyBubbleSort {
    public static void main(String[] args) {
        int[] arr= {2,4,3,1,5,9,7,8,6,11,22,55,75,34,67,22,89,9,56,444,3567,8765,32,5,6,8,9,434,436,78,35,35,46,7,456,3532};
        bubbleSort(arr);
        for (int item : arr){
            System.out.println(item);
        }
    }

    public static void bubbleSort(int[] arr){
        int n = arr.length;
        boolean swap;
        for (int i=0; i<n; i++){
            swap = false;
            for (int j=0; j<n-1-i; j++){
                if (arr[j] > arr[j+1]){
                    int temp =  arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1] =temp;
                    swap= true;
                }
            }
            if (!swap){
                return;
            }

        }
    }
}
