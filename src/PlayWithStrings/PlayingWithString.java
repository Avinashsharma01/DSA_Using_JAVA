package PlayWithStrings;

import java.util.Scanner;

public class PlayingWithString {
    public static void main(String[] args) {
//        System.out.println("/////////////////////////////////////////////////////////////");
//        String str = "Avinash";
//        System.out.println(str);
//        System.out.println(str.length()/2);
//
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("Enter your name:- ");
//        String name = sc.nextLine();
//
//        System.out.println(name.length());
//        for (int i=0; i<name.length(); i++){
//            System.out.println(name.charAt(i));
//        }
//
//        System.out.println(name);

        System.out.println("/////////////////////////////////////////////////////////////");
        String str1 = "Avinash";
        String str2 = "Avinash";
        String str3 = new String("Avinash");
        String str4 = new String("Avinash");


        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println(str1 == str3);
        System.out.println(str3.equals(str4));

    }
}
