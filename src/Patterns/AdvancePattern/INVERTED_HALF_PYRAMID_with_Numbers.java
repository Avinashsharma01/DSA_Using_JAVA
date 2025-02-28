package Patterns.AdvancePattern;

public class INVERTED_HALF_PYRAMID_with_Numbers {
    public static void INVERTED_HALF_PYRAMID_with_Num(int rows, int cols){
        for (int i=1; i<=rows; i++){
            for (int j=1; j<=cols+1-i; j++ ){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        INVERTED_HALF_PYRAMID_with_Num(5,5);
    }
}
