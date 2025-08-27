package Logic;

public class CoutZeros {
    public static void main(String[] args) {
        System.out.println(countZ(102004064));

    }

    public static int countZ(int n){
        if (n==0){
            return 1;
        }

        return helper(n);
    }

    private static int helper(int n){
        if (n==0){
            return 0;
        }

        int digit = n%10;
        n=n/10;
//        int count = digit==0 ? 1: 0;
//        return count + helper(n);
        if (digit==0){
            return 1 + helper(n);
        }else {
            return helper(n);
        }

    }
}
