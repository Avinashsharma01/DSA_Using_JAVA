package Arrays.MyArray;

public class MyBinarySearch {
    public static int MyBinary(int[] arr, int key){
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            System.out.println(mid + "mid");
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void mmmm(int[] arr, int key) {
        int low = 0, high = arr.length;
        // Additional logic may be added here
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 3;
        int resultIndex = MyBinary(arr, key);  // Only call once
        if (resultIndex != -1) {
            System.out.println("Index no :- " + resultIndex + " Element :- " + arr[resultIndex]);
        } else {
            System.out.println("Element not found");
        }

        mmmm(arr, key);
    }
}
