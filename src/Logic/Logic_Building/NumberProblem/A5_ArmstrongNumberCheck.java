package Logic.Logic_Building.NumberProblem;

public class A5_ArmstrongNumberCheck {
    public static void main(String[] args) {
        System.out.println(isArmstrong(153));
    }

    public static boolean isArmstrong(int n){
        int original =n;
        int digits = String.valueOf(n).length();
        int sum=0;

        while (n>0){
            int digit = n%10;
            sum= (int) (sum +Math.pow(digit, digits));
            n=n/10;
        }
        if (original==sum){
            return true;
        }
        return false;
    }
}
