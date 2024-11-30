package Sorting;

public class BubbleSort {

    public static void bubbleSort(int[] array){
        for(int turn=0; turn<=array.length-1; turn++){
            for (int j=0; j<array.length-1-turn; j++){
                if (array[j] > array[j+1]) {
                    int temp;
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {4,6,1,8,2,9,4,2,6,5,34567};

        bubbleSort(arr);

        for (int i : arr){
            System.out.println(i);
        }
    }
}
