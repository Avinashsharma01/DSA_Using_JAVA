package Arrays;

public class PairsOfArray {
    public static void main(String[] args) {
        int[] number= {1,2,3,4,5,6,7,8,9,10};
        for (int i=0; i<number.length; i++){
            int curr= number[i];
            for (int j=i+1; j<number.length; j++){
                System.out.print(" ("+ curr+ "," + number[j]+ ") ");
            }
            System.out.println();
        }
    }
}
