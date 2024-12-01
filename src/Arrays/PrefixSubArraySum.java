package Arrays;

public class PrefixSubArraySum {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10};
        int currentSum;
        int maxSum=Integer.MIN_VALUE;

        int[] prefix = new int[arr.length];
        prefix[0]=arr[0];
        for(int i=1; i<prefix.length; i++){
            prefix[i]=prefix[i-1]+arr[i];
        }

        for(int i=0; i<arr.length; i++){
            for (int j=i; j<arr.length; j++){

                currentSum= i == 0 ? prefix[j]: prefix[j]-prefix[i-1];

                if(maxSum<currentSum){
                    maxSum=currentSum;
                }
            }
        }
        System.out.println(maxSum);
    }
}
