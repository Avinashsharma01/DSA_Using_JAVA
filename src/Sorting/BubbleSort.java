package Sorting;

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        int n = arr.length;
        boolean swap;
        for (int i=0; i<n-1; i++){
            swap = false;
            for (int j=0; j<n-1-i;  j++){
                if(arr[j]> arr[j+1]){
                    int temp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]= temp;
                }
            }

            if (!swap){
                return;
            }
        }
    }
    // method one of print an array
    public static void PrintArr(int[] a){
        for (int num: a){
            System.out.println(num+ " ");
        }
    }
    // method two of print an array
    public static void PrintH(int[] b){
        for (int i=0;  i<b.length; i++){
            System.out.println(b[i]+ " ");
        }
    }

    public static void main(String[] args) {
        int[] myarray= {1,3,2,8,6,5};
        bubbleSort(myarray);
        PrintH(myarray);
    }
}
