package Recursion;


public class CheckLastOccurrence {

    public static int checkOccurrence(int[] arr, int key, int index){
        if (index == arr.length){
            return -1;
        }

        // Recursive call first
        int isFound = checkOccurrence(arr, key, index + 1);

        // If found in deeper call, return that
        if (isFound != -1) {
            return isFound;
        }

        // Else check current index
        if (arr[index] == key) {
            return index;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 5};
        System.out.println(checkOccurrence(arr, 3, 0)); // Output: 4
    }
}

