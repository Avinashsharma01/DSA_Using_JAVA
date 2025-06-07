package Arrays.TwoDArray;

public class DiagonalSum {
    public static void main(String[] args) {
        int[][]  matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        // primary diagonal
        int pn= matrix.length;
        int pm = matrix[0].length;
        int sum=0;
        // time complexity o(n^2)
//        for (int i=0; i<pn; i++){ // row
//            for (int j = 0; j< pm; j++){  // col
//
//                if (i==j){  // primary diagonal
//                    System.out.println(matrix[i][j]);
//                    sum+=matrix[i][j];
//                } else if (i+j == matrix.length-1) {   // secondary diagonal
//                    sum+=matrix[i][j];
//                    System.out.println(matrix[i][j]);
//                }
//            }
//        }

        // time complexity o(n)
        for (int i=0;  i<matrix.length; i++){
            // primary diagonal
            sum+=matrix[i][i];

            if (i != matrix.length-1-i){
                sum+=matrix[i][matrix.length-i-1];
            }
        }
        System.out.println("Total Diagonal Sum:- "+ sum);
    }
}




//
//package Arrays.TwoDArray;
//
//public class DiagonalSum {
//    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16}
//        };
//
//        int n = matrix.length; // Assuming square matrix
//
//        System.out.println("Primary Diagonal:");
//        for (int i = 0; i < n; i++) {
//            System.out.println(matrix[i][i]);
//        }
//
//        System.out.println("\nSecondary Diagonal:");
//        for (int i = 0; i < n; i++) {
//            System.out.println(matrix[i][n - 1 - i]);
//        }
//    }
//}
