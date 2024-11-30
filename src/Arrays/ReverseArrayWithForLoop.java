package Arrays;

public class ReverseArrayWithForLoop {
    public static void ReverseWithFor(int[] array){

        for(int first=0, last=array.length-1; first<=last; first++, last--){
            int temp;
            temp=array[last];
            array[last]=array[first];
            array[first]=temp;
        }

    }

    public static void main(String[] args) {
        int[] arr={9,8,7,6,5,4,3,2,1};
        ReverseWithFor(arr);

        for(int i: arr){
            System.out.print(i+ ",");
        }
    }
}
