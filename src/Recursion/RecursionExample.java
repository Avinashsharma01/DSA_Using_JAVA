package Recursion;

public class RecursionExample {
    public static void PrintDecOrder(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        PrintDecOrder(n-1);
    }

    public static void PrintIncOrder(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        PrintIncOrder(n-1);
        System.out.println(n);
    }
    public static void main(String[] args) {
        int n =5;
        PrintDecOrder(n);
        System.out.println("----------------------");
        PrintIncOrder(n);
    }
}
