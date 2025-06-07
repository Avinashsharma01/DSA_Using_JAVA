package Arrays.TwoDArray;

import java.util.Scanner;

public class InputDatain2DArray {


    public static void Search(int[][] matrix){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter key to find:- ");
        int key = sc.nextInt();
        int n= matrix.length;
        int m = matrix[0].length;

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (matrix[i][j]==key){
                    System.out.println(key+ " found at cell:- "+ "("+ i+ " "+j+ ")");
                    return;
                }
            }
        }
        System.out.println(key+" not found");
        return ;
    }


    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);

        int[][] matrix = new int[3][3];
        int n=matrix.length;
        int m=matrix[0].length;

        System.out.println("insert number to matrix:- ");
        for(int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        System.out.println("You have successfully insert the number into matrix ");

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }

        // search a number into matrix
        Search(matrix);
    }
}
