package Arrays.MyArray;

public class FirstOccurrence {

    public static void checkOccurrence(int[] arr, int key){
        for (int i=0; i< arr.length; i++){
            if (arr[i]==key){
                System.out.println("First occurrence at index: " + i);
                return;
            }
        }
        System.out.println("Key not found at any index");
    }

    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5,6,7,8,9,10};

        checkOccurrence(arr, 51);
    }
}
