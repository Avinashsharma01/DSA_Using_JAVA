package Arrays;

public class BinarySearch {

    public static int Binary(int[] array, int key){

        for (int start=0, end=array.length-1; start<=end;){
            int mid = (start+end)/2;

            if (array[mid]==key){
                return mid;
            }
            if (array[mid]<key){
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] number = {1,2,5,6,3,8,9,5,6};
        int key=8;
        System.out.println("index is :- "+Binary(number,key));
    }
}
