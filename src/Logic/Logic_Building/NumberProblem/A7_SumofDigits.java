package Logic.Logic_Building.NumberProblem;

public class A7_SumofDigits {
    public static void main(String[] args) {
        System.out.println(Sum(12345));
    }

    public static int Sum(int n){
        int sum=0;
        while (n>0){
            int digit = n%10;
            sum=sum+digit;
            n=n/10;
        }
        return sum;
    }
}
