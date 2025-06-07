package PracticeQ;

import java.util.Scanner;

public class AvgOf3Num {
    public static double averageofThree(double a, double b, double c){
        return (a+b+c)/3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your First mark:- ");
        double x = sc.nextDouble();
        System.out.println("Enter your Second mark:- ");
        double y = sc.nextDouble();
        System.out.println("Enter your Third mark:- ");
        double z = sc.nextDouble();

        System.out.println("This is the average of your marks:- " + averageofThree(x,y,z));
    }
}
