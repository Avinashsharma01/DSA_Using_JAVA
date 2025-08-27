package Logic.Logic_Building.NumberProblem;

public class A6_ReverseaNumber {
    public static void main(String[] args) {
        System.out.println(reverse(123));
    }

    public static int reverse(int n){
        int original =n;
        int res=0;
        while(n>0){
            int digit =n%10;
            res=res*10+digit;
            n=n/10;
        }
        return res;
    }
}
