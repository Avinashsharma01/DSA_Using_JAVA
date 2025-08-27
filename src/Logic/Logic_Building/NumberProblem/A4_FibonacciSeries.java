package Logic.Logic_Building.NumberProblem;

public class A4_FibonacciSeries {
    public static void main(String[] args) {
        fibonacci(10);
    }

    public static void fibonacci(int n){
        if (n<=0){
            return;
        }
        int first =0;
        int second = 1;
        System.out.print(first+" ");
        if (n>1){
            System.out.println(second+" ");
        }

        for(int i=2; i<n; i++){
            int next = first+second;
            System.out.print(next+" ");
            first=second;
            second=next;
        }

    }
}
