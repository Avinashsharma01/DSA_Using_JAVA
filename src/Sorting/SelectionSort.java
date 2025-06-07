package Sorting;

public class SelectionSort {
    public static void selectionSort(int[] arr){
        for (int i=0; i<arr.length; i++){
            int minIndex=i;
            for (int j=i+1; j<arr.length; j++){
                if (arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            int temp= arr[minIndex];
            arr[minIndex]=arr[i];
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
        System.out.println("Before sort");
        printArr(arrrr);
        selectionSort(arrrr);
        System.out.println("After sort");
        printArr(arrrr);
    }
}
