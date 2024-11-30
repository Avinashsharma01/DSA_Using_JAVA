package Arrays.MyArray;

public class MyreverseArray {

    public static void myReverse(int[] array){
        int first = 0;
        int last = array.length - 1;

        // Loop to reverse the array
        while (first <= last) {
            // Swap the elements at first and last indices
            int temp = array[last];
            array[last] = array[first];
            array[first] = temp;
            first++;
            last--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        // Print the original array
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();

        // Reverse the array
        myReverse(arr);

        // Print the reversed array
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}