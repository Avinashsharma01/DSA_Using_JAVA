package Logic;

import java.util.Scanner;

public class CheckNumberIsPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any Number");
        int number = sc.nextInt();
        int originalNumber = number;
        System.out.println(number%10);
        System.out.println("before reversed "+ originalNumber);
        int reversed =0;
        while (number != 0){
            int digit =  number%10;
            reversed = reversed * 10 +digit;
            number /= 10;
        }
        System.out.println("after reversed "+ reversed);
        System.out.println("--------------------------------------------------");
        if (originalNumber == reversed){
            System.out.println("Number is palindrome");
        }else {
            System.out.println("Number is not palindrome");
        }
    }
}
