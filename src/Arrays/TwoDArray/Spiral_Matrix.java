package Arrays.TwoDArray;
import java.util.Scanner;
public class Spiral_Matrix {

    public static void printSpiral(int[][] matrix){
        int startRow=0;
        int startCol=0;
        int endRow=matrix.length-1;
        int endCol= matrix[0].length-1;

        while (startRow<=endRow && startCol<=endCol){

            // top boundary
            for (int j=startCol; j<=endCol; j++){
                System.out.println(matrix[startRow][j]+" ");
            }

            // right boundary
            for (int i=startRow+1; i<=endRow; i++){
                System.out.println(matrix[i][endCol]+ " ");
            }

            //bottom boundary
            for (int j =endCol-1; j>=startCol; j--){
                if (startRow==endRow){
                    break;
                }
                System.out.println(matrix[endRow][j]+" ");
            }

            // left boundary
            for (int i=endRow-1; i>= startRow+1; i--){
                if (startCol==endCol){
                    break;
                }
                System.out.println(matrix[i][startCol]+" ");
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        System.out.println();
        System.out.println("successfully printed the spiral matrix");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int[][] matrix= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] matrix = new int[4][4];
        int n = matrix.length;
        int m = matrix[0].length;

        System.out.println("Insert the value into matrix");
        for (int i=0; i<n; i++){
            for (int j =0; j<m; j++){
                matrix[i][j]=sc.nextInt();
            }
        }

        System.out.println("You have successfully inserted the element into matrix");
        printSpiral(matrix);

    }
}
