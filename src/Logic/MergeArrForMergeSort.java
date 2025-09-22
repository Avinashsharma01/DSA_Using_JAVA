package Logic;

public class MergeArrForMergeSort {
    public static void main(String[] args) {
        int[] arr1 = {1,3,5};
        int[] arr2 = {2,4,6};
        int[] mixedArr = merge(arr1, arr2);


        for (int num : mixedArr){
            System.out.print(num+" ");
        }
    }

    static int[] merge(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;

        int[] mixed = new int[n1+n2];

        int i=0, j=0, k=0;

        while (i< n1 && j<n2){
            if (arr1[i] <= arr2[j]){
                mixed[k++] = arr1[i++];
            }else {
                mixed[k++]= arr2[j++];
            }
        }

        while (i < n1) {
            mixed[k++]=arr1[i++];
        }
        while (j<n2){
            mixed[k++]= arr2[j++];
        }

        return mixed;
    }
}
