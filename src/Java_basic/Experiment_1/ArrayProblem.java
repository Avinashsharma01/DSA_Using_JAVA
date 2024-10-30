package Java_basic.Experiment_1;

public class ArrayProblem {
    public static void main(String[] args) {
        int[] number={1,2,3,4,5};
        for (int i=0; i<number.length; i++){
            int start=i;
            for (int j=i; j<number.length; j++){
                int end=j;
                System.out.println("( " + start + end + " )");
            }
            System.out.println();
        }
    }
}
