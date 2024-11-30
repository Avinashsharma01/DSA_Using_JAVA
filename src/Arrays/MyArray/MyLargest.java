package Arrays.MyArray;

public class MyLargest {

    public static void LargestWIthINT(int[]arr){
        int largestNum= Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(largestNum < arr[i]){
                largestNum=arr[i];
            }
        }
        System.out.println("Largest number:- "+ largestNum);
    }

    public static void SmallestWIthINT(int[] arr){
        int smallestNum= Integer.MAX_VALUE;
        for(int i=0; i<arr.length;i++){
            if(smallestNum > arr[i]){
                smallestNum=arr[i];
            }
        }
        System.out.println("Smallest value:- " + smallestNum);
    }

    public static void Largest(int[] arr){
        int largest=arr[0];
        for(int i=0; i<arr.length; i++){
            if(largest < arr[i]){
                largest=arr[i];
            }
        }
        System.out.println("Largest number:- "+ largest);
    }

    public static void Smallest(int[] arr){
        // pick any random index value of an array then compare with all element
        int smallest = arr[2];
        for (int i=0; i<arr.length; i++){
            if (smallest > arr[i]){
                smallest=arr[i];
            }
        }
        System.out.println("Smallest number:- "+ smallest);
    }

    public static void main(String[] args) {
        int[] arr = {5,6,5,99,1,4,3344,334,222};
        SmallestWIthINT(arr);
        Smallest(arr);
        LargestWIthINT(arr);
        Largest(arr);
    }
}
