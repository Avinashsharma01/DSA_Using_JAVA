package Arrays.TwoDArray;

public class SearchINsortedMatrix {

    public static boolean StairCaseDOWNSearch(int[][] matrix, int key){
        int row = 0; int col = matrix[0].length-1;
        System.out.println(matrix[row][col]);
        System.out.println(matrix[3][0]);
        while(row < matrix.length && col>=0){
            if(matrix[row][col]==key){
                System.out.println("found key at (" + row + ", "+ col+ ")");
                return true;
            } else if (key< matrix[row][col]) {
                col--;
            }else {
                row++;
            }
        }
        System.out.println("Key not found");
        return false;
    }

    public static boolean StairCaseUPSearch(int[][] matrix, int key){
        int row = 3; int col =0;
        return false;
        // i will continue latter
    }

    public static void main(String[] args) {
        int [][] matrix = {
                {10,20,30,40},
                {15,25,35,45},
                {27,29,37,48},
                {32,33, 39,50}
        };

        int key = 33;

        StairCaseDOWNSearch(matrix, key);
    }
}
