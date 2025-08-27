package Recursion.RecursionPractice;

public class RecursionPractice {
    public static void main(String[] args) {
//       Print_Numbers_from_1_to_N(5);
//        Print_Numbers_from_N_to_1(5);
//        int fact = Factorial_of_a_Number(5);
//        System.out.println(fact);
//        int sum = Sum_of_First_N_Natural_Numbers(5);
//        System.out.println(sum);

//        SumOfNDigitWithoutRec(12345);

//        int sum =SumOfNDigit(123456789);
//        System.out.println(sum);

        int product =productOfDigit(12345);
        System.out.println(product);

    }


    //1. Print Numbers from 1 to N
    public static void Print_Numbers_from_1_to_N(int n){
        if(n==0){
            return;
        }
        Print_Numbers_from_1_to_N(n-1);
        System.out.println(n);
    }

    //2. Print Numbers from N to 1
    public static void Print_Numbers_from_N_to_1(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        Print_Numbers_from_N_to_1(n-1);
    }

    //3. Factorial of a Number
    public static int Factorial_of_a_Number(int n){
        if(n<=1){
            return 1;
        }
        return n*Factorial_of_a_Number(n-1);
    }

    // 4. Sum of First N Natural Numbers
    public static int Sum_of_First_N_Natural_Numbers(int n){
        if (n==0){
            return 0;
        }
        return  n + Sum_of_First_N_Natural_Numbers(n-1);
    }

    // 5. Check if Array is Sorted
//    public static boolean Check_if_Array_is_Sorted(int[] arr){
//
//    }


    // sum of n number without Recursion
    public static void SumOfNDigitWithoutRec(int n){
        int sum=0;
        while (n > 0){
            int digit = n % 10;
            sum+=digit;
            n=n/10;
        }
        System.out.println(sum);
    }

    public static int SumOfNDigit(int n){
        if(n==0){
            return 0;
        }
        int digit = n%10;
        n=n/10;
        return digit + SumOfNDigit(n);
//        return (n%10) + SumOfNDigit(n/10);
    }

    public static int productOfDigit(int n){
        if (n==0)
            return 1;

        return (n%10) * productOfDigit(n/10);
    }
}
