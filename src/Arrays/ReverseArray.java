package Arrays;

public class ReverseArray {
    public static void reverseA(int[] arr){
        int fist=0;
        int last= arr.length-1;

        while (fist < last){
            int temp = arr[fist];
            arr[fist] =arr[last];
            arr[last]=temp;

            fist++;
            last--;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[100000];
        for(int i=0; i<arr.length; i++){
            arr[i] = i;
        }
        reverseA(arr);
        for (int j : arr){
            System.out.println(j);
        }
    }
}
