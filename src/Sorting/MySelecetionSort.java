package Sorting;

public class MySelecetionSort {
    public static void main(String[] args) {
        int[] arr = {2,3,1,5,4};

        selectionSort(arr);

        for (int item : arr){
            System.out.println(item);
        }
    }
    public static void selectionSort(int[] arr){
        int n=arr.length;
        for (int i=0; i<n; i++){
            int minIndexValueIs = i;
            for (int j=i+1; j<n; j++){
                if (arr[j] < arr[minIndexValueIs]){
                    minIndexValueIs =j;
                }
            }
            // swaping the value
            int temp = arr[minIndexValueIs];
            arr[minIndexValueIs]  = arr[i];
            arr[i] = temp;
        }
    }
}
