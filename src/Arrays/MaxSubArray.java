package Arrays;
public class MaxSubArray {
    public static void MaxSubArrayFun(int arr[]){
        int currsum=0;
        int maxsum= Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            int start=i;
            for (int j=i; j<arr.length; j++){
                int end=j;
                currsum=0;
                for (int k=start; k<=end; k++){
                    currsum+=arr[k];
                }
                System.out.println(currsum);
                if (maxsum<currsum){
                    maxsum=currsum;
                }
            }
        }
        System.out.println("max sum:- "+ maxsum);
    }
    public static void main(String[] args) {
        int[] number={2,4,6,8,10};
        int[] number1={1,2,3,4,5};
        MaxSubArrayFun(number1);
    }
}
