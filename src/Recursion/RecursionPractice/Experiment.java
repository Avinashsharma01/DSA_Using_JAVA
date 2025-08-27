package Recursion.RecursionPractice;

public class Experiment {
    public static void main(String[] args) {
//        PrintN(5);
        fun(5);
    }

    public static void PrintN(int n){
        if (n==0){
            return;
        }

        System.out.println(n);
        PrintN(n-1);
        System.out.println(n);
    }

    public static void fun(int n){
        if (n==0){
            return;
        }

        System.out.println(n);
//        What happens when you run fun(5)?
//
//                Call: fun(5)
//
//        n = 5, not 0 → print 5
//
//        Calls fun(5) again (because of post-decrement, 5 is passed, then n becomes 4 after the call returns).
//
//                The recursive call fun(5) happens again…
//        And again…
//        And again…
//
//❌ It never reaches 0 because the argument passed is always the old value (5, 5, 5, …).


//        fun(n--);
        fun(n-1);
//        fun(--n);
    }

}
