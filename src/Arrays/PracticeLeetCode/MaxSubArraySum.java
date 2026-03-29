package Arrays.PracticeLeetCode;

public class MaxSubArraySum {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int windowSize=2;

        int result = SubArraySumMax(arr,windowSize);
        System.out.println(result);
    }


    public static int SubArraySumMax(int[] arr, int w){
        int n = arr.length;

        if (n < w){
            return -1;
        }

        int windowSum=0;
        // fist window sum
        for (int i=0; i<w; i++){
            windowSum+=arr[i];
        }

        int maxWindowSum = windowSum;


        // slide the window
        for (int i=w; i<n; i++){
            windowSum = windowSum + arr[i] - arr[i-w];
            maxWindowSum = Math.max(windowSum, maxWindowSum);
        }

        return maxWindowSum;
    }
}
