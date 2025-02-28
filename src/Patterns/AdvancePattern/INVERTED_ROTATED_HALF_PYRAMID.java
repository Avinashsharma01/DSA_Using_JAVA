package Patterns.AdvancePattern;

public class INVERTED_ROTATED_HALF_PYRAMID {
    public static void  INVERTED_ROTATED(int rows, int cols){
        for (int i=1; i<=rows; i++){  // outer space
            // for spaces print
            for (int j=1; j<=cols-i; j++){ // inner space
                System.out.print(" ");
            }
            // for star print
            for (int k=1; k<=i; k++){  // inner space
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        INVERTED_ROTATED(4,4);
    }
}
