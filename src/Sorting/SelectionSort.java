package Sorting;

public class SelectionSort {

    public static void selectionSort(int[] arr){
        int n = arr.length;
        for (int i=0; i<n-1; i++){
            int minIndex = i;
            for (int j=i+1; j<n; j++){
                if (arr[j]< arr[minIndex]){
                    minIndex =j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i]=temp;
        }
    }


    static void printArr(int[] arrr){
        for (int num: arrr){
            System.out.println(num);
        }
    }
    public static void main(String[] args) {
        int[]  arrrr ={3,4,2,1};
        System.out.println("before sort");
        printArr(arrrr);


        selectionSort(arrrr);
        System.out.println("after sorting");
        printArr(arrrr);
    }
}





