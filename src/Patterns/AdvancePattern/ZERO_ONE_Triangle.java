package Patterns.AdvancePattern;

public class ZERO_ONE_Triangle {
    public static void ZERO_ONE(int rows){
        for (int i=1; i<=rows; i++){
            for (int j=1; j<=i; j++){
                if ((i+j) % 2 == 0){   // i+j = 0 then 0 otherwise 1
                    System.out.print(" 1 ");
                }else {
                    System.out.print(" 0 ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ZERO_ONE(10);
    }
}
