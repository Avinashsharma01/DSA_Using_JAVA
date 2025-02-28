package Patterns.AdvancePattern;

public class HOLLOW_RECTANGLE_pattern {
    public static void HOLLOW_RECTANGLE(int rows, int cols){
        for (int i=1; i<=rows; i++){
            for (int j=1; j<=cols; j++){
                if (i==1 || i==rows || j==1|| j==cols){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HOLLOW_RECTANGLE(4,10);
    }
}
