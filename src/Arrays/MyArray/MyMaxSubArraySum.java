package Arrays.MyArray;

public class MyMaxSubArraySum {
    public static void main(String[] args) {
        int[] arr={2,4,6,8,10};
        int current=0;
        int maxsum=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            for (int j=i; j<arr.length; j++){
                current=0;
                for (int k=i; k<=j; k++){
                    current+=arr[k];
                }
                if (maxsum<current){
                    maxsum=current;
                }
            }
        }
        System.out.print("Maxsum:- "+ maxsum);
    }
}
