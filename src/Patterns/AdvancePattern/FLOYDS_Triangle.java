package Patterns.AdvancePattern;

public class FLOYDS_Triangle {
    public static void FLOYD_TriangleP(int rows){
        int counter =1;
        for(int i=1; i<=rows; i++){
            for (int j =1; j<=i; j++){
                System.out.print(counter+" ");
                counter++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        FLOYD_TriangleP(5);
    }
}
